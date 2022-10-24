/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DatabaseManagerTool.PantallaConexiones;

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
    }
    
    public boolean GuardarConexion(){
        
        return false;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTreeUsers = new javax.swing.JTree();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaResult = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtConName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanelUserData1 = new javax.swing.JPanel();
        jtxtUserPass1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtUserName2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jCBTypeCon = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTabbedPaneDetails = new javax.swing.JTabbedPane();
        jPanelUserData = new javax.swing.JPanel();
        jtxtUserPass = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtUserName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtxtUserPass2 = new javax.swing.JTextField();
        jbtCreateUser1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jbtCreateUser2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1680, 870));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelImagen.setBackground(new java.awt.Color(102, 204, 255));
        jPanelImagen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DatabaseManagerTool/Recursos/Imagenes/cloud-computing-modern-flat-concept-for-web-banner-design-woman-working-on-laptop-processing-files-and-images-online-and-using-cloud-technologies-illustration-with-isolated-people-scene-free-vector__1.png"))); // NOI18N
        jPanelImagen.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 480, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DatabaseManagerTool/Recursos/Imagenes/ConnectionDB.png"))); // NOI18N
        jPanelImagen.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jPanel1.add(jPanelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 870));

        jScrollPane2.setViewportView(jTreeUsers);

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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DatabaseManagerTool/Recursos/Imagenes/HostImage.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 400, 130, 210));

        jtxtConName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtConName.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jtxtConName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 370, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Nombre de la Conexion:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, -1, -1));

        jPanelUserData1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelUserData1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtUserPass1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtUserPass1.setForeground(new java.awt.Color(102, 102, 102));
        jPanelUserData1.add(jtxtUserPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 340, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Tipo de Conexion:");
        jPanelUserData1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jtxtUserName2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtUserName2.setForeground(new java.awt.Color(102, 102, 102));
        jPanelUserData1.add(jtxtUserName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 340, -1));

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

        jtxtUserPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtUserPass.setForeground(new java.awt.Color(102, 102, 102));
        jPanelUserData.add(jtxtUserPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 340, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Port:");
        jPanelUserData.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jtxtUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtUserName.setForeground(new java.awt.Color(102, 102, 102));
        jPanelUserData.add(jtxtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 340, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Host:");
        jPanelUserData.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("SID:");
        jPanelUserData.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jtxtUserPass2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtUserPass2.setForeground(new java.awt.Color(102, 102, 102));
        jPanelUserData.add(jtxtUserPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 340, -1));

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

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DatabaseManagerTool/Recursos/Imagenes/DBConnection.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 110, 210, 210));

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
    }//GEN-LAST:event_jbtCreateUser2ActionPerformed

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
            java.util.logging.Logger.getLogger(ConnectionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTree jTreeUsers;
    private javax.swing.JButton jbtCreateUser1;
    private javax.swing.JButton jbtCreateUser2;
    private javax.swing.JTextField jtxtConName;
    private javax.swing.JTextField jtxtUserName;
    private javax.swing.JTextField jtxtUserName2;
    private javax.swing.JTextField jtxtUserPass;
    private javax.swing.JTextField jtxtUserPass1;
    private javax.swing.JTextField jtxtUserPass2;
    // End of variables declaration//GEN-END:variables
}
