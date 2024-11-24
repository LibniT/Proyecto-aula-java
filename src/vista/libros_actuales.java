/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.util.*;

import javax.swing.table.DefaultTableModel;

import modelo.*;

import javax.swing.JOptionPane;

/**
 *
 * @author Yudys
 */
public class libros_actuales extends javax.swing.JPanel {

    /**
     * Creates new form libros_actuales
     */
    public libros_actuales() {
        initComponents();
        cargarEnTabla();
    }

    // Métodos aquí abajo
     public void cargarEnTabla() {
        DefaultTableModel model = (DefaultTableModel) tblcontenido.getModel();
        model.setRowCount(0); // Clear existing data

        List<libro> libros = libro.cargarLibros();
        for (libro lib : libros) {
            model.addRow(new Object[]{
                lib.getTitulo(), // Add this line to include the book title
                lib.getAutor(),
                lib.getAnio(),
                lib.getGenero(),
                lib.getId(),
                lib.getPrestado() ? "No disponible" : "Disponible"
            });
        }
    }

    public void cambiar_tabla_por_id() {
        String idStr = TxtBuscarLibro.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de libro.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            List<libro> libros = libro.cargarLibros();
            boolean libroEncontrado = false;

            for (libro lib : libros) {
                if (lib.getId() == id) {
                    DefaultTableModel model = (DefaultTableModel) tblcontenido.getModel();
                    model.setRowCount(0);
                    model.addRow(new Object[]{
                        lib.getTitulo(), // Add this line to include the book title
                        lib.getAutor(),
                        lib.getAnio(),
                        lib.getGenero(),
                        lib.getId(),
                        lib.getPrestado() ? "No disponible" : "Disponible"
                    });
                    libroEncontrado = true;
                    break;
                }
            }

            if (!libroEncontrado) {
                JOptionPane.showMessageDialog(this, "No se encontró un libro con el ID especificado.", "Libro no encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido (número entero).", "ID inválido", JOptionPane.ERROR_MESSAGE);
        }
    }

  
    public void editar_libros() {
        int selectedRow = tblcontenido.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tblcontenido.getValueAt(selectedRow, 4); // Assuming ID is now in the 5th column
            String tituloActual = (String) tblcontenido.getValueAt(selectedRow, 0);
            String autorActual = (String) tblcontenido.getValueAt(selectedRow, 1);
            int anioActual = (int) tblcontenido.getValueAt(selectedRow, 2);
            String generoActual = (String) tblcontenido.getValueAt(selectedRow, 3);

            String nuevoTitulo = JOptionPane.showInputDialog(this, "Ingrese el nuevo título:", tituloActual);
            String nuevoAutor = JOptionPane.showInputDialog(this, "Ingrese el nuevo autor:", autorActual);
            String nuevoAnioStr = JOptionPane.showInputDialog(this, "Ingrese el nuevo año:", anioActual);
            String nuevoGenero = JOptionPane.showInputDialog(this, "Ingrese el nuevo género:", generoActual);

            if (nuevoTitulo != null && nuevoAutor != null && nuevoAnioStr != null && nuevoGenero != null) {
                try {
                    int nuevoAnio = Integer.parseInt(nuevoAnioStr);
                    libro.editarLibro(id, nuevoTitulo, nuevoAutor, nuevoAnio, nuevoGenero);
                    cargarEnTabla(); // Refresh the table
                    JOptionPane.showMessageDialog(this, "Libro editado con éxito.");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Por favor, ingrese un año válido.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un libro para editar.");
        }
    }

    public void eliminar() {
        int selectedRow = tblcontenido.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tblcontenido.getValueAt(selectedRow, 4); // Assuming ID is now in the 5th column
            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea eliminar este libro?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                libro.eliminarLibro(id);
                cargarEnTabla(); // Refresh the table
                JOptionPane.showMessageDialog(this, "Libro eliminado con éxito.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un libro para eliminar.");
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcontenido = new javax.swing.JTable();
        BTNAGREGAR = new javax.swing.JButton();
        BTNEDITAR = new javax.swing.JButton();
        BRNELIMINAR = new javax.swing.JButton();
        TxtBuscarLibro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BTNBUSCAR = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblcontenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Autor", "Título", "Año", "Genero", "ID", "disponible"
            }
        ));
        jScrollPane1.setViewportView(tblcontenido);

        BTNAGREGAR.setText("AGREGAR NUEVO LIBRO");
        BTNAGREGAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTNAGREGARMouseClicked(evt);
            }
        });
        BTNAGREGAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAGREGARActionPerformed(evt);
            }
        });

        BTNEDITAR.setText("EDITAR DATOS LIBRO");
        BTNEDITAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTNEDITARMouseClicked(evt);
            }
        });

        BRNELIMINAR.setText("ELIMINAR LIBRO");
        BRNELIMINAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BRNELIMINARMouseClicked(evt);
            }
        });

        TxtBuscarLibro.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        TxtBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBuscarLibroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("BUSCAR LIBRO");

        BTNBUSCAR.setText("BUSCAR");
        BTNBUSCAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTNBUSCARMouseClicked(evt);
            }
        });
        BTNBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBUSCARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(370, 370, 370))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(BTNAGREGAR, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(BTNEDITAR, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(BRNELIMINAR, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(TxtBuscarLibro)
                        .addGap(40, 40, 40)
                        .addComponent(BTNBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTNAGREGAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTNEDITAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BRNELIMINAR, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

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

    private void BTNEDITARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTNEDITARMouseClicked
        editar_libros();
    }//GEN-LAST:event_BTNEDITARMouseClicked

    private void BRNELIMINARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BRNELIMINARMouseClicked
        //Eliminar libros de aquí
        eliminar();
    }//GEN-LAST:event_BRNELIMINARMouseClicked

    private void BTNBUSCARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTNBUSCARMouseClicked
        cambiar_tabla_por_id();
    }//GEN-LAST:event_BTNBUSCARMouseClicked

    private void BTNAGREGARActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BTNAGREGARActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_BTNAGREGARActionPerformed

    private void TxtBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TxtBuscarLibroActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_TxtBuscarLibroActionPerformed

    private void BTNBUSCARActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BTNBUSCARActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_BTNBUSCARActionPerformed

    private void BTNAGREGARMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_BTNAGREGARMouseClicked
        dashboard.cambiarPanel(new AGREGAR_LIBROS());
    }// GEN-LAST:event_BTNAGREGARMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BRNELIMINAR;
    private javax.swing.JButton BTNAGREGAR;
    private javax.swing.JButton BTNBUSCAR;
    private javax.swing.JButton BTNEDITAR;
    private javax.swing.JTextField TxtBuscarLibro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblcontenido;
    // End of variables declaration//GEN-END:variables
}
