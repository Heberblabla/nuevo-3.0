
package Tropas;
import Modo_de_juego.*;

public class Lanzatonio {

    public String nombre;
    public int vida;
    public int ataque_base;
    public double daño_critico;
    public double probabilidad_de_critico;
    public boolean aereo;
    public boolean estado_de_vida;
    public String rutaviva;
    public String rutamuerta;

    // Constructor
    public Lanzatonio(String nombre, int vida, int ataque_base, double daño_critico,
            double probabilidad_de_critico, boolean aereo, boolean estado_de_vida,
            String rutaviva, String rutamuerta) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque_base = ataque_base;
        this.daño_critico = daño_critico;
        this.probabilidad_de_critico = probabilidad_de_critico;
        this.aereo = aereo;
        this.estado_de_vida = estado_de_vida;
        this.rutaviva = rutaviva;
        this.rutamuerta = rutamuerta;
    }

    // ================== Habilidades ==================
    // Lanzamiento Poderoso → pierde 100 de vida, pero hace daño x2 al enemigo
    public void lanzamientoPoderoso(Jugador enemigo) {
        this.vida -= 100;
        if (this.vida < 0) {
            this.vida = 0;
        }

        int daño = this.ataque_base * 2;
        enemigo.vida -= daño;
        if (enemigo.vida < 0) {
            enemigo.vida = 0;
        }

        System.out.println(this.nombre + " usa Lanzamiento Poderoso: pierde 100 de vida pero daña a "
                + enemigo.nombre + " con " + daño + " de daño.");
    }

    // Estocada → golpe x3 al enemigo
    public void estocada(Jugador enemigo) {
        int daño = this.ataque_base * 3;
        enemigo.vida -= daño;
        if (enemigo.vida < 0) {
            enemigo.vida = 0;
        }

        System.out.println(this.nombre + " realiza Estocada contra " + enemigo.nombre + " causando " + daño + " de daño.");
    }

    // Bloqueo → cura +150 de vida
    public void bloqueo() {
        this.vida += 150;
        System.out.println(this.nombre + " se defiende con Bloqueo y recupera 150 de vida. Vida actual: " + this.vida);
    }

    // ================== Métodos de utilidad ==================
    public boolean estaVivo() {
        return this.vida > 0;
    }
}
