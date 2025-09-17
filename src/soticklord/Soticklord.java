package soticklord;

import Herramientas.*;
import Data.*;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class Soticklord {

    private static JFrame frame; // referencia de la ventana
    private static JFrame Dificultad;
    static List<Tropa> ejercito1 = new ArrayList<>();
    static List<Tropa> ejercito2 = new ArrayList<>();
    //static Mago magito;
    // Objetos de cada jugador    
    //static Jugador rey10, Tropa11, Tropa12, rey20, Tropa21, Tropa22;

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
            dificultad();

        });
        catalogoButton.addActionListener(e -> {
            System.out.println("hola waza");

        });

    }

    public static void pvp() {
        frame.dispose(); // 🔹 cierra  
        Seleccion seleccion1 = new Seleccion(null, "Jugador 1");
        Seleccion seleccion2 = new Seleccion(null, "Jugador 2");
        Buscador buscador = new Buscador();
        List<Tropa> ejercito1 = buscador.obtenerTropas(seleccion1);
        List<Tropa> ejercito2 = buscador.obtenerTropas(seleccion2);
        Batalla_1 xd = new Batalla_1(ejercito1, ejercito2, null, "waza");

    }

    public static void evento() {
        Dificultad.dispose(); // 🔹 cierra

    }

    public static void dificultad() {
        frame.dispose();
        Dificultad = new JFrame("Elije la dificultadd");
        Dificultad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dificultad.setSize(300, 200);
        Dificultad.setLocationRelativeTo(null); // Centrar en pantalla

        // Crear panel con layout vertical
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 filas, 1 columna, espacio entre botones

        // Crear botones
        JButton facil = new JButton("Fcil");
        JButton medio = new JButton("Medio");
        JButton Dificil = new JButton("Dificil");
        JButton Locura = new JButton("Locura");

        // Agregar botones al panel
        panel.add(facil);
        panel.add(medio);
        panel.add(Dificil);
        panel.add(Locura);
        // Agregar panel a la ventana
        Dificultad.add(panel, BorderLayout.CENTER);

        // Mostrar ventana
        Dificultad.setVisible(true);

        // Acciones de los botones (ejemplo con mensaje)
        facil.addActionListener(e -> {
            //magito = new Mago("Rey Mago", 5000, 45, 2, 0.30, true, "recursos/Rey_Mago.png", "recursos/tropa_muerta.png");
            evento();
        });
        medio.addActionListener(e -> {
            //magito = new Mago("Rey Mago", 9000, 60, 4, 0.40, true, "recursos/Rey_Mago.png", "recursos/tropa_muerta.png");
            evento();
        });
        Dificil.addActionListener(e -> {
            //magito = new Mago("Rey Mago", 15000, 70, 5, 0.50, true, "recursos/Rey_Mago.png", "recursos/tropa_muerta.png");
            evento();
        });

        Locura.addActionListener(e -> {
            //magito = new Mago("Rey Mago", 20000, 100, 10, 0.80, true, "recursos/Rey_Mago.png", "recursos/tropa_muerta.png");
            evento();
        });
    }

    public static void main(String[] args) {
        menu();
    }

}
