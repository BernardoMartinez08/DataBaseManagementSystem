/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseManagerTool.ModuloConexion;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author angie
 */
public class CurrentConnection {

    private Conexion conexion;

    public String connection_status = "NO HAY UNA CONEXION ESTABLECIDA";
    public String connection_save_status = "NO SE HA LOGRADO ALMACENAR SU CONEXION";
    public String connection_search_status = "NO SE HA ENCONTRADO UNA CONEXION CON ESTOS DATOS";

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
        return  _conexion;
    }
}
