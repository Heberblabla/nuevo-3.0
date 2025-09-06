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
import Modo_de_juego.Vs_Rey_Mago;
import javax.swing.*;
import java.awt.*;
import Modo_de_juego.*;

public class Soticklord {

    private static JFrame frame; // referencia de la ventana
    static List<jugador1> ejercitojugador1 = new ArrayList<>();
    static List<jugador2> ejercitojugador2 = new ArrayList<>();

    static List<Jugador> ejercitojugadores = new ArrayList<>();

    static Mago magitoa = new Mago("Rey Mago", 5000, 50, 2, 0.5, true, "recursos/Rey_Mago.png", "recursos/tropa_muerta.png");

    // Objetos de cada jugador
    static jugador1 rey1;
    static jugador1 tropaA1, tropaA2, tropaA3, tropaA4, tropaA5;

    static jugador2 rey2;
    static jugador2 tropaB1, tropaB2, tropaB3, tropaB4, tropaB5;

    static Jugador rey10, Tropa11, Tropa12, rey20, Tropa21, Tropa22;

    //  Guardar la selección de cada jugador
    static Seleccion seleccion1;
    static Seleccion seleccion2;
    static Modo_de_juego.Seleccion seleccion3;
    static Modo_de_juego.Seleccion seleccion4;

    //  Base de datos de personajes cargada desde CSV
    static Map<String, String[]> stats = new HashMap<>();

    public static void pvp() {
        frame.dispose(); // 🔹 cierra
        seleccion1 = new Seleccion(null, "Jugador 1");
        System.out.println("Jugador 2 eligió: " + seleccion1.nombre);

        seleccion2 = new Seleccion(null, "Jugador 2");
        System.out.println("Jugador 2 eligió: " + seleccion2.nombre);

        asignar();

        Batalla xd = new Batalla(ejercitojugador1, ejercitojugador2, null, "waza");

    }

    public static void evento() {
        frame.dispose(); // 🔹 cierra
        seleccion3 = new Modo_de_juego.Seleccion(null, "Jugador 1");
        System.out.println("Jugador 1 eligió: " + seleccion3.nombre);

        seleccion4 = new Modo_de_juego.Seleccion(null, "Jugador 2");
        System.out.println("Jugador 2 eligió: " + seleccion4.nombre);

        asignar1();

        System.out.println("creadni jueh");
        Vs_Rey_Mago waza = new Vs_Rey_Mago(ejercitojugadores, null, "waza", magitoa);
        System.out.println("creadni jueh");
    }

    public static void menu() {
        frame = new JFrame("Mini Menú");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Centrar en pantalla

        // Crear panel con layout vertical
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 filas, 1 columna, espacio entre botones

        // Crear botones
        JButton pvpButton = new JButton("PvP Local");
        JButton eventoButton = new JButton("Evento");
        JButton catalogoButton = new JButton("Catálogo");

        // Agregar botones al panel
        panel.add(pvpButton);
        panel.add(eventoButton);
        panel.add(catalogoButton);

        // Agregar panel a la ventana
        frame.add(panel, BorderLayout.CENTER);

        // Mostrar ventana
        frame.setVisible(true);

        // Acciones de los botones (ejemplo con mensaje)
        pvpButton.addActionListener(e -> {
            pvp();

        });
        eventoButton.addActionListener(e -> {
            evento();

        });
        catalogoButton.addActionListener(e -> {
            System.out.println("hola waza");

        });

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

    public static Jugador crearJugador(String nombre) {
        String[] s = stats.get(nombre);
        if (s == null) {
            return null;
        }
        return new Jugador(
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

    // Asignación automática de tropas y reyes . pvp
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

    // Asignación automática de tropas y reyes . evento
    public static void asignar1() {
        // Jugadores
        rey10 = crearJugador(seleccion3.nombre);
        Tropa11 = crearJugador(seleccion3.nombre1);
        Tropa12 = crearJugador(seleccion3.nombre2);
        rey20 = crearJugador(seleccion4.nombre);
        Tropa21 = crearJugador(seleccion4.nombre1);
        Tropa22 = crearJugador(seleccion4.nombre2);

        ejercitojugadores.addAll(Arrays.asList(rey10, Tropa11, Tropa12, rey20, Tropa21, Tropa22));
        System.out.println("asigando");
    }

    public static void main(String[] args) {
        cargarCSV("recursos/Datos.csv");//  Cargar datos del CSV
        menu();
    }

}
