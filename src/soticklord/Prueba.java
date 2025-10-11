
package soticklord;

import Data.*;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
public class Prueba {
    public static void main(String[] args){
        
        List<Tropa> ejercito1 = new ArrayList<>();
        
        Tropa primero = new Arquero();
        System.out.println(primero.getVida());
        primero.setVida(200);
        System.out.println(primero.getVida());
        
        
        ejercito1.add(primero);
        Tropa segundo = new Lanzatonio();
        
        //Method m = segundo.;
        String contraseña =getSHA256("heber2006");
        System.out.println(contraseña);
    }
    
     private static String getSHA256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar hash SHA-256", e);
        }
    }
    
}
