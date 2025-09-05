package Extra;

public class jugador2 {

    public String nombre;
    public int vida;
    public int ataque_base;
    public double daño_critico;
    public double probabilidad_de_critico;
    public boolean aereo;
    public boolean estado_de_vida;
    public String rutaviva;
    public String rutamuerta;
    
    public jugador2() {
    }

    public jugador2(String nombre, int vida, int ataque_base, double daño_critico, double probabilidad_de_critico, boolean aereo, boolean estado_de_vida, String rutaviva, String rutamuerta) {
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

    public boolean isEstado_de_vida() {
        return estado_de_vida;
    }

    public void setEstado_de_vida(boolean estado_de_vida) {
        this.estado_de_vida = estado_de_vida;
    }

    public String getRutaviva() {
        return rutaviva;
    }

    public void setRutaviva(String rutaviva) {
        this.rutaviva = rutaviva;
    }

    public String getRutamuerta() {
        return rutamuerta;
    }

    public void setRutamuerta(String rutamuerta) {
        this.rutamuerta = rutamuerta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque_base() {
        return ataque_base;
    }

    public void setAtaque_base(int ataque_base) {
        this.ataque_base = ataque_base;
    }

    public double getDaño_critico() {
        return daño_critico;
    }

    public void setDaño_critico(double daño_critico) {
        this.daño_critico = daño_critico;
    }

    public double getProbabilidad_de_critico() {
        return probabilidad_de_critico;
    }

    public void setProbabilidad_de_critico(double probabilidad_de_critico) {
        this.probabilidad_de_critico = probabilidad_de_critico;
    }

    public boolean isAereo() {
        return aereo;
    }

    public void setAereo(boolean aereo) {
        this.aereo = aereo;
    }

    public void ataque(jugador1 enemigo) {
        enemigo.setVida(enemigo.getVida() - this.ataque_base);

        // Opcional: evitar que la vida sea negativa
        if (enemigo.getVida() < 0) {
            enemigo.setVida(0);
        }

    }

}
