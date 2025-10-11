package Data;

import java.util.ArrayList;
import java.util.Random;

public class Rey_de_los_Gigantes extends Tropa{

    
    public Rey_de_los_Gigantes() {
        this.nombre = "Rey_de_los_Gigantes";
        this.vida = 1500;
        this.ataque_base = 50;
        this.daño_critico = 1.5;
        this.probabilidad_de_critico = 0.50;
        this.aereo = false;
        this.estado_de_vida = true;
        this.rutaviva = "recursos/rey/rey_de_los_gigantes.png";
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
}
