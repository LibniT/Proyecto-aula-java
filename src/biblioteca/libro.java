package biblioteca;

public class libro {
    private String name;
    private String author;
    private int year;
    private int id;
    private String genre;
    private boolean borrowed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    // Constructor de la clase Libro
    public libro(String name, String author, int year, int id, String genre, boolean borrowed) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.id = id;
        this.genre = genre;
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", id=" + id +
                ", genre='" + genre + '\'' +
                ", borrowed=" + borrowed +
                '}';
    }
    
    
    
}
