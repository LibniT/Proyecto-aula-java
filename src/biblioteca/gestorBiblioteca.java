package biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class gestorBiblioteca implements gestorPrestamos {

    private List<libro> listaLibros;

    public gestorBiblioteca(List<libro> listaLibros) {
        this.listaLibros = listaLibros != null ? listaLibros : new ArrayList<>();
        cargarArchivo();
    }

    @Override
    public void prestar(libro libro) {
        if (!libro.getPrestado()) {
            libro.setPrestado(true);
            System.out.println("El libro " + libro.getTitulo() + " ha sido prestado.");
        } else {
            System.out.println("El libro " + libro.getTitulo() + " no está disponible.");
        }
        actualizarDatos();
    }

    @Override
    public void devolver(libro libro) {
        if (libro.getPrestado()) {
            libro.setPrestado(false);
            System.out.println("El libro " + libro.getTitulo() + " ha sido devuelto.");
        } else {
            System.out.println("El libro " + libro.getTitulo() + " no está prestado.");
        }
        actualizarDatos();
    }

    public void agregarLibro(libro libro) {
        listaLibros.add(libro);
        actualizarDatos();
    }

    public void actualizarDatos() {
        String filePath = "src/archivos/libros.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, false))) {
            for (libro libro : listaLibros) {
                bw.write(libro.getAuthor() + "," +
                        libro.getYear() + "," +
                        libro.getGenre() + "," +
                        libro.getId() + "," +
                        libro.getTitulo() + "," +
                        libro.getPrestado());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarArchivo() {
        listaLibros.clear();
        String filePath = "src/archivos/libros.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] data = line.split(",");
                if (data.length != 6) continue;

                try {
                    String author = data[0];
                    int year = Integer.parseInt(data[1]);
                    String genre = data[2];
                    int id = Integer.parseInt(data[3]);
                    String titulo = data[4];
                    Boolean prestado = Boolean.parseBoolean(data[5]);

                    listaLibros.add(new libro(author, year, genre, id, titulo, prestado));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error al procesar la línea: " + line + " | " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
