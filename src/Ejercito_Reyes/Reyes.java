package Ejercito_Reyes;

public abstract class Reyes {

    // 🔹 Atributos
    private String nombre;
    private int vida;
    private int ataqueBase;
    private double dañoCritico;
    private double probabilidadCritico;
    private boolean aereo;

    // 🔹 Rutas de imágenes
    private String rutaViva;
    private String rutaMuerta;

    // 🔹 Control de turnos
    private boolean turnoActivo;
    private boolean turnoDoble;

    // 🔹 Constructor
    public Reyes(String nombre, int vida, int ataqueBase, double dañoCritico,
            double probabilidadCritico, boolean aereo,
            String rutaViva, String rutaMuerta,
            boolean turnoActivo, boolean turnoDoble) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataqueBase = ataqueBase;
        this.dañoCritico = dañoCritico;
        this.probabilidadCritico = probabilidadCritico;
        this.aereo = aereo;
        this.rutaViva = rutaViva;
        this.rutaMuerta = rutaMuerta;
        this.turnoActivo = turnoActivo;
        this.turnoDoble = turnoDoble;
    }

    // 🔹 Métodos útiles
    public boolean estaVivo() {
        return vida > 0;
    }

    // 🔹 Getters y Setters
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
        this.vida = Math.max(vida, 0);
    } // evita vida negativa

    public int getAtaqueBase() {
        return ataqueBase;
    }

    public void setAtaqueBase(int ataqueBase) {
        this.ataqueBase = ataqueBase;
    }

    public double getDañoCritico() {
        return dañoCritico;
    }

    public void setDañoCritico(double dañoCritico) {
        this.dañoCritico = dañoCritico;
    }

    public double getProbabilidadCritico() {
        return probabilidadCritico;
    }

    public void setProbabilidadCritico(double probabilidadCritico) {
        this.probabilidadCritico = probabilidadCritico;
    }

    public boolean isAereo() {
        return aereo;
    }

    public void setAereo(boolean aereo) {
        this.aereo = aereo;
    }

    public String getRutaViva() {
        return rutaViva;
    }

    public void setRutaViva(String rutaViva) {
        this.rutaViva = rutaViva;
    }

    public String getRutaMuerta() {
        return rutaMuerta;
    }

    public void setRutaMuerta(String rutaMuerta) {
        this.rutaMuerta = rutaMuerta;
    }

    public boolean isTurnoActivo() {
        return turnoActivo;
    }

    public void setTurnoActivo(boolean turnoActivo) {
        this.turnoActivo = turnoActivo;
    }

    public boolean isTurnoDoble() {
        return turnoDoble;
    }

    public void setTurnoDoble(boolean turnoDoble) {
        this.turnoDoble = turnoDoble;
    }
}
