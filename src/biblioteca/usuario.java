package biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class usuario extends persona {

    private static final long serialVersionUID = 1L;
    private static final String ARCHIVO = "src/archivos/usuarios.txt";

    private String contraseña;
    private long telefono;
    private String domicilio;

    public usuario(String nombre, String contraseña, String cedula, String apellido, long telefono, String domicilio) {
        super(nombre, apellido, cedula);
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }

    public usuario() {
        super(null, null, null);
    }

    public static boolean validarUsuario(String nombre, String contraseña) {
        List<usuario> usuarios = cargarUsuarios();
        for (usuario u : usuarios) {
            if (u.getNombre().equals(nombre) && u.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeUsuario(String nombre) {
        List<usuario> usuarios = cargarUsuarios();
        for (usuario u : usuarios) {
            if (u.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public static void agregarUsuario(String nombre, String contraseña, String cedula, String apellido, long telefono, String domicilio) {
        usuario nuevoUsuario = new usuario(nombre, contraseña, cedula, apellido, telefono, domicilio);
        List<usuario> usuarios = cargarUsuarios();
        usuarios.add(nuevoUsuario);
        guardarUsuarios(usuarios);
        System.out.println("Usuario agregado con éxito.");
    }

    private static void guardarUsuarios(List<usuario> usuarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (usuario u : usuarios) {
                writer.write(String.format("%s,%s,%s,%s,%d,%s%n",
                        u.getNombre(), u.getContraseña(), u.getCedula(),
                        u.getApellido(), u.getTelefono(), u.getDomicilio()));
            }
            System.out.println("Usuarios guardados con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar los usuarios: " + e.getMessage());
        }
    }

    public static List<usuario> cargarUsuarios() {
        List<usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 6) {
                    usuarios.add(new usuario(partes[0], partes[1], partes[2], partes[3],
                            Long.parseLong(partes[4]), partes[5]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    public static void eliminarUsuario(String cedula) {
        List<usuario> usuarios = cargarUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCedula().equals(cedula)) {
                usuarios.remove(i);
                guardarUsuarios(usuarios);
                System.out.println("Usuario eliminado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró el usuario con la cédula especificada.");
    }

    public static void editarUsuario(String cedula, String nuevoNombre, String nuevoApellido, String nuevaContraseña, long nuevoTelefono, String nuevoDomicilio) {
        List<usuario> usuarios = cargarUsuarios();
        for (usuario u : usuarios) {
            if (u.getCedula().equals(cedula)) {
                u.setNombre(nuevoNombre);
                u.setApellido(nuevoApellido);
                u.setContraseña(nuevaContraseña);
                u.setTelefono(nuevoTelefono);
                u.setDomicilio(nuevoDomicilio);
                guardarUsuarios(usuarios);
                System.out.println("Usuario editado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró el usuario con la cédula especificada.");
    }

    // Getters y setters
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}