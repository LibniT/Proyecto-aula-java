package modelo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class libro extends item {

    private static int contadorId = 1;
    private String autor;
    private int anio;
    private String genero;
    private static final String ARCHIVO = "src/archivos/libros.txt";
    private static final String CONTADOR_ARCHIVO = "src/archivos/contador_id.txt";
    private static final String ARCHIVO_ENTREGADOS = "src/archivos/libros_entregados.txt";

    static {
        cargarContadorId();
    }

    public libro(String autor, int anio, String genero, String titulo, Boolean prestado) {
        super(contadorId, titulo, prestado);
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        contadorId++;
    }

    public libro() {
    }

    private static void cargarContadorId() {
        File file = new File(CONTADOR_ARCHIVO);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(CONTADOR_ARCHIVO))) {
                String linea = reader.readLine();
                if (linea != null) {
                    contadorId = Integer.parseInt(linea);
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error al cargar el contador de ID: " + e.getMessage());
            }
        }
    }

    private static void guardarContadorId() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTADOR_ARCHIVO))) {
            writer.write(String.valueOf(contadorId));
        } catch (IOException e) {
            System.out.println("Error al guardar el contador de ID: " + e.getMessage());
        }
    }

    @Override
    public void mostrarInfo() {
        System.out.println("ID: " + this.id);
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Año: " + this.anio);
        System.out.println("Género: " + this.genero);
        System.out.println("Prestado: " + (this.prestado ? "Sí" : "No"));
    }

    @Override
    public boolean prestar(int idLibro, String nombreUsuario) {
        if (!existeLibro(idLibro)) {
            System.out.println("El libro no existe.");
            return false;
        }

        if (!usuario.existeUsuario(nombreUsuario)) {
            System.out.println("El usuario no existe. Sugiere crear el usuario primero.");
            return false;
        }

        List<libro> libros = cargarLibros();
        for (libro libro : libros) {
            if (libro.getId() == idLibro && !libro.getPrestado()) {
                libro.setPrestado(true);
                if (guardarLibros(libros)) {
                    enviarReporte(nombreUsuario, idLibro, LocalDate.now());
                    System.out.println("Libro prestado con éxito a " + nombreUsuario);
                    return true;
                } else {
                    System.out.println("Error al guardar los cambios del préstamo.");
                    return false;
                }
            }
        }
        System.out.println("No se pudo prestar el libro. Verifique el ID o si ya está prestado.");
        return false;
    }

    public void enviarReporte(String nombreUsuario, int idLibro, LocalDate fechaSalida) {
        LocalDate fechaEntrega = fechaSalida.plusWeeks(1);
        String nombreArchivo = "reportes.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(nombreUsuario + "," + idLibro + "," + fechaSalida + "," + fechaEntrega);
            writer.newLine();
            System.out.println("Reporte de préstamo guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de reportes: " + e.getMessage());
        }
    }

    @Override
    public boolean devolver(int idLibro, String nombreUsuario) {
        if (!existeLibro(idLibro)) {
            System.out.println("El libro no existe.");
            return false;
        }

        if (!usuario.existeUsuario(nombreUsuario)) {
            System.out.println("El usuario no existe.");
            return false;
        }

        List<libro> libros = cargarLibros();
        for (libro libro : libros) {
            if (libro.getId() == idLibro && libro.getPrestado()) {
                libro.setPrestado(false);
                if (guardarLibros(libros)) {
                    actualizarReporte(nombreUsuario, idLibro);
                    registrarLibroEntregado(nombreUsuario, idLibro);
                    System.out.println("Libro devuelto con éxito por " + nombreUsuario);
                    return true;
                } else {
                    System.out.println("Error al guardar los cambios de la devolución.");
                    return false;
                }
            }
        }
        System.out.println("No se pudo devolver el libro. Verifique el ID o si ya está devuelto.");
        return false;
    }

    private void registrarLibroEntregado(String nombreUsuario, int idLibro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_ENTREGADOS, true))) {
            writer.write(nombreUsuario + "," + idLibro + "," + LocalDate.now());
            writer.newLine();
            System.out.println("Libro entregado registrado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al registrar el libro entregado: " + e.getMessage());
        }
    }

    private void actualizarReporte(String nombreUsuario, int idLibro) {
        String nombreArchivo = "reportes.txt";
        String tempArchivo = "temp_reportes.txt";
        LocalDate fechaDevolucion = LocalDate.now();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempArchivo))) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4 && datos[0].equals(nombreUsuario) && datos[1].equals(String.valueOf(idLibro)) && datos[3].isEmpty()) {
                    // Actualizar la fecha de devolución
                    writer.write(String.format("%s,%s,%s,%s", datos[0], datos[1], datos[2], fechaDevolucion));
                } else {
                    writer.write(linea);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al actualizar el archivo de reportes: " + e.getMessage());
            return;
        }

        // Reemplazar el archivo original con el temporal
        File archivoOriginal = new File(nombreArchivo);
        File archivoTemporal = new File(tempArchivo);
        if (archivoOriginal.delete() && archivoTemporal.renameTo(archivoOriginal)) {
            System.out.println("Reporte actualizado correctamente.");
        } else {
            System.err.println("Error al reemplazar el archivo de reportes.");
        }
    }

    private boolean existeLibro(int idLibro) {
        List<libro> libros = cargarLibros();
        for (libro libro : libros) {
            if (libro.getId() == idLibro) {
                return true;
            }
        }
        return false;
    }



    public static boolean crearLibro(String autor, int anio, String genero, String titulo, boolean prestado) {
        try {
            libro nuevoLibro = new libro(autor, anio, genero, titulo, prestado);
            List<libro> libros = cargarLibros();
            libros.add(nuevoLibro);
            guardarLibros(libros);
            guardarContadorId();
            System.out.println("Libro creado con éxito. ID: " + nuevoLibro.getId() + ", Prestado: " + prestado);
            return true;
        } catch (Exception e) {
            System.err.println("Error al crear el libro: " + e.getMessage());
            return false;
        }
    }

    public static boolean guardarLibros(List<libro> libros) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (libro l : libros) {
                writer.write(l.getId() + ";" + l.getTitulo() + ";" + l.getAutor() + ";" + l.getAnio() + ";" + l.getGenero() + ";" + l.getPrestado());
                writer.newLine();
            }
            System.out.println("Libros guardados con éxito.");
            return true; // Guardado exitoso
        } catch (IOException e) {
            System.err.println("Error al guardar los libros: " + e.getMessage());
            return false; // Error al guardar
        }
    }

    public static void eliminarLibro(int id) {
        List<libro> libros = cargarLibros();
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == id) {
                libros.remove(i);
                guardarLibros(libros);
                System.out.println("Libro eliminado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró el libro con el ID especificado.");
    }

    public static void editarLibro(int id, String nuevoTitulo, String nuevoAutor, int nuevoAnio, String nuevoGenero) {
        List<libro> libros = cargarLibros();
        for (libro libro : libros) {
            if (libro.getId() == id) {
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                libro.setAnio(nuevoAnio);
                libro.setGenero(nuevoGenero);
                guardarLibros(libros);
                System.out.println("Libro editado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró el libro con el ID especificado.");
    }

    public static List<libro> cargarLibros() {
        List<libro> libros = new ArrayList<>();
        File file = new File(ARCHIVO);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    String[] datos = linea.split(";");
                    if (datos.length == 6) {
                        libro l = new libro();
                        int id = Integer.parseInt(datos[0]);
                        l.setId(id);
                        l.setTitulo(datos[1]);
                        l.setAutor(datos[2]);
                        l.setAnio(Integer.parseInt(datos[3]));
                        l.setGenero(datos[4]);
                        l.setPrestado(Boolean.parseBoolean(datos[5]));
                        libros.add(l);
                        if (id >= contadorId) {
                            contadorId = id + 1;
                        }
                    }
                }
                guardarContadorId();
                System.out.println("Libros cargados con éxito.");
            } catch (IOException e) {
                System.out.println("Error al cargar los libros: " + e.getMessage());
            }
        }
        return libros;
    }

    // Getters y setters
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
