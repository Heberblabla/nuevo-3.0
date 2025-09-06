/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modo_de_juego;

import java.util.*;

import java.util.List;
import java.util.Random;
import java.util.*;

/**
 * Clase Mago: único mago del juego con varios ataques (cada uno inspirado en un
 * algoritmo). Cada ataque recibe una lista de objetivos (ejército enemigo).
 */
public class Mago {

    // ============================
    // Atributos
    // ============================
    public String nombre;
    public int vida;
    private int ataque_base;
    private double danio_critico;
    private double probabilidad_de_critico;
    private boolean aereo;
    public boolean estado_de_vida; // true = vivo, false = muerto
    private String rutaviva;
    private String rutamuerta;

    private final Random random = new Random();

    // ============================
    // Constructor
    // ============================
    public Mago(String nombre, int vida, int ataque_base,
            double danio_critico, double probabilidad_de_critico,
            boolean aereo, String rutaviva, String rutamuerta) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque_base = ataque_base;
        this.danio_critico = danio_critico;
        this.probabilidad_de_critico = probabilidad_de_critico;
        this.aereo = aereo;
        this.estado_de_vida = true; // inicia vivo
        this.rutaviva = rutaviva;
        this.rutamuerta = rutamuerta;
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

    public void setDanio_critico(double danio_critico) {
        this.danio_critico = danio_critico;
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

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque_base() {
        return ataque_base;
    }

    public double getDanio_critico() {
        return danio_critico;
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

    public Random getRandom() {
        return random;
    }

    // ============================
    // Turno del mago
    // ============================
    /**
     * El mago actúa: se elige un ataque aleatorio (1..7). Si deseas forzar un
     * ataque, usa realizarTurno(ejercito, opcionForzada).
     */
    public void realizarTurno(List<Jugador> ejercitoEnemigo) {
        realizarTurno(ejercitoEnemigo, -1);
    }

    /**
     * Realiza el turno; si opcionForzada entre 1 y 7 se usa esa opción.
     */
    public void realizarTurno(List<Jugador> ejercitoEnemigo, int opcionForzada) {
        if (!estado_de_vida) {
            System.out.println(nombre + " está muerto y no puede actuar.");
            return;
        }
        if (ejercitoEnemigo == null || ejercitoEnemigo.isEmpty()) {
            System.out.println("No hay ejército enemigo para atacar.");
            return;
        }

        int eleccion = (opcionForzada >= 1 && opcionForzada <= 7)
                ? opcionForzada
                : random.nextInt(7) + 1;

        System.out.println("\n" + this.nombre + " realiza ataque #" + eleccion);
        switch (eleccion) {
            case 1 ->
                ataqueNormal(ejercitoEnemigo);
            case 2 ->
                ataqueSelectivo(ejercitoEnemigo);
            case 3 ->
                golpeBurbujeante(ejercitoEnemigo);
            case 4 ->
                insercionFantasma(ejercitoEnemigo);
            case 5 ->
                fusionDeDaños(ejercitoEnemigo);
            case 6 ->
                tormentaEquilibrada(ejercitoEnemigo);
            case 7 ->
                ritualPolifasico(ejercitoEnemigo);
            default ->
                System.out.println("Opción inválida.");
        }
    }

    // ============================
    // Ataques (implementaciones seguras)
    // ============================
    // 1) Ataque Normal: recorre la lista (dinámicamente) y aplica ataque_base
    private void ataqueNormal(List<Jugador> ejercitoEnemigo) {
        System.out.println("Entrando a ataque normal");
        for (int i = 0; i < ejercitoEnemigo.size(); i++) {
            Jugador objetivo = ejercitoEnemigo.get(i);
            if (objetivo != null && objetivo.estado_de_vida) {
                System.out.println("Atacando a " + objetivo.nombre + " con " + this.ataque_base);
                aplicarDaño(objetivo, this.ataque_base);
            }
        }
    }

    // 2) Ataque Selectivo: busca el objetivo con mayor vida (entre vivos)
    private void ataqueSelectivo(List<Jugador> ejercitoEnemigo) {
        System.out.println("Ataque selectivo: buscando objetivo con mayor vida");
        Jugador objetivo = null;
        for (Jugador j : ejercitoEnemigo) {
            if (j != null && j.estado_de_vida) {
                if (objetivo == null || j.vida > objetivo.vida) {
                    objetivo = j;
                }
            }
        }
        if (objetivo != null) {
            System.out.println("Objetivo elegido: " + objetivo.nombre);
            aplicarDaño(objetivo, ataque_base * 2); // golpe más fuerte
        } else {
            System.out.println("No hay objetivos vivos para ataque selectivo.");
        }
    }

    // 3) Golpe Burbujeante: compara pares consecutivos y ataca al que "sube" (mayor vida)
    private void golpeBurbujeante(List<Jugador> ejercitoEnemigo) {
        System.out.println("Golpe burbujeante: comparando pares consecutivos");
        int n = ejercitoEnemigo.size();
        for (int j = 0; j < n - 1; j++) {
            Jugador a = ejercitoEnemigo.get(j);
            Jugador b = ejercitoEnemigo.get(j + 1);
            if ((a == null || !a.estado_de_vida) && (b == null || !b.estado_de_vida)) {
                continue;
            }

            // Si ambos vivos, ataca al de mayor vida; si sólo uno vivo ataca a ese.
            if (a != null && a.estado_de_vida && b != null && b.estado_de_vida) {
                if (a.vida > b.vida) {
                    System.out.println("Comparación: " + a.nombre + " > " + b.nombre + " → golpe a " + a.nombre);
                    aplicarDaño(a, ataque_base);
                } else if (b.vida > a.vida) {
                    System.out.println("Comparación: " + b.nombre + " > " + a.nombre + " → golpe a " + b.nombre);
                    aplicarDaño(b, ataque_base);
                } else { // iguales -> golpe a ambos ligeramente
                    System.out.println("Vidas iguales, golpe a ambos.");
                    aplicarDaño(a, ataque_base);
                    aplicarDaño(b, ataque_base);
                }
            } else {
                if (a != null && a.estado_de_vida) {
                    aplicarDaño(a, ataque_base);
                }
                if (b != null && b.estado_de_vida) {
                    applyIfAlive(b, ataque_base);
                }
            }
        }
    }

    // 4) Inserción Fantasma: ataca de menor a mayor vida y aplica un "golpe fantasma" extra
    private void insercionFantasma(List<Jugador> ejercitoEnemigo) {
        System.out.println("Inserción fantasma: atacando de menor a mayor vida");
        List<Jugador> vivos = new ArrayList<>();
        for (Jugador j : ejercitoEnemigo) {
            if (j != null && j.estado_de_vida) {
                vivos.add(j);
            }
        }
        vivos.sort(Comparator.comparingInt(x -> x.vida));
        for (Jugador objetivo : vivos) {
            System.out.println("Atacando a " + objetivo.nombre);
            aplicarDaño(objetivo, ataque_base);
            // golpe fantasma (mitad del daño base)
            int fantasma = Math.max(1, ataque_base / 2);
            System.out.println("Golpe fantasma a " + objetivo.nombre + " por " + fantasma);
            aplicarDaño(objetivo, fantasma);
        }
    }

    // 5) Fusión de Daños: divide en dos mitades, ordena cada mitad y hace merge aplicando ataques
    private void fusionDeDaños(List<Jugador> ejercitoEnemigo) {
        System.out.println("Fusión de daños: merge de mitades");
        int n = ejercitoEnemigo.size();
        int mid = n / 2;
        List<Jugador> left = new ArrayList<>();
        List<Jugador> right = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            if (ejercitoEnemigo.get(i) != null && ejercitoEnemigo.get(i).estado_de_vida) {
                left.add(ejercitoEnemigo.get(i));
            }
        }
        for (int i = mid; i < n; i++) {
            if (ejercitoEnemigo.get(i) != null && ejercitoEnemigo.get(i).estado_de_vida) {
                right.add(ejercitoEnemigo.get(i));
            }
        }

        left.sort(Comparator.comparingInt(j -> j.vida));
        right.sort(Comparator.comparingInt(j -> j.vida));

        int i = 0, j = 0;
        while (i < left.size() || j < right.size()) {
            Jugador next;
            if (i < left.size() && (j >= right.size() || left.get(i).vida <= right.get(j).vida)) {
                next = left.get(i++);
            } else {
                next = right.get(j++);
            }
            aplicarDaño(next, ataque_base);
        }
    }

    // 6) Tormenta Equilibrada: divide en k buckets (rayos) y los procesa equilibradamente
    private void tormentaEquilibrada(List<Jugador> ejercitoEnemigo) {
        System.out.println("Tormenta equilibrada: dividiendo en 3 rayos");
        int k = Math.min(3, Math.max(1, ejercitoEnemigo.size()));
        List<List<Jugador>> buckets = new ArrayList<>();
        for (int t = 0; t < k; t++) {
            buckets.add(new ArrayList<>());
        }

        int idx = 0;
        for (Jugador j : ejercitoEnemigo) {
            if (j != null && j.estado_de_vida) {
                buckets.get(idx % k).add(j);
                idx++;
            }
        }
        for (List<Jugador> bucket : buckets) {
            bucket.sort(Comparator.comparingInt(x -> x.vida));
        }

        boolean any;
        do {
            any = false;
            for (List<Jugador> bucket : buckets) {
                if (!bucket.isEmpty()) {
                    Jugador objetivo = bucket.remove(0);
                    aplicarDaño(objetivo, Math.max(1, ataque_base / k));
                    any = true;
                }
            }
        } while (any);
    }

    // 7) Ritual Polifásico: fases desiguales (50% - 30% - 20%) con daño creciente por fase
    private void ritualPolifasico(List<Jugador> ejercitoEnemigo) {
        System.out.println("Ritual polifásico: fases desiguales");
        List<Jugador> vivos = new ArrayList<>();
        for (Jugador j : ejercitoEnemigo) {
            if (j != null && j.estado_de_vida) {
                vivos.add(j);
            }
        }
        int total = vivos.size();
        if (total == 0) {
            System.out.println("No hay objetivos vivos");
            return;
        }

        // tamaños por fase
        int s1 = (int) Math.round(total * 0.5);
        int s2 = (int) Math.round(total * 0.3);
        int s3 = total - s1 - s2;
        int pos = 0;

        List<Jugador> phase1 = vivos.subList(0, Math.min(pos + s1, total));
        pos += phase1.size();
        List<Jugador> phase2 = vivos.subList(pos, Math.min(pos + s2, total));
        pos += phase2.size();
        List<Jugador> phase3 = vivos.subList(pos, total);

        for (Jugador j : phase1) {
            aplicarDaño(j, ataque_base);
        }
        for (Jugador j : phase2) {
            aplicarDaño(j, (int) Math.round(ataque_base * 1.5));
        }
        for (Jugador j : phase3) {
            aplicarDaño(j, ataque_base * 2);
        }
    }

    // ============================
    // Utilitarios
    // ============================
    // Aplica daño solo si objetivo vivo; maneja crítico y estado_de_vida coherente (true = vivo)
    private void aplicarDaño(Jugador objetivo, int daño) {
        if (objetivo == null) {
            return;
        }
        if (!objetivo.estado_de_vida) {
            System.out.println(objetivo.nombre + " ya está muerto, saltando.");
            return;
        }

        System.out.println("Aplicando daño a " + objetivo.nombre + " (base=" + daño + ")");
        boolean critico = random.nextDouble() < probabilidad_de_critico;
        int dañoFinal = critico ? (int) Math.round(daño * danio_critico) : daño;
        if (critico) {
            System.out.println("¡CRÍTICO! Daño final = " + dañoFinal);
        }

        objetivo.vida -= dañoFinal;
        if (objetivo.vida <= 0) {
            objetivo.vida = 0;
            objetivo.estado_de_vida = false; // ahora false = muerto
            System.out.println(objetivo.nombre + " ha caído ☠️");
            // aquí podrías setear sprite a rutamuerta si quieres
        } else {
            System.out.println(objetivo.nombre + " ahora tiene " + objetivo.vida + " de vida.");
        }
    }

    // helper cuando no queremos prints repetidos en pequeños lugares
    private void applyIfAlive(Jugador objetivo, int daño) {
        if (objetivo != null && objetivo.estado_de_vida) {
            aplicarDaño(objetivo, daño);
        }
    }

    // Getters / setters si los necesitas (omitidos por brevedad)
}
