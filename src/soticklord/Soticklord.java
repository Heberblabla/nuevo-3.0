package soticklord;

import Extra.Batalla;
import Extra.Seleccion;
import Extra.jugador1;
import Extra.jugador2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Soticklord {

    static List<jugador1> ejercitojugador1 = new ArrayList<>();
    static List<jugador2> ejercitojugador2 = new ArrayList<>();

    // Objetos de cada jugador
    static jugador1 rey1;
    static jugador1 tropaA1, tropaA2, tropaA3, tropaA4, tropaA5;

    static jugador2 rey2;
    static jugador2 tropaB1, tropaB2, tropaB3, tropaB4, tropaB5;

    //  Guardar la selección de cada jugador
    static Seleccion seleccion1;
    static Seleccion seleccion2;

    //  Base de datos de personajes cargada desde CSV
    static Map<String, String[]> stats = new HashMap<>();

    public static void main(String[] args) {
        //  Cargar datos del CSV
        cargarCSV("recursos/Datos.csv");

        //  Selección del jugador 1
        seleccion1 = new Seleccion(null, "Jugador 1");
        System.out.println("Jugador 1 eligió: " + seleccion1.nombre);

        // 🔹 Selección del jugador 2
        seleccion2 = new Seleccion(null, "Jugador 2");
        System.out.println("Jugador 2 eligió: " + seleccion2.nombre);

        // 🔹 Asignar los objetos reales de cada selección
        asignar();

        // ✅ Mostrar los ejércitos
        System.out.println("\n--- EJÉRCITOS ---");

        System.out.println("👑 Jugador 1 -> Rey: " + rey1.getNombre() + " | Vida: " + rey1.getVida());
        jugador1[] tropas1 = {tropaA1, tropaA2, tropaA3, tropaA4, tropaA5};
        for (int i = 0; i < tropas1.length; i++) {
            if (tropas1[i] != null) {
                System.out.println("  Tropa A" + (i + 1) + " -> " + tropas1[i].getNombre() + " | Vida: " + tropas1[i].getVida());
            }
        }

        System.out.println("\n👑 Jugador 2 -> Rey: " + rey2.getNombre() + " | Vida: " + rey2.getVida());
        jugador2[] tropas2 = {tropaB1, tropaB2, tropaB3, tropaB4, tropaB5};
        for (int i = 0; i < tropas2.length; i++) {
            if (tropas2[i] != null) {
                System.out.println("  Tropa B" + (i + 1) + " -> " + tropas2[i].getNombre() + " | Vida: " + tropas2[i].getVida());
            }
        }

        // 🔹 Inicia batalla
        Batalla xd = new Batalla(ejercitojugador1, ejercitojugador2, null, "waza");
    }

    // 📌 Método para cargar el CSV a memoria
    public static void cargarCSV(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine(); // saltar encabezado
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                // Nombre será la clave
                String nombre = datos[0].trim();
                stats.put(nombre, datos);
            }
            System.out.println("✅ CSV cargado correctamente (" + stats.size() + " personajes)");
        } catch (IOException e) {
            System.err.println("❌ Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    // 📌 Método genérico que crea un jugador1
    public static jugador1 crearJugador1(String nombre) {
        String[] s = stats.get(nombre);
        if (s == null) {
            return null;
        }
        return new jugador1(
                s[0], // Nombre
                Integer.parseInt(s[1]), // Vida
                Integer.parseInt(s[2]), // Ataque
                Double.parseDouble(s[3]), // Multiplicador
                Double.parseDouble(s[4]), // Probabilidad
                Boolean.parseBoolean(s[5]), // Aereo
                true, // siempre inicia vivo
                s[6], // RutaViva
                s[7] // RutaMuerta
        );
    }

    // 📌 Método genérico que crea un jugador2
    public static jugador2 crearJugador2(String nombre) {
        String[] s = stats.get(nombre);
        if (s == null) {
            return null;
        }
        return new jugador2(
                s[0], // Nombre
                Integer.parseInt(s[1]), // Vida
                Integer.parseInt(s[2]), // Ataque
                Double.parseDouble(s[3]), // Multiplicador
                Double.parseDouble(s[4]), // Probabilidad
                Boolean.parseBoolean(s[5]), // Aereo
                true, // siempre inicia vivo
                s[6], // RutaViva
                s[7] // RutaMuerta
        );
    }

    // 📌 Asignación automática de tropas y reyes
    public static void asignar() {
        // Jugador 1
        rey1 = crearJugador1(seleccion1.nombre);
        tropaA1 = crearJugador1(seleccion1.nombre1);
        tropaA2 = crearJugador1(seleccion1.nombre2);
        tropaA3 = crearJugador1(seleccion1.nombre3);
        tropaA4 = crearJugador1(seleccion1.nombre4);
        tropaA5 = crearJugador1(seleccion1.nombre5);

        ejercitojugador1.addAll(Arrays.asList(rey1, tropaA1, tropaA2, tropaA3, tropaA4, tropaA5));

        // Jugador 2
        rey2 = crearJugador2(seleccion2.nombre);
        tropaB1 = crearJugador2(seleccion2.nombre1);
        tropaB2 = crearJugador2(seleccion2.nombre2);
        tropaB3 = crearJugador2(seleccion2.nombre3);
        tropaB4 = crearJugador2(seleccion2.nombre4);
        tropaB5 = crearJugador2(seleccion2.nombre5);

        ejercitojugador2.addAll(Arrays.asList(rey2, tropaB1, tropaB2, tropaB3, tropaB4, tropaB5));
    }
}
