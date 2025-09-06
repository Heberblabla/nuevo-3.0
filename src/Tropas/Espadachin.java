package Tropas;

public class Espadachin {

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
    public Espadachin(String nombre, int vida, int ataque_base, double daño_critico,
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
    // Proteger → cura +50 de vida
    public void proteger() {
        this.vida += 50;
        if (this.vida < 0) {
            this.vida = 0; // por si acaso
        }
        System.out.println(this.nombre + " se protege y recupera 50 de vida. Vida actual: " + this.vida);
    }

    // Contraataque → daño crítico al enemigo
    public void contraataque(Espadachin enemigo) {
        int daño = this.ataque_base * 2; // critico fijo x2
        enemigo.vida -= daño;
        if (enemigo.vida < 0) {
            enemigo.vida = 0;
        }
        System.out.println(this.nombre + " contraataca a " + enemigo.nombre + " causando " + daño + " de daño.");
    }

    // Estocada veloz → pierde 150 vida pero golpea al enemigo con crítico
    public void estocadaVeloz(Espadachin enemigo) {
        // pierde vida
        this.vida -= 150;
        if (this.vida < 0) {
            this.vida = 0;
        }

        // pega daño crítico al enemigo
        int daño = this.ataque_base * 2;
        enemigo.vida -= daño;
        if (enemigo.vida < 0) {
            enemigo.vida = 0;
        }

        System.out.println(this.nombre + " usa Estocada Veloz: pierde 150 de vida pero golpea a "
                + enemigo.nombre + " con " + daño + " de daño.");
    }

    // ================== Métodos de utilidad ==================
    public boolean estaVivo() {
        return this.vida > 0;
    }
}
