/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseManagerTool.Operaciones;

import DatabaseManagerTool.ModuloConexion.Conexion;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angie
 */
public class BaseOperations {

    private static PreparedStatement prepared_statement;
    private static ResultSet result;
    DefaultTableModel ModeloTabla;

    public String num_results = "";
    public String exeptions = "";

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
            exeptions = "Error: " + e;
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
            exeptions = "Error: " + e;
        }

        return null;
    }

    public void fill_table(String query, String[] _columnas, JTable tabla) {
        num_results = "";
        exeptions = "";

        String[] fila = new String[_columnas.length];

        ModeloTabla = new DefaultTableModel(null, _columnas) {
            @Override
            public boolean isCellEditable(int row, int colunm) {
                return false;
            }
        };

        try {
            result = select(query);
            ResultSetMetaData rsmd = result.getMetaData();

            int resultados = 0;
            String tabla_name = "";

            while (result.next()) {
                for (int i = 1; i < fila.length + 1; i++) {
                    fila[i - 1] = result.getString(i);
                }
                resultados++;
                ModeloTabla.addRow(fila);
            }

            num_results = "SE RECUPERARON: " + resultados + " RESULTADOS DE: " + rsmd.getColumnCount() + " COLUMNAS.";

            tabla.setModel(ModeloTabla);

            c.disconect();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            exeptions = "Error: " + e;
        } finally {
            c.disconect();
        }
    }

    public ArrayList fill_array(String query, int columna) {
        num_results = "";
        exeptions = "";
        ArrayList datos = new ArrayList();
        String fila = "";
        try {
            result = select(query);
            ResultSetMetaData rsmd = result.getMetaData();

            int resultados = 0;
            while (result.next()) {
                fila = result.getString(columna);
                datos.add(fila);
                resultados++;
            }
            num_results = "SE RECUPERARON: " + resultados + " RESULTADOS DE: " + rsmd.getColumnCount() + " COLUMNAS.";

            c.disconect();
            return datos;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            exeptions = "Error: " + e;
        } finally {
            c.disconect();
        }
        return null;
    }

    public void fill_text_area(String query, JTextArea text_area) {
        try {
            text_area.setText("");
            result = select(query);
            ResultSetMetaData rsmd = result.getMetaData();
            while (result.next()) {

                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String fila = result.getString(i);
                    text_area.append(fila + "\n");
                }
            }

            c.disconect();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            exeptions = "Error: " + e;
        } finally {
            c.disconect();
        }
    }

    public void fill_data(String query, JTabbedPane panel, int n, JTextArea status, JTextArea exception) {
        try {
            num_results = "";
            exeptions = "";
            result = select(query);
            if (result != null) {
                ResultSetMetaData rsmd = result.getMetaData();
                int num_columns = rsmd.getColumnCount();

                String columnas[] = new String[num_columns];

                for (int i = 1; i <= num_columns; i++) {
                    String _columna = rsmd.getColumnLabel(i);
                    columnas[i - 1] = (_columna.toUpperCase());
                }

                String[] fila = new String[num_columns];

                ModeloTabla = new DefaultTableModel(null, columnas) {
                    @Override
                    public boolean isCellEditable(int row, int colunm) {
                        return false;
                    }
                };

                int resultados = 0;
                while (result.next()) {
                    for (int i = 1; i < fila.length + 1; i++) {
                        fila[i - 1] = result.getString(i);
                    }
                    ModeloTabla.addRow(fila);
                    resultados++;
                }

                num_results = "SE RECUPERARON: " + resultados + " RESULTADOS DE: " + rsmd.getColumnCount() + " COLUMNAS.";

                String _status = status.getText() + num_results + "\n\n";
                status.setText(_status);

                String _exeptions = exception.getText() + exeptions + "\n\n";
                exception.setText(_exeptions);

                JTable tabla = new JTable();
                tabla.setModel(ModeloTabla);

                JScrollPane panel_scroll = null;
                panel_scroll = new JScrollPane(tabla,
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                tabla.setFillsViewportHeight(true);
                tabla.setFillsViewportHeight(true);

                panel.add("Result " + n, panel_scroll);
            } else {
                exeptions = "Error: RESULTADO FUE NULL";
            }
            c.disconect();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            exeptions = "Error: " + e;
        } finally {
            c.disconect();
        }
    }

    public void import_sqlfile_script(File file, JTextArea text_area) {
        FileReader fr = null;
        try {

            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            String lineaBD = "";

            while (linea != null) {
                if (linea.length() != 0) {
                    char Firstchar = linea.charAt(0);

                    if (Firstchar != '/' && Firstchar != '-' && linea.length() != 0) {
                        char LastChar = linea.charAt(linea.length() - 1);

                        if (LastChar == ';') {
                            linea = linea.substring(0, linea.length() - 1);
                            PreparedStatement ps = c.conexion.prepareStatement(lineaBD + linea);
                            text_area.append("\n" + lineaBD + linea);
                            ps.executeUpdate();
                            ps.close();
                            lineaBD = "";
                            linea = br.readLine();
                        } else {
                            lineaBD += linea;
                            linea = br.readLine();
                        }
                    } else {
                        linea = br.readLine();
                    }
                } else {
                    linea = br.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "El documento que desea ejecutar, no fue encontrado", "ARCHIVOS NO ENCONTRADOS", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "El documento que desea ejecutar, no permitio la lectura de manera correcta", "ARCHIVOS NO PUEDIERON SER LEIDOS", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El script que desea extraer no fue posible de ejecutar", "ERROR DE SCRIPT", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void import_sqlfile_query(File file, JTabbedPane panel, JTextArea text_area, JTextArea st, JTextArea exep) {
        FileReader fr = null;
        try {

            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            String lineaBD = "";

            int n = 0;
            while (linea != null) {
                if (linea.length() != 0) {
                    char Firstchar = linea.charAt(0);

                    if (Firstchar != '/' && Firstchar != '-' && linea.length() != 0) {
                        char LastChar = linea.charAt(linea.length() - 1);

                        if (LastChar == ';') {
                            linea = linea.substring(0, linea.length() - 1);
                            String query = lineaBD + linea;
                            text_area.append(query + "\n");
                            fill_data(query, panel, n, st, exep);
                            lineaBD = "";
                            linea = br.readLine();
                            n++;
                        } else {
                            lineaBD += linea;
                            linea = br.readLine();
                        }
                    } else {
                        linea = br.readLine();
                    }
                } else {
                    linea = br.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "El documento que desea ejecutar, no fue encontrado", "ARCHIVOS NO ENCONTRADOS", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "El documento que desea ejecutar, no permitio la lectura de manera correcta", "ARCHIVOS NO PUEDIERON SER LEIDOS", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void split_querys(String querys, JTabbedPane panel, JTextArea st, JTextArea exep) {
        String[] lineas = querys.split("\n");
        String lineaBD = "";
        int n = 0;
        for (String linea : lineas) {
            if (linea.length() != 0) {
                char Firstchar = linea.charAt(0);

                if (Firstchar != '/' && Firstchar != '-' && linea.length() != 0) {
                    char LastChar = linea.charAt(linea.length() - 1);

                    if (LastChar == ';') {
                        linea = linea.substring(0, linea.length() - 1);
                        String query = lineaBD + linea;
                        fill_data(query, panel, n, st, exep);
                        lineaBD = "";
                        n++;
                    } else {
                        lineaBD += linea;
                    }
                }
            }
        }
    }
}
