package Data;

import java.util.ArrayList;
import java.util.Random;

public class Rey_Goku extends Tropa {

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
    private boolean kayokenactivo;

    public Rey_Goku() {
        this.nombre = "Rey_Goku";
        this.vida = 500;
        this.ataque_base = 50;
        this.daño_critico = 1.5;
        this.probabilidad_de_critico = 0.50;
        this.aereo = true;
        this.estado_de_vida = true;
        this.rutaviva = "recursos/rey/Goku/rey_Goku.png";
        this.rutamuerta = "recursos/tropa_muerta.png";
        this.turnoActivo = true; //verficar si puede atacar este turno
        this.turnoDoble = false; //verficar si tiene doble turno
        this.kayokenactivo = false; //verfica si tiene kayoken activo

    }

    public boolean isTurnoActivo() {
        return turnoActivo;
    }

    public boolean isTurnoDoble() {
        return turnoDoble;
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

    //metodo principal para atcar
    public void Ataque_normal(ArrayList<Tropa> enemigos, int posicion) {
        if (this.kayokenactivo) {
            this.vida = this.vida - 200;
        }
        int daño = Daño();
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);

    }

    public void Hame_hame_ha(ArrayList<Tropa> enemigos, int posicion) {
        if (this.kayokenactivo) {
            this.vida = this.vida - 300;
        }
        int daño = Daño();
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);
    }

    public void Henki_dama(ArrayList<Tropa> enemigos, int posicion) {
        if (this.kayokenactivo) {
            this.vida = this.vida - 400;
        }
        int daño = Daño();
        int nuevavida = enemigos.get(posicion).getVida() - daño;
        enemigos.get(posicion).setVida(nuevavida);
    }

    public void Activar_Kayoken(ArrayList<Tropa> enemigos, int posicion) {
        if (this.rutaviva.equalsIgnoreCase("recursos/rey/Goku/rey_Goku.png")) {
            this.rutaviva = "recursos/rey/Goku/Kayoken/rey_Goku.png";
            this.kayokenactivo = true;
            this.ataque_base = this.ataque_base * 2;
        }
        if (this.rutaviva.equalsIgnoreCase("recursos/rey/Goku/rey_Goku_SS1.png")) {
            this.rutaviva = "recursos/rey/Goku/Kayoken/rey_Goku_SS1.png";
            this.kayokenactivo = true;
            this.ataque_base = this.ataque_base * 2;
        }
        if (this.rutaviva.equalsIgnoreCase("recursos/rey/Goku/rey_Goku_SS2.png")) {
            this.rutaviva = "recursos/rey/Goku/Kayoken/rey_Goku_SS2.png";
            this.kayokenactivo = true;
            this.ataque_base = this.ataque_base * 2;
        }
        if (this.rutaviva.equalsIgnoreCase("recursos/rey/Goku/rey_Goku_SS3.png")) {
            this.rutaviva = "recursos/rey/Goku/Kayoken/rey_Goku_SS3.png";
            this.kayokenactivo = true;
            this.ataque_base = this.ataque_base * 2;
        }
        if (this.rutaviva.equalsIgnoreCase("recursos/rey/Goku/rey_Goku_SSDIOS.png")) {
            this.rutaviva = "recursos/rey/Goku/Kayoken/rey_Goku_SSDIOS.png";
            this.kayokenactivo = true;
            this.ataque_base = this.ataque_base * 2;
        }
        if (this.rutaviva.equalsIgnoreCase("recursos/rey/Goku/rey_Goku_SSBLUE.png")) {
            this.rutaviva = "recursos/rey/Goku/Kayoken/rey_Goku_SSBLUE.png";
            this.kayokenactivo = true;
            this.ataque_base = this.ataque_base * 2;
        }

    }

    public void Fase_Normal(ArrayList<Tropa> enemigos, int posicion) {

        this.rutaviva = "recursos/rey/Goku/rey_Goku.png";
        this.vida = 500;
        this.ataque_base = 50;

    }

    public void Transformarse_SS1(ArrayList<Tropa> enemigos, int posicion) {
        this.kayokenactivo = false;
        this.rutaviva = "recursos/rey/Goku/rey_Goku_SS1.png";
        this.vida = this.vida + 100;
        this.ataque_base = this.ataque_base + 50;
        this.probabilidad_de_critico = 0.55;
        if (this.vida > 700) {
            this.vida = 700;
        }
        if (this.ataque_base > 100) {
            this.ataque_base = 100;
        }
    }

    public void Transformarse_SS2(ArrayList<Tropa> enemigos, int posicion) {
        this.kayokenactivo = false;
        this.rutaviva = "recursos/rey/Goku/rey_Goku_SS2.png";
        this.vida = this.vida + 200;
        this.ataque_base = this.ataque_base + 60;
        this.probabilidad_de_critico = 0.60;
        if (this.vida > 900) {
            this.vida = 900;
        }
        if (this.ataque_base > 160) {
            this.ataque_base = 160;
        }

    }

    public void Transformarse_SS3(ArrayList<Tropa> enemigos, int posicion) {
        this.kayokenactivo = false;
        this.rutaviva = "recursos/rey/Goku/rey_Goku_SS3.png";
        this.vida = this.vida + 200;
        this.ataque_base = this.ataque_base + 70;
        this.probabilidad_de_critico = 0.65;
        if (this.vida > 1200) {
            this.vida = 1200;
        }
        if (this.ataque_base > 230) {
            this.ataque_base = 230;
        }
    }

    public void Transformarse_SSDIOS(ArrayList<Tropa> enemigos, int posicion) {
        this.kayokenactivo = false;
        this.rutaviva = "recursos/rey/Goku/rey_Goku_SSDIOS.png";
        this.vida = this.vida + 200;
        this.ataque_base = this.ataque_base + 70;
        this.probabilidad_de_critico = 0.70;
        if (this.vida > 1500) {
            this.vida = 1500;
        }
        if (this.ataque_base > 300) {
            this.ataque_base = 300;
        }

    }

    public void Transformarse_SSBLUE(ArrayList<Tropa> enemigos, int posicion) {
        this.kayokenactivo = false;
        this.rutaviva = "recursos/rey/Goku/rey_Goku_SSBLUE.png";
        this.vida = this.vida + 500;
        this.ataque_base = this.ataque_base + 100;
        this.probabilidad_de_critico = 0.75;

        if (this.vida > 2000) {
            this.vida = 2000;
        }
        if (this.ataque_base > 400) {
            this.ataque_base = 400;
        }

    }

}
