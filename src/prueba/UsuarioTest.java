// UsuarioTest.java
package prueba;

import modelo.usuario;
import java.util.List;

public class UsuarioTest {
    public void ejecutarPruebas() {
        System.out.println("Pruebas de usuario:");
        testCrearUsuario();
        testLeerUsuario();
        testActualizarUsuario();
        testEliminarUsuario();
    }

    private void testCrearUsuario() {
        String nombre = "UsuarioPrueba";
        String contraseña = "clavePrueba";
        String cedula = "9999999999";
        String apellido = "ApellidoPrueba";
        long telefono = 9999999999L;
        String domicilio = "Dirección de prueba";

        usuario.agregarUsuario(nombre, contraseña, cedula, apellido, telefono, domicilio);
        boolean resultado = usuario.existeUsuario(nombre);
        System.out.println("- Crear usuario: " + (resultado ? "OK" : "Fallo"));

        // Limpieza: Eliminar el usuario de prueba
        if (resultado) {
            usuario.eliminarUsuario(cedula);
        }
    }

    private void testLeerUsuario() {
        List<usuario> usuarios = usuario.cargarUsuarios();
        boolean resultado = !usuarios.isEmpty();
        System.out.println("- Leer usuarios: " + (resultado ? "OK" : "Fallo"));
    }

    private void testActualizarUsuario() {
        // Crear un usuario temporal para la prueba
        String cedula = "8888888888";
        String nombre = "UsuarioTemp";
        usuario.agregarUsuario(nombre, "claveTemp", cedula, "ApellidoTemp", 8888888888L, "DirecciónTemp");

        String nuevoNombre = "UsuarioTempActualizado";
        String nuevoApellido = "ApellidoTempActualizado";
        String nuevaContraseña = "nuevaClaveTemp";
        long nuevoTelefono = 7777777777L;
        String nuevoDomicilio = "NuevaDirecciónTemp";

        usuario.editarUsuario(cedula, nuevoNombre, nuevoApellido, nuevaContraseña, nuevoTelefono, nuevoDomicilio);
        List<usuario> usuarios = usuario.cargarUsuarios();
        boolean resultado = usuarios.stream()
                .anyMatch(u -> u.getNombre().equals(nuevoNombre) && u.getApellido().equals(nuevoApellido));
        System.out.println("- Actualizar usuario: " + (resultado ? "OK" : "Fallo"));

        // Limpieza: Eliminar el usuario temporal
        usuario.eliminarUsuario(cedula);
    }

    private void testEliminarUsuario() {
        // Crear un usuario temporal para la prueba
        String cedula = "7777777777";
        String nombre = "UsuarioEliminar";
        usuario.agregarUsuario(nombre, "claveEliminar", cedula, "ApellidoEliminar", 7777777777L, "DirecciónEliminar");

        usuario.eliminarUsuario(cedula);
        List<usuario> usuarios = usuario.cargarUsuarios();
        boolean resultado = usuarios.stream()
                .noneMatch(u -> u.getCedula().equals(cedula));
        System.out.println("- Eliminar usuario: " + (resultado ? "OK" : "Fallo"));
    }
}
