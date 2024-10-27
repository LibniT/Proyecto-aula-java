
package biblioteca;

import java.time.LocalDate;


public class usuario extends persona {
    private int idUsuario;
    private String email;
    private String telefono;
    private String direccion;
    private LocalDate fechaRegistro;
    private boolean activo;

    public usuario() {
    }

    public usuario( boolean activo, String nombre, String apellido, int sexo, int edad, String nivel_educativo, int idUsuario, String email, String telefono, String direccion, LocalDate fechaRegistro) {
        super(nombre, apellido, sexo, edad, nivel_educativo);
        this.idUsuario = idUsuario;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    

}