/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.util.ArrayList;
import java.util.Random;

public class Rey_Lanzatonio extends Tropa {

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
// 🔹 REY LANZATONIO

    //if (Ataque_selecionado.equalsIgnoreCase("Tormenta de lanzas")) {
    //   magitoo.vida = magitoo.vida - (ejercito1.get(posicion).ataque_base * 3);
    //  }
    public void Lanza_Imperial(ArrayList<Enemigo> enemigos, int posicion) {
        int daño = Daño();
        daño = daño * 2;
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);
    }

    public void Bloqueo_real(ArrayList<Enemigo> enemigos, int posicion) {
        this.vida = this.vida + 120;
    }

    public void Tormenta_de_Lanzas(ArrayList<Enemigo> enemigos, int posicion) {
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
