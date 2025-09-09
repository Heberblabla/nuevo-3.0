package Data;

import java.util.ArrayList;
import java.util.Random;

public class Lanzatonio extends Tropa {

    private String nombre = "Lanzatonio";
    private int vida = 550;
    private int ataque_base = 100;
    private double daño_critico = 1.5;
    private double probabilidad_de_critico = 0.40;
    private boolean aereo = false;
    private boolean estado_de_vida = true;
    private String rutaviva = "recursos/Tropas/lanzatonio_tropa.png";
    private String rutamuerta = "recursos/tropa_muerta.png";
    private boolean turnoActivo = true; //verficar si puede atacar este turno
    private boolean turnoDoble = false; //verficar si tiene doble turno

    
    private int Daño() {
        int daño;
        Random random = new Random();
        double suerte = random.nextDouble();

        if (suerte < this.probabilidad_de_critico) {
            double x = this.ataque_base * this.daño_critico;
            daño = (int) Math.ceil(x); // convertir a int redondeando hacia arriba
        } else {
            daño = this.ataque_base; // golpe normal
        }

        return daño;
    }

    @Override //metodo principal para atcar
    void Ataque_normal(ArrayList<Tropa> enemigos, int posicion) { // ataque normal on la probabilidad de lanzatonio
        int daño = Daño();
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);

    }

    public void Estocada(ArrayList<Tropa> enemigos, int posicion) { //30%de probabilida de multiplicar tu daño x 4
        int daño;
        Random random = new Random();
        double suerte = random.nextDouble();

        if (suerte < 0.3) {
            double x = this.ataque_base * 4;
            daño = (int) Math.ceil(x); // convertir a int redondeando hacia arriba
        } else {
            daño = this.ataque_base; // golpe normal
        }
        
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);

    }
    
    public void Bloqueo(){ //aumenta + 100 puntos de vida
        this.vida = this.vida + 100;
        
    }
}
