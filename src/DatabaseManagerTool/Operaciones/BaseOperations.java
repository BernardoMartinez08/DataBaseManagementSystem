/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseManagerTool.Operaciones;

import DatabaseManagerTool.ModuloConexion.Conexion;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angie
 */
public class BaseOperations {

    private static PreparedStatement prepared_statement;
    private static ResultSet result;
    DefaultTableModel ModeloTabla;

    public Conexion c;

    public BaseOperations() {

    }

    public boolean insert_delete_update(String query) {
        try {
            c.conect();
            prepared_statement = c.conexion.prepareStatement(query);
            int i = prepared_statement.executeUpdate();

            return i > 0;

        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    public ResultSet select(String query) {
        try {
            c.conect();
            prepared_statement = c.conexion.prepareStatement(query);
            result = prepared_statement.executeQuery();
            return result;

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return null;
    }

    public void fill_table(String query, String[] _columnas, JTable tabla) {
        /*
        String columnas_data = "";
        for (String _columna : _columnas) {
            columnas_data += StringUtils.toUpperCase(_columna);
        }
        
        String[] columnas = {columnas_data};
         */

        String[] fila = new String[_columnas.length];

        ModeloTabla = new DefaultTableModel(null, _columnas) {
            @Override
            public boolean isCellEditable(int row, int colunm) {
                return false;
            }
        };

        try {
            result = select(query);
            
            while (result.next()) {
                for (int i = 1; i < fila.length + 1; i++) {
                    fila[i - 1] = result.getString(i);
                }                
                ModeloTabla.addRow(fila);
            }

            tabla.setModel(ModeloTabla);
            c.disconect();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            c.disconect();
        }
    }

    public ArrayList fill_array(String query, int columna) {
        ArrayList datos = new ArrayList();
        String fila = "";
        try {
            result = select(query);

            while (result.next()) {
                fila = result.getString(columna);
                datos.add(fila);
            }
            //System.out.println(fila);

            c.disconect();
            return datos;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            c.disconect();
        }
        return null;
    }

}
