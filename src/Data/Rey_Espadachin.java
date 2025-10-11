package Data;

import java.util.ArrayList;
import java.util.Random;

public class Rey_Espadachin extends Tropa {


    public Rey_Espadachin() {
        this.nombre = "Rey_Espadachin";
        this.vida = 850;
        this.ataque_base = 110;
        this.daño_critico = 1.8;
        this.probabilidad_de_critico = 0.30;
        this.aereo = false;
        this.estado_de_vida = true;
        this.rutaviva = "recursos/rey/rey_espadachin.png";
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

    public void Espadazo_Real(ArrayList<Tropa> enemigos, int posicion) {
        this.vida = this.vida - 50;
        int daño = Daño();
        daño = daño * 2;
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);

    }

    public void En_Guardia(ArrayList<Tropa> enemigos, int posicion) {
        this.vida = this.vida + 120;
    }

    public void Ataque_Final(ArrayList<Tropa> enemigos, int posicion) {
        this.vida = this.vida - 150;
        int daño = Daño();
        daño = daño * 4;
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);
    }

}
