package Prueba;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Inicio_de_Sesion {

    // Guardamos usuarios en un HashMap (clave = usuario, valor = hash contraseña)
    private static HashMap<String, String> usuarios = new HashMap<>();

    public static void main(String[] args) {
        // Registrar usuarios
        registrar("Juan", "xd");
        registrar("Maria", "Waos");

        // Intentos de inicio de sesión
        login("Juan", "xd");         // ✅ Correcto
        login("Juan", "waos");         // ❌ Incorrecto
        login("Maria", "waos"); // ✅ Correcto
        System.out.println(usuarios);

    }

    // Método para registrar usuario
    public static void registrar(String usuario, String contraseña) {
        String hash = getSHA256(contraseña);
        usuarios.put(usuario, hash);
        System.out.println("Usuario " + usuario + " registrado con éxito.");
    }

    // Método para iniciar sesión
    public static void login(String usuario, String contraseña) {
        String hash = getSHA256(contraseña);

        if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(hash)) {
            System.out.println("✅ Bienvenido " + usuario);
        } else {
            System.out.println("❌ Usuario o contraseña incorrecta");
        }
    }

    // Función que genera el hash SHA-256 de un texto
    public static String getSHA256(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(texto.getBytes());

            // Convertir a hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
