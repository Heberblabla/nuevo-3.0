package Data;

import java.util.ArrayList;
import java.util.Random;

public class Arquero extends Tropa {

    private String nombre = "Arquero";
    private int vida = 300;
    private int ataque_base = 40;
    private double daño_critico = 2.0;
    private double probabilidad_de_critico = 0.30;
    private boolean aereo = true;
    private boolean estado_de_vida = true;
    private String rutaviva = "recursos/Tropas/arquero_tropa.png";
    private String rutamuerta = "recursos/tropa_muerta.png";

    // 🔹 ARQUERO
    // if (Ataque_selecionado.equalsIgnoreCase("Flecha penetrante")) {
    //      magitoo.vida = magitoo.vida - (ejercito1.get(posicion).ataque_base * 3);
    //}
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
    void Ataque_normal(ArrayList<Tropa> enemigos, int posicion) {
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

    public void Flecha_penetrante(ArrayList<Tropa> enemigos, int posicion) { //20%de probabilida de multiplicar tu daño x 5
        int daño;
        Random random = new Random();
        double suerte = random.nextDouble();

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
