
package modelo;

import javax.swing.JFrame;
import vista.*;


public class prueba {
    public static void main(String[] args) {
       

        JFrame frame = new JFrame("Agregar Libro");
        AGREGAR_LIBROS agregarLibroPanel = new AGREGAR_LIBROS(); // Assuming AgregarLibroPanel is your JPanel class
        frame.setContentPane(agregarLibroPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        
    }
}