package biblioteca;

public class libro extends item {

    private String author;
    private int year;
    private String genre;

    public libro(String author, int year, String genre, int id, String titulo, Boolean prestado) {
        super(id, titulo, prestado);
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("ID: " + this.getId());
        System.out.println("Título: " + this.getTitulo());
        System.out.println("Autor: " + this.author);
        System.out.println("Año: " + this.year);
        System.out.println("Género: " + this.genre);
        System.out.println("Prestado: " + this.getPrestado());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
