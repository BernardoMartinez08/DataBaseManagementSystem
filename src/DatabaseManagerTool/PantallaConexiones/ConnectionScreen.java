/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DatabaseManagerTool.PantallaConexiones;

import javax.swing.JOptionPane;
import DatabaseManagerTool.ModuloConexion.CurrentConnection;
import DatabaseManagerTool.ModuloConexion.Conexion;
import DatabaseManagerTool.PantallaPrincipal.MainScreen;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author angie
 */
public class ConnectionScreen extends javax.swing.JFrame {

    /**
     * Creates new form ConexionScreen
     */
    public ConnectionScreen() {
        initComponents();
        initLostFocusEvents();
        addHijo();
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
    
    public boolean conectar() {
        if (!conection_name.equals("")) {
            if (!user.equals("")) {
                if (!password.equals("")) {
                    if (!host.equals("")) {
                        if (!port.equals("")) {
                            if (!sid.equals("")) {
                                conexion_actual = new CurrentConnection(conection_name, host, port, sid, user, password);
                                conexion_actual.conectar();
                                addHijo();
                                JOptionPane.showMessageDialog(null, conexion_actual.connection_status, "ESTADO DE LA CONEXION", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Debe ingresar el SID que correspomde al servidor al que desea conectarse, Intente denuevo.", "FALTAN DATOS", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe ingresar el puerto del servidor al que desea conectarse, Intente denuevo.", "FALTAN DATOS", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe ingresar el host del servidor al que desea conectarse, Intente denuevo.", "FALTAN DATOS", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar la contraseña del usuario para poder verificar su identidad, Intente denuevo.", "FALTAN DATOS", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del usuario para poder conectarse, Intente denuevo.", "FALTAN DATOS", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe asignar un nombre a su conexion, Intente denuevo.", "FALTAN DATOS", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    final void initLostFocusEvents() {
        this.jtxtConName.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                conection_name = jtxtConName.getText();
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
            }
        });

        this.jtxtUserName.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                user = jtxtUserName.getText();
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
            }
        });

        this.jtxtUserPass.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                password = jtxtUserPass.getText();
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
            }
        });

        this.jtxtHost.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                host = jtxtHost.getText();
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
            }
        });

        this.jtxtPort.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                port = jtxtPort.getText();
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
            }
        });

        this.jtxtSID.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                sid = jtxtSID.getText();
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void addHijo() {
        raiz = new DefaultMutableTreeNode("Connections");
        dtm = new DefaultTreeModel(raiz);
        addHijo(raiz);
    }

    private void addHijo(DefaultMutableTreeNode node) {
        ArrayList<Conexion> conexiones = conexion_actual.getConnections();

        for (Conexion conexion : conexiones) {
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(conexion.getNAME());
            node.add(child);

            child.add(new DefaultMutableTreeNode("HOST: " + conexion.getHOST()));
            child.add(new DefaultMutableTreeNode("PORT: " + conexion.getPORT()));
            child.add(new DefaultMutableTreeNode("SID: " + conexion.getSID()));
        }
        dtm = new DefaultTreeModel(raiz);
        this.jTreeConnectios.setModel(dtm);

    }

