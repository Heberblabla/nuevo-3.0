package Prueba;

import Data.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import Herramientas.*;

public class main2 {

    public static void main(String[] args) {
        Class<?>[] clases = {
            Arquero.class,
            Lanzatonio.class,
            Espadachin.class,
            Rey_Arquero.class,
            Rey_Lanzatonio.class,
            Rey_Espadachin.class
        };

        for (Class<?> clase : clases) {
            System.out.println("Clase: " + clase.getSimpleName());

            Method[] metodos = clase.getDeclaredMethods();
            for (Method m : metodos) {
                String nombre = m.getName();

                // Filtrar getters, setters y métodos de Object
                if (nombre.startsWith("isAereo") || nombre.startsWith("get")
                        || nombre.startsWith("set") || nombre.equals("toString")
                        || nombre.equals("hashCode") || nombre.equals("equals")
                        || nombre.equals("isEstado_de_vida") || nombre.equals("Daño")
                        || nombre.equals("isTurnoActivo") || nombre.equals("isTurnoDoble")) {
                    continue; // saltar
                }

                System.out.println("   Método: " + nombre);
            }

            System.out.println("---------------------------");
        }

        Arquero waos1 = new Arquero();
        System.out.println(waos1.getNombre());
        Lanzatonio waos2 = new Lanzatonio();
        System.out.println(waos2.getNombre());

        
        
        
        System.out.println("vida del arquero: " + waos1.getVida());
        System.out.println("el lanzantoinio baja :" + waos2.getAtaque_base());
        
        Enemigo enemis = convertir(waos1);
        
        //ArrayList<tropa> enemigos = new ArrayList();
        
        //enemigos.add(enemis);
        
        //waos2.Ataque_normal(enemigos, 0);
        
        Trasladar(waos1, enemis);
        
        System.out.println("vida del arquero: " + waos1.getVida());

    }
    
    //copiamos los datos q nos interas modifica a una clase q todos puedan leer 
    static public Enemigo convertir(Tropa waos) {
        String nombre = waos.getNombre();
        int vida = waos.getVida();
        int vidavida = waos.getVidavida();
        int ataque_base = waos.getAtaque_base();
        double daño_critico = waos.getDaño_critico();
        double probabilidad_de_critico = waos.getProbabilidad_de_critico();
        boolean aereo = waos.isAereo();
        boolean estado_de_vida = waos.isEstado_de_vida();
        String rutaviva = waos.getRutaviva();
        String rutamuerta = waos.getRutamuerta();
        boolean turnoActivo = waos.isTurnoActivo();
        boolean turnoDoble = waos.isTurnoDoble();
        System.out.println(nombre);
        return new Enemigo(nombre, vida, vidavida, ataque_base, daño_critico, probabilidad_de_critico, aereo,
                estado_de_vida, rutaviva, rutamuerta, turnoActivo, turnoDoble);
    }
    
    //se devuelve los datos modificados V:
    static public void Trasladar(Tropa waos, Enemigo enemis) {
        waos.setNombre(enemis.getNombre());
        waos.setVida(enemis.getVida());
        waos.setVidavida(enemis.getVidavida());
        waos.setAtaque_base(enemis.getAtaque_base());
        waos.setDaño_critico(enemis.getDaño_critico());
        waos.setProbabilidad_de_critico(enemis.getProbabilidad_de_critico());
        waos.setAereo(enemis.isAereo());
        waos.setEstado_de_vida(enemis.isEstado_de_vida());
        waos.setRutaviva(enemis.getRutaviva());
        waos.setRutamuerta(enemis.getRutamuerta());
        waos.setTurnoActivo(enemis.isTurnoActivo());
        waos.setTurnoDoble(enemis.isTurnoDoble());

    }

}
