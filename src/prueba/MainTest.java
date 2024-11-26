package prueba;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("Iniciando pruebas de la aplicación de gestión de biblioteca");
        System.out.println("--------------------------------------------------------");

        UsuarioTest usuarioTest = new UsuarioTest();
        usuarioTest.ejecutarPruebas();

        LibroTest libroTest = new LibroTest();
        libroTest.ejecutarPruebas();

        System.out.println("\n--------------------------------------------------------");
        System.out.println("Finalizando pruebas de la aplicación de gestión de biblioteca");
    }
}