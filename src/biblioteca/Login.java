
package biblioteca;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Login extends javax.swing.JFrame {

    int xMouse, yMouse;

    public Login() {
        initComponents();
        //this.setContentPane(fondo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlBackGround = new javax.swing.JPanel();
        BtnMusica = new javax.swing.JButton();
        PnlLogingBackground = new javax.swing.JPanel();
        LblLogin = new javax.swing.JLabel();
        LblUsuario = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        LblPassword = new javax.swing.JLabel();
        Password_1 = new javax.swing.JPasswordField();
        BtnIngresar = new javax.swing.JButton();
        BtnRegistrarse = new javax.swing.JButton();
        Separator_user = new javax.swing.JSeparator();
        Separator_password = new javax.swing.JSeparator();
        Lbl_Libros_imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        setLocationByPlatform(true);
        setResizable(false);

        PnlBackGround.setBackground(new java.awt.Color(204, 255, 204));

        BtnMusica.setBackground(new java.awt.Color(153, 255, 153));
        BtnMusica.setForeground(new java.awt.Color(102, 102, 102));
        BtnMusica.setText("musica");
        BtnMusica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnMusicaMouseClicked(evt);
            }
        });

        PnlLogingBackground.setBackground(new java.awt.Color(153, 255, 153));
        PnlLogingBackground.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PnlLogingBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblLogin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LblLogin.setForeground(new java.awt.Color(0, 0, 0));
        LblLogin.setText("Login");
        PnlLogingBackground.add(LblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 61, 36));

        LblUsuario.setForeground(new java.awt.Color(0, 0, 0));
        LblUsuario.setText("Usuario");
        PnlLogingBackground.add(LblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 59, 30));

        TxtUsuario.setBackground(new java.awt.Color(153, 255, 153));
        TxtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        TxtUsuario.setText("Nombre de usuario aquí");
        TxtUsuario.setBorder(null);
        TxtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtUsuarioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TxtUsuarioMousePressed(evt);
            }
        });
        TxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUsuarioActionPerformed(evt);
            }
        });
        PnlLogingBackground.add(TxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 106, 250, -1));

        LblPassword.setForeground(new java.awt.Color(0, 0, 0));
        LblPassword.setText("Contraseña");
        PnlLogingBackground.add(LblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 30));

        Password_1.setBackground(new java.awt.Color(153, 255, 153));
        Password_1.setForeground(new java.awt.Color(204, 204, 204));
        Password_1.setText("clavejaja");
        Password_1.setBorder(null);
        Password_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Password_1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Password_1MousePressed(evt);
            }
        });
        PnlLogingBackground.add(Password_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 250, 20));

        BtnIngresar.setBackground(new java.awt.Color(0, 153, 0));
        BtnIngresar.setText("Ingresar");
        BtnIngresar.setToolTipText("");
        BtnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnIngresarMouseExited(evt);
            }
        });
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });
        PnlLogingBackground.add(BtnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        BtnRegistrarse.setBackground(new java.awt.Color(0, 153, 0));
        BtnRegistrarse.setText("Registrarse");
        BtnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnRegistrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnRegistrarseMouseExited(evt);
            }
        });
        BtnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarseActionPerformed(evt);
            }
        });
        PnlLogingBackground.add(BtnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

        Separator_user.setForeground(new java.awt.Color(0, 0, 0));
        PnlLogingBackground.add(Separator_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 123, 250, 10));

        Separator_password.setForeground(new java.awt.Color(0, 0, 0));
        PnlLogingBackground.add(Separator_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 250, 20));

        Lbl_Libros_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/biblioteca.jpg"))); // NOI18N

        javax.swing.GroupLayout PnlBackGroundLayout = new javax.swing.GroupLayout(PnlBackGround);
        PnlBackGround.setLayout(PnlBackGroundLayout);
        PnlBackGroundLayout.setHorizontalGroup(
            PnlBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlBackGroundLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(BtnMusica)
                .addGap(114, 114, 114)
                .addComponent(PnlLogingBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(Lbl_Libros_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PnlBackGroundLayout.setVerticalGroup(
            PnlBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlBackGroundLayout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(BtnMusica))
            .addGroup(PnlBackGroundLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(PnlLogingBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(Lbl_Libros_imagen)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMusicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMusicaMouseClicked
        try {
            // Cargar el archivo de audio
            File file = new File("src/musica/paper-rings.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Obtener el control de volumen
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // Ajustar el volumen a un nivel bajo pero audible
            float volume = -20.0f; // Valor entre -80.0f (silencio) y 6.0f (máximo)
            volumeControl.setValue(volume);

            // Reproducir el audio
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnMusicaMouseClicked

    private void BtnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarseActionPerformed
        contraseñas gestionContraseñas = new contraseñas();

        if (TxtUsuario.getText().equals("Nombre de usuario aquí") || Password_1.getText().equals("clavejaja")) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre de usuario y contraseña correctos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (TxtUsuario.getText().isEmpty() || Password_1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete primero ambos campos", "Complete los campos", JOptionPane.WARNING_MESSAGE);
        } else {
            String id = TxtUsuario.getText();
            String pass = Password_1.getText();

            if (gestionContraseñas.existeClave(id)) {
                JOptionPane.showMessageDialog(null, "Ya existe ese usuario, por favor ingrese uno diferente", "Usuario existente", JOptionPane.ERROR_MESSAGE);
                TxtUsuario.setText("");
                return;
            }

            gestionContraseñas.registrar(id, pass);
            JOptionPane.showMessageDialog(null, "Registrado exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            dashboard dash = new dashboard();
            dash.setVisible(true);
            dispose();

        }
    }//GEN-LAST:event_BtnRegistrarseActionPerformed

    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed

        contraseñas gestionContraseñas = new contraseñas();

        String id = TxtUsuario.getText();
        String pass = Password_1.getText();

        if (gestionContraseñas.validarCredenciales(id, pass)) {
            dashboard dash = new dashboard();
            dash.setVisible(true);
            dispose();
            if (gestionContraseñas.esAdmin(id, pass)) {
                //nada aun
            }
        } else {
            if (gestionContraseñas.usuario(id)) {
                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "Contraseña incorrecta", JOptionPane.INFORMATION_MESSAGE);
                Password_1.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario y contrasea incorrectos", "Incorrecto", JOptionPane.INFORMATION_MESSAGE);
                TxtUsuario.setText("");
                Password_1.setText("");
            }
        }
    }//GEN-LAST:event_BtnIngresarActionPerformed

    private void TxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUsuarioActionPerformed

    private void TxtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtUsuarioMouseClicked

    }//GEN-LAST:event_TxtUsuarioMouseClicked

    private void Password_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Password_1MouseClicked

    }//GEN-LAST:event_Password_1MouseClicked

    private void BtnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIngresarMouseEntered
        BtnIngresar.setBackground(Color.green);
    }//GEN-LAST:event_BtnIngresarMouseEntered

    private void BtnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIngresarMouseExited
        BtnIngresar.setBackground(new Color(0, 153, 0));
    }//GEN-LAST:event_BtnIngresarMouseExited

    private void BtnRegistrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRegistrarseMouseEntered
        BtnRegistrarse.setBackground(Color.green);
    }//GEN-LAST:event_BtnRegistrarseMouseEntered

    private void BtnRegistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRegistrarseMouseExited
        BtnRegistrarse.setBackground(new Color(0, 153, 0));
    }//GEN-LAST:event_BtnRegistrarseMouseExited

    private void TxtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtUsuarioMousePressed
        TxtUsuario.setText("");
    }//GEN-LAST:event_TxtUsuarioMousePressed

    private void Password_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Password_1MousePressed
        Password_1.setText("");
    }//GEN-LAST:event_Password_1MousePressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JButton BtnMusica;
    private javax.swing.JButton BtnRegistrarse;
    private javax.swing.JLabel LblLogin;
    private javax.swing.JLabel LblPassword;
    private javax.swing.JLabel LblUsuario;
    private javax.swing.JLabel Lbl_Libros_imagen;
    private javax.swing.JPasswordField Password_1;
    private javax.swing.JPanel PnlBackGround;
    private javax.swing.JPanel PnlLogingBackground;
    private javax.swing.JSeparator Separator_password;
    private javax.swing.JSeparator Separator_user;
    private javax.swing.JTextField TxtUsuario;
    // End of variables declaration//GEN-END:variables

//    class FondoPanel extends JPanel{
//        
//        private Image imagen;
//        
//        @Override
//        public void paint(Graphics g)
//        {
//            imagen = new ImageIcon(getClass().getResource("/imagenes/login_background.jpg")).getImage();
//            
//            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
//            setOpaque(false);
//            super.paint(g);
//        }
//    }
}
