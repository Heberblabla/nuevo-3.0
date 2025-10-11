
package soticklord;

import Data.*;
import java.lang.reflect.Method;
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
        
        
    }
    
}
