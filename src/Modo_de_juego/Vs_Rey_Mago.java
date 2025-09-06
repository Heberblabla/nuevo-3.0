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
import Tropas.*;

public class Vs_Rey_Mago extends JDialog {

    private static int turno_de_la_tropa_correspondiente = 1; // Controla cuál desplegable mostrar
    private static JLabel jugador1Rey, jugador1Tropa1, jugador1Tropa2;//imagenes
    private static JLabel jugador2Rey, jugador2Tropa1, jugador2Tropa2;//imagenes

    private static JLabel magito; //imagen del mago
    private static JLabel magitovida;  //vida del magito

    private static JLabel vidaRey1, vidaT1A, vidaT2A;//texto
    private static JLabel vidaRey2, vidaT1B, vidaT2B;//textos
    private static JComboBox<String> combo1, combo2, combo3, combo4, combo5, combo6; //desplegable

    public Vs_Rey_Mago(List<Jugador> ejercitos, Frame parent, String titulo, Mago magito) {
        super(parent, titulo, true); // <- true = modal (bloquea hasta cerrar)
        //creamos la ventana de batalla :v
        setSize(1000, 700);
        getContentPane().setBackground(Color.decode("#d8d197"));
        setLayout(null);

        // ------------ BOTÓN atacar ----------------
        JButton botonAtacar = new JButton("Atacar");
        botonAtacar.setBounds(500, 350, 150, 40);
        add(botonAtacar);
        botonAtacar.setVisible(false);

        //boton de inicializador
        JButton empezar = new JButton("Empezar Batalla");
        empezar.setBounds(500, 350, 150, 40);
        add(empezar);
        empezar.setVisible(true);

        empezar.addActionListener(e -> {
            InicializarImagenes(ejercitos, magito);
            crearcombos(ejercitos);
            combo1.setVisible(false);
            //se crea para la primera tropa para atacar

            empezar.setVisible(false); //boton de empezar se oculta
            botonAtacar.setVisible(true); //boton de atacr se hace visible

        });

        JButton waos = new JButton("Empezar");
        waos.setBounds(400, 250, 150, 40);
        add(waos);

        botonAtacar.addActionListener(e -> {
            waos(ejercitos, magito);
            waos.setVisible(true);
        });

        waos.addActionListener(e -> {
            int Seleccion_posicion_del_turno_tropa;
            String seleccion_de_ataque;
            int posicionn;

            switch (turno_de_la_tropa_correspondiente) {
                case 1:
                    posicionn = 2;
                    seleccion_de_ataque = (String) combo1.getSelectedItem();
                    //int Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo2_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv
                    waos1(seleccion_de_ataque, ejercitos, magito, posicionn);
                    mostrarSiguiente(ejercitos, posicionn);
                    break;
                case 2:
                    posicionn = 1;
                    seleccion_de_ataque = (String) combo2.getSelectedItem();
                    //int Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo2_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv
                    waos1(seleccion_de_ataque, ejercitos, magito, posicionn);
                    mostrarSiguiente(ejercitos, posicionn);
                    break;
                case 3:
                    posicionn = 0;
                    seleccion_de_ataque = (String) combo3.getSelectedItem();
                    //int Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo2_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv
                    waos1(seleccion_de_ataque, ejercitos, magito, posicionn);
                    mostrarSiguiente(ejercitos, posicionn);
                    break;
                case 4:
                    posicionn = 5;
                    seleccion_de_ataque = (String) combo4.getSelectedItem();
                    //int Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo2_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv
                    waos1(seleccion_de_ataque, ejercitos, magito, posicionn);
                    mostrarSiguiente(ejercitos, posicionn);
                    break;
                case 5:
                    posicionn = 4;
                    seleccion_de_ataque = (String) combo5.getSelectedItem();
                    //int Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo2_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv
                    waos1(seleccion_de_ataque, ejercitos, magito, posicionn);
                    mostrarSiguiente(ejercitos, posicionn);
                    break;
                case 6:
                    posicionn = 3;
                    seleccion_de_ataque = (String) combo6.getSelectedItem();
                    //int Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo2_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv
                    waos1(seleccion_de_ataque, ejercitos, magito, posicionn);
                    mostrarSiguiente(ejercitos, posicionn);
                    break;
            }

        });

        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void mostrarSiguiente(List<Jugador> ejercito11, int posicion_del_turno_actual) {
        //si estoy en pocicion 5 , debo ver si la siguiente tropa en el arrasylist (posicon4) esta viva :v
        //si estoy en turno 1 , debo ver si la siguiente tropa en el arrasylist (poscion2)  esta viva :v
        int waaa = 0;
        //tropas_del_enemigo2_para_seleccionar.setVisible(false);
        //tropas_del_enemigo1_para_seleccionar.setVisible(false);

        while (true) {

            if (turno_de_la_tropa_correspondiente == 1) {
                //el desplegable de la tripa 1 desaparece
                combo1.setVisible(false);
                //vamos a ver si la tropa q sigue ,esta viva
                posicion_del_turno_actual = posicion_del_turno_actual - 1;
                //verficamos 
                if (ejercito11.get(posicion_del_turno_actual).estado_de_vida) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    combo2.setVisible(true);
                    //desplegable(ejercito11, ejercito22, posicion_del_turno_actual, true, false);
                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente++;
                    //y se acaba el metood
                    return;
                } else {
                    turno_de_la_tropa_correspondiente++;
                }

            }
            if (turno_de_la_tropa_correspondiente == 2) {
                //el desplegable de la tripa 1 desaparece
                combo2.setVisible(false);
                //vamos a ver si la tropa q sigue ,esta viva
                posicion_del_turno_actual = posicion_del_turno_actual - 1;
                //verficamos 
                if (ejercito11.get(posicion_del_turno_actual).estado_de_vida) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    combo3.setVisible(true);
                    //desplegable(ejercito11, ejercito22, posicion_del_turno_actual, true, false);
                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente++;
                    //y se acaba el metood
                    return;
                } else {
                    turno_de_la_tropa_correspondiente++;
                }

            }
            if (turno_de_la_tropa_correspondiente == 3) {
                //el desplegable de la tripa 1 desaparece
                combo3.setVisible(false);
                //vamos a ver si la tropa q sigue ,esta viva
                posicion_del_turno_actual = posicion_del_turno_actual - 1;
                //verficamos 
                if (ejercito11.get(posicion_del_turno_actual).estado_de_vida) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    //combo4.setVisible(true);
                    //desplegable(ejercito11, ejercito22, posicion_del_turno_actual, true, false);
                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente++;
                    //y se acaba el metood
                    return;
                } else {
                    posicion_del_turno_actual = 6;
                    turno_de_la_tropa_correspondiente++;
                }

            }
            if (turno_de_la_tropa_correspondiente == 4) {
                //el desplegable de la tripa 1 desaparece
                combo4.setVisible(false);
                //vamos a ver si la tropa q sigue ,esta viva
                posicion_del_turno_actual = posicion_del_turno_actual - 1;
                //verficamos 
                if (ejercito11.get(posicion_del_turno_actual).estado_de_vida) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    //desplegable(ejercito11, ejercito22, posicion_del_turno_actual, true, false);
                    combo5.setVisible(true);
                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente++;
                    //y se acaba el metood
                    return;
                } else {
                    turno_de_la_tropa_correspondiente++;
                }

            }
            if (turno_de_la_tropa_correspondiente == 5) {
                //el desplegable de la tripa 1 desaparece
                combo5.setVisible(false);
                //vamos a ver si la tropa q sigue ,esta viva

                posicion_del_turno_actual = posicion_del_turno_actual - 1;
                //verficamos      
                if (ejercito11.get(posicion_del_turno_actual).estado_de_vida) {
                    //si esta viva ,entonces se activa su deslegable de ataques

                    combo6.setVisible(true);
                    //desplegable(ejercito11, ejercito22, posicion_del_turno_actual, true, false);
                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente++;
                    return;
                } else {

                    turno_de_la_tropa_correspondiente++;
                }

            }

            //nos pasamos pala siguietne tropa
            if (turno_de_la_tropa_correspondiente == 6) {
                //el desplegable de la tripa 1 desaparece
                combo6.setVisible(false);
                //vamos a ver si la tropa q sigue ,esta viva ,actualizamos el contenedor
                posicion_del_turno_actual = 5;
                //verficamos 
                if (ejercito11.get(posicion_del_turno_actual).estado_de_vida) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    //desplegable(ejercito11, ejercito22, posicion_del_turno_actual, false, true);
                    combo1.setVisible(true);
                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente++;
                    //y se acaba el metood
                    return;
                } else {
                    turno_de_la_tropa_correspondiente = 1;
                    waaa = waaa + 1;
                }

            }

            if (waaa > 100) {
                break;
            }

        }
    }

    private void waos1(String Ataque_selecionado, List<Jugador> ejercito1, Mago magitoo, int posicion) {

        // 🔹 ESPADACHÍN
        if (Ataque_selecionado.equalsIgnoreCase("Proteger")) {
            ejercito1.get(posicion).vida += 50;
        }
        if (Ataque_selecionado.equalsIgnoreCase("Contraataque")) {
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 2);
        }
        if (Ataque_selecionado.equalsIgnoreCase("Estocada veloz")) {
            ejercito1.get(posicion).vida -= 150; // pierde vida por arriesgarse
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 2);
        }

        // 🔹 ARQUERO
        if (Ataque_selecionado.equalsIgnoreCase("Disparo rápido")) {
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 2);
        }
        if (Ataque_selecionado.equalsIgnoreCase("Flecha penetrante")) {
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 3);
        }
        if (Ataque_selecionado.equalsIgnoreCase("Lluvia de flechas")) {
            ejercito1.get(posicion).vida -= 100; // desgaste físico
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 2);
        }

        // 🔹 LANZATONIO
        if (Ataque_selecionado.equalsIgnoreCase("Lanzamiento poderoso")) {
            ejercito1.get(posicion).vida -= 100;
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 2);
        }
        if (Ataque_selecionado.equalsIgnoreCase("Estocada")) {
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 3);
        }
        if (Ataque_selecionado.equalsIgnoreCase("Bloqueo")) {
            ejercito1.get(posicion).vida += 150;
        }

        // 🔹 REY ESPADACHÍN
        if (Ataque_selecionado.equalsIgnoreCase("Espadazo real")) {
            ejercito1.get(posicion).vida -= 50;
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 2);
        }
        if (Ataque_selecionado.equalsIgnoreCase("Guardia de hierro")) {
            ejercito1.get(posicion).vida += 50;
        }
        if (Ataque_selecionado.equalsIgnoreCase("Golpe final")) {
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 3);
        }

        // 🔹 REY LANZATONIO
        if (Ataque_selecionado.equalsIgnoreCase("Lanza imperial")) {
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 3);
        }
        if (Ataque_selecionado.equalsIgnoreCase("Bloqueo real")) {
            ejercito1.get(posicion).vida += 50;
        }
        if (Ataque_selecionado.equalsIgnoreCase("Tormenta de lanzas")) {
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 3);
        }

        // 🔹 REY ARQUERO
        if (Ataque_selecionado.equalsIgnoreCase("Disparo real")) {
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 3);
        }
        if (Ataque_selecionado.equalsIgnoreCase("Flecha explosiva")) {
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 4);
        }
        if (Ataque_selecionado.equalsIgnoreCase("Furia del rey")) {
            magitoo.vida -= (ejercito1.get(posicion).ataque_base * 5);
        }
    }

    public void waos(List<Jugador> jugador, Mago magitoo) {
        System.out.println("waza");
        magitoo.realizarTurno(jugador);
        actualizarImagenes(jugador, magitoo);
        System.out.println("wazaaaa");

    }

    public void InicializarImagenes(List<Jugador> ejercito1, Mago magitoo) {
        // ------------ IMÁGENES izquierda ----------------
        jugador1Rey = new JLabel(escalarImagen(ejercito1.get(0).rutaviva, 120, 120, 1));
        jugador1Rey.setBounds(50, 125, 120, 120);
        add(jugador1Rey);

        jugador1Tropa1 = new JLabel(escalarImagen(ejercito1.get(1).rutaviva, 100, 100, 1));
        jugador1Tropa1.setBounds(230, 50, 120, 120);
        add(jugador1Tropa1);

        jugador1Tropa2 = new JLabel(escalarImagen(ejercito1.get(2).rutaviva, 100, 100, 1));
        jugador1Tropa2.setBounds(230, 200, 120, 120);
        add(jugador1Tropa2);

        jugador2Rey = new JLabel(escalarImagen(ejercito1.get(3).rutaviva, 120, 120, 1));
        jugador2Rey.setBounds(50, 425, 120, 120);
        add(jugador2Rey);

        jugador2Tropa1 = new JLabel(escalarImagen(ejercito1.get(4).rutaviva, 100, 100, 1));
        jugador2Tropa1.setBounds(230, 350, 120, 120);
        add(jugador2Tropa1);

        jugador2Tropa2 = new JLabel(escalarImagen(ejercito1.get(5).rutaviva, 100, 100, 1));
        jugador2Tropa2.setBounds(230, 500, 120, 120);
        add(jugador2Tropa2);

        magito = new JLabel(escalarImagen(magitoo.getRutaviva(), 100, 100, 1));
        magito.setBounds(850, 225, 120, 120);
        add(magito);

        // ------------ VIDA LABELS ----------------
        vidaRey1 = new JLabel("Vida: " + ejercito1.get(0).vida);
        vidaRey1.setBounds(50, 100, 100, 20);
        add(vidaRey1);

        vidaT1A = new JLabel("Vida: " + ejercito1.get(1).vida);
        vidaT1A.setBounds(230, 25, 100, 20);
        add(vidaT1A);

        vidaT2A = new JLabel("Vida: " + ejercito1.get(2).vida);
        vidaT2A.setBounds(230, 175, 100, 20);
        add(vidaT2A);

        vidaRey2 = new JLabel("Vida: " + ejercito1.get(3).vida);
        vidaRey2.setBounds(50, 400, 100, 20);
        add(vidaRey2);

        vidaT1B = new JLabel("Vida: " + ejercito1.get(4).vida);
        vidaT1B.setBounds(230, 325, 100, 20);
        add(vidaT1B);

        vidaT2B = new JLabel("Vida: " + ejercito1.get(5).vida);
        vidaT2B.setBounds(230, 475, 100, 20);
        add(vidaT2B);

        magitovida = new JLabel("Vida: " + magitoo.getVida());
        magitovida.setBounds(850, 200, 100, 20);
        add(magitovida);

    }

    public static void actualizarImagenes(List<Jugador> ejercito1, Mago magitoo) {

        // Rey A
        jugador1Rey.setIcon(escalarImagen(
                (ejercito1.get(0).vida > 0) ? ejercito1.get(0).rutaviva : ejercito1.get(0).rutamuerta,
                120, 120, 1));
        vidaRey1.setText((ejercito1.get(0).vida > 0) ? "vida: " + ejercito1.get(0).vida : " X ");

        // Tropa A1
        jugador1Tropa1.setIcon(escalarImagen(
                (ejercito1.get(1).vida > 0) ? ejercito1.get(1).rutaviva : ejercito1.get(1).rutamuerta,
                120, 120, 1));
        vidaT1A.setText((ejercito1.get(1).vida > 0) ? "vida: " + ejercito1.get(1).vida : " X ");

        // Tropa A2
        jugador1Tropa2.setIcon(escalarImagen(
                (ejercito1.get(2).vida > 0) ? ejercito1.get(2).rutaviva : ejercito1.get(2).rutamuerta,
                120, 120, 1));
        vidaT2A.setText((ejercito1.get(2).vida > 0) ? "vida: " + ejercito1.get(2).vida : " X ");

        // Rey B
        jugador2Rey.setIcon(escalarImagen(
                (ejercito1.get(3).vida > 0) ? ejercito1.get(3).rutaviva : ejercito1.get(3).rutamuerta,
                120, 120, 1));
        vidaRey2.setText((ejercito1.get(3).vida > 0) ? "vida: " + ejercito1.get(3).vida : " X ");

        // Tropa B1
        jugador2Tropa1.setIcon(escalarImagen(
                (ejercito1.get(4).vida > 0) ? ejercito1.get(4).rutaviva : ejercito1.get(4).rutamuerta,
                120, 120, 1));
        vidaT1B.setText((ejercito1.get(4).vida > 0) ? "vida: " + ejercito1.get(4).vida : " X ");

        // Tropa B2
        jugador2Tropa2.setIcon(escalarImagen(
                (ejercito1.get(5).vida > 0) ? ejercito1.get(5).rutaviva : ejercito1.get(5).rutamuerta,
                120, 120, 1));
        vidaT2B.setText((ejercito1.get(5).vida > 0) ? "vida: " + ejercito1.get(5).vida : " X ");

        // Mago
        magito.setIcon(escalarImagen(
                (magitoo.getVida() > 0) ? magitoo.getRutaviva() : magitoo.getRutamuerta(),
                120, 120, 1));
        magitovida.setText((magitoo.getVida() > 0) ? "vida: " + magitoo.getVida() : " X ");

    }

    //crea los combsos en general
    private void crearcombos(List<Jugador> ejercito1) {
        // Crear desplegables manualmente

        combo1 = crearCombo(ejercito1.get(2).nombre, 230, 520);
        combo2 = crearCombo(ejercito1.get(1).nombre, 230, 170);
        combo3 = crearCombo(ejercito1.get(0).nombre, 50, 250);

        combo4 = crearCombo(ejercito1.get(3).nombre, 230, 620);
        combo5 = crearCombo(ejercito1.get(4).nombre, 230, 470);
        combo6 = crearCombo(ejercito1.get(5).nombre, 50,550);

        // Al inicio todos invisibles
        combo1.setVisible(false);
        combo2.setVisible(false);
        combo3.setVisible(false);

        combo4.setVisible(false);
        combo5.setVisible(false);
        combo6.setVisible(false);

        add(combo1);
        add(combo2);
        add(combo3);

        add(combo4);
        add(combo5);
        add(combo6);

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

    private static ImageIcon escalarImagen1(String ruta, int ancho, int alto) {
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imgEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imgEscalada);
    }

    private static ImageIcon escalarImagen(String ruta, int ancho, int alto, int a) {
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
