/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseManagerTool.ModuloConexion;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Conexion {

    //Datos de Conexion
    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private String HOST = "localhost";
    private String PORT = "1521";
    private String SID = "XE";
    private String URL = "jdbc:oracle:thin:@" + HOST + ":" + PORT + ":" + SID;
    private String USER = "NORTHWIND";
    private String PASSWORD = "24464438";
    private String NAME = "Local Instance";
    public boolean founded = false;
    public boolean connected = false;

    //Datos para almacenar la conexion
    private RandomAccessFile registro_conexion;

    public Connection conexion;
    private String connection_status = "NO HAY UNA CONEXION ESTABLECIDA";
    private String connection_save_status = "NO SE HA LOGRADO ALMACENAR SU CONEXION";
    private String connection_search_status = "NO SE HA ENCONTRADO UNA CONEXION CON ESTOS DATOS";

    public Conexion() {
        try {
            conexion = null;
            //1-Asegurar que el folder Conexiones exista
            File conexiones_file = new File("Conexiones");
            conexiones_file.mkdir();

            //2-Instanciar los RAFs dentro de Conexiones
            registro_conexion = new RandomAccessFile("Conexiones/connections.con", "rw");

        } catch (IOException e) {
            connection_save_status = "Estamos teniendo problemas para abrir archivo de tus conexiones" + e;
            System.out.println(connection_save_status);
        }
    }

    public boolean conect() {
        try {
            Class.forName(DRIVER);
            URL = URL = "jdbc:oracle:thin:@" + HOST + ":" + PORT + ":" + SID;
            this.conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            this.connection_status = "Conexion Establecida Correctamente.";
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            this.connection_status = "No se ha logrado establecer la conexion debiado a: " + e.getMessage() + ".";
            return false;
        }
    }

    public boolean disconect() {
        try {
            this.conexion.close();
            this.connection_status = "Conexion Terminada Correctamente.";
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            this.connection_status = e.getMessage() + ".";
            return false;
        }
    }

    public Connection getConnection() {
        return this.conexion;
    }

    public void setHOST(String _host) {
        this.HOST = _host;
    }

    public void setPORT(String _port) {
        this.PORT = _port;
    }

    public void setSID(String _sid) {
        this.SID = _sid;
    }

    public void setUSER(String _user) {
        this.USER = _user;
    }

    public void setPASSWORD(String _password) {
        this.PASSWORD = _password;
    }

    public void setNAME(String _name) {
        this.NAME = _name;
    }

    public String getHOST() {
        return this.HOST;
    }

    public String getPORT() {
        return this.PORT;
    }

    public String getSID() {
        return this.SID;
    }

    public String getUSER() {
        return this.USER;
    }

    public String getPASSWORD() {
        return this.PASSWORD;
    }

    public String getNAME() {
        return this.NAME;
    }

    public String getStatus() {
        return this.connection_status;
    }

    public String getSaveStatus() {
        return this.connection_save_status;
    }

    public String getSearchStatus() {
        return this.connection_search_status;
    }

    public void save_connection() {
        try {
            searchConnection(NAME);

            if (founded == false) {
                //Asegurar que el puntero este en el final
                registro_conexion = new RandomAccessFile("Conexiones/connections.con", "rw");
                registro_conexion.seek(registro_conexion.length());

                //Almacenar Informacion de la Conexion
                registro_conexion.writeUTF(NAME);
                registro_conexion.writeUTF(HOST);
                registro_conexion.writeUTF(PORT);
                registro_conexion.writeUTF(SID);
                registro_conexion.writeUTF(USER);
                registro_conexion.writeUTF(PASSWORD);

                connection_search_status = "Conexion Almacenada Correctamente.";
                System.out.println(connection_save_status);
                registro_conexion.close();
            }
        } catch (IOException e) {
            connection_save_status = "Estamos teniendo problemas para guardar tu conexiones en el archivo de tus conexiones: " + e;
            System.out.println(connection_save_status);

            try {
                registro_conexion.close();
            } catch (IOException ex) {
                connection_save_status = "Estamos teniendo problemas para trabajar tus conexiones en el archivo de tus conexiones: " + e;
                System.out.println(connection_save_status);
            }
        }
    }

    public ArrayList connection_list() {
        ArrayList listado = new ArrayList();
        try {
            registro_conexion = new RandomAccessFile("Conexiones/connections.con", "rw");
            registro_conexion.seek(0);

            while (registro_conexion.getFilePointer() < registro_conexion.length()) {
                String _name = registro_conexion.readUTF();
                String _host = registro_conexion.readUTF();
                String _port = registro_conexion.readUTF();
                String _sid = registro_conexion.readUTF();
                String _user = registro_conexion.readUTF();
                String _password = registro_conexion.readUTF();

                Conexion _conexion = new Conexion();
                _conexion.setNAME(_name);
                _conexion.setHOST(_host);
                _conexion.setPORT(_port);
                _conexion.setSID(_sid);
                _conexion.setUSER(_user);
                _conexion.setPASSWORD(_password);

                listado.add(_conexion);
            }

            connection_search_status = "Conexiones Encontradas Correctamente.";
            System.out.println(connection_search_status);
            registro_conexion.close();
        } catch (IOException e) {
            connection_search_status = "Estamos teniendo problemas para extraer tus conexiones en el archivo de tus conexiones: " + e;
            System.out.println(connection_search_status);

            try {
                registro_conexion.close();
            } catch (IOException ex) {
                connection_search_status = "Estamos teniendo problemas para trabajar tus conexiones en el archivo de tus conexiones: " + e;
                System.out.println(connection_search_status);
            }
        }
        return listado;
    }

    public Conexion searchConnection(String _name_search) {
        Conexion _conexion;
        _conexion = new Conexion();
        founded = false;

        try {
            registro_conexion = new RandomAccessFile("Conexiones/connections.con", "rw");
            registro_conexion.seek(0);

            while (registro_conexion.getFilePointer() < registro_conexion.length()) {
                String _name = registro_conexion.readUTF();
                String _host = registro_conexion.readUTF();
                String _port = registro_conexion.readUTF();
                String _sid = registro_conexion.readUTF();
                String _user = registro_conexion.readUTF();
                String _password = registro_conexion.readUTF();

                if (_name.equalsIgnoreCase(_name_search)) {
                    _conexion.setNAME(_name);
                    _conexion.setHOST(_host);
                    _conexion.setPORT(_port);
                    _conexion.setSID(_sid);
                    _conexion.setUSER(_user);
                    _conexion.setPASSWORD(_password);

                    connection_search_status = "Conexion Encontrada Correctamente.";
                    System.out.println(connection_search_status);
                    registro_conexion.close();
                    founded = true;
                    return _conexion;
                }
            }
        } catch (IOException e) {
            connection_search_status = "Estamos teniendo problemas para encontrar tu conexion en el archivo de tus conexiones, intenta con otra conexion: " + e;
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
