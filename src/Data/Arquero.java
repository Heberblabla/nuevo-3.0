package Data;

import java.util.ArrayList;
import java.util.Random;

public class Arquero extends Tropa {
    
    public Arquero(){
      
        this.nombre = "Arquero";
        this.vida = 300;
        this.ataque_base = 40;
        this.daño_critico = 2.0;
        this.probabilidad_de_critico = 0.30;
        this.aereo = true;
        this.estado_de_vida = true;
        this.rutaviva = "recursos/Tropas/arquero_tropa.png";
        this.rutamuerta = "recursos/tropa_muerta.png";
        this.turnoActivo = true; //verficar si puede atacar este turno
        this.turnoDoble = false; //verficar si tiene doble turno
        
    }
            
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

     //metodo principal para atcar
    public void Ataque_normal(ArrayList<Tropa> enemigos, int posicion) {
        int daño = Daño();
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);

    }
    public void Flecha_de_Sangre(ArrayList<Tropa> enemigos, int posicion) {
        this.vida = this.vida - 50;
        int daño = Daño();
        daño = daño * 3;
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);

    }
    public void Flecha_penetrante(ArrayList<Tropa> enemigos, int posicion) { //20% de probabilida de multiplicar tu daño x 5
        int daño;
        Random random = new Random();
        double suerte = random.nextDouble(0,1);

        if (suerte < 0.2) {
            double x = this.ataque_base * 5;
            daño = (int) Math.ceil(x); // convertir a int redondeando hacia arriba
        } else {
            daño = this.ataque_base; // golpe normal
        }

        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);

    }

}
