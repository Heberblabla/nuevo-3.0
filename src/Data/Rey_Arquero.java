package Data;

import java.util.ArrayList;
import java.util.Random;

public class Rey_Arquero extends Tropa {

    private String nombre;
    private int vida;
    private int ataque_base;
    private double daño_critico;
    private double probabilidad_de_critico;
    private boolean aereo;
    private boolean estado_de_vida;
    private String rutaviva;
    private String rutamuerta;
    private boolean turnoActivo;
    private boolean turnoDoble;

    public Rey_Arquero() {
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

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque_base() {
        return ataque_base;
    }

    public double getDaño_critico() {
        return daño_critico;
    }

    public double getProbabilidad_de_critico() {
        return probabilidad_de_critico;
    }

    public boolean isAereo() {
        return aereo;
    }

    public boolean isEstado_de_vida() {
        return estado_de_vida;
    }

    public String getRutaviva() {
        return rutaviva;
    }

    public String getRutamuerta() {
        return rutamuerta;
    }

    public boolean isTurnoActivo() {
        return turnoActivo;
    }

    public boolean isTurnoDoble() {
        return turnoDoble;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque_base(int ataque_base) {
        this.ataque_base = ataque_base;
    }

    public void setDaño_critico(double daño_critico) {
        this.daño_critico = daño_critico;
    }

    public void setProbabilidad_de_critico(double probabilidad_de_critico) {
        this.probabilidad_de_critico = probabilidad_de_critico;
    }

    public void setAereo(boolean aereo) {
        this.aereo = aereo;
    }

    public void setEstado_de_vida(boolean estado_de_vida) {
        this.estado_de_vida = estado_de_vida;
    }

    public void setRutaviva(String rutaviva) {
        this.rutaviva = rutaviva;
    }

    public void setRutamuerta(String rutamuerta) {
        this.rutamuerta = rutamuerta;
    }

    public void setTurnoActivo(boolean turnoActivo) {
        this.turnoActivo = turnoActivo;
    }

    public void setTurnoDoble(boolean turnoDoble) {
        this.turnoDoble = turnoDoble;
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

    
    public void Ataque_normal(ArrayList<Enemigo> enemigos, int posicion) {
        int daño = Daño();
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);
    }

    public void Disparo_Real(ArrayList<Enemigo> enemigos, int posicion) {
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

    public void Flecha_Explosiva(ArrayList<Enemigo> enemigos, int posicion) {
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
