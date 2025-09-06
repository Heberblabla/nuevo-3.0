package Tropas;

import Modo_de_juego.*;

public class Arquero {

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
    public Arquero(String nombre, int vida, int ataque_base, double daño_critico,
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
    // Disparo rápido → cura +100 de vida
    public void disparoRapido() {
        this.vida += 100;
        System.out.println(this.nombre + " usa Disparo Rápido y recupera 100 de vida. Vida actual: " + this.vida);
    }

    // Flecha penetrante → daño x3 al enemigo
    public void flechaPenetrante(Jugador enemigo) {
        int daño = this.ataque_base * 3;
        enemigo.vida -= daño;
        if (enemigo.vida < 0) {
            enemigo.vida = 0;
        }
        System.out.println(this.nombre + " lanza Flecha Penetrante a " + enemigo.nombre + " causando " + daño + " de daño.");
    }

    // Lluvia de flechas → pierde 100 de vida, pero hace daño x2 al enemigo
    public void lluviaDeFlechas(Jugador enemigo) {
        // pierde vida
        this.vida -= 100;
        if (this.vida < 0) {
            this.vida = 0;
        }

        // hace daño
        int daño = this.ataque_base * 2;
        enemigo.vida -= daño;
        if (enemigo.vida < 0) {
            enemigo.vida = 0;
        }

        System.out.println(this.nombre + " usa Lluvia de Flechas: pierde 100 de vida pero golpea a "
                + enemigo.nombre + " con " + daño + " de daño.");
    }

    // ================== Métodos de utilidad ==================
    public boolean estaVivo() {
        return this.vida > 0;
    }
}
