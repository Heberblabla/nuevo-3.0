package Data;

import java.util.ArrayList;
import java.util.Random;

public class Rey_Arquero extends Tropa {

    public Rey_Arquero() {
        this.nombre = "Rey_Arquero";
        this.vida = 700;
        this.ataque_base = 90;
        this.daño_critico = 1.9;
        this.probabilidad_de_critico = 0.40;
        this.aereo = true;
        this.estado_de_vida = true;
        this.rutaviva = "recursos/rey/rey_arquero.png";
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

    public void Disparo_Real(ArrayList<Tropa> enemigos, int posicion) {
        int daño;
        Random random = new Random();
        double suerte = random.nextDouble();
        double probabilidad = this.probabilidad_de_critico / 2;

        if (suerte < probabilidad) {
            double x = this.ataque_base * 5;
            daño = (int) Math.ceil(x); // convertir a int redondeando hacia arriba
        } else {
            daño = this.ataque_base; // golpe normal
        }

        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);
    }

    public void Flecha_Explosiva(ArrayList<Tropa> enemigos, int posicion) {
        Random rand = new Random();

        // genera un número entre 0 y 99
        int num = rand.nextInt(100);

        if (num < 15) { // 0–9 → 10% de probabilidad        
            this.vida = this.vida - 200;
        } else {
            int daño = Daño();
            daño = daño * 4;
            int nuevavida = enemigos.get(posicion).getVida() - daño;
            enemigos.get(posicion).setVida(nuevavida);
        }

    }

    public void Furia_Del_Rey(ArrayList<Tropa> enemigos, int posicion) {
        this.vida = this.vida + 50;
        this.ataque_base = this.ataque_base + 50;
        this.probabilidad_de_critico = this.probabilidad_de_critico + 0.1;
        this.daño_critico = this.daño_critico + 0.1;
    }

}
