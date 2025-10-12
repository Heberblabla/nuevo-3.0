package Extra;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Batalla extends JDialog {

    private int turno_de_la_tropa_correspondiente = 1; // Controla cuál desplegable mostrar
    private JLabel jugador1Rey, jugador1Tropa1, jugador1Tropa2, jugador1Tropa3, jugador1Tropa4, jugador1Tropa5;//imagenes
    private JLabel jugador2Rey, jugador2Tropa1, jugador2Tropa2, jugador2Tropa3, jugador2Tropa4, jugador2Tropa5;//imagenes
    private JLabel vidaRey1, vidaT1A, vidaT2A, vidaT3A, vidaT4A, vidaT5A;//textos
    private JLabel vidaRey2, vidaT1B, vidaT2B, vidaT3B, vidaT4B, vidaT5B;//textos
    private JComboBox<String> combo1, combo2, combo3, combo4, combo5, combo6, tropas_del_enemigo2_para_seleccionar; //desplegable
    private JComboBox<String> combo7, combo8, combo9, combo10, combo11, combo12, tropas_del_enemigo1_para_seleccionar; //deplegable

    public Batalla(List<jugador1> ejercito1, List<jugador2> ejercito2, Frame parent, String titulo) {
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
    private void desplegable(List<jugador1> ejercito1, List<jugador2> ejercito2, int posicion_del_turno_tropa, boolean waos1, boolean waos2) {
        boolean uno = false;
        boolean dos = false;
        boolean tres = false;
        boolean cuatro = false;
        boolean cinco = false;

        tropas_del_enemigo2_para_seleccionar.removeAllItems();
        tropas_del_enemigo1_para_seleccionar.removeAllItems();
        //eliminamos las tropas por defecto

        if (waos1) {
            System.out.println("tropa activa : " + ejercito1.get(posicion_del_turno_tropa).nombre);
            if (ejercito1.get(posicion_del_turno_tropa).aereo) {
                System.out.println("La tropa es: " + (ejercito1.get(posicion_del_turno_tropa).aereo ? "aéreo" : "terrestre"));

                for (int i = 5; i >= 0; i--) {
                    if (ejercito2.get(i).vida > 0) {
                        tropas_del_enemigo2_para_seleccionar.addItem(i + "" + ejercito2.get(i).nombre);
                    }
                }
            } //esto quiere decir q es terrestre
            else {
                System.out.println("La tropa es: " + (ejercito1.get(posicion_del_turno_tropa).aereo ? "aéreo" : "terrestre"));

                if (ejercito2.get(5).vida > 0) {
                    tropas_del_enemigo2_para_seleccionar.addItem("5" + ejercito2.get(5).nombre);

                } else {
                    uno = true;//true = muerto
                }
                ///
                if (ejercito2.get(4).vida > 0) {
                    tropas_del_enemigo2_para_seleccionar.addItem("4" + ejercito2.get(4).nombre);
                } else {
                    dos = true;//true= muerto
                }
                ///

                if (ejercito2.get(3).vida > 0) {
                    tropas_del_enemigo2_para_seleccionar.addItem("3" + ejercito2.get(3).nombre);
                } else {
                    tres = true;//true = muerto
                }

                if (uno && dos && tres) {

                    if (ejercito2.get(2).vida > 0) {
                        tropas_del_enemigo2_para_seleccionar.addItem("2" + ejercito2.get(2).nombre);

                    } else {
                        cuatro = true;
                    }

                    if (ejercito2.get(1).vida > 0) {
                        tropas_del_enemigo2_para_seleccionar.addItem("1" + ejercito2.get(1).nombre);

                    } else {
                        cinco = true;
                    }
                }

                if (uno && dos && tres && cuatro && cinco) {
                    if (ejercito2.get(0).vida > 0) {
                        tropas_del_enemigo2_para_seleccionar.addItem("0" + ejercito2.get(0).nombre);
                    }
                }

            }
            //hacemos visible las tropas a las q podemos atacar
            tropas_del_enemigo2_para_seleccionar.setVisible(true);
        }

        if (waos2) {
            System.out.println("esta entrandon la tropa : " + ejercito2.get(posicion_del_turno_tropa).nombre);
            if (ejercito2.get(posicion_del_turno_tropa).aereo) {
                System.out.println("La tropa es: " + (ejercito2.get(posicion_del_turno_tropa).aereo ? "aéreo" : "terrestre"));
                for (int i = 5; i >= 0; i--) {
                    if (ejercito1.get(i).vida > 0) {
                        tropas_del_enemigo1_para_seleccionar.addItem(i + "" + ejercito1.get(i).nombre);
                    }
                }
            } else {
                System.out.println("La tropa es: " + (ejercito2.get(posicion_del_turno_tropa).aereo ? "aéreo" : "terrestre"));
                if (ejercito1.get(5).vida > 0) {
                    tropas_del_enemigo1_para_seleccionar.addItem("5" + ejercito1.get(5).nombre);

                } else {
                    uno = true;//true = muerto
                }

                if (ejercito1.get(4).vida > 0) {
                    tropas_del_enemigo1_para_seleccionar.addItem("4" + ejercito1.get(4).nombre);
                } else {
                    dos = true;//true= muerto
                }
                if (ejercito1.get(3).vida > 0) {
                    tropas_del_enemigo1_para_seleccionar.addItem("3" + ejercito1.get(3).nombre);
                } else {
                    tres = true;//true = muerto
                }

                if (uno && dos && tres) {

                    if (ejercito1.get(2).vida > 0) {
                        tropas_del_enemigo1_para_seleccionar.addItem("2" + ejercito1.get(2).nombre);

                    } else {
                        cuatro = true;
                    }
                    if (ejercito1.get(1).vida > 0) {
                        tropas_del_enemigo1_para_seleccionar.addItem("1" + ejercito1.get(1).nombre);

                    } else {
                        cinco = true;
                    }
                }

                if (uno && dos && tres && cuatro && cinco) {
                    if (ejercito1.get(0).vida > 0) {
                        tropas_del_enemigo1_para_seleccionar.addItem("0" + ejercito1.get(0).nombre);
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

    private void mostrarSiguiente(List<jugador1> ejercito11, List<jugador2> ejercito22, int posicion_del_turno_actual) {
        //si estoy en pocicion 5 , debo ver si la siguiente tropa en el arrasylist (posicon4) esta viva :v
        //si estoy en turno 1 , debo ver si la siguiente tropa en el arrasylist (poscion2)  esta viva :v
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
                if (ejercito11.get(posicion_del_turno_actual).estado_de_vida) {
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
                if (ejercito11.get(posicion_del_turno_actual).estado_de_vida) {
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
                if (ejercito11.get(posicion_del_turno_actual).estado_de_vida) {
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
                if (ejercito11.get(posicion_del_turno_actual).estado_de_vida) {
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
                if (ejercito11.get(posicion_del_turno_actual).estado_de_vida) {
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
                if (ejercito22.get(posicion_del_turno_actual).estado_de_vida) {
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
                if (ejercito22.get(posicion_del_turno_actual).estado_de_vida) {
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
                if (ejercito22.get(posicion_del_turno_actual).estado_de_vida) {
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
                if (ejercito22.get(posicion_del_turno_actual).estado_de_vida) {
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
                if (ejercito22.get(posicion_del_turno_actual).estado_de_vida) {
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
                if (ejercito22.get(posicion_del_turno_actual).estado_de_vida) {
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
                if (ejercito11.get(posicion_del_turno_actual).estado_de_vida) {
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

    private void waos(String Ataque_selecionado, int posicion_del_enemigo, List<jugador1> ejercito1, List<jugador2> ejercito2, int posicion) {

        //arryas para actualizar vidas
        JLabel[] labelsVida1 = {vidaRey1, vidaT1A, vidaT2A, vidaT3A, vidaT4A, vidaT5A};
        JLabel[] labelsVida2 = {vidaRey2, vidaT1B, vidaT2B, vidaT3B, vidaT4B, vidaT5B};
        JLabel[] labelsimagen1 = {jugador1Rey, jugador1Tropa1, jugador1Tropa2, jugador1Tropa3, jugador1Tropa4, jugador1Tropa5};
        JLabel[] labelsimagen2 = {jugador2Rey, jugador2Tropa1, jugador2Tropa2, jugador2Tropa3, jugador2Tropa4, jugador2Tropa5};

        //espadachin 
        if (Ataque_selecionado.equalsIgnoreCase("Proteger")) {

            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {//el ejercito 1 esta atacando
                ejercito1.get(posicion).vida += 50;
                labelsVida1[posicion].setText("Vida: " + ejercito1.get(posicion).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) { //el ejercito 2 esta atacando
                ejercito2.get(posicion).vida += 50;
                labelsVida2[posicion].setText("Vida: " + ejercito2.get(posicion).vida);
            }

        }
        if (Ataque_selecionado.equalsIgnoreCase("Contraataque")) { //con critico

            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {

                ejercito2.get(posicion_del_enemigo).vida = ejercito2.get(posicion_del_enemigo).vida - (ejercito1.get(posicion).ataque_base * 2);
                labelsVida2[posicion_del_enemigo].setText("Vida: " + ejercito2.get(posicion_del_enemigo).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {

                ejercito1.get(posicion_del_enemigo).vida = ejercito1.get(posicion_del_enemigo).vida - (ejercito2.get(posicion).ataque_base * 2);
                labelsVida1[posicion_del_enemigo].setText("Vida: " + ejercito1.get(posicion_del_enemigo).vida);
            }
        }
        if (Ataque_selecionado.equalsIgnoreCase("Estocada veloz")) {

            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {
                ejercito1.get(posicion).vida -= 150;
                labelsVida1[posicion].setText("Vida: " + ejercito1.get(posicion).vida);

                ejercito2.get(posicion_del_enemigo).vida = ejercito2.get(posicion_del_enemigo).vida - (ejercito1.get(posicion).ataque_base * 2);
                labelsVida2[posicion_del_enemigo].setText("Vida: " + ejercito2.get(posicion_del_enemigo).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {
                ejercito2.get(posicion).vida -= 150;
                labelsVida2[posicion].setText("Vida: " + ejercito2.get(posicion).vida);

                ejercito1.get(posicion_del_enemigo).vida = ejercito1.get(posicion_del_enemigo).vida - (ejercito2.get(posicion).ataque_base * 2);
                labelsVida1[posicion_del_enemigo].setText("Vida: " + ejercito1.get(posicion_del_enemigo).vida);
            }
        }

        //arquero
        if (Ataque_selecionado.equalsIgnoreCase("Disparo rápido")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {//el ejercito 1 esta atacando
                ejercito1.get(posicion).vida += 100;
                labelsVida1[posicion].setText("Vida: " + ejercito1.get(posicion).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) { //el ejercito 2 esta atacando
                ejercito2.get(posicion).vida += 100;
                labelsVida2[posicion].setText("Vida: " + ejercito2.get(posicion).vida);
            }
        }
        if (Ataque_selecionado.equalsIgnoreCase("Flecha penetrante")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {

                ejercito2.get(posicion_del_enemigo).vida = ejercito2.get(posicion_del_enemigo).vida - (ejercito1.get(posicion).ataque_base * 3);
                labelsVida2[posicion_del_enemigo].setText("Vida: " + ejercito2.get(posicion_del_enemigo).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {

                ejercito1.get(posicion_del_enemigo).vida = ejercito1.get(posicion_del_enemigo).vida - (ejercito2.get(posicion).ataque_base * 3);
                labelsVida1[posicion_del_enemigo].setText("Vida: " + ejercito1.get(posicion_del_enemigo).vida);
            }
        }
        if (Ataque_selecionado.equalsIgnoreCase("Lluvia de flechas")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {
                ejercito1.get(posicion).vida -= 100;
                labelsVida1[posicion].setText("Vida: " + ejercito1.get(posicion).vida);

                ejercito2.get(posicion_del_enemigo).vida = ejercito2.get(posicion_del_enemigo).vida - (ejercito1.get(posicion).ataque_base * 2);
                labelsVida2[posicion_del_enemigo].setText("Vida: " + ejercito2.get(posicion_del_enemigo).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {
                ejercito2.get(posicion).vida -= 100;
                labelsVida2[posicion].setText("Vida: " + ejercito2.get(posicion).vida);

                ejercito1.get(posicion_del_enemigo).vida = ejercito1.get(posicion_del_enemigo).vida - (ejercito2.get(posicion).ataque_base * 2);
                labelsVida1[posicion_del_enemigo].setText("Vida: " + ejercito1.get(posicion_del_enemigo).vida);
            }
        }

        //lanzatonio
        if (Ataque_selecionado.equalsIgnoreCase("Lanzamiento poderoso")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {
                ejercito1.get(posicion).vida -= 100;
                labelsVida1[posicion].setText("Vida: " + ejercito1.get(posicion).vida);

                ejercito2.get(posicion_del_enemigo).vida = ejercito2.get(posicion_del_enemigo).vida - (ejercito1.get(posicion).ataque_base * 2);
                labelsVida2[posicion_del_enemigo].setText("Vida: " + ejercito2.get(posicion_del_enemigo).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {
                ejercito2.get(posicion).vida -= 100;
                labelsVida2[posicion].setText("Vida: " + ejercito2.get(posicion).vida);

                ejercito1.get(posicion_del_enemigo).vida = ejercito1.get(posicion_del_enemigo).vida - (ejercito2.get(posicion).ataque_base * 2);
                labelsVida1[posicion_del_enemigo].setText("Vida: " + ejercito1.get(posicion_del_enemigo).vida);
            }
        }
        if (Ataque_selecionado.equalsIgnoreCase("Estocada")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {

                ejercito2.get(posicion_del_enemigo).vida = ejercito2.get(posicion_del_enemigo).vida - (ejercito1.get(posicion).ataque_base * 3);
                labelsVida2[posicion_del_enemigo].setText("Vida: " + ejercito2.get(posicion_del_enemigo).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {

                ejercito1.get(posicion_del_enemigo).vida = ejercito1.get(posicion_del_enemigo).vida - (ejercito2.get(posicion).ataque_base * 3);
                labelsVida1[posicion_del_enemigo].setText("Vida: " + ejercito1.get(posicion_del_enemigo).vida);
            }
        }
        if (Ataque_selecionado.equalsIgnoreCase("Bloqueo")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {//el ejercito 1 esta atacando
                ejercito1.get(posicion).vida += 150;
                labelsVida1[posicion].setText("Vida: " + ejercito1.get(posicion).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) { //el ejercito 2 esta atacando
                ejercito2.get(posicion).vida += 150;
                labelsVida2[posicion].setText("Vida: " + ejercito2.get(posicion).vida);
            }
        }

        //rey espadachin
        if (Ataque_selecionado.equalsIgnoreCase("Espadazo real")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {
                ejercito1.get(posicion).vida -= 50;
                labelsVida1[posicion].setText("Vida: " + ejercito1.get(posicion).vida);

                ejercito2.get(posicion_del_enemigo).vida = ejercito2.get(posicion_del_enemigo).vida - (ejercito1.get(posicion).ataque_base * 2);
                labelsVida2[posicion_del_enemigo].setText("Vida: " + ejercito2.get(posicion_del_enemigo).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {
                ejercito2.get(posicion).vida -= 50;
                labelsVida2[posicion].setText("Vida: " + ejercito2.get(posicion).vida);

                ejercito1.get(posicion_del_enemigo).vida = ejercito1.get(posicion_del_enemigo).vida - (ejercito2.get(posicion).ataque_base * 2);
                labelsVida1[posicion_del_enemigo].setText("Vida: " + ejercito1.get(posicion_del_enemigo).vida);
            }
        }
        if (Ataque_selecionado.equalsIgnoreCase("Guardia de hierro")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {//el ejercito 1 esta atacando
                ejercito1.get(posicion).vida += 50;
                labelsVida1[posicion].setText("Vida: " + ejercito1.get(posicion).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) { //el ejercito 2 esta atacando
                ejercito2.get(posicion).vida += 50;
                labelsVida2[posicion].setText("Vida: " + ejercito2.get(posicion).vida);
            }
        }
        if (Ataque_selecionado.equalsIgnoreCase("Golpe final")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {

                ejercito2.get(posicion_del_enemigo).vida = ejercito2.get(posicion_del_enemigo).vida - (ejercito1.get(posicion).ataque_base * 3);
                labelsVida2[posicion_del_enemigo].setText("Vida: " + ejercito2.get(posicion_del_enemigo).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {

                ejercito1.get(posicion_del_enemigo).vida = ejercito1.get(posicion_del_enemigo).vida - (ejercito2.get(posicion).ataque_base * 3);
                labelsVida1[posicion_del_enemigo].setText("Vida: " + ejercito1.get(posicion_del_enemigo).vida);
            }
        }

        //rey lanzatonio
        if (Ataque_selecionado.equalsIgnoreCase("Lanza imperial")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {

                ejercito2.get(posicion_del_enemigo).vida = ejercito2.get(posicion_del_enemigo).vida - (ejercito1.get(posicion).ataque_base * 3);
                labelsVida2[posicion_del_enemigo].setText("Vida: " + ejercito2.get(posicion_del_enemigo).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {

                ejercito1.get(posicion_del_enemigo).vida = ejercito1.get(posicion_del_enemigo).vida - (ejercito2.get(posicion).ataque_base * 3);
                labelsVida1[posicion_del_enemigo].setText("Vida: " + ejercito1.get(posicion_del_enemigo).vida);
            }
        }
        if (Ataque_selecionado.equalsIgnoreCase("Bloqueo real")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {//el ejercito 1 esta atacando
                ejercito1.get(posicion).vida += 50;
                labelsVida1[posicion].setText("Vida: " + ejercito1.get(posicion).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) { //el ejercito 2 esta atacando
                ejercito2.get(posicion).vida += 50;
                labelsVida2[posicion].setText("Vida: " + ejercito2.get(posicion).vida);
            }
        }
        if (Ataque_selecionado.equalsIgnoreCase("Tormenta de lanzas")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {

                ejercito2.get(posicion_del_enemigo).vida = ejercito2.get(posicion_del_enemigo).vida - (ejercito1.get(posicion).ataque_base * 3);
                labelsVida2[posicion_del_enemigo].setText("Vida: " + ejercito2.get(posicion_del_enemigo).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {

                ejercito1.get(posicion_del_enemigo).vida = ejercito1.get(posicion_del_enemigo).vida - (ejercito2.get(posicion).ataque_base * 3);
                labelsVida1[posicion_del_enemigo].setText("Vida: " + ejercito1.get(posicion_del_enemigo).vida);
            }
        }

        //rey arquero
        if (Ataque_selecionado.equalsIgnoreCase("Disparo real")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {

                ejercito2.get(posicion_del_enemigo).vida = ejercito2.get(posicion_del_enemigo).vida - (ejercito1.get(posicion).ataque_base * 3);
                labelsVida2[posicion_del_enemigo].setText("Vida: " + ejercito2.get(posicion_del_enemigo).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {

                ejercito1.get(posicion_del_enemigo).vida = ejercito1.get(posicion_del_enemigo).vida - (ejercito2.get(posicion).ataque_base * 3);
                labelsVida1[posicion_del_enemigo].setText("Vida: " + ejercito1.get(posicion_del_enemigo).vida);
            }
        }
        if (Ataque_selecionado.equalsIgnoreCase("Flecha explosiva")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {

                ejercito2.get(posicion_del_enemigo).vida = ejercito2.get(posicion_del_enemigo).vida - (ejercito1.get(posicion).ataque_base * 4);
                labelsVida2[posicion_del_enemigo].setText("Vida: " + ejercito2.get(posicion_del_enemigo).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {

                ejercito1.get(posicion_del_enemigo).vida = ejercito1.get(posicion_del_enemigo).vida - (ejercito2.get(posicion).ataque_base * 4);
                labelsVida1[posicion_del_enemigo].setText("Vida: " + ejercito1.get(posicion_del_enemigo).vida);
            }
        }
        if (Ataque_selecionado.equalsIgnoreCase("Furia del rey")) {
            if (turno_de_la_tropa_correspondiente > 0 && turno_de_la_tropa_correspondiente <= 6) {

                ejercito2.get(posicion_del_enemigo).vida = ejercito2.get(posicion_del_enemigo).vida - (ejercito1.get(posicion).ataque_base * 5);
                labelsVida2[posicion_del_enemigo].setText("Vida: " + ejercito2.get(posicion_del_enemigo).vida);
            }
            if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {

                ejercito1.get(posicion_del_enemigo).vida = ejercito1.get(posicion_del_enemigo).vida - (ejercito2.get(posicion).ataque_base * 5);
                labelsVida1[posicion_del_enemigo].setText("Vida: " + ejercito1.get(posicion_del_enemigo).vida);
            }
        }

        ///////actualizar su png si este muere :v
        if (turno_de_la_tropa_correspondiente >= 0 && turno_de_la_tropa_correspondiente <= 6) {
            if (ejercito2.get(posicion_del_enemigo).vida <= 0) {
                ejercito2.get(posicion_del_enemigo).estado_de_vida = false;

                labelsVida2[posicion_del_enemigo].setText(" X ");
                labelsimagen2[posicion_del_enemigo].setIcon(escalarImagen("recursos/tropa_muerta.png", 120, 120, 0));

            }
            if (ejercito1.get(posicion).vida <= 0) {
                ejercito1.get(posicion).estado_de_vida = false;

                labelsVida1[posicion].setText(" X ");
                labelsimagen1[posicion].setIcon(escalarImagen("recursos/tropa_muerta.png", 120, 120, 0));

            }
        }

        if (turno_de_la_tropa_correspondiente >= 7 && turno_de_la_tropa_correspondiente <= 12) {
            if (ejercito1.get(posicion_del_enemigo).vida <= 0) {
                ejercito1.get(posicion_del_enemigo).estado_de_vida = false;

                labelsVida1[posicion_del_enemigo].setText(" X ");
                labelsimagen1[posicion_del_enemigo].setIcon(escalarImagen("recursos/tropa_muerta.png", 120, 120, 1));

            }
            if (ejercito2.get(posicion_del_enemigo).vida <= 0) {
                ejercito2.get(posicion_del_enemigo).estado_de_vida = false;

                labelsVida2[posicion_del_enemigo].setText(" X ");
                labelsimagen2[posicion_del_enemigo].setIcon(escalarImagen("recursos/tropa_muerta.png", 120, 120, 0));

            }

        }

    }

    // ----------- Funciones extras -----------
    //ára escalar la imagen nomas
    private ImageIcon escalarImagen1(String ruta, int ancho, int alto) {
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imgEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imgEscalada);
    }

    //crea manualmente los combos (desplegabls q se utilizzaran)
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

    //inicia las imagen una ves empezado el boton
    private void InicializarImagenes(List<jugador1> ejercito1, List<jugador2> ejercito2) {
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

        jugador1Tropa3 = new JLabel(escalarImagen(ejercito1.get(3).rutaviva, 100, 100, 1));
        jugador1Tropa3.setBounds(400, 75, 120, 120);
        add(jugador1Tropa3);

        jugador1Tropa4 = new JLabel(escalarImagen(ejercito1.get(4).rutaviva, 100, 100, 1));
        jugador1Tropa4.setBounds(400, 225, 120, 120);
        add(jugador1Tropa4);

        jugador1Tropa5 = new JLabel(escalarImagen(ejercito1.get(5).rutaviva, 100, 100, 1));
        jugador1Tropa5.setBounds(400, 375, 120, 120);
        add(jugador1Tropa5);

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

        vidaT3A = new JLabel("Vida: " + ejercito1.get(3).vida);
        vidaT3A.setBounds(400, 50, 100, 20);
        add(vidaT3A);

        vidaT4A = new JLabel("Vida: " + ejercito1.get(4).vida);
        vidaT4A.setBounds(400, 200, 100, 20);
        add(vidaT4A);

        vidaT5A = new JLabel("Vida: " + ejercito1.get(5).vida);
        vidaT5A.setBounds(400, 350, 100, 20);
        add(vidaT5A);
        //////////////////////////////////////////////////////////////
        //deplegable de acciones :v

//-----------------------------------------------------------------------------------------------------------------//
        // ------------ IMÁGENES derecha ----------------
        jugador2Rey = new JLabel(escalarImagen(ejercito2.get(0).rutaviva, 120, 120, 0));
        jugador2Rey.setBounds(910, 225, 120, 120);
        add(jugador2Rey);

        jugador2Tropa1 = new JLabel(escalarImagen(ejercito2.get(1).rutaviva, 100, 100, 0));
        jugador2Tropa1.setBounds(740, 150, 120, 120);
        add(jugador2Tropa1);

        jugador2Tropa2 = new JLabel(escalarImagen(ejercito2.get(2).rutaviva, 100, 100, 0));
        jugador2Tropa2.setBounds(740, 300, 120, 120);
        add(jugador2Tropa2);

        jugador2Tropa3 = new JLabel(escalarImagen(ejercito2.get(3).rutaviva, 100, 100, 0));
        jugador2Tropa3.setBounds(570, 75, 120, 120);
        add(jugador2Tropa3);

        jugador2Tropa4 = new JLabel(escalarImagen(ejercito2.get(4).rutaviva, 100, 100, 0));
        jugador2Tropa4.setBounds(570, 225, 120, 120);
        add(jugador2Tropa4);

        jugador2Tropa5 = new JLabel(escalarImagen(ejercito2.get(5).rutaviva, 100, 100, 0));
        jugador2Tropa5.setBounds(570, 375, 120, 120);
        add(jugador2Tropa5);

        // ------------ VIDA LABELS ----------------
        vidaRey2 = new JLabel("Vida: " + ejercito2.get(0).vida);
        vidaRey2.setBounds(910, 200, 100, 20);
        add(vidaRey2);

        vidaT1B = new JLabel("Vida: " + ejercito2.get(1).vida);
        vidaT1B.setBounds(740, 125, 100, 20);
        add(vidaT1B);

        vidaT2B = new JLabel("Vida: " + ejercito2.get(2).vida);
        vidaT2B.setBounds(740, 275, 100, 20);
        add(vidaT2B);

        vidaT3B = new JLabel("Vida: " + ejercito2.get(3).vida);
        vidaT3B.setBounds(570, 50, 100, 20);
        add(vidaT3B);

        vidaT4B = new JLabel("Vida: " + ejercito2.get(4).vida);
        vidaT4B.setBounds(570, 200, 100, 20);
        add(vidaT4B);

        vidaT5B = new JLabel("Vida: " + ejercito2.get(5).vida);
        vidaT5B.setBounds(570, 350, 100, 20);
        add(vidaT5B);
    }

    //crea los combsos en general
    private void crearcombos(List<jugador1> ejercito1, List<jugador2> ejercito2) {
        // Crear desplegables manualmente
        tropas_del_enemigo2_para_seleccionar = new JComboBox<>(new String[]{"5" + ejercito2.get(5).nombre, "4" + ejercito2.get(4).nombre, "3" + ejercito2.get(3).nombre, "2" + ejercito2.get(2).nombre, "1" + ejercito2.get(1).nombre, "0" + ejercito2.get(0).nombre});
        tropas_del_enemigo2_para_seleccionar.setBounds(800, 400, 150, 40);
        add(tropas_del_enemigo2_para_seleccionar);

        tropas_del_enemigo1_para_seleccionar = new JComboBox<>(new String[]{"5" + ejercito1.get(5).nombre, "4" + ejercito1.get(4).nombre, "3" + ejercito1.get(3).nombre, "2" + ejercito1.get(2).nombre, "1" + ejercito1.get(1).nombre, "0" + ejercito1.get(0).nombre});
        tropas_del_enemigo1_para_seleccionar.setBounds(800, 400, 150, 40);
        add(tropas_del_enemigo1_para_seleccionar);

        tropas_del_enemigo2_para_seleccionar.setVisible(false);
        tropas_del_enemigo1_para_seleccionar.setVisible(false);

        combo1 = crearCombo(ejercito1.get(5).nombre, 400, 475);
        combo2 = crearCombo(ejercito1.get(4).nombre, 400, 325);
        combo3 = crearCombo(ejercito1.get(3).nombre, 400, 175);
        combo4 = crearCombo(ejercito1.get(2).nombre, 230, 400);
        combo5 = crearCombo(ejercito1.get(1).nombre, 230, 250);
        combo6 = crearCombo(ejercito1.get(0).nombre, 50, 225);

        combo7 = crearCombo(ejercito2.get(5).nombre, 570, 475);
        combo8 = crearCombo(ejercito2.get(4).nombre, 570, 325);
        combo9 = crearCombo(ejercito2.get(3).nombre, 570, 175);
        combo10 = crearCombo(ejercito2.get(2).nombre, 740, 400);
        combo11 = crearCombo(ejercito2.get(1).nombre, 740, 250);
        combo12 = crearCombo(ejercito2.get(0).nombre, 910, 225);

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

}



