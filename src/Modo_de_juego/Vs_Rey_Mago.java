package Modo_de_juego;


//se creara los atques del mago
//Ataque Normal ⚔️
//Estrategia: Recorrido secuencial (O(n)).
//Recorre todos los datos de un archivo y te golpea uno por uno.
//Ataque Selectivo 
//estrategia: Selección (Selection Sort).
//Busca el número más fuerte y lo lanza contra ti.
//Golpe Burbujeante 💥
//Estrategia: Burbuja (Bubble Sort).
//Compara golpes en pares y deja que los más fuertes “suban” para atacarte.
//Inserción Fantasma 👻
//Estrategia: Inserción (Insertion Sort).
//Inserta ataques adicionales entre los existentes, confundiendo al enemigo.
//Fusión de Daños 🔗
//Estrategia: Fusión natural (Merge Sort).
//Divide ataques en dos mitades, los ordena y los lanza como combo.
//Tormenta Equilibrada ⚡
//Estrategia: Mezcla equilibrada múltiple.
//Divide los ataques en varios rayos mágicos y los reparte de forma balanceada.
//Ritual Polifásico ⏳
//Estrategia: Polifásico (ordenación externa).
//Lanza ráfagas en fases: primero largas, luego cortas y más fuertes.


import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.lang.reflect.Method;

import Extra.*;

public class Vs_Rey_Mago extends JDialog {

    private int turno_de_la_tropa_correspondiente = 1; // Controla cuál desplegable mostrar
    private JLabel jugador1Rey, jugador1Tropa1, jugador1Tropa2;//imagenes
    private JLabel jugador2Rey, jugador2Tropa1, jugador2Tropa2;//imagenes
    private JLabel vidaRey1, vidaT1A, vidaT2A;//textos
    private JLabel vidaRey2, vidaT1B, vidaT2B;//textos
    private JComboBox<String> combo1, combo2, combo3; //desplegable
    private JComboBox<String> combo7, combo8, combo9; //deplegable

