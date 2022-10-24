/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DatabaseManagerTool.PantallaUsuarios;

/**
 *
 * @author angie
 */
public class UserScreen extends javax.swing.JFrame {

    /**
     * Creates new form UserScreen
     */
    public UserScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        jPanelImagen = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtDefRole = new javax.swing.JTextField();
        jtxtUserName = new javax.swing.JTextField();
        jtxtUserPass = new javax.swing.JTextField();
        jtxtDefTabSpa = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaResult = new javax.swing.JTextArea();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTreeUsers = new javax.swing.JTree();
        jbtCreateUser = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1680, 870));
        setSize(new java.awt.Dimension(1680, 870));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelLogin.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelImagen.setBackground(new java.awt.Color(102, 204, 255));
        jPanelImagen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DatabaseManagerTool/Recursos/Imagenes/admin-login.png"))); // NOI18N
        jPanelImagen.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jPanelLogin.add(jPanelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 870));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("USERS");
        jPanelLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Default Role:");
        jPanelLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Nombre de Usuario:");
        jPanelLogin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Contraseña:");
        jPanelLogin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Default TableSpace:");
        jPanelLogin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 210, -1, -1));

        jtxtDefRole.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtDefRole.setForeground(new java.awt.Color(102, 102, 102));
        jPanelLogin.add(jtxtDefRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 330, 340, -1));

        jtxtUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtUserName.setForeground(new java.awt.Color(102, 102, 102));
        jPanelLogin.add(jtxtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 340, -1));

        jtxtUserPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtUserPass.setForeground(new java.awt.Color(102, 102, 102));
        jPanelLogin.add(jtxtUserPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 150, 340, -1));

        jtxtDefTabSpa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtDefTabSpa.setForeground(new java.awt.Color(102, 102, 102));
        jPanelLogin.add(jtxtDefTabSpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 240, 340, -1));

        jTextAreaResult.setColumns(20);
        jTextAreaResult.setRows(5);
        jScrollPane1.setViewportView(jTextAreaResult);

        jTabbedPane1.addTab("Result", jScrollPane1);

        jPanelLogin.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 710, 970, 160));

        jScrollPane2.setViewportView(jTreeUsers);

        jTabbedPane2.addTab("Users", jScrollPane2);

        jPanelLogin.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 290, 710));

        jbtCreateUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtCreateUser.setForeground(new java.awt.Color(102, 102, 102));
        jbtCreateUser.setText("CREATE");
        jPanelLogin.add(jbtCreateUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 390, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DatabaseManagerTool/Recursos/Imagenes/loginIcon.png"))); // NOI18N
        jPanelLogin.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 110, 210, 210));

        getContentPane().add(jPanelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1680, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(UserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanelImagen;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextAreaResult;
    private javax.swing.JTree jTreeUsers;
    private javax.swing.JButton jbtCreateUser;
    private javax.swing.JTextField jtxtDefRole;
    private javax.swing.JTextField jtxtDefTabSpa;
    private javax.swing.JTextField jtxtUserName;
    private javax.swing.JTextField jtxtUserPass;
    // End of variables declaration//GEN-END:variables
}