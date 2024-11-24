/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package biblioteca;

import java.awt.BorderLayout;
import java.time.LocalDate;
import javax.swing.JPanel;
import vista.Prestamos;
import vista.REPORTES_ENTREGADOS;
import vista.devoluciones;
import vista.libros_actuales;
import vista.principal_vista;
import vista.reportes;
import vista.reportes_principal;
import vista.usuarios;

/**
 *
 * @author Yudys
 */
public class dashboard extends javax.swing.JFrame {

    public dashboard() {
        initComponents();
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int dia = now.getDayOfMonth();
        int month = now.getMonthValue();
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        String fechaActual = "Hoy es " + dia + " de " + meses[month - 1] + " de " + year;
        LblHora.setText(fechaActual);
        
        initCOntent();
    }
    
    private void initCOntent()
    {
        cambiarPanel(new principal_vista());
        setLocationRelativeTo(null);
                
        
    }
    
    
    public static void cambiarPanel(JPanel p)
    {
        p.setSize(812, 450);
        p.setLocation(0,0);
        PnlContent.removeAll();
        PnlContent.add(p, BorderLayout.CENTER);
        PnlContent.revalidate();
        PnlContent.repaint();
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
        jPanel2 = new javax.swing.JPanel();
        PnlMenu = new javax.swing.JPanel();
        BtnPrincipal = new javax.swing.JButton();
        BtnDevoluciones = new javax.swing.JButton();
        BtnUsers = new javax.swing.JButton();
        BtnLibros = new javax.swing.JButton();
        BtnReportes = new javax.swing.JButton();
        BtnPrestamos = new javax.swing.JButton();
        PnlHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PnlContent = new javax.swing.JPanel();
        LblBiblioteca = new javax.swing.JLabel();
        LblHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1065, 678));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 255, 51));

        PnlMenu.setBackground(new java.awt.Color(204, 204, 204));

        BtnPrincipal.setBackground(new java.awt.Color(51, 51, 255));
        BtnPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iniciOo.png"))); // NOI18N
        BtnPrincipal.setText("Principal");
        BtnPrincipal.setToolTipText("");
        BtnPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        BtnPrincipal.setBorderPainted(false);
        BtnPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnPrincipal.setIconTextGap(10);
        BtnPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnPrincipalMouseClicked(evt);
            }
        });
        BtnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrincipalActionPerformed(evt);
            }
        });

        BtnDevoluciones.setBackground(new java.awt.Color(51, 51, 255));
        BtnDevoluciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnDevoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/devolver.png"))); // NOI18N
        BtnDevoluciones.setText("Devoluciones");
        BtnDevoluciones.setToolTipText("");
        BtnDevoluciones.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        BtnDevoluciones.setBorderPainted(false);
        BtnDevoluciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDevoluciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnDevoluciones.setIconTextGap(10);
        BtnDevoluciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnDevolucionesMouseClicked(evt);
            }
        });
        BtnDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDevolucionesActionPerformed(evt);
            }
        });

        BtnUsers.setBackground(new java.awt.Color(51, 51, 255));
        BtnUsers.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarios.png"))); // NOI18N
        BtnUsers.setText("Usuarios");
        BtnUsers.setToolTipText("");
        BtnUsers.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        BtnUsers.setBorderPainted(false);
        BtnUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnUsers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnUsers.setIconTextGap(10);
        BtnUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnUsersMouseClicked(evt);
            }
        });
        BtnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUsersActionPerformed(evt);
            }
        });

        BtnLibros.setBackground(new java.awt.Color(51, 51, 255));
        BtnLibros.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libros.png"))); // NOI18N
        BtnLibros.setText("Libros");
        BtnLibros.setToolTipText("");
        BtnLibros.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        BtnLibros.setBorderPainted(false);
        BtnLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLibros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnLibros.setIconTextGap(10);
        BtnLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnLibrosMouseClicked(evt);
            }
        });
        BtnLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLibrosActionPerformed(evt);
            }
        });

        BtnReportes.setBackground(new java.awt.Color(51, 51, 255));
        BtnReportes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportes.png"))); // NOI18N
        BtnReportes.setText("Reportes");
        BtnReportes.setToolTipText("");
        BtnReportes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        BtnReportes.setBorderPainted(false);
        BtnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnReportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnReportes.setIconTextGap(10);
        BtnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnReportesMouseClicked(evt);
            }
        });
        BtnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReportesActionPerformed(evt);
            }
        });

        BtnPrestamos.setBackground(new java.awt.Color(51, 51, 255));
        BtnPrestamos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/prestamo.png"))); // NOI18N
        BtnPrestamos.setText("Prestamos");
        BtnPrestamos.setToolTipText("");
        BtnPrestamos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        BtnPrestamos.setBorderPainted(false);
        BtnPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnPrestamos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnPrestamos.setIconTextGap(10);
        BtnPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnPrestamosMouseClicked(evt);
            }
        });
        BtnPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrestamosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlMenuLayout = new javax.swing.GroupLayout(PnlMenu);
        PnlMenu.setLayout(PnlMenuLayout);
        PnlMenuLayout.setHorizontalGroup(
            PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnDevoluciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(BtnUsers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PnlMenuLayout.setVerticalGroup(
            PnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlMenuLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(BtnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PnlHeader.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Gestión biblioteca");

        javax.swing.GroupLayout PnlHeaderLayout = new javax.swing.GroupLayout(PnlHeader);
        PnlHeader.setLayout(PnlHeaderLayout);
        PnlHeaderLayout.setHorizontalGroup(
            PnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlHeaderLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlHeaderLayout.setVerticalGroup(
            PnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlHeaderLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        PnlContent.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PnlContentLayout = new javax.swing.GroupLayout(PnlContent);
        PnlContent.setLayout(PnlContentLayout);
        PnlContentLayout.setHorizontalGroup(
            PnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PnlContentLayout.setVerticalGroup(
            PnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        LblBiblioteca.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LblBiblioteca.setForeground(new java.awt.Color(0, 0, 0));
        LblBiblioteca.setText("Bilbioteca");

        LblHora.setBackground(new java.awt.Color(0, 153, 51));
        LblHora.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        LblHora.setForeground(new java.awt.Color(0, 0, 0));
        LblHora.setText("Hoy es {daytime} {day} de {month} de {year}");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(LblBiblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(145, 145, 145)
                .addComponent(LblHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addComponent(PnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(811, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(LblBiblioteca))
                    .addComponent(LblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(PnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrestamosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPrestamosActionPerformed

    private void BtnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnReportesActionPerformed

    private void BtnLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLibrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnLibrosActionPerformed

    private void BtnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnUsersActionPerformed

    private void BtnDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDevolucionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnDevolucionesActionPerformed

    private void BtnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrincipalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPrincipalActionPerformed

    private void BtnPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrincipalMouseClicked
        //Abrir ventana de inicio
        cambiarPanel(new principal_vista());
    }//GEN-LAST:event_BtnPrincipalMouseClicked

    private void BtnPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnPrestamosMouseClicked
        cambiarPanel(new Prestamos());
    }//GEN-LAST:event_BtnPrestamosMouseClicked

    private void BtnDevolucionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnDevolucionesMouseClicked
        cambiarPanel(new devoluciones());
    }//GEN-LAST:event_BtnDevolucionesMouseClicked

    private void BtnUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnUsersMouseClicked
        cambiarPanel(new usuarios());
    }//GEN-LAST:event_BtnUsersMouseClicked

    private void BtnLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLibrosMouseClicked
        cambiarPanel(new libros_actuales());
    }//GEN-LAST:event_BtnLibrosMouseClicked

    private void BtnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnReportesMouseClicked
        
        cambiarPanel(new reportes_principal());    
    }//GEN-LAST:event_BtnReportesMouseClicked

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
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDevoluciones;
    private javax.swing.JButton BtnLibros;
    private javax.swing.JButton BtnPrestamos;
    private javax.swing.JButton BtnPrincipal;
    private javax.swing.JButton BtnReportes;
    private javax.swing.JButton BtnUsers;
    private javax.swing.JLabel LblBiblioteca;
    private javax.swing.JLabel LblHora;
    private static javax.swing.JPanel PnlContent;
    private javax.swing.JPanel PnlHeader;
    private javax.swing.JPanel PnlMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
