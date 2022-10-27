/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseManagerTool.Operaciones;

import DatabaseManagerTool.ModuloConexion.Conexion;
import com.sun.tools.javac.util.StringUtils;
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

    public BaseOperations() {

    }

    public static boolean insert_delete_update(String query) {
        Conexion c = new Conexion();
        try {
            c.conect();
            prepared_statement = c.conexion.prepareStatement(query);
            int i = prepared_statement.executeUpdate();
            c.disconect();

            return i > 0;

        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            c.disconect();
        }
        return false;
    }

    public ResultSet select(String query) {
        Conexion c = new Conexion();
        try {
            c.conect();
            prepared_statement = c.conexion.prepareStatement(query);
            result = prepared_statement.executeQuery();
            c.disconect();
            return result;

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            c.disconect();
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
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = result.getString(i);
                }

                ModeloTabla.addRow(fila);
            }

            tabla.setModel(ModeloTabla);

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            
        }
    }

    public ArrayList fill_array(String query, int _num_columnas) {
        ArrayList datos = new ArrayList();
        String[] fila = new String[_num_columnas];
        try {
            result = select(query);

            while (result.next()) {
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = result.getString(i);
                }

                datos.add(fila);
            }
            return datos;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
        }
        return null;
    }

}
