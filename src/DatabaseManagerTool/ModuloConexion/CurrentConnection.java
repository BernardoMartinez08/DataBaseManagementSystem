/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseManagerTool.ModuloConexion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angie
 */
public class CurrentConnection {

    private Conexion conexion;

    public String connection_status = "NO HAY UNA CONEXION ESTABLECIDA";
    public String connection_save_status = "NO SE HA LOGRADO ALMACENAR SU CONEXION";
    public String connection_search_status = "NO SE HA ENCONTRADO UNA CONEXION CON ESTOS DATOS";

    //Datos para almacenar la conexion
    private RandomAccessFile registro_conexion;

    public CurrentConnection(String _name, String _host, String _port, String _sid, String _user, String _password) {
        this.conexion = new Conexion();
        this.conexion.setNAME(_name);
        this.conexion.setHOST(_host);
        this.conexion.setPORT(_port);
        this.conexion.setSID(_sid);
        this.conexion.setUSER(_user);
        this.conexion.setPASSWORD(_password);
    }

    public Connection conectar() {
        Conexion aux = conexion.searchConnection(this.conexion.getNAME());

        if (aux.founded == true) {
            if (aux.getPASSWORD().equals(this.conexion.getPASSWORD())) {
                this.conexion.conect();
                this.connection_status = this.conexion.getStatus();
                return this.conexion.getConnection();
            } else {
                this.connection_status = this.conexion.getStatus() + "\nCONTRASEÑA INCORRECTA!.";
                return null;
            }
        } else {
            conexion.save_connection();
            this.connection_save_status = this.conexion.getSaveStatus();
            this.conexion.conect();
            this.connection_status = this.conexion.getStatus();
            return this.conexion.getConnection();
        }
    }

    public boolean desconectar() {
        if (this.conexion != null) {
            this.conexion.disconect();
            this.connection_status = this.conexion.getStatus();
            try {
                registro_conexion = new RandomAccessFile("Conexiones/current_connection.con", "rw");
                registro_conexion.setLength(0);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CurrentConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CurrentConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        } else {
            this.connection_status = this.conexion.getStatus();
            return false;
        }
    }

    public ArrayList getConnections() {
        return this.conexion.connection_list();
    }

    public Conexion searchConexion(String _name) {
        Conexion _conexion = this.conexion.searchConnection(_name);
        this.connection_search_status = this.conexion.getSearchStatus();
        return _conexion;
    }

    public void save_connection() {
        try {
            //Asegurar que el puntero este en el final
            registro_conexion = new RandomAccessFile("Conexiones/current_connection.con", "rw");
            registro_conexion.setLength(0);

            //Almacenar Informacion de la Conexion
            registro_conexion.writeUTF(this.conexion.getNAME());
            registro_conexion.writeUTF(this.conexion.getHOST());
            registro_conexion.writeUTF(this.conexion.getPORT());
            registro_conexion.writeUTF(this.conexion.getSID());
            registro_conexion.writeUTF(this.conexion.getUSER());
            registro_conexion.writeUTF(this.conexion.getPASSWORD());

            connection_search_status = "Conexion Actual Almacenada Correctamente.";
            System.out.println(connection_save_status);
            registro_conexion.close();

        } catch (IOException e) {
            connection_save_status = "Estamos teniendo problemas para guardar tu conexion actual en el archivo de tus conexiones: " + e;
            System.out.println(connection_save_status);

            try {
                registro_conexion.close();
            } catch (IOException ex) {
                connection_save_status = "Estamos teniendo problemas para trabajar tus conexiones almacenadas en el archivo de tus conexiones: " + e;
                System.out.println(connection_save_status);
            }
        }
    }

    public Conexion searchCurrentConnection() {
        Conexion _conexion;
        _conexion = new Conexion();

        try {
            registro_conexion = new RandomAccessFile("Conexiones/current_connection.con", "rw");
            registro_conexion.seek(0);

            while (registro_conexion.getFilePointer() < registro_conexion.length()) {
                String _name = registro_conexion.readUTF();
                String _host = registro_conexion.readUTF();
                String _port = registro_conexion.readUTF();
                String _sid = registro_conexion.readUTF();
                String _user = registro_conexion.readUTF();
                String _password = registro_conexion.readUTF();

                _conexion.setNAME(_name);
                _conexion.setHOST(_host);
                _conexion.setPORT(_port);
                _conexion.setSID(_sid);
                _conexion.setUSER(_user);
                _conexion.setPASSWORD(_password);

                connection_search_status = "Conexion Encontrada Correctamente.";
                System.out.println(connection_search_status);
                registro_conexion.close();
                return _conexion;
            }

        } catch (IOException e) {
            connection_search_status = "Estamos teniendo problemas para encontrar tu conexion actual en el archivo de tus conexiones, intenta con otra conexion: " + e;
            System.out.println(connection_search_status);

            try {
                registro_conexion.close();
            } catch (IOException ex) {
                connection_search_status = "Estamos teniendo problemas para trabajar tus conexiones en el archivo de tus conexiones: " + e;
                System.out.println(connection_search_status);
            }
        }
        return _conexion;
    }
}

