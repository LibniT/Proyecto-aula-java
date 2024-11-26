// LibroTest.java
package prueba;

import modelo.libro;
import java.util.List;

public class LibroTest {
    public void ejecutarPruebas() {
        System.out.println("\nPruebas de Libro:");
        testCrearLibro();
        testLeerLibro();
        testActualizarLibro();
        testEliminarLibro();
        testPrestarLibro();
        testDevolverLibro();
    }

    private void testCrearLibro() {
        String titulo = "Libro de Prueba";
        boolean resultado = libro.crearLibro("Autor Prueba", 2023, "Género Prueba", titulo, false);
        System.out.println("- Crear libro: " + (resultado ? "OK" : "Fallo"));

        // Limpieza: Eliminar el libro de prueba
        if (resultado) {
            List<libro> libros = libro.cargarLibros();
            libros.stream()
                .filter(l -> l.getTitulo().equals(titulo))
                .findFirst()
                .ifPresent(l -> libro.eliminarLibro(l.getId()));
        }
    }

    private void testLeerLibro() {
        List<libro> libros = libro.cargarLibros();
        boolean resultado = !libros.isEmpty();
        System.out.println("- Leer libros: " + (resultado ? "OK" : "Fallo"));
    }

    private void testActualizarLibro() {
        // Crear un libro temporal para la prueba
        String tituloOriginal = "Libro Temporal";
        libro.crearLibro("Autor Temporal", 2023, "Género Temporal", tituloOriginal, false);
        
        List<libro> libros = libro.cargarLibros();
        libro libroTemp = libros.stream()
                .filter(l -> l.getTitulo().equals(tituloOriginal))
                .findFirst()
                .orElse(null);

        if (libroTemp != null) {
            String nuevoTitulo = "Libro Actualizado";
            libro.editarLibro(libroTemp.getId(), nuevoTitulo, "Autor Actualizado", 2024, "Género Actualizado");
            
            libros = libro.cargarLibros();
            boolean resultado = libros.stream()
                    .anyMatch(l -> l.getTitulo().equals(nuevoTitulo));
            System.out.println("- Actualizar libro: " + (resultado ? "OK" : "Fallo"));

            // Limpieza: Eliminar el libro temporal
            libro.eliminarLibro(libroTemp.getId());
        } else {
            System.out.println("- Actualizar libro: Fallo (No se pudo crear libro temporal)");
        }
    }

    private void testEliminarLibro() {
        // Crear un libro temporal para la prueba
        String tituloEliminar = "Libro para Eliminar";
        libro.crearLibro("Autor Eliminar", 2023, "Género Eliminar", tituloEliminar, false);
        
        List<libro> libros = libro.cargarLibros();
        libro libroEliminar = libros.stream()
                .filter(l -> l.getTitulo().equals(tituloEliminar))
                .findFirst()
                .orElse(null);

        if (libroEliminar != null) {
            int idEliminar = libroEliminar.getId();
            libro.eliminarLibro(idEliminar);
            
            libros = libro.cargarLibros();
            boolean resultado = libros.stream()
                    .noneMatch(l -> l.getId() == idEliminar);
            System.out.println("- Eliminar libro: " + (resultado ? "OK" : "Fallo"));
        } else {
            System.out.println("- Eliminar libro: Fallo (No se pudo crear libro temporal)");
        }
    }

    private void testPrestarLibro() {
        // Usar un libro existente que no esté prestado
        List<libro> libros = libro.cargarLibros();
        libro libroPrestamo = libros.stream()
                .filter(l -> !l.getPrestado())
                .findFirst()
                .orElse(null);

        if (libroPrestamo != null) {
            libro libroObj = new libro();
            boolean resultado = libroObj.prestar(libroPrestamo.getId(), "UsuarioPrueba");
            System.out.println("- Prestar libro: " + (resultado ? "OK" : "Fallo"));

            // Devolver el libro para no afectar el estado
            if (resultado) {
                libroObj.devolver(libroPrestamo.getId(), "UsuarioPrueba");
            }
        } else {
            System.out.println("- Prestar libro: No se pudo realizar (No hay libros disponibles para prestar)");
        }
    }

    private void testDevolverLibro() {
        // Primero prestar un libro para luego devolverlo
        List<libro> libros = libro.cargarLibros();
        libro libroDevolucion = libros.stream()
                .filter(l -> !l.getPrestado())
                .findFirst()
                .orElse(null);

        if (libroDevolucion != null) {
            libro libroObj = new libro();
            libroObj.prestar(libroDevolucion.getId(), "UsuarioPrueba");
            boolean resultado = libroObj.devolver(libroDevolucion.getId(), "UsuarioPrueba");
            System.out.println("- Devolver libro: " + (resultado ? "OK" : "Fallo"));
        } else {
            System.out.println("- Devolver libro: No se pudo realizar (No hay libros disponibles para la prueba)");
        }
    }
}
