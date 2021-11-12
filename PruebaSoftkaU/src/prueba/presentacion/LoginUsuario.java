package prueba.presentacion;

import javax.swing.JOptionPane;
import prueba.exeptions.InnovaModelException;
import static prueba.logica.Constantes.ALGORITMO;
import prueba.logica.Fabrica;
import static prueba.logica.Hash.getHash;
import prueba.logica.entidades.Usuario;

public class LoginUsuario extends javax.swing.JFrame {
    
    Fabrica fabrica = new Fabrica();

    public LoginUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Nickname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boton_jugar = new javax.swing.JButton();
        Registrar = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        ShowPass = new javax.swing.JCheckBox();
        Configuraccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Engravers MT", 0, 36)); // NOI18N
        jLabel1.setText("BIENVENIDOS");
        jLabel1.setMaximumSize(new java.awt.Dimension(330, 20));
        jLabel1.setMinimumSize(new java.awt.Dimension(330, 20));

        Nickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NicknameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dosis", 3, 18)); // NOI18N
        jLabel2.setText("Nickname:");

        jLabel3.setFont(new java.awt.Font("Dosis", 3, 18)); // NOI18N
        jLabel3.setText("Password:");

        boton_jugar.setText("JUGAR!");
        boton_jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_jugarActionPerformed(evt);
            }
        });

        Registrar.setText("Registrar Usuario");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        ShowPass.setText("Show Pass");
        ShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPassActionPerformed(evt);
            }
        });

        Configuraccion.setText("Configuraccion");
        Configuraccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiguraccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Nickname, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ShowPass)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Password))))
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Configuraccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Registrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton_jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Nickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShowPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_jugar)
                    .addComponent(Registrar)
                    .addComponent(Configuraccion))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NicknameActionPerformed

    private void boton_jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_jugarActionPerformed
        try {
            String nickname = this.Nickname.getText();
            String pass = this.Password.getText();
            
            String claveHash = getHash(this.Password.getText().getBytes(), ALGORITMO);
            //usuario.setPass(claveHash);
            Usuario usuario = new Usuario(nickname,claveHash);
            fabrica.getUsuarioControladorImpl().LoginUsuario(nickname, claveHash);
       
            MenuPrincipal ec = new MenuPrincipal();
            ec.outputPlayer.setText("Usuario: "+usuario.getNickname());
            ec.setVisible(true);
            this.setVisible(false);
            
        } catch (InnovaModelException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, String.format("Error [%s]", e.getMessage()));
        }
              
        //System.out.println(fabrica.getUsuarioControlador().getTodosLosUsuarios());

    }//GEN-LAST:event_boton_jugarActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        RegistrarUsuario ru = new RegistrarUsuario();
        ru.show();
        this.setVisible(false);
    }//GEN-LAST:event_RegistrarActionPerformed

    private void ShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPassActionPerformed
      if (ShowPass.isSelected()) {
            Password.setEchoChar((char) 0);
        } else {
            Password.setEchoChar('*');
        }  
    }//GEN-LAST:event_ShowPassActionPerformed

    private void ConfiguraccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguraccionActionPerformed
        new Configuraccion().setVisible(true);
    }//GEN-LAST:event_ConfiguraccionActionPerformed
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
            java.util.logging.Logger.getLogger(LoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Configuraccion;
    private javax.swing.JTextField Nickname;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton Registrar;
    private javax.swing.JCheckBox ShowPass;
    private javax.swing.JButton boton_jugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