/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelImagen = new javax.swing.JPanel();
        jLabelLoginIcon = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTreeConnectios = new javax.swing.JTree();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaResult = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabelConnectionIcon = new javax.swing.JLabel();
        jtxtConName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanelUserData1 = new javax.swing.JPanel();
        jtxtUserPass = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtUserName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jCBTypeCon = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTabbedPaneDetails = new javax.swing.JTabbedPane();
        jPanelUserData = new javax.swing.JPanel();
        jtxtPort = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtHost = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtxtSID = new javax.swing.JTextField();
        jbtCreateUser1 = new javax.swing.JButton();
        jLabelDBIcon = new javax.swing.JLabel();
        jbtCreateUser2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1680, 870));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelImagen.setBackground(new java.awt.Color(102, 204, 255));
        jPanelImagen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLoginIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DatabaseManagerTool/Recursos/Imagenes/ConnectionDB.png"))); // NOI18N
        jPanelImagen.add(jLabelLoginIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jPanel1.add(jPanelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 870));

        jTreeConnectios.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeConnectiosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jTreeConnectios);

        jTabbedPane2.addTab("Connections", jScrollPane2);

        jPanel1.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 290, 710));

        jTextAreaResult.setColumns(20);
        jTextAreaResult.setRows(5);
        jScrollPane1.setViewportView(jTextAreaResult);

        jTabbedPane1.addTab("Result", jScrollPane1);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 710, 970, 160));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("CONNECTIONS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 20, -1, -1));

        jLabelConnectionIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DatabaseManagerTool/Recursos/Imagenes/HostImage.png"))); // NOI18N
        jPanel1.add(jLabelConnectionIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 400, 130, 210));

        jtxtConName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtConName.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jtxtConName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 370, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Nombre de la Conexion:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, -1, -1));

        jPanelUserData1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelUserData1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtUserPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtUserPass.setForeground(new java.awt.Color(102, 102, 102));
        jPanelUserData1.add(jtxtUserPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 340, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Tipo de Conexion:");
        jPanelUserData1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jtxtUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtUserName.setForeground(new java.awt.Color(102, 102, 102));
        jPanelUserData1.add(jtxtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 340, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Nombre de Usuario:");
        jPanelUserData1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jCBTypeCon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCBTypeCon.setForeground(new java.awt.Color(102, 102, 102));
        jCBTypeCon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "default", "SYSDBA", "SYSOPER", "SYSBACKUP", "SYSDG", "SYSKM", "SYSASM" }));
        jPanelUserData1.add(jCBTypeCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 130, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Contraseña:");
        jPanelUserData1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jTabbedPane4.addTab("USER INFO", jPanelUserData1);

        jPanel1.add(jTabbedPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 150, 370, 230));

        jPanelUserData.setBackground(new java.awt.Color(255, 255, 255));
        jPanelUserData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtPort.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtPort.setForeground(new java.awt.Color(102, 102, 102));
        jPanelUserData.add(jtxtPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 340, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Port:");
        jPanelUserData.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jtxtHost.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtHost.setForeground(new java.awt.Color(102, 102, 102));
        jPanelUserData.add(jtxtHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 340, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Host:");
        jPanelUserData.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("SID:");
        jPanelUserData.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jtxtSID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtSID.setForeground(new java.awt.Color(102, 102, 102));
        jPanelUserData.add(jtxtSID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 340, -1));

        jTabbedPaneDetails.addTab("DETAILS", jPanelUserData);

        jPanel1.add(jTabbedPaneDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 390, 370, 270));

        jbtCreateUser1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtCreateUser1.setForeground(new java.awt.Color(102, 102, 102));
        jbtCreateUser1.setText("SAVE");
        jbtCreateUser1.setActionCommand("");
        jbtCreateUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCreateUser1ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtCreateUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 670, -1, -1));

        jLabelDBIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DatabaseManagerTool/Recursos/Imagenes/DBConnection.png"))); // NOI18N
        jPanel1.add(jLabelDBIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 110, 210, 210));

        jbtCreateUser2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtCreateUser2.setForeground(new java.awt.Color(102, 102, 102));
        jbtCreateUser2.setText("CONNECT");
        jbtCreateUser2.setActionCommand("");
        jbtCreateUser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCreateUser2ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtCreateUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 670, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1680, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCreateUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCreateUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtCreateUser1ActionPerformed

    private void jbtCreateUser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCreateUser2ActionPerformed
        // TODO add your handling code here:
        conectar();
        MainScreen main_screen = new MainScreen();
        main_screen.setVisible(true);
        dispose();
    }//GEN-LAST:event_jbtCreateUser2ActionPerformed

    private void jTreeConnectiosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeConnectiosValueChanged
        // TODO add your handling code here:
        
        TreePath path = jTreeConnectios.getSelectionPath();
        Object [] nodos;
        try{
            nodos = path.getPath();
            for (Object nodo: nodos){
                Conexion aux = conexion_actual.searchConexion(nodo.toString());
                jtxtConName.setText(aux.getNAME());
                conection_name = aux.getNAME();
                
                jtxtHost.setText(aux.getHOST());
                host = aux.getHOST();
                
                jtxtPort.setText(aux.getPORT());
                port = aux.getPORT();
                
                jtxtSID.setText(aux.getSID());
                sid = aux.getSID();
                
                jtxtUserName.setText(aux.getUSER());
                user = aux.getUSER();
                
                jtxtUserPass.setText("");
                password = "";
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jTreeConnectiosValueChanged

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
            java.util.logging.Logger.getLogger(ConnectionScreen.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectionScreen.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectionScreen.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectionScreen.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectionScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCBTypeCon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelConnectionIcon;
    private javax.swing.JLabel jLabelDBIcon;
    private javax.swing.JLabel jLabelLoginIcon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelImagen;
    private javax.swing.JPanel jPanelUserData;
    private javax.swing.JPanel jPanelUserData1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPaneDetails;
    private javax.swing.JTextArea jTextAreaResult;
    private javax.swing.JTree jTreeConnectios;
    private javax.swing.JButton jbtCreateUser1;
    private javax.swing.JButton jbtCreateUser2;
    private javax.swing.JTextField jtxtConName;
    private javax.swing.JTextField jtxtHost;
    private javax.swing.JTextField jtxtPort;
    private javax.swing.JTextField jtxtSID;
    private javax.swing.JTextField jtxtUserName;
    private javax.swing.JTextField jtxtUserPass;
    // End of variables declaration//GEN-END:variables
}
