/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercito_Reyes;
import Modo_de_juego.*;


public class Rey_Espadachin {

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
    public Rey_Espadachin(String nombre, int vida, int ataque_base, double daño_critico,
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
    // Espadazo Real → pierde 50 de vida, golpea al enemigo con daño x2
    public void espadazoReal( Jugador enemigo) {
        this.vida -= 50;
        if (this.vida < 0) {
            this.vida = 0;
        }

        int daño = this.ataque_base * 2;
        enemigo.vida -= daño;
        if (enemigo.vida < 0) {
            enemigo.vida = 0;
        }

        System.out.println(this.nombre + " usa Espadazo Real: pierde 50 de vida pero golpea a "
                + enemigo.nombre + " con " + daño + " de daño.");
    }

    // Guardia de Hierro → cura +50 de vida
    public void guardiaDeHierro() {
        this.vida += 50;
        System.out.println(this.nombre + " activa Guardia de Hierro y recupera 50 de vida. Vida actual: " + this.vida);
    }

    // Golpe Final → daño x3 al enemigo
    public void golpeFinal(Jugador enemigo) {
        int daño = this.ataque_base * 3;
        enemigo.vida -= daño;
        if (enemigo.vida < 0) {
            enemigo.vida = 0;
        }

        System.out.println(this.nombre + " ejecuta Golpe Final contra " + enemigo.nombre + " causando " + daño + " de daño.");
    }

    // ================== Métodos de utilidad ==================
    public boolean estaVivo() {
        return this.vida > 0;
    }
}
