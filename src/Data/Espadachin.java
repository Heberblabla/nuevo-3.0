package Data;

import java.util.ArrayList;
import java.util.Random;

public class Espadachin extends Tropa {

    public Espadachin() {
        this.nombre = "Espadachin";
        this.vida = 420;
        this.vidavida = 420;
        this.ataque_base = 50;
        this.daño_critico = 1.8;
        this.probabilidad_de_critico = 0.45;
        this.aereo = false;
        this.estado_de_vida = true;
        this.rutaviva = "recursos/Tropas/espadachin_tropa.png";
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
        int nuevavida;
        nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);
    }

    public void Contraataque(ArrayList<Tropa> enemigos, int posicion) {//solo sirve si te bajaron vida
        int daño = Daño();
        int contraatque = ((vidavida - this.vida) / 2) + daño;

        int nuevavida = enemigos.get(posicion).getVida() - contraatque;
        enemigos.get(posicion).setVida(nuevavida);
    }

    public void Estocada_Veloz(ArrayList<Tropa> enemigos, int posicion) {
        this.vida = this.vida - 60;
        int daño = Daño();
        daño = daño * 2;
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);
    }
}
