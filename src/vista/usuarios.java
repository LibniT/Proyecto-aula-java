/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import biblioteca.dashboard;
import biblioteca.usuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yudys
 */
public class usuarios extends javax.swing.JPanel {

    /**
     * Creates new form usuarios
     */
    public usuarios() {
        initComponents();
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    private void cargarTabla() {
        List<usuario> usuarios = usuario.cargarUsuarios();
        DefaultTableModel model = (DefaultTableModel) TBLUSUARIOS.getModel();
        model.setRowCount(0); // Limpia la tabla

        for (usuario u : usuarios) {
            model.addRow(new Object[]{
                u.getNombre(),
                u.getApellido(),
                u.getCedula(),
                u.getTelefono(),
                u.getDomicilio()
            });
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLUSUARIOS = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEditUser = new javax.swing.JButton();
        btnNuevoUser1 = new javax.swing.JButton();
        btnEliminarUser = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TBLUSUARIOS.setBackground(new java.awt.Color(204, 204, 204));
        TBLUSUARIOS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TBLUSUARIOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Cedula", "Teléfono", "Domicilio"
            }
        ));
        jScrollPane1.setViewportView(TBLUSUARIOS);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 810, 320));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("USUARIOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btnEditUser.setText("EDITAR USUARIO");
        btnEditUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditUserMouseClicked(evt);
            }
        });
        jPanel1.add(btnEditUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 130, 50));

        btnNuevoUser1.setText("NUEVO USUARIO");
        btnNuevoUser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoUser1MouseClicked(evt);
            }
        });
        jPanel1.add(btnNuevoUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 130, 50));

        btnEliminarUser.setText("ELIMINAR USUARIO");
        btnEliminarUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarUserMouseClicked(evt);
            }
        });
        jPanel1.add(btnEliminarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 140, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoUser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoUser1MouseClicked
        dashboard.cambiarPanel(new AGREGAR_USUARIO());
    }//GEN-LAST:event_btnNuevoUser1MouseClicked

    private void btnEliminarUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarUserMouseClicked
        int selectedRow = TBLUSUARIOS.getSelectedRow();
        if (selectedRow != -1) {
            String cedula = (String) TBLUSUARIOS.getValueAt(selectedRow, 2);
            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea eliminar este usuario?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                usuario.eliminarUsuario(cedula);
                cargarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarUserMouseClicked

    private void btnEditUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditUserMouseClicked
        int selectedRow = TBLUSUARIOS.getSelectedRow();
        if (selectedRow != -1) {
            String cedula = (String) TBLUSUARIOS.getValueAt(selectedRow, 2);
            String nombre = (String) TBLUSUARIOS.getValueAt(selectedRow, 0);
            String apellido = (String) TBLUSUARIOS.getValueAt(selectedRow, 1);
            long telefono = (long) TBLUSUARIOS.getValueAt(selectedRow, 3);
            String domicilio = (String) TBLUSUARIOS.getValueAt(selectedRow, 4);

            // Aquí deberías abrir un nuevo JPanel o JDialog para editar el usuario
            // Por ahora, usaremos JOptionPane para simplificar
            String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo nombre:", nombre);
            String nuevoApellido = JOptionPane.showInputDialog(this, "Nuevo apellido:", apellido);
            String nuevaContraseña = JOptionPane.showInputDialog(this, "Nueva contraseña:");
            long nuevoTelefono = Long.parseLong(JOptionPane.showInputDialog(this, "Nuevo teléfono:", telefono));
            String nuevoDomicilio = JOptionPane.showInputDialog(this, "Nuevo domicilio:", domicilio);

            usuario.editarUsuario(cedula, nuevoNombre, nuevoApellido, nuevaContraseña, nuevoTelefono, nuevoDomicilio);
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario para editar.");
        }
    }//GEN-LAST:event_btnEditUserMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBLUSUARIOS;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnEliminarUser;
    private javax.swing.JButton btnNuevoUser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
