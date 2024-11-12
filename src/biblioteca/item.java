
package biblioteca;

import java.util.List;


public abstract class item {
    protected int id;
    protected String titulo;
    protected Boolean prestado;

    public item(int id, String titulo, Boolean prestado) {
        this.id = id;
        this.titulo = titulo;
        this.prestado = prestado;
    }

    public item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getPrestado() {
        return prestado;
    }

    public void setPrestado(Boolean prestado) {
        this.prestado = prestado;
    }
    
    
    public abstract void mostrarInfo();
    
    public void prestar()
    {
        
    }
    
    public void devolver()
    {
        
    }
    
    
}
