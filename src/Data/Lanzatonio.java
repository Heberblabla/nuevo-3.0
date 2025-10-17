package Data;
import java.util.ArrayList;
import java.util.Random;
public class Lanzatonio extends Tropa {

    public Lanzatonio() {
        this.nombre = "Lanzatonio";
        this.vida = 550;
        this.ataque_base = 100;
        this.daño_critico = 1.5;
        this.probabilidad_de_critico = 0.40;
        this.aereo = false;
        this.estado_de_vida = true;
        this.rutaviva = "recursos/Tropas/lanzatonio_tropa.png";
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

    public void Bloqueo(ArrayList<Tropa> enemigos, int posicion) { //aumenta + 100 puntos de vida
        this.vida += 100;

    }
}
