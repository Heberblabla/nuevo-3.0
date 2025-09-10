package Data;

import java.util.ArrayList;
import java.util.Random;

public class Espadachin extends Tropa {

    private String nombre = "Espadachin";
    private int vida = 420;
    private int vidavida = 420;
    private int ataque_base = 50;
    private double daño_critico = 1.8;
    private double probabilidad_de_critico = 0.45;
    private boolean aereo = false;
    private boolean estado_de_vida = true;
    private String rutaviva = "recursos/Tropas/espadachin_tropa.png";
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
    public void Ataque_normal(ArrayList<Tropa> enemigos, int posicion) {
        int daño = Daño();
        int nuevavida;
        nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);
    }

    //// 🔹 ESPADACHÍN
    // if (Ataque_selecionado.equalsIgnoreCase("Estocada veloz")) {
    //    ejercito1.get(posicion).vida -= 150; // pierde vida por arriesgarse
    //     magitoo.vida = magitoo.vida - (ejercito1.get(posicion).ataque_base * 2);
    // }
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