    public Vs_Rey_Mago(List<jugador1> ejercito1, List<jugador2> ejercito2, Frame parent, String titulo) {
        super(parent, titulo, true); // <- true = modal (bloquea hasta cerrar)
        //creamos la ventana de batalla :v
        setSize(1100, 700);
        getContentPane().setBackground(Color.decode("#d8d197"));
        setLayout(null);

        // ------------ BOTÓN atacar ----------------
        JButton botonAtacar = new JButton("Atacar");
        botonAtacar.setBounds(30, 400, 150, 40);
        add(botonAtacar);
        botonAtacar.setVisible(false);

        //boton de inicializador
        JButton empezar = new JButton("Empezar Batalla");
        empezar.setBounds(230, 450, 150, 40);
        add(empezar);
        empezar.setVisible(true);

        empezar.addActionListener(e -> {
            InicializarImagenes(ejercito1, ejercito2);
            crearcombos(ejercito1, ejercito2);
            combo1.setVisible(true);
            //se crea para la primera tropa para atacar

            empezar.setVisible(false); //boton de empezar se oculta
            botonAtacar.setVisible(true); //boton de atacr se hace visible

        });

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void InicializarImagenes(List<jugador1> ejercito1, List<jugador2> ejercito2) {
        // ------------ IMÁGENES izquierda ----------------
        jugador1Rey = new JLabel(escalarImagen(ejercito1.get(0).rutaviva, 120, 120, 1));
        jugador1Rey.setBounds(50, 225, 120, 120);
        add(jugador1Rey);

        jugador1Tropa1 = new JLabel(escalarImagen(ejercito1.get(1).rutaviva, 100, 100, 1));
        jugador1Tropa1.setBounds(230, 150, 120, 120);
        add(jugador1Tropa1);

        jugador1Tropa2 = new JLabel(escalarImagen(ejercito1.get(2).rutaviva, 100, 100, 1));
        jugador1Tropa2.setBounds(230, 300, 120, 120);
        add(jugador1Tropa2);

        jugador2Rey = new JLabel(escalarImagen(ejercito2.get(0).rutaviva, 120, 120, 0));
        jugador2Rey.setBounds(910, 225, 120, 120);
        add(jugador2Rey);

        jugador2Tropa1 = new JLabel(escalarImagen(ejercito2.get(1).rutaviva, 100, 100, 0));
        jugador2Tropa1.setBounds(740, 150, 120, 120);
        add(jugador2Tropa1);

        jugador2Tropa2 = new JLabel(escalarImagen(ejercito2.get(2).rutaviva, 100, 100, 0));
        jugador2Tropa2.setBounds(740, 300, 120, 120);
        add(jugador2Tropa2);

        // ------------ VIDA LABELS ----------------
        vidaRey1 = new JLabel("Vida: " + ejercito1.get(0).vida);
        vidaRey1.setBounds(50, 200, 100, 20);
        add(vidaRey1);

        vidaT1A = new JLabel("Vida: " + ejercito1.get(1).vida);
        vidaT1A.setBounds(230, 125, 100, 20);
        add(vidaT1A);

        vidaT2A = new JLabel("Vida: " + ejercito1.get(2).vida);
        vidaT2A.setBounds(230, 275, 100, 20);
        add(vidaT2A);

        vidaRey2 = new JLabel("Vida: " + ejercito2.get(0).vida);
        vidaRey2.setBounds(910, 200, 100, 20);
        add(vidaRey2);

        vidaT1B = new JLabel("Vida: " + ejercito2.get(1).vida);
        vidaT1B.setBounds(740, 125, 100, 20);
        add(vidaT1B);

        vidaT2B = new JLabel("Vida: " + ejercito2.get(2).vida);
        vidaT2B.setBounds(740, 275, 100, 20);
        add(vidaT2B);

    }

    //crea los combsos en general
    private void crearcombos(List<jugador1> ejercito1, List<jugador2> ejercito2) {
        // Crear desplegables manualmente

        combo1 = crearCombo(ejercito1.get(2).nombre, 400, 475);
        combo2 = crearCombo(ejercito1.get(1).nombre, 400, 325);
        combo3 = crearCombo(ejercito1.get(0).nombre, 400, 175);

        combo7 = crearCombo(ejercito2.get(2).nombre, 570, 475);
        combo8 = crearCombo(ejercito2.get(1).nombre, 570, 325);
        combo9 = crearCombo(ejercito2.get(0).nombre, 570, 175);

        // Al inicio todos invisibles
        combo1.setVisible(false);
        combo2.setVisible(false);
        combo3.setVisible(false);

        combo7.setVisible(false);
        combo8.setVisible(false);
        combo9.setVisible(false);

        add(combo1);
        add(combo2);
        add(combo3);

        add(combo7);
        add(combo8);
        add(combo9);

    }

    private JComboBox<String> crearCombo(String j, int x, int y) {
        JComboBox<String> combo = new JComboBox<>();
        combo.setBounds(x, y, 150, 30);

        combo.addItem(j); // título
        // ataques según el tipo
        switch (j) {
            case "Arquero":
                combo.addItem("Disparo rápido");
                combo.addItem("Flecha penetrante");
                combo.addItem("Lluvia de flechas");
                break;
            case "Lanzatonio":
                combo.addItem("Lanzamiento poderoso");
                combo.addItem("Estocada");
                combo.addItem("Bloqueo");
                break;
            case "Espadachin":
                combo.addItem("Proteger");
                combo.addItem("Contraataque");
                combo.addItem("Estocada veloz");
                break;
            case "Rey Arquero":
                combo.addItem("Disparo real");
                combo.addItem("Flecha explosiva");
                combo.addItem("Furia del rey");
                break;
            case "Rey Lanzatonio":
                combo.addItem("Lanza imperial");
                combo.addItem("Bloqueo real");
                combo.addItem("Tormenta de lanzas");
                break;
            case "Rey Espadachin":
                combo.addItem("Espadazo real");
                combo.addItem("Guardia de hierro");
                combo.addItem("Golpe final");
                break;
        }
        return combo;
    }

    private ImageIcon escalarImagen1(String ruta, int ancho, int alto) {
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imgEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imgEscalada);
    }

    private ImageIcon escalarImagen(String ruta, int ancho, int alto, int a) {
        if (a == 1) {
            return escalarImagen1(ruta, ancho, alto);
        } else {

            try {
                // 1) Cargar la imagen original
                BufferedImage original = ImageIO.read(new File(ruta));

                // 2) Voltearla horizontalmente
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-original.getWidth(), 0);
                AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                BufferedImage volteada = op.filter(original, null);

                // 3) Escalar la imagen volteada
                Image imgEscalada = volteada.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

                // 4) Retornar como ImageIcon
                return new ImageIcon(imgEscalada);

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
