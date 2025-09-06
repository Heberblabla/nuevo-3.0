/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tropas;

public abstract class Tropa {

    public String nombre;
    public int vida;
    public int ataque_base;
    public double daño_critico;
    public double probabilidad_de_critico;
    public boolean aereo;
    public boolean estado_de_vida;
    public String rutaviva;
    public String rutamuerta;

    public Tropa(String nombre, int vida, int ataque_base, double daño_critico,
            double probabilidad_de_critico, boolean aereo,
            boolean estado_de_vida, String rutaviva, String rutamuerta) {
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

    public void recibirDaño(int daño) {
        this.vida -= daño;
        if (this.vida <= 0) {
            this.vida = 0;
            this.estado_de_vida = false;
        }
    }

    public void curar(int cantidad) {
        this.vida += cantidad;
    }

    // Cada tropa tendrá su acción especial
    public abstract void accionEspecial(Tropa enemigo);
}
