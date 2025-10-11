package Herramientas;

import Extra.jugador1;
import Extra.jugador2;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import Data.*;
import java.lang.reflect.Method;

public class Batalla_1 extends JDialog {

    private int turno_de_la_tropa_correspondiente = 1; // Controla cuál desplegable mostrar
    private JLabel jugador1Rey, jugador1Tropa1, jugador1Tropa2, jugador1Tropa3, jugador1Tropa4, jugador1Tropa5;//imagenes
    private JLabel jugador2Rey, jugador2Tropa1, jugador2Tropa2, jugador2Tropa3, jugador2Tropa4, jugador2Tropa5;//imagenes
    private static JLabel vidaRey1, vidaT1A, vidaT2A, vidaT3A, vidaT4A, vidaT5A;//textos
    private static JLabel vidaRey2, vidaT1B, vidaT2B, vidaT3B, vidaT4B, vidaT5B;//textos
    private static JComboBox<String> combo1, combo2, combo3, combo4, combo5, combo6, tropas_del_enemigo2_para_seleccionar; //desplegable
    private static JComboBox<String> combo7, combo8, combo9, combo10, combo11, combo12, tropas_del_enemigo1_para_seleccionar; //deplegable

    public Batalla_1(List<Tropa> ejercito1, List<Tropa> ejercito2, Frame parent, String titulo) {
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
            desplegable(ejercito1, ejercito2, 5, true, false);

            empezar.setVisible(false); //boton de empezar se oculta
            botonAtacar.setVisible(true); //boton de atacr se hace visible

        });

        botonAtacar.addActionListener(e -> {

            int Seleccion_posicion_del_turno_tropa;
            String seleccion_de_ataque;
            int posicionn;

            switch (turno_de_la_tropa_correspondiente) {
                case 1:
                    posicionn = 5;

                    seleccion_de_ataque = (String) combo1.getSelectedItem();

                    Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo2_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv

                    waos(seleccion_de_ataque, Seleccion_posicion_del_turno_tropa, ejercito1, ejercito2, posicionn);
                    //se apagar el desplegable actual
                    tropas_del_enemigo2_para_seleccionar.setVisible(false);
                    //se crea el desplegable de la segunda tropa para atacar

                    mostrarSiguiente(ejercito1, ejercito2, posicionn);

                    break;

                case 2:
                    posicionn = 4;

                    seleccion_de_ataque = (String) combo2.getSelectedItem();

                    Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo2_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv

                    waos(seleccion_de_ataque, Seleccion_posicion_del_turno_tropa, ejercito1, ejercito2, posicionn);

                    mostrarSiguiente(ejercito1, ejercito2, posicionn);
                    break;

                case 3:
                    posicionn = 3;

                    seleccion_de_ataque = (String) combo3.getSelectedItem();

                    Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo2_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv

                    waos(seleccion_de_ataque, Seleccion_posicion_del_turno_tropa, ejercito1, ejercito2, posicionn);

                    mostrarSiguiente(ejercito1, ejercito2, posicionn);
                    break;

                case 4:
                    posicionn = 2;

                    seleccion_de_ataque = (String) combo4.getSelectedItem();

                    Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo2_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv

                    waos(seleccion_de_ataque, Seleccion_posicion_del_turno_tropa, ejercito1, ejercito2, posicionn);

                    mostrarSiguiente(ejercito1, ejercito2, posicionn);
                    break;

                case 5:
                    posicionn = 1;

                    seleccion_de_ataque = (String) combo5.getSelectedItem();

                    Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo2_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv

                    waos(seleccion_de_ataque, Seleccion_posicion_del_turno_tropa, ejercito1, ejercito2, posicionn);

                    mostrarSiguiente(ejercito1, ejercito2, posicionn);
                    break;

                case 6:
                    posicionn = 0;

                    seleccion_de_ataque = (String) combo6.getSelectedItem();

                    Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo2_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv

                    waos(seleccion_de_ataque, Seleccion_posicion_del_turno_tropa, ejercito1, ejercito2, posicionn);

                    mostrarSiguiente(ejercito1, ejercito2, posicionn);
                    break;

                case 7:
                    posicionn = 5;

                    seleccion_de_ataque = (String) combo7.getSelectedItem();

                    Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo1_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv

                    waos(seleccion_de_ataque, Seleccion_posicion_del_turno_tropa, ejercito1, ejercito2, posicionn);

                    mostrarSiguiente(ejercito1, ejercito2, posicionn);
                    break;

                case 8:
                    posicionn = 4;

                    seleccion_de_ataque = (String) combo8.getSelectedItem();

                    Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo1_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv

                    waos(seleccion_de_ataque, Seleccion_posicion_del_turno_tropa, ejercito1, ejercito2, posicionn);

                    mostrarSiguiente(ejercito1, ejercito2, posicionn);
                    break;

                case 9:
                    posicionn = 3;

                    seleccion_de_ataque = (String) combo9.getSelectedItem();

                    Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo1_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv

                    waos(seleccion_de_ataque, Seleccion_posicion_del_turno_tropa, ejercito1, ejercito2, posicionn);

                    mostrarSiguiente(ejercito1, ejercito2, posicionn);
                    break;

                case 10:
                    posicionn = 2;

                    seleccion_de_ataque = (String) combo10.getSelectedItem();

                    Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo1_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv

                    waos(seleccion_de_ataque, Seleccion_posicion_del_turno_tropa, ejercito1, ejercito2, posicionn);

                    mostrarSiguiente(ejercito1, ejercito2, posicionn);
                    break;

                case 11:
                    posicionn = 1;

                    seleccion_de_ataque = (String) combo11.getSelectedItem();

                    Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo1_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv

                    waos(seleccion_de_ataque, Seleccion_posicion_del_turno_tropa, ejercito1, ejercito2, posicionn);

                    mostrarSiguiente(ejercito1, ejercito2, posicionn);
                    break;

                case 12:
                    posicionn = 0;

                    seleccion_de_ataque = (String) combo12.getSelectedItem();

                    Seleccion_posicion_del_turno_tropa = Character.getNumericValue(((String) tropas_del_enemigo1_para_seleccionar.getSelectedItem()).charAt(0)); //:vvvvvvvv

                    waos(seleccion_de_ataque, Seleccion_posicion_del_turno_tropa, ejercito1, ejercito2, posicionn);

                    mostrarSiguiente(ejercito1, ejercito2, posicionn);

                    break;

                case 0:
                    break;
            }

            //dispose(); // 🔹 cierra el programa
        });

        setLocationRelativeTo(null);
        setVisible(true);

    }

    //esto crea a q tropa podemos atacar
    private void desplegable(List<Tropa> ejercito1, List<Tropa> ejercito2, int posicion_del_turno_tropa, boolean waos1, boolean waos2) {
        boolean uno = false;
        boolean dos = false;
        boolean tres = false;
        boolean cuatro = false;
        boolean cinco = false;

        tropas_del_enemigo2_para_seleccionar.removeAllItems();
        tropas_del_enemigo1_para_seleccionar.removeAllItems();
        //eliminamos las tropas por defecto

        if (waos1) {
            System.out.println("tropa activa : " + ejercito1.get(posicion_del_turno_tropa).getNombre());
            if (ejercito1.get(posicion_del_turno_tropa).isAereo()) {
                System.out.println("La tropa es: " + (ejercito1.get(posicion_del_turno_tropa).isAereo() ? "aéreo" : "terrestre"));

                for (int i = 5; i >= 0; i--) {
                    if (ejercito2.get(i).getVida() > 0) {
                        tropas_del_enemigo2_para_seleccionar.addItem(i + "" + ejercito2.get(i).getNombre());
                    }
                }
            } //esto quiere decir q es terrestre
            else {
                System.out.println("La tropa es: " + (ejercito1.get(posicion_del_turno_tropa).isAereo() ? "aéreo" : "terrestre"));

                if (ejercito2.get(5).getVida() > 0) {
                    tropas_del_enemigo2_para_seleccionar.addItem("5" + ejercito2.get(5).getNombre());

                } else {
                    uno = true;//true = muerto
                }
                ///
                if (ejercito2.get(4).getVida() > 0) {
                    tropas_del_enemigo2_para_seleccionar.addItem("4" + ejercito2.get(4).getNombre());
                } else {
                    dos = true;//true= muerto
                }
                ///

                if (ejercito2.get(3).getVida() > 0) {
                    tropas_del_enemigo2_para_seleccionar.addItem("3" + ejercito2.get(3).getNombre());
                } else {
                    tres = true;//true = muerto
                }

                if (uno && dos && tres) {

                    if (ejercito2.get(2).getVida() > 0) {
                        tropas_del_enemigo2_para_seleccionar.addItem("2" + ejercito2.get(2).getNombre());

                    } else {
                        cuatro = true;
                    }

                    if (ejercito2.get(1).getVida() > 0) {
                        tropas_del_enemigo2_para_seleccionar.addItem("1" + ejercito2.get(1).getNombre());

                    } else {
                        cinco = true;
                    }
                }

                if (uno && dos && tres && cuatro && cinco) {
                    if (ejercito2.get(0).getVida() > 0) {
                        tropas_del_enemigo2_para_seleccionar.addItem("0" + ejercito2.get(0).getNombre());
                    }
                }

            }
            //hacemos visible las tropas a las q podemos atacar
            tropas_del_enemigo2_para_seleccionar.setVisible(true);
        }

        if (waos2) {
            System.out.println("esta entrandon la tropa : " + ejercito2.get(posicion_del_turno_tropa).getNombre());
            if (ejercito2.get(posicion_del_turno_tropa).isAereo()) {
                System.out.println("La tropa es: " + (ejercito2.get(posicion_del_turno_tropa).isAereo() ? "aéreo" : "terrestre"));
                for (int i = 5; i >= 0; i--) {
                    if (ejercito1.get(i).getVida() > 0) {
                        tropas_del_enemigo1_para_seleccionar.addItem(i + "" + ejercito1.get(i).getNombre());
                    }
                }
            } else {
                System.out.println("La tropa es: " + (ejercito2.get(posicion_del_turno_tropa).isAereo() ? "aéreo" : "terrestre"));
                if (ejercito1.get(5).getVida() > 0) {
                    tropas_del_enemigo1_para_seleccionar.addItem("5" + ejercito1.get(5).getNombre());

                } else {
                    uno = true;//true = muerto
                }

                if (ejercito1.get(4).getVida() > 0) {
                    tropas_del_enemigo1_para_seleccionar.addItem("4" + ejercito1.get(4).getNombre());
                } else {
                    dos = true;//true= muerto
                }
                if (ejercito1.get(3).getVida() > 0) {
                    tropas_del_enemigo1_para_seleccionar.addItem("3" + ejercito1.get(3).getNombre());
                } else {
                    tres = true;//true = muerto
                }

                if (uno && dos && tres) {

                    if (ejercito1.get(2).getVida() > 0) {
                        tropas_del_enemigo1_para_seleccionar.addItem("2" + ejercito1.get(2).getNombre());

                    } else {
                        cuatro = true;
                    }
                    if (ejercito1.get(1).getVida() > 0) {
                        tropas_del_enemigo1_para_seleccionar.addItem("1" + ejercito1.get(1).getNombre());

                    } else {
                        cinco = true;
                    }
                }

                if (uno && dos && tres && cuatro && cinco) {
                    if (ejercito1.get(0).getVida() > 0) {
                        tropas_del_enemigo1_para_seleccionar.addItem("0" + ejercito1.get(0).getNombre());
                    }
                }

            }
            //reiniciar confirmadores

            tropas_del_enemigo1_para_seleccionar.setVisible(true);
        }

        uno = false;
        dos = false;
        tres = false;
        cuatro = false;
        cinco = false;
    }

    private void mostrarSiguiente(List<Tropa> ejercito11, List<Tropa> ejercito22, int posicion_del_turno_actual) {
        int waaa = 0;
        tropas_del_enemigo2_para_seleccionar.setVisible(false);
        tropas_del_enemigo1_para_seleccionar.setVisible(false);
        while (true) {

            if (turno_de_la_tropa_correspondiente == 1) {
                //el desplegable de la tripa 1 desaparece
                combo1.setVisible(false);
                //vamos a ver si la tropa q sigue ,esta viva
                posicion_del_turno_actual = posicion_del_turno_actual - 1;
                //verficamos 

                if (ejercito11.get(posicion_del_turno_actual).isEstado_de_vida() && ejercito11.get(posicion_del_turno_actual).getVida() > 0) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    combo2.setVisible(true);
                    desplegable(ejercito11, ejercito22, posicion_del_turno_actual, true, false);
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
                if (ejercito11.get(posicion_del_turno_actual).isEstado_de_vida() && ejercito11.get(posicion_del_turno_actual).getVida() > 0) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    combo3.setVisible(true);
                    desplegable(ejercito11, ejercito22, posicion_del_turno_actual, true, false);
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
                if (ejercito11.get(posicion_del_turno_actual).isEstado_de_vida() && ejercito11.get(posicion_del_turno_actual).getVida() > 0) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    combo4.setVisible(true);
                    desplegable(ejercito11, ejercito22, posicion_del_turno_actual, true, false);
                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente++;
                    //y se acaba el metood
                    return;
                } else {
                    turno_de_la_tropa_correspondiente++;
                }

            }
            if (turno_de_la_tropa_correspondiente == 4) {
                //el desplegable de la tripa 1 desaparece
                combo4.setVisible(false);
                //vamos a ver si la tropa q sigue ,esta viva
                posicion_del_turno_actual = posicion_del_turno_actual - 1;
                //verficamos 
                if (ejercito11.get(posicion_del_turno_actual).isEstado_de_vida() && ejercito11.get(posicion_del_turno_actual).getVida() > 0) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    desplegable(ejercito11, ejercito22, posicion_del_turno_actual, true, false);
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
                if (ejercito11.get(posicion_del_turno_actual).isEstado_de_vida() && ejercito11.get(posicion_del_turno_actual).getVida() > 0) {
                    //si esta viva ,entonces se activa su deslegable de ataques

                    combo6.setVisible(true);
                    desplegable(ejercito11, ejercito22, posicion_del_turno_actual, true, false);
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
                if (ejercito22.get(posicion_del_turno_actual).isEstado_de_vida() && ejercito22.get(posicion_del_turno_actual).getVida() > 0) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    desplegable(ejercito11, ejercito22, posicion_del_turno_actual, false, true);
                    combo7.setVisible(true);
                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente++;
                    //y se acaba el metood
                    return;
                } else {
                    turno_de_la_tropa_correspondiente++;
                }

            }

            if (turno_de_la_tropa_correspondiente == 7) {
                //el desplegable de la tripa 1 desaparece
                combo7.setVisible(false);
                //vamos a ver si la tropa q sigue ,esta viva
                posicion_del_turno_actual = posicion_del_turno_actual - 1;
                //verficamos 
                if (ejercito22.get(posicion_del_turno_actual).isEstado_de_vida() && ejercito22.get(posicion_del_turno_actual).getVida() > 0) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    desplegable(ejercito11, ejercito22, posicion_del_turno_actual, false, true);
                    combo8.setVisible(true);
                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente++;
                    //y se acaba el metood
                    return;
                } else {
                    turno_de_la_tropa_correspondiente++;
                }

            }
            if (turno_de_la_tropa_correspondiente == 8) {
                //el desplegable de la tripa 1 desaparece
                combo8.setVisible(false);
                //vamos a ver si la tropa q sigue ,esta viva
                posicion_del_turno_actual = posicion_del_turno_actual - 1;
                //verficamos 
                if (ejercito22.get(posicion_del_turno_actual).isEstado_de_vida() && ejercito22.get(posicion_del_turno_actual).getVida() > 0) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    desplegable(ejercito11, ejercito22, posicion_del_turno_actual, false, true);
                    combo9.setVisible(true);
                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente++;
                    //y se acaba el metood
                    return;
                } else {
                    turno_de_la_tropa_correspondiente++;
                }

            }
            if (turno_de_la_tropa_correspondiente == 9) {
                //el desplegable de la tripa 1 desaparece
                combo9.setVisible(false);
                //vamos a ver si la tropa q sigue ,esta viva
                posicion_del_turno_actual = posicion_del_turno_actual - 1;
                //verficamos 
                if (ejercito22.get(posicion_del_turno_actual).isEstado_de_vida() && ejercito22.get(posicion_del_turno_actual).getVida() > 0) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    desplegable(ejercito11, ejercito22, posicion_del_turno_actual, false, true);
                    combo10.setVisible(true);
                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente++;
                    //y se acaba el metood
                    return;
                } else {
                    turno_de_la_tropa_correspondiente++;
                }

            }
            if (turno_de_la_tropa_correspondiente == 10) {
                //el desplegable de la tripa 1 desaparece
                combo10.setVisible(false);
                //vamos a ver si la tropa q sigue ,esta viva
                posicion_del_turno_actual = posicion_del_turno_actual - 1;
                //verficamos 
                if (ejercito22.get(posicion_del_turno_actual).isEstado_de_vida() && ejercito22.get(posicion_del_turno_actual).getVida() > 0) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    desplegable(ejercito11, ejercito22, posicion_del_turno_actual, false, true);
                    combo11.setVisible(true);
                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente++;
                    //y se acaba el metood
                    return;
                } else {
                    turno_de_la_tropa_correspondiente++;
                }

            }
            if (turno_de_la_tropa_correspondiente == 11) {
                //el desplegable de la tripa 1 desaparece
                combo11.setVisible(false);
                //vamos a ver si la tropa q sigue ,esta viva
                posicion_del_turno_actual = posicion_del_turno_actual - 1;
                //verficamos 
                if (ejercito22.get(posicion_del_turno_actual).isEstado_de_vida() && ejercito22.get(posicion_del_turno_actual).getVida() > 0) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    desplegable(ejercito11, ejercito22, posicion_del_turno_actual, false, true);
                    combo12.setVisible(true);

                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente++;
                    //y se acaba el metood
                    return;
                } else {
                    turno_de_la_tropa_correspondiente++;
                }

            }
            if (turno_de_la_tropa_correspondiente == 12) {
                //el desplegable de la tripa 1 desaparece
                combo12.setVisible(false);
                //vamos a ver q la siguiente tropa del enemigo esta viva
                //comprobar_si_existe_tropa_viva
                posicion_del_turno_actual = 5;
                //verficamos 
                if (ejercito11.get(posicion_del_turno_actual).isEstado_de_vida() && ejercito11.get(posicion_del_turno_actual).getVida() > 0) {
                    //si esta viva ,entonces se activa su deslegable de ataques
                    desplegable(ejercito11, ejercito22, posicion_del_turno_actual, true, false);
                    combo1.setVisible(true);

                    //y se avanza a l siguiente turno
                    turno_de_la_tropa_correspondiente = 1;
                    //y se acaba el metood
                    return;
                }

                turno_de_la_tropa_correspondiente = 1;
                waaa = waaa + 1;
            }

            if (waaa > 100) {
                break;
            }

        }
    }

    private void waos(String Ataque_selecionado, int posicion_del_enemigo, List<Tropa> ejercito1, List<Tropa> ejercito2, int posicion) {

        Class<?>[] clases = Buscador.getInstancia().obtenerTodas();

        if (turno_de_la_tropa_correspondiente >= 0 && turno_de_la_tropa_correspondiente <= 6) {
            Tropa tropa = ejercito1.get(posicion);
            String nombre = tropa.getNombre(); // nombre de la clase de tropa

            for (Class<?> c : clases) { // se busca esa clase
                if (c.getSimpleName().equals(nombre)) {
                    System.out.println("Clase encontrada: " + c.getName());

                    try {
                        // 👉 usar la instancia real, no crear una nueva
                        Object instancia = tropa;

                        // Buscar solo el método deseado (no hace falta recorrer todos si ya sabes el nombre)
                        for (Method m : c.getDeclaredMethods()) {
                            String metodo = m.getName();

                            if (metodo.startsWith("isAereo") || metodo.startsWith("get")
                                    || metodo.startsWith("set") || metodo.equals("toString")
                                    || metodo.equals("hashCode") || metodo.equals("equals")
                                    || metodo.equals("isEstado_de_vida") || metodo.equals("Daño")
                                    || metodo.equals("isTurnoActivo") || metodo.equals("isTurnoDoble")) {
                                continue; // saltar
                            }

                            if (metodo.equals(Ataque_selecionado)) {
                                // Ejecutar el ataque en la tropa real
                                m.invoke(instancia, ejercito2, posicion_del_enemigo);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {
            Tropa tropa = ejercito2.get(posicion);
            String nombre = tropa.getNombre(); // nombre de la clase de tropa

            for (Class<?> c : clases) { // se busca esa clase
                if (c.getSimpleName().equals(nombre)) {
                    System.out.println("Clase encontrada: " + c.getName());

                    try {
                        // 👉 usar la instancia real, no crear una nueva
                        Object instancia = tropa;

                        // Buscar solo el método deseado (no hace falta recorrer todos si ya sabes el nombre)
                        for (Method m : c.getDeclaredMethods()) {
                            String metodo = m.getName();

                            if (metodo.startsWith("isAereo") || metodo.startsWith("get")
                                    || metodo.startsWith("set") || metodo.equals("toString")
                                    || metodo.equals("hashCode") || metodo.equals("equals")
                                    || metodo.equals("isEstado_de_vida") || metodo.equals("Daño")
                                    || metodo.equals("isTurnoActivo") || metodo.equals("isTurnoDoble")) {
                                continue; // saltar
                            }

                            if (metodo.equals(Ataque_selecionado)) {
                                // Ejecutar el ataque en la tropa real
                                m.invoke(instancia, ejercito1, posicion_del_enemigo);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        ///////actualizar su png si este muere :v
        if (turno_de_la_tropa_correspondiente >= 0 && turno_de_la_tropa_correspondiente <= 6) {
            if (ejercito2.get(posicion_del_enemigo).getVida() <= 0) {
                ejercito2.get(posicion_del_enemigo).setEstado_de_vida(false);

            }
            if (ejercito1.get(posicion).getVida() <= 0) {
                ejercito1.get(posicion).setEstado_de_vida(false);

            }
        }

        if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {
            if (ejercito1.get(posicion_del_enemigo).getVida() <= 0) {
                ejercito1.get(posicion_del_enemigo).setEstado_de_vida(false);

            }
            if (ejercito2.get(posicion).getVida() <= 0) {
                ejercito2.get(posicion).setEstado_de_vida(false);

            }

        }

        actualizarImagenes(ejercito1, ejercito2);

    }

    private JComboBox<String> crearCombo(String j, int x, int y) {
        JComboBox<String> combo = new JComboBox<>();
        combo.setBounds(x, y, 150, 30);

        Class<?>[] clases = Buscador.getInstancia().obtenerTodas();


        for (Class<?> c : clases) {
            if (c.getSimpleName().equals(j)) {
                System.out.println("Clase encontrada: " + c.getName());

                // Listar métodos filtrando
                for (Method m : c.getDeclaredMethods()) {
                    String metodo = m.getName();

                    if (metodo.startsWith("isAereo") || metodo.startsWith("get")
                            || metodo.startsWith("set") || metodo.equals("toString")
                            || metodo.equals("hashCode") || metodo.equals("equals")
                            || metodo.equals("isEstado_de_vida") || metodo.equals("Daño")
                            || metodo.equals("isTurnoActivo") || metodo.equals("isTurnoDoble")) {
                        continue; // saltar
                    }

                    combo.addItem(metodo);

                }

            }

        }
        return combo;
    }

    private void InicializarImagenes(List<Tropa> ejercito1, List<Tropa> ejercito2) {
        // ------------ IMÁGENES izquierda ----------------
        jugador1Rey = new JLabel(escalarImagen(ejercito1.get(0).getRutaviva(), 120, 120, 1));
        jugador1Rey.setBounds(50, 225, 120, 120);
        add(jugador1Rey);

        jugador1Tropa1 = new JLabel(escalarImagen(ejercito1.get(1).getRutaviva(), 100, 100, 1));
        jugador1Tropa1.setBounds(230, 150, 120, 120);
        add(jugador1Tropa1);

        jugador1Tropa2 = new JLabel(escalarImagen(ejercito1.get(2).getRutaviva(), 100, 100, 1));
        jugador1Tropa2.setBounds(230, 300, 120, 120);
        add(jugador1Tropa2);

        jugador1Tropa3 = new JLabel(escalarImagen(ejercito1.get(3).getRutaviva(), 100, 100, 1));
        jugador1Tropa3.setBounds(400, 75, 120, 120);
        add(jugador1Tropa3);

        jugador1Tropa4 = new JLabel(escalarImagen(ejercito1.get(4).getRutaviva(), 100, 100, 1));
        jugador1Tropa4.setBounds(400, 225, 120, 120);
        add(jugador1Tropa4);

        jugador1Tropa5 = new JLabel(escalarImagen(ejercito1.get(5).getRutaviva(), 100, 100, 1));
        jugador1Tropa5.setBounds(400, 375, 120, 120);
        add(jugador1Tropa5);

        // ------------ VIDA LABELS ----------------
        vidaRey1 = new JLabel("Vida: " + ejercito1.get(0).getVida());
        vidaRey1.setBounds(50, 200, 100, 20);
        add(vidaRey1);

        vidaT1A = new JLabel("Vida: " + ejercito1.get(1).getVida());
        vidaT1A.setBounds(230, 125, 100, 20);
        add(vidaT1A);

        vidaT2A = new JLabel("Vida: " + ejercito1.get(2).getVida());
        vidaT2A.setBounds(230, 275, 100, 20);
        add(vidaT2A);

        vidaT3A = new JLabel("Vida: " + ejercito1.get(3).getVida());
        vidaT3A.setBounds(400, 50, 100, 20);
        add(vidaT3A);

        vidaT4A = new JLabel("Vida: " + ejercito1.get(4).getVida());
        vidaT4A.setBounds(400, 200, 100, 20);
        add(vidaT4A);

        vidaT5A = new JLabel("Vida: " + ejercito1.get(5).getVida());
        vidaT5A.setBounds(400, 350, 100, 20);
        add(vidaT5A);
        //////////////////////////////////////////////////////////////
        //deplegable de acciones :v

//-----------------------------------------------------------------------------------------------------------------//
        // ------------ IMÁGENES derecha ----------------
        jugador2Rey = new JLabel(escalarImagen(ejercito2.get(0).getRutaviva(), 120, 120, 0));
        jugador2Rey.setBounds(910, 225, 120, 120);
        add(jugador2Rey);

        jugador2Tropa1 = new JLabel(escalarImagen(ejercito2.get(1).getRutaviva(), 100, 100, 0));
        jugador2Tropa1.setBounds(740, 150, 120, 120);
        add(jugador2Tropa1);

        jugador2Tropa2 = new JLabel(escalarImagen(ejercito2.get(2).getRutaviva(), 100, 100, 0));
        jugador2Tropa2.setBounds(740, 300, 120, 120);
        add(jugador2Tropa2);

        jugador2Tropa3 = new JLabel(escalarImagen(ejercito2.get(3).getRutaviva(), 100, 100, 0));
        jugador2Tropa3.setBounds(570, 75, 120, 120);
        add(jugador2Tropa3);

        jugador2Tropa4 = new JLabel(escalarImagen(ejercito2.get(4).getRutaviva(), 100, 100, 0));
        jugador2Tropa4.setBounds(570, 225, 120, 120);
        add(jugador2Tropa4);

        jugador2Tropa5 = new JLabel(escalarImagen(ejercito2.get(5).getRutaviva(), 100, 100, 0));
        jugador2Tropa5.setBounds(570, 375, 120, 120);
        add(jugador2Tropa5);

        // ------------ VIDA LABELS ----------------
        vidaRey2 = new JLabel("Vida: " + ejercito2.get(0).getVida());
        vidaRey2.setBounds(910, 200, 100, 20);
        add(vidaRey2);

        vidaT1B = new JLabel("Vida: " + ejercito2.get(1).getVida());
        vidaT1B.setBounds(740, 125, 100, 20);
        add(vidaT1B);

        vidaT2B = new JLabel("Vida: " + ejercito2.get(2).getVida());
        vidaT2B.setBounds(740, 275, 100, 20);
        add(vidaT2B);

        vidaT3B = new JLabel("Vida: " + ejercito2.get(3).getVida());
        vidaT3B.setBounds(570, 50, 100, 20);
        add(vidaT3B);

        vidaT4B = new JLabel("Vida: " + ejercito2.get(4).getVida());
        vidaT4B.setBounds(570, 200, 100, 20);
        add(vidaT4B);

        vidaT5B = new JLabel("Vida: " + ejercito2.get(5).getVida());
        vidaT5B.setBounds(570, 350, 100, 20);
        add(vidaT5B);
    }

    public void actualizarImagenes(List<Tropa> ejercito1, List<Tropa> ejercito2) {
        // ---------------- ACTUALIZAR EJERCITO 1 ----------------
        jugador1Rey.setIcon(escalarImagen(
                (ejercito1.get(0).getVida() > 0) ? ejercito1.get(0).getRutaviva() : ejercito1.get(0).getRutamuerta(),
                120, 120, 1));
        vidaRey1.setText((ejercito1.get(0).getVida() > 0) ? "❤: " + ejercito1.get(0).getVida() : "X");

        jugador1Tropa1.setIcon(escalarImagen(
                (ejercito1.get(1).getVida() > 0) ? ejercito1.get(1).getRutaviva() : ejercito1.get(1).getRutamuerta(),
                100, 100, 1));
        vidaT1A.setText((ejercito1.get(1).getVida() > 0) ? "❤: " + ejercito1.get(1).getVida() : "X");

        jugador1Tropa2.setIcon(escalarImagen(
                (ejercito1.get(2).getVida() > 0) ? ejercito1.get(2).getRutaviva() : ejercito1.get(2).getRutamuerta(),
                100, 100, 1));
        vidaT2A.setText((ejercito1.get(2).getVida() > 0) ? "❤: " + ejercito1.get(2).getVida() : "X");

        jugador1Tropa3.setIcon(escalarImagen(
                (ejercito1.get(3).getVida() > 0) ? ejercito1.get(3).getRutaviva() : ejercito1.get(3).getRutamuerta(),
                100, 100, 1));
        vidaT3A.setText((ejercito1.get(3).getVida() > 0) ? "❤: " + ejercito1.get(3).getVida() : "X");

        jugador1Tropa4.setIcon(escalarImagen(
                (ejercito1.get(4).getVida() > 0) ? ejercito1.get(4).getRutaviva() : ejercito1.get(4).getRutamuerta(),
                100, 100, 1));
        vidaT4A.setText((ejercito1.get(4).getVida() > 0) ? "❤: " + ejercito1.get(4).getVida() : "X");

        jugador1Tropa5.setIcon(escalarImagen(
                (ejercito1.get(5).getVida() > 0) ? ejercito1.get(5).getRutaviva() : ejercito1.get(5).getRutamuerta(),
                100, 100, 1));
        vidaT5A.setText((ejercito1.get(5).getVida() > 0) ? "❤: " + ejercito1.get(5).getVida() : "X");

        // ---------------- ACTUALIZAR EJERCITO 2 ----------------
        jugador2Rey.setIcon(escalarImagen(
                (ejercito2.get(0).getVida() > 0) ? ejercito2.get(0).getRutaviva() : ejercito2.get(0).getRutamuerta(),
                120, 120, 0));
        vidaRey2.setText((ejercito2.get(0).getVida() > 0) ? "❤: " + ejercito2.get(0).getVida() : "X");

        jugador2Tropa1.setIcon(escalarImagen(
                (ejercito2.get(1).getVida() > 0) ? ejercito2.get(1).getRutaviva() : ejercito2.get(1).getRutamuerta(),
                100, 100, 0));
        vidaT1B.setText((ejercito2.get(1).getVida() > 0) ? "❤: " + ejercito2.get(1).getVida() : "X");

        jugador2Tropa2.setIcon(escalarImagen(
                (ejercito2.get(2).getVida() > 0) ? ejercito2.get(2).getRutaviva() : ejercito2.get(2).getRutamuerta(),
                100, 100, 0));
        vidaT2B.setText((ejercito2.get(2).getVida() > 0) ? "❤: " + ejercito2.get(2).getVida() : "X");

        jugador2Tropa3.setIcon(escalarImagen(
                (ejercito2.get(3).getVida() > 0) ? ejercito2.get(3).getRutaviva() : ejercito2.get(3).getRutamuerta(),
                100, 100, 0));
        vidaT3B.setText((ejercito2.get(3).getVida() > 0) ? "❤: " + ejercito2.get(3).getVida() : "X");

        jugador2Tropa4.setIcon(escalarImagen(
                (ejercito2.get(4).getVida() > 0) ? ejercito2.get(4).getRutaviva() : ejercito2.get(4).getRutamuerta(),
                100, 100, 0));
        vidaT4B.setText((ejercito2.get(4).getVida() > 0) ? "❤: " + ejercito2.get(4).getVida() : "X");

        jugador2Tropa5.setIcon(escalarImagen(
                (ejercito2.get(5).getVida() > 0) ? ejercito2.get(5).getRutaviva() : ejercito2.get(5).getRutamuerta(),
                100, 100, 0));
        vidaT5B.setText((ejercito2.get(5).getVida() > 0) ? "❤: " + ejercito2.get(5).getVida() : "X");

        // ---------------- CONDICIONES DE VICTORIA ----------------
        boolean ejercito1Muerto = true;
        for (Tropa t : ejercito1) {
            if (t.getVida() > 0) {
                ejercito1Muerto = false;
                break;
            }
        }

        boolean ejercito2Muerto = true;
        for (Tropa t : ejercito2) {
            if (t.getVida() > 0) {
                ejercito2Muerto = false;
                break;
            }
        }

        if (ejercito1Muerto) {
            JOptionPane.showMessageDialog(null, "¡¡Ganó el Jugador 2!!");
            System.exit(0);
        } else if (ejercito2Muerto) {
            JOptionPane.showMessageDialog(null, "¡¡Ganó el Jugador 1!!");
            System.exit(0);
        }
    }

    private void crearcombos(List<Tropa> ejercito1, List<Tropa> ejercito2) {
        // Crear desplegables manualmente
        tropas_del_enemigo2_para_seleccionar = new JComboBox<>(new String[]{"5" + ejercito2.get(5).getNombre(), "4" + ejercito2.get(4).getNombre(), "3" + ejercito2.get(3).getNombre(), "2" + ejercito2.get(2).getNombre(), "1" + ejercito2.get(1).getNombre(), "0" + ejercito2.get(0).getNombre()});
        tropas_del_enemigo2_para_seleccionar.setBounds(800, 400, 150, 40);
        add(tropas_del_enemigo2_para_seleccionar);

        tropas_del_enemigo1_para_seleccionar = new JComboBox<>(new String[]{"5" + ejercito1.get(5).getNombre(), "4" + ejercito1.get(4).getNombre(), "3" + ejercito1.get(3).getNombre(), "2" + ejercito1.get(2).getNombre(), "1" + ejercito1.get(1).getNombre(), "0" + ejercito1.get(0).getNombre()});
        tropas_del_enemigo1_para_seleccionar.setBounds(800, 400, 150, 40);
        add(tropas_del_enemigo1_para_seleccionar);

        tropas_del_enemigo2_para_seleccionar.setVisible(false);
        tropas_del_enemigo1_para_seleccionar.setVisible(false);

        combo1 = crearCombo(ejercito1.get(5).getNombre(), 400, 475);
        combo2 = crearCombo(ejercito1.get(4).getNombre(), 400, 325);
        combo3 = crearCombo(ejercito1.get(3).getNombre(), 400, 175);
        combo4 = crearCombo(ejercito1.get(2).getNombre(), 230, 400);
        combo5 = crearCombo(ejercito1.get(1).getNombre(), 230, 250);
        combo6 = crearCombo(ejercito1.get(0).getNombre(), 50, 225);

        combo7 = crearCombo(ejercito2.get(5).getNombre(), 570, 475);
        combo8 = crearCombo(ejercito2.get(4).getNombre(), 570, 325);
        combo9 = crearCombo(ejercito2.get(3).getNombre(), 570, 175);
        combo10 = crearCombo(ejercito2.get(2).getNombre(), 740, 400);
        combo11 = crearCombo(ejercito2.get(1).getNombre(), 740, 250);
        combo12 = crearCombo(ejercito2.get(0).getNombre(), 910, 225);

        // Al inicio todos invisibles
        combo1.setVisible(false);
        combo2.setVisible(false);
        combo3.setVisible(false);
        combo4.setVisible(false);
        combo5.setVisible(false);
        combo6.setVisible(false);
        combo7.setVisible(false);
        combo8.setVisible(false);
        combo9.setVisible(false);
        combo10.setVisible(false);
        combo11.setVisible(false);
        combo12.setVisible(false);

        add(combo1);
        add(combo2);
        add(combo3);
        add(combo4);
        add(combo5);
        add(combo6);
        add(combo7);
        add(combo8);
        add(combo9);
        add(combo10);
        add(combo11);
        add(combo12);
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

    private ImageIcon escalarImagen1(String ruta, int ancho, int alto) {
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imgEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imgEscalada);
    }

}
