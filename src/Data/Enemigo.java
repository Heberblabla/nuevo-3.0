/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;


public class Enemigo {
    private String nombre;
    private int vida;
    private int vidavida;
    private int ataque_base;
    private double daño_critico;
    private double probabilidad_de_critico;
    private boolean aereo;
    private boolean estado_de_vida;
    private String rutaviva;
    private String rutamuerta;
    private boolean turnoActivo;
    private boolean turnoDoble;

    public Enemigo(String nombre, int vida, int vidavida, int ataque_base, double daño_critico, double probabilidad_de_critico, boolean aereo, boolean estado_de_vida, String rutaviva, String rutamuerta, boolean turnoActivo, boolean turnoDoble) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidavida = vidavida;
        this.ataque_base = ataque_base;
        this.daño_critico = daño_critico;
        this.probabilidad_de_critico = probabilidad_de_critico;
        this.aereo = aereo;
        this.estado_de_vida = estado_de_vida;
        this.rutaviva = rutaviva;
        this.rutamuerta = rutamuerta;
        this.turnoActivo = turnoActivo;
        this.turnoDoble = turnoDoble;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getVidavida() {
        return vidavida;
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

    public void setVidavida(int vidavida) {
        this.vidavida = vidavida;
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
    
    
    
}
