/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DatabaseManagerTool.PantallaPrincipal;

import DatabaseManagerTool.ModuloConexion.Conexion;
import DatabaseManagerTool.ModuloConexion.CurrentConnection;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import DatabaseManagerTool.Operaciones.BaseOperations;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author angie
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
        conectar();
        cargarDBInformation();
        fill_table_conexion();
    }

    String conection_name = "";
    String user = "";
    String password = "";
    String host = "";
    String port = "";
    String sid = "";

    DefaultMutableTreeNode top = new DefaultMutableTreeNode("Connectios");
    DefaultMutableTreeNode raiz;
    DefaultTreeModel dtm;

    public CurrentConnection conexion_actual = new CurrentConnection(conection_name, host, port, sid, user, password);
    public BaseOperations operaciones = new BaseOperations();

    public void conectar() {
        CurrentConnection auxCurrentCon = new CurrentConnection(conection_name, host, port, sid, user, password);
        Conexion auxCon = auxCurrentCon.searchCurrentConnection();

        conexion_actual = new CurrentConnection(auxCon.getNAME(), auxCon.getHOST(), auxCon.getPORT(), auxCon.getSID(), auxCon.getUSER(), auxCon.getPASSWORD());

        conexion_actual.conectar();
        System.out.println(conexion_actual.conexion.getPORT());

        operaciones.c = conexion_actual.conexion;
    }

    private void cargarDBInformation() {
        raiz = new DefaultMutableTreeNode("Connections");
        dtm = new DefaultTreeModel(raiz);
        cargarDBInformation(raiz);
    }

    /*
    private void cargarDBInformation(DefaultMutableTreeNode _node) {
        ArrayList<Conexion> conexiones = conexion_actual.getConnections();
        String query = "";
        
        for (Conexion conexion : conexiones) {
            DefaultMutableTreeNode conexion_node = new DefaultMutableTreeNode(conexion.getNAME());
            _node.add(conexion_node);

            DefaultMutableTreeNode usuario_node = new DefaultMutableTreeNode(conexion.getUSER().toUpperCase());
            conexion_node.add(usuario_node);
            
            DefaultMutableTreeNode table_spaces_node = new DefaultMutableTreeNode("TABLE SPACES");
            conexion_node.add(table_spaces_node);
            query = "SELECT TABLESPACE_NAME FROM USER_TABLESPACES";
            add_to_tree(table_spaces_node, query, 1);

            DefaultMutableTreeNode tables_node = new DefaultMutableTreeNode("TABLES");
            usuario_node.add(tables_node);
            addTablas(tables_node, conexion.getUSER());

            DefaultMutableTreeNode views_node = new DefaultMutableTreeNode("VIEWS");
            usuario_node.add(views_node);
            query = "SELECT OWNER, VIEW_NAME FROM ALL_VIEWS WHERE OWNER LIKE '%" + user.toUpperCase() + "'";
            add_to_tree(views_node, query, 2);

            DefaultMutableTreeNode packages_node = new DefaultMutableTreeNode("PACKAGES");
            usuario_node.add(packages_node);
            query = "SELECT OWNER, PROCEDURE_NAME, OBJECT_TYPE FROM ALL_PROCEDURES WHERE OWNER LIKE '%" + user.toUpperCase() + "' AND OBJECT_TYPE LIKE '%PACKAGE%'";
            add_to_tree(packages_node, query, 2);

            DefaultMutableTreeNode stored_procedures_node = new DefaultMutableTreeNode("STORED PROCEDURES");
            usuario_node.add(stored_procedures_node);
            query = "SELECT OWNER, PROCEDURE_NAME, OBJECT_TYPE FROM ALL_PROCEDURES WHERE OWNER LIKE '%" + user.toUpperCase() + "' AND OBJECT_TYPE LIKE '%PROCEDURE%'";
            add_to_tree(stored_procedures_node, query, 2);

            DefaultMutableTreeNode functions_node = new DefaultMutableTreeNode("FUNCTIONS");
            usuario_node.add(functions_node);
            query = "SELECT OWNER, PROCEDURE_NAME, OBJECT_TYPE FROM ALL_PROCEDURES WHERE OWNER LIKE '%" + user.toUpperCase() + "' AND OBJECT_TYPE LIKE '%FUNCTION%'";
            add_to_tree(functions_node, query, 2);

            DefaultMutableTreeNode secuences_node = new DefaultMutableTreeNode("SECUENCES");
            usuario_node.add(secuences_node);
            query = "SELECT SEQUENCE_OWNER, SEQUENCE_NAME FROM ALL_SEQUENCES WHERE SEQUENCE_OWNER LIKE '%" + user.toUpperCase() + "'";
            add_to_tree(secuences_node, query, 2);

            DefaultMutableTreeNode triggers_node = new DefaultMutableTreeNode("TRIGGERS");
            usuario_node.add(triggers_node);
            query = "SELECT OWNER, TRIGGER_NAME FROM ALL_TRIGGERS WHERE OWNER LIKE '%" + user.toUpperCase() + "'";
            add_to_tree(triggers_node, query, 2);

            DefaultMutableTreeNode indexes_node = new DefaultMutableTreeNode("INDEXES");
            usuario_node.add(indexes_node);
            query = "SELECT OWNER, INDEX_NAME FROM ALL_INDEXES WHERE OWNER LIKE '%" + user.toUpperCase() + "'";
            add_to_tree(indexes_node, query, 2);

        }
        dtm = new DefaultTreeModel(raiz);
        this.jTree_BDsInfo.setModel(dtm);

    }
     */
    private void cargarDBInformation(DefaultMutableTreeNode _node) {
        String query = "";

        DefaultMutableTreeNode conexion_node = new DefaultMutableTreeNode(conexion_actual.conexion.getNAME());
        _node.add(conexion_node);

        DefaultMutableTreeNode usuario_node = new DefaultMutableTreeNode(conexion_actual.conexion.getUSER().toUpperCase());
        conexion_node.add(usuario_node);

        DefaultMutableTreeNode table_spaces_node = new DefaultMutableTreeNode("TABLE SPACES");
        conexion_node.add(table_spaces_node);
        query = "SELECT TABLESPACE_NAME FROM USER_TABLESPACES";
        add_to_tree(table_spaces_node, query, 1);

        DefaultMutableTreeNode tables_node = new DefaultMutableTreeNode("TABLES");
        usuario_node.add(tables_node);
        addTablas(tables_node);

        DefaultMutableTreeNode views_node = new DefaultMutableTreeNode("VIEWS");
        usuario_node.add(views_node);
        query = "SELECT VIEW_NAME FROM USER_VIEWS";
        add_to_tree(views_node, query, 1);

        DefaultMutableTreeNode packages_node = new DefaultMutableTreeNode("PACKAGES");
        usuario_node.add(packages_node);
        query = "SELECT PROCEDURE_NAME, OBJECT_TYPE FROM USER_PROCEDURES WHERE OBJECT_TYPE LIKE '%PACKAGE%'";
        add_to_tree(packages_node, query, 1);

        DefaultMutableTreeNode stored_procedures_node = new DefaultMutableTreeNode("STORED PROCEDURES");
        usuario_node.add(stored_procedures_node);
        query = "SELECT PROCEDURE_NAME, OBJECT_TYPE FROM USER_PROCEDURES WHERE OBJECT_TYPE LIKE '%PROCEDURE%'";
        add_to_tree(stored_procedures_node, query, 1);

        DefaultMutableTreeNode functions_node = new DefaultMutableTreeNode("FUNCTIONS");
        usuario_node.add(functions_node);
        query = "SELECT PROCEDURE_NAME, OBJECT_TYPE FROM USER_PROCEDURES WHERE OBJECT_TYPE LIKE '%FUNCTION%'";
        add_to_tree(functions_node, query, 1);

        DefaultMutableTreeNode secuences_node = new DefaultMutableTreeNode("SECUENCES");
        usuario_node.add(secuences_node);
        query = "SELECT SEQUENCE_NAME FROM USER_SEQUENCES";
        add_to_tree(secuences_node, query, 1);

        DefaultMutableTreeNode triggers_node = new DefaultMutableTreeNode("TRIGGERS");
        usuario_node.add(triggers_node);
        query = "SELECT TRIGGER_NAME FROM USER_TRIGGERS";
        add_to_tree(triggers_node, query, 1);

        DefaultMutableTreeNode indexes_node = new DefaultMutableTreeNode("INDEXES");
        usuario_node.add(indexes_node);
        query = "SELECT INDEX_NAME FROM USER_INDEXES";
        add_to_tree(indexes_node, query, 1);

        dtm = new DefaultTreeModel(raiz);
        this.jTree_BDsInfo.setModel(dtm);

    }

    private void addTablas(DefaultMutableTreeNode tablas_node) {
        String query = "SELECT TABLE_NAME FROM USER_TABLES";
        ArrayList<String> tables = operaciones.fill_array(query, 1);

        for (String row_table : tables) {
            //System.out.println(row[1] + "\n");
            DefaultMutableTreeNode child_table = new DefaultMutableTreeNode(row_table);
            tablas_node.add(child_table);

            String query_columns = "SELECT TABLE_NAME, COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME LIKE '%" + row_table + "%'";
            ArrayList<String> columns = operaciones.fill_array(query_columns, 2);

            for (String row_columns : columns) {
                DefaultMutableTreeNode child_column = new DefaultMutableTreeNode(row_columns);
                child_table.add(child_column);
            }
        }
    }

    private void add_to_tree(DefaultMutableTreeNode views_node, String query, int columna) {
        ArrayList<String> rows = operaciones.fill_array(query, columna);

        for (String row : rows) {
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(row);
            views_node.add(child);
        }
    }

    public void fill_table_conexion() {
        String[] fila = new String[2];
        String[] columnas = {"ID", "VALUE"};

        DefaultTableModel ModeloTabla = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int colunm) {
                return false;
            }
        };

        fila[0] = "NAME";
        fila[1] = this.conexion_actual.conexion.getNAME();
        ModeloTabla.addRow(fila);

        fila[0] = "USER";
        fila[1] = this.conexion_actual.conexion.getUSER();
        ModeloTabla.addRow(fila);

        fila[0] = "HOST";
        fila[1] = this.conexion_actual.conexion.getHOST();
        ModeloTabla.addRow(fila);

        fila[0] = "PORT";
        fila[1] = this.conexion_actual.conexion.getPORT();
        ModeloTabla.addRow(fila);

        fila[0] = "SID";
        fila[1] = this.conexion_actual.conexion.getSID();
        ModeloTabla.addRow(fila);

        jTableSession.setModel(ModeloTabla);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanelMainScreen = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree_BDsInfo = new javax.swing.JTree();
        jTabbedPane_TableInfo = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableColumns = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableConstrains = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableSession = new javax.swing.JTable();
        jTabbedPane_TableData = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableInfo = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextAreaQuery = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTabbedPaneStatus = new javax.swing.JTabbedPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextAreaStatus = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1690, 840));
        setPreferredSize(new java.awt.Dimension(1690, 870));
        setSize(new java.awt.Dimension(1690, 870));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMainScreen.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMainScreen.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMainScreen.setMinimumSize(new java.awt.Dimension(1680, 830));
        jPanelMainScreen.setPreferredSize(new java.awt.Dimension(1920, 180));
        jPanelMainScreen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTree_BDsInfo.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree_BDsInfoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree_BDsInfo);

        jPanelMainScreen.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 210, 430));

        jTableColumns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableColumns);

        jTabbedPane_TableInfo.addTab("Colums", jScrollPane2);

        jTableConstrains.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableConstrains);

        jTabbedPane_TableInfo.addTab("Constrains", jScrollPane3);

        jTableSession.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(jTableSession);

        jTabbedPane_TableInfo.addTab("Session", jScrollPane10);

        jPanelMainScreen.add(jTabbedPane_TableInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 210, 300));

        jTableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTableData);

        jTabbedPane_TableData.addTab("Data", jScrollPane4);

        jTableInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTableInfo);

        jTabbedPane_TableData.addTab("Information", jScrollPane5);

        jTextAreaQuery.setColumns(20);
        jTextAreaQuery.setRows(5);
        jScrollPane6.setViewportView(jTextAreaQuery);

        jTabbedPane_TableData.addTab("Query", jScrollPane6);

        jPanelMainScreen.add(jTabbedPane_TableData, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 1430, 370));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Oracle Data Base Management System");
        jPanelMainScreen.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 40));

        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Sistema de manejo de base de datos de Oracle");
        jPanelMainScreen.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 400, -1));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(jTable3);

        jTabbedPane1.addTab("Results", jScrollPane7);

        jPanelMainScreen.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 1430, 230));

        jTextAreaStatus.setColumns(20);
        jTextAreaStatus.setRows(5);
        jScrollPane9.setViewportView(jTextAreaStatus);

        jTabbedPaneStatus.addTab("Status", jScrollPane9);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane8.setViewportView(jTextArea2);

        jTabbedPaneStatus.addTab("Exceptions", jScrollPane8);

        jPanelMainScreen.add(jTabbedPaneStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 690, 1430, 120));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DatabaseManagerTool/Recursos/Logos/Oracle-logo.png"))); // NOI18N
        jPanelMainScreen.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 10, 210, 80));

        getContentPane().add(jPanelMainScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1680, 870));
        jPanelMainScreen.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String table = "";
    private void jTree_BDsInfoValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree_BDsInfoValueChanged
        // TODO add your handling code here:
        TreePath path = jTree_BDsInfo.getSelectionPath();
        Object[] nodos;
        TreePath padre;
        try {
            nodos = path.getPath();
            padre = path.getParentPath();

            if (padre.getLastPathComponent().toString().equals("TABLES")) {
                table = nodos[nodos.length - 1].toString();
                
                
                //Informacion en tabla Columns
                String query = "SELECT COLUMN_ID, COLUMN_NAME, DATA_TYPE FROM USER_TAB_COLUMNS WHERE TABLE_NAME = '" + table + "'";
                String[] columns = {"ID", "NAME", "TYPE"};
                this.operaciones.fill_table(query, columns, jTableColumns);

                
                //Informacion en tabla Data
                String[] columns_datos = new String[jTableColumns.getRowCount()];
                for (int i = 0; i < jTableColumns.getRowCount(); i++) {
                    columns_datos[i] = jTableColumns.getValueAt(i, 1).toString();
                }
                String query_select_datos = "SELECT * FROM " + table;
                System.out.println(table);
                this.operaciones.fill_table(query_select_datos, columns_datos, jTableData);
                
                
                //Informacion en tabla Constrains
                String query_constrains = "SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE , TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = '" + table + "' AND CONSTRAINT_TYPE != 'C'";
                String[] columns_constrais = {"CONSTRAINT_NAME"};
                this.operaciones.fill_table(query_constrains, columns_constrais, jTableConstrains);
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTree_BDsInfoValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelMainScreen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPaneStatus;
    private javax.swing.JTabbedPane jTabbedPane_TableData;
    private javax.swing.JTabbedPane jTabbedPane_TableInfo;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTableColumns;
    private javax.swing.JTable jTableConstrains;
    private javax.swing.JTable jTableData;
    private javax.swing.JTable jTableInfo;
    private javax.swing.JTable jTableSession;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextAreaQuery;
    private javax.swing.JTextArea jTextAreaStatus;
    private javax.swing.JTree jTree_BDsInfo;
    // End of variables declaration//GEN-END:variables
}
