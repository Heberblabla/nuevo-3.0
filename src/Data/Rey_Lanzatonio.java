/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.util.ArrayList;
import java.util.Random;

public class Rey_Lanzatonio extends Tropa {

    
    public Rey_Lanzatonio() {
        this.nombre = "Rey_Lanzatonio";
        this.vida = 950;
        this.ataque_base = 150;
        this.daño_critico = 1.5;
        this.probabilidad_de_critico = 0.50;
        this.aereo = false;
        this.estado_de_vida = true;
        this.rutaviva = "recursos/rey/rey_lanzatonio.png";
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

    
    public void Ataque_normal(ArrayList<Tropa> enemigos, int posicion) {
        int daño = Daño();
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);
    }
// 🔹 REY LANZATONIO

    //if (Ataque_selecionado.equalsIgnoreCase("Tormenta de lanzas")) {
    //   magitoo.vida = magitoo.vida - (ejercito1.get(posicion).ataque_base * 3);
    //  }
    public void Lanza_Imperial(ArrayList<Tropa> enemigos, int posicion) {
        int daño = Daño();
        daño = daño * 2;
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);
    }

    public void Bloqueo_real(ArrayList<Tropa> enemigos, int posicion) {
        this.vida = this.vida + 120;
    }

    public void Tormenta_de_Lanzas(ArrayList<Tropa> enemigos, int posicion) {
        int ataque = this.ataque_base;
        int daño_total = 0;
        for (int i = 0; i < 25; i++) {
            this.ataque_base = 10;
            daño_total = daño_total + Daño();
        }
        int nuevavida = enemigos.get(posicion).getVida() - daño_total;
        enemigos.get(posicion).setVida(nuevavida);
    }
}
