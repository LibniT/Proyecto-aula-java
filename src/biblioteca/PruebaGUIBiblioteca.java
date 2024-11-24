package biblioteca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PruebaGUIBiblioteca extends JFrame {
    private JTable tablaLibros;
    private DefaultTableModel modeloTabla;
    private JTextField txtTitulo, txtAutor, txtAnio, txtGenero;
    private JButton btnAgregar, btnEditar, btnEliminar, btnActualizar;

    public PruebaGUIBiblioteca() {
        setTitle("Gestión de Biblioteca");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Título");
        modeloTabla.addColumn("Autor");
        modeloTabla.addColumn("Año");
        modeloTabla.addColumn("Género");
        modeloTabla.addColumn("Prestado");

        tablaLibros = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaLibros);
        add(scrollPane, BorderLayout.CENTER);

        // Panel de entrada de datos
        JPanel panelEntrada = new JPanel(new GridLayout(5, 2));
        panelEntrada.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panelEntrada.add(txtTitulo);
        panelEntrada.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        panelEntrada.add(txtAutor);
        panelEntrada.add(new JLabel("Año:"));
        txtAnio = new JTextField();
        panelEntrada.add(txtAnio);
        panelEntrada.add(new JLabel("Género:"));
        txtGenero = new JTextField();
        panelEntrada.add(txtGenero);

        // Botones
        btnAgregar = new JButton("Agregar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        btnActualizar = new JButton("Actualizar Tabla");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnActualizar);

        JPanel panelSur = new JPanel(new BorderLayout());
        panelSur.add(panelEntrada, BorderLayout.CENTER);
        panelSur.add(panelBotones, BorderLayout.SOUTH);

        add(panelSur, BorderLayout.SOUTH);

        // Agregar listeners a los botones
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarLibro();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTabla();
            }
        });

        // Cargar libros iniciales
        actualizarTabla();
    }

    private void agregarLibro() {
        try {
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            int anio = Integer.parseInt(txtAnio.getText());
            String genero = txtGenero.getText();

            libro.crearLibro(autor, anio, genero, titulo);
            limpiarCampos();
            actualizarTabla();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un año válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarLibro() {
        int filaSeleccionada = tablaLibros.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                int id = Integer.parseInt(tablaLibros.getValueAt(filaSeleccionada, 0).toString());
                String nuevoTitulo = txtTitulo.getText();
                String nuevoAutor = txtAutor.getText();
                int nuevoAnio = Integer.parseInt(txtAnio.getText());
                String nuevoGenero = txtGenero.getText();

                libro.editarLibro(id, nuevoTitulo, nuevoAutor, nuevoAnio, nuevoGenero);
                limpiarCampos();
                actualizarTabla();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un año válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un libro para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarLibro() {
        int filaSeleccionada = tablaLibros.getSelectedRow();
        if (filaSeleccionada != -1) {
            int id = Integer.parseInt(tablaLibros.getValueAt(filaSeleccionada, 0).toString());
            libro.eliminarLibro(id);
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un libro para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        List<libro> libros = libro.cargarLibros();
        for (libro lib : libros) {
            modeloTabla.addRow(new Object[]{
                lib.getId(),
                lib.getTitulo(),
                lib.getAutor(),
                lib.getAnio(),
                lib.getGenero(),
                lib.getPrestado() ? "Sí" : "No"
            });
        }
    }

    private void limpiarCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtAnio.setText("");
        txtGenero.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PruebaGUIBiblioteca().setVisible(true);
            }
        });
    }
}

