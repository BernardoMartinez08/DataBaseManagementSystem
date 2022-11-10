/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DatabaseManagerTool.PantallaPrincipal;

import DatabaseManagerTool.ModuloConexion.Conexion;
import DatabaseManagerTool.ModuloConexion.CurrentConnection;
import DatabaseManagerTool.PantallaConexiones.ConnectionScreen;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import DatabaseManagerTool.Operaciones.BaseOperations;
import java.io.File;
import javax.swing.JFileChooser;
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

    private void add_to_tree(DefaultMutableTreeNode node, String query, int columna) {
        ArrayList<String> rows = operaciones.fill_array(query, columna);

        for (String row : rows) {
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(row);
            node.add(child);
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

    public File extract_sqlfile() {
        JFileChooser file_chooser = new JFileChooser();
        file_chooser.showOpenDialog(this);
        File fileChoosed = file_chooser.getSelectedFile();

        if (fileChoosed != null) {
            return fileChoosed;
        }
        return null;
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
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextAreaQuery = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaDDL = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPaneResults = new javax.swing.JTabbedPane();
        jTabbedPaneStatus = new javax.swing.JTabbedPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextAreaStatus = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextAreaExceptions = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jbtDesconectar = new javax.swing.JButton();
        jBtImportScript = new javax.swing.JButton();
        jBtExecute = new javax.swing.JButton();
        jBtImportSql2 = new javax.swing.JButton();
        jBtUpdateDB = new javax.swing.JButton();
        jBtClearResults1 = new javax.swing.JButton();

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

        jTextAreaQuery.setColumns(20);
        jTextAreaQuery.setRows(5);
        jTextAreaQuery.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextAreaQueryInputMethodTextChanged(evt);
            }
        });
        jTextAreaQuery.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextAreaQueryKeyPressed(evt);
            }
        });
        jScrollPane6.setViewportView(jTextAreaQuery);

        jTabbedPane_TableData.addTab("Query", jScrollPane6);

        jTextAreaDDL.setColumns(20);
        jTextAreaDDL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextAreaDDL.setRows(5);
        jScrollPane7.setViewportView(jTextAreaDDL);

        jTabbedPane_TableData.addTab("DDL", jScrollPane7);

        jPanelMainScreen.add(jTabbedPane_TableData, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 1430, 370));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Oracle Data Base Management System");
        jPanelMainScreen.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 40));

        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Sistema de manejo de base de datos de Oracle");
        jPanelMainScreen.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 400, -1));
        jPanelMainScreen.add(jTabbedPaneResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 1430, 230));

        jTextAreaStatus.setColumns(20);
        jTextAreaStatus.setRows(5);
        jScrollPane9.setViewportView(jTextAreaStatus);

        jTabbedPaneStatus.addTab("Status", jScrollPane9);

        jTextAreaExceptions.setColumns(20);
        jTextAreaExceptions.setRows(5);
        jScrollPane8.setViewportView(jTextAreaExceptions);

        jTabbedPaneStatus.addTab("Exceptions", jScrollPane8);

        jPanelMainScreen.add(jTabbedPaneStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 690, 1430, 120));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DatabaseManagerTool/Recursos/Logos/Oracle-logo.png"))); // NOI18N
        jPanelMainScreen.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 10, 210, 30));

        jbtDesconectar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtDesconectar.setForeground(new java.awt.Color(102, 102, 102));
        jbtDesconectar.setText("DISCONNECT");
        jbtDesconectar.setActionCommand("");
        jbtDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDesconectarActionPerformed(evt);
            }
        });
        jPanelMainScreen.add(jbtDesconectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 50, 150, 40));

        jBtImportScript.setBackground(new java.awt.Color(255, 102, 102));
        jBtImportScript.setForeground(new java.awt.Color(255, 255, 255));
        jBtImportScript.setText("IMPORT SCRIPT");
        jBtImportScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImportScriptActionPerformed(evt);
            }
        });
        jPanelMainScreen.add(jBtImportScript, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 50, -1, -1));

        jBtExecute.setBackground(new java.awt.Color(255, 102, 102));
        jBtExecute.setForeground(new java.awt.Color(255, 255, 255));
        jBtExecute.setText("EXECUTE");
        jBtExecute.setEnabled(false);
        jBtExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExecuteActionPerformed(evt);
            }
        });
        jPanelMainScreen.add(jBtExecute, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));

        jBtImportSql2.setBackground(new java.awt.Color(255, 102, 102));
        jBtImportSql2.setForeground(new java.awt.Color(255, 255, 255));
        jBtImportSql2.setText("IMPORT SQL");
        jBtImportSql2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImportSql2ActionPerformed(evt);
            }
        });
        jPanelMainScreen.add(jBtImportSql2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 50, -1, -1));

        jBtUpdateDB.setBackground(new java.awt.Color(255, 102, 102));
        jBtUpdateDB.setForeground(new java.awt.Color(255, 255, 255));
        jBtUpdateDB.setText("UPDATE DATABASE");
        jBtUpdateDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtUpdateDBActionPerformed(evt);
            }
        });
        jPanelMainScreen.add(jBtUpdateDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, -1, -1));

        jBtClearResults1.setBackground(new java.awt.Color(255, 102, 102));
        jBtClearResults1.setForeground(new java.awt.Color(255, 255, 255));
        jBtClearResults1.setText("CLEAR RESULTS");
        jBtClearResults1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtClearResults1ActionPerformed(evt);
            }
        });
        jPanelMainScreen.add(jBtClearResults1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

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

                String _status = jTextAreaStatus.getText() + "\n\n" + operaciones.num_results;
                jTextAreaStatus.setText(_status);

                //Informacion en tabla Data
                String[] columns_datos = new String[jTableColumns.getRowCount()];
                for (int i = 0; i < jTableColumns.getRowCount(); i++) {
                    columns_datos[i] = jTableColumns.getValueAt(i, 1).toString();
                }
                String query_select_datos = "SELECT * FROM " + table;
                this.operaciones.fill_table(query_select_datos, columns_datos, jTableData);

                _status = jTextAreaStatus.getText() + "\n\n" + operaciones.num_results;
                jTextAreaStatus.setText(_status);

                //Informacion en tabla Constrains
                String query_constrains = "SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE , TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = '" + table + "' AND CONSTRAINT_TYPE != 'C'";
                String[] columns_constrais = {"CONSTRAINT_NAME"};
                this.operaciones.fill_table(query_constrains, columns_constrais, jTableConstrains);

                _status = jTextAreaStatus.getText() + "\n\n" + operaciones.num_results;
                jTextAreaStatus.setText(_status);
                
                
                //Informacion de tabla ddl
                String query_ddl = "SELECT dbms_metadata.get_ddl('TABLE', '" + table + "', '" + user + "') FROM dual";
                this.operaciones.fill_text_area(query_ddl, jTextAreaDDL);
            }
            
            if (padre.getLastPathComponent().toString().equals("VIEWS")) {
                String view = nodos[nodos.length - 1].toString();              
                
                //Informacion de tabla ddl
                String query_ddl = "SELECT dbms_metadata.get_ddl('VIEW', '" + view + "', '" + user + "') FROM dual";
                this.operaciones.fill_text_area(query_ddl, jTextAreaDDL);
            }
            
            if (padre.getLastPathComponent().toString().equals("PACKAGES")) {
                String _package = nodos[nodos.length - 1].toString();              
                
                //Informacion de tabla ddl
                String query_ddl = "SELECT dbms_metadata.get_ddl('PACKAGE', '" + _package + "', '" + user + "') FROM dual";
                this.operaciones.fill_text_area(query_ddl, jTextAreaDDL);
            }

            if (padre.getLastPathComponent().toString().equals("SECUENCES")) {
                String secuence = nodos[nodos.length - 1].toString();              
                
                //Informacion de tabla ddl
                String query_ddl = "SELECT dbms_metadata.get_ddl('SEQUENCE', '" + secuence + "', '" + user + "') FROM dual";
                this.operaciones.fill_text_area(query_ddl, jTextAreaDDL);
            }
            
            if (padre.getLastPathComponent().toString().equals("TRIGGERS")) {
                String trigger = nodos[nodos.length - 1].toString();              
                
                //Informacion de tabla ddl
                String query_ddl = "SELECT dbms_metadata.get_ddl('TRIGGER', '" + trigger + "', '" + user + "') FROM dual";
                this.operaciones.fill_text_area(query_ddl, jTextAreaDDL);
            }
            
            if (padre.getLastPathComponent().toString().equals("INDEXES")) {
                String index = nodos[nodos.length - 1].toString();              
                
                //Informacion de tabla ddl
                String query_ddl = "SELECT dbms_metadata.get_ddl('INDEX', '" + index + "', '" + user + "') FROM dual";
                this.operaciones.fill_text_area(query_ddl, jTextAreaDDL);
            }
            
            if (padre.getLastPathComponent().toString().equals("PACKAGES") || padre.getLastPathComponent().toString().equals("STORED PROCEDURES") || padre.getLastPathComponent().toString().equals("FUNCTIONS")) {
                String procedure = nodos[nodos.length - 1].toString();              
                
                //Informacion de tabla ddl
                String query_ddl = "SELECT dbms_metadata.get_ddl('PROCEDURE', '" + procedure + "', '" + user + "') FROM dual";
                this.operaciones.fill_text_area(query_ddl, jTextAreaDDL);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTree_BDsInfoValueChanged

    private void jbtDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDesconectarActionPerformed
        // TODO add your handling code here:
        ConnectionScreen connection_screen = new ConnectionScreen();
        conexion_actual.desconectar();
        connection_screen.setVisible(true);
        dispose();
    }//GEN-LAST:event_jbtDesconectarActionPerformed


    private void jBtExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExecuteActionPerformed
        // TODO add your handling code here:
        String query = jTextAreaQuery.getText();
        operaciones.split_querys(query, jTabbedPaneResults, jTextAreaStatus, jTextAreaExceptions);
    }//GEN-LAST:event_jBtExecuteActionPerformed

    private void jBtImportScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImportScriptActionPerformed
        // TODO add your handling code here:
        File script = extract_sqlfile();
        
        operaciones.import_sqlfile_script(script, jTextAreaQuery);
    }//GEN-LAST:event_jBtImportScriptActionPerformed

    private void jBtImportSql2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImportSql2ActionPerformed
        // TODO add your handling code here:
        File querys = extract_sqlfile();
        
        operaciones.import_sqlfile_query(querys, jTabbedPaneResults, jTextAreaQuery, jTextAreaStatus, jTextAreaExceptions);
    }//GEN-LAST:event_jBtImportSql2ActionPerformed

    private void jBtUpdateDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtUpdateDBActionPerformed
        // TODO add your handling code here:
        cargarDBInformation();
    }//GEN-LAST:event_jBtUpdateDBActionPerformed

    private void jBtClearResults1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtClearResults1ActionPerformed
        // TODO add your handling code here:
        jTabbedPaneResults.removeAll();
    }//GEN-LAST:event_jBtClearResults1ActionPerformed

    private void jTextAreaQueryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaQueryKeyPressed
        // TODO add your handling code here:
        if (jTextAreaQuery.getText().isEmpty()) {
            jBtExecute.setEnabled(false);
        } else {
            jBtExecute.setEnabled(true);
        }
    }//GEN-LAST:event_jTextAreaQueryKeyPressed

    private void jTextAreaQueryInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextAreaQueryInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAreaQueryInputMethodTextChanged

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
    private javax.swing.JButton jBtClearResults1;
    private javax.swing.JButton jBtExecute;
    private javax.swing.JButton jBtImportScript;
    private javax.swing.JButton jBtImportSql2;
    private javax.swing.JButton jBtUpdateDB;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPaneResults;
    private javax.swing.JTabbedPane jTabbedPaneStatus;
    private javax.swing.JTabbedPane jTabbedPane_TableData;
    private javax.swing.JTabbedPane jTabbedPane_TableInfo;
    private javax.swing.JTable jTableColumns;
    private javax.swing.JTable jTableConstrains;
    private javax.swing.JTable jTableData;
    private javax.swing.JTable jTableSession;
    private javax.swing.JTextArea jTextAreaDDL;
    private javax.swing.JTextArea jTextAreaExceptions;
    private javax.swing.JTextArea jTextAreaQuery;
    private javax.swing.JTextArea jTextAreaStatus;
    private javax.swing.JTree jTree_BDsInfo;
    private javax.swing.JButton jbtDesconectar;
    // End of variables declaration//GEN-END:variables
}
