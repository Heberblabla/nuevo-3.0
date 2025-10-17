package Data;

import java.util.ArrayList;
import java.util.Random;

public class Gigante extends Tropa {

    public Gigante() {
        this.nombre = "Gigante";
        this.vida = 800;
        this.ataque_base = 100;
        this.daño_critico = 5.0;
        this.probabilidad_de_critico = 0.10;
        this.aereo = false;
        this.estado_de_vida = true;
        this.rutaviva = "recursos/Tropas/Gigante_tropa.png";
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
    
    public void Terremoto(ArrayList<Tropa> enemigos, int posicion){
        int daño = 50;
        enemigos.get(0).setVida(enemigos.get(0).getVida() - daño);
        enemigos.get(1).setVida(enemigos.get(1).getVida() - daño);
        enemigos.get(2).setVida(enemigos.get(2).getVida() - daño);
        enemigos.get(3).setVida(enemigos.get(3).getVida() - daño);
        enemigos.get(4).setVida(enemigos.get(4).getVida() - daño);
        enemigos.get(5).setVida(enemigos.get(5).getVida() - daño);
        
        
    }
}
