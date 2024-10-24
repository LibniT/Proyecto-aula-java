package biblioteca;

import java.util.ArrayList;

public class Biblioteca {

   private ArrayList<libro> libros = new ArrayList<>();

    public void cargarLibrosIniciales() {
        libros.add(new libro("The Catcher in the Rye", "J.D. Salinger", 1951, 1, "Ficción", false));
        libros.add(new libro("To Kill a Mockingbird", "Harper Lee", 1960, 2, "Ficción", true));
        libros.add(new libro("A Brief History of Time", "Stephen Hawking", 1988, 3, "Ciencia", false));
        libros.add(new libro("1984", "George Orwell", 1949, 4, "Ficción", true));
        libros.add(new libro("The Art of War", "Sun Tzu", -500, 5, "Filosofía", false));
        libros.add(new libro("The Great Gatsby", "F. Scott Fitzgerald", 1925, 6, "Ficción", false));
        libros.add(new libro("Brave New World", "Aldous Huxley", 1932, 7, "Ficción", true));
        libros.add(new libro("Moby Dick", "Herman Melville", 1851, 8, "Ficción", false));
        libros.add(new libro("The Road", "Cormac McCarthy", 2006, 9, "Ficción", true));
        libros.add(new libro("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 2014, 10, "Historia", false));
        libros.add(new libro("The Alchemist", "Paulo Coelho", 1988, 11, "Ficción", false));
        libros.add(new libro("War and Peace", "Leo Tolstoy", 1869, 12, "Ficción", true));
        libros.add(new libro("The Lord of the Rings", "J.R.R. Tolkien", 1954, 13, "Fantasía", false));
        libros.add(new libro("Pride and Prejudice", "Jane Austen", 1813, 14, "Ficción", false));
        libros.add(new libro("Crime and Punishment", "Fyodor Dostoevsky", 1866, 15, "Ficción", true));

    }

    public Biblioteca() {
        libros = new ArrayList<>();
        cargarLibrosIniciales();

        AddBooks("New Book", "New Author", 2024, "Fiction", false);

        System.out.println("Current books: " + obtenerLibros());
    }

    // Método para obtener todos los libros
    public ArrayList<libro> obtenerLibros() {
        return libros;
    }

    public void AddBooks(String name, String author, int year, String genre, boolean borrowed) {
        int newId = libros.size() + 1;
        libro nuevoLibro = new libro(name, author, year, newId, genre, borrowed);
        libros.add(nuevoLibro);
    }

    public ArrayList<libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<libro> libros) {
        this.libros = libros;
    }
    
    public void Borrar_FIla(int i )
    {
        libros.remove(i);
    }

    public void actualizarLibro(int id, String nombre, String autor, int anio, String genero, boolean prestado) {
        for (libro l : libros) {
            if (l.getId() == id) {
                l.setName(nombre);
                l.setAuthor(autor);
                l.setYear(anio);
                l.setGenre(genero);
                l.setBorrowed(prestado);
                break;
            }
        }
    }

}
