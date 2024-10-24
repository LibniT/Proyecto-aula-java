package biblioteca;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class contraseñas {
    private HashMap<String, String> passwords;
    private Set<String> administradores;

    
    public contraseñas() {
        passwords = new HashMap<>();
        passwords.put("admin", "claveadmin");
        passwords.put("Admin2", "1234sdadsa");

       
        administradores = new HashSet<>();
        administradores.add("admin");
        administradores.add("Admin2");
    }

    public contraseñas(HashMap<String, String> passwords) {
        this.passwords = passwords;
        administradores = new HashSet<>();
        administradores.add("admin");
        administradores.add("Admin2");
    }

    // Método para validar credenciales
    public boolean validarCredenciales(String usuario, String contrasena) {
        if (passwords.containsKey(usuario)) {
            return passwords.get(usuario).equals(contrasena);
        }
        return false;
    }

    // Método para verificar si el usuario existe en el sistema
    public boolean usuario(String usuario) {
        return passwords.containsKey(usuario);
    }

    // Método para registrar un nuevo usuario
    public void registrar(String id, String pass) {
        passwords.put(id, pass);
    }

    // Método para verificar si existe una clave (usuario)
    public boolean existeClave(String key) {
        return passwords.containsKey(key);
    }

    // Método que verifica si el usuario es administrador
    public boolean esAdmin(String usuario, String contraseña) {
        
        if (validarCredenciales(usuario, contraseña)) {
            
            return administradores.contains(usuario);
        }
        return false;
    }
}
