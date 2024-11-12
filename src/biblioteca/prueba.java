package biblioteca;

import java.util.ArrayList;

public class prueba {
    public static void main(String[] args) {
        // Crear lista de libros
        ArrayList<libro> listaLibros = new ArrayList<>();

        // Crear el gestor de biblioteca con la lista de libros
        gestorBiblioteca gb = new gestorBiblioteca(listaLibros);

        // Crear un libro
        libro l2 = new libro("Mario Vargas Llosa", 1963, "Novela", 2, "La ciudad y los perros", false);

        

        // Agregar el libro al gestor
        gb.agregarLibro(l2);

        // Realizar acciones con el libro
        gb.prestar(l2);
        gb.devolver(l2);
    }
}

