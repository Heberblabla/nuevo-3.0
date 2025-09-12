package Extra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import Extra.jugador1;
import Extra.jugador2;

public class Seleccion extends JDialog {

    private JComboBox<String> cbRey, cbTropa1, cbTropa2, cbTropa3, cbTropa4, cbTropa5;//desplegables 
    private JLabel lblRey, lblTropa1, lblTropa2, lblTropa3, lblTropa4, lblTropa5;//imagenes 
    private JLabel vidaRey, vidaT1, vidaT2, vidaT3, vidaT4, vidaT5;//textos
    public int vida;
    public String nombre;
    public String nombre1;
    public String nombre2;
    public String nombre3;
    public String nombre4;
    public String nombre5;

    //contructor por defecto para decri wazaaa :V
    public Seleccion(Frame parent, String titulo) {
        super(parent, titulo, true); // <- true = modal (bloquea hasta cerrar)
        setSize(1000, 600);
        getContentPane().setBackground(Color.decode("#d8d197"));
        setLayout(null);

        // ------------ OPCIONES IZQUIERDA ----------------
        cbRey = new JComboBox<>(new String[]{"Rey Arquero", "Rey Lanzatonio", "Rey Espadachin"});
        cbRey.setBounds(30, 70, 150, 30);
        add(new JLabel("Rey:")).setBounds(30, 50, 100, 20);
        add(cbRey);

        cbTropa1 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa1.setBounds(30, 120, 150, 30);
        add(new JLabel("Tropa 1:")).setBounds(30, 100, 100, 20);
        add(cbTropa1);

        cbTropa2 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa2.setBounds(30, 170, 150, 30);
        add(new JLabel("Tropa 2:")).setBounds(30, 150, 100, 20);
        add(cbTropa2);

        cbTropa3 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa3.setBounds(30, 220, 150, 30);
        add(new JLabel("Tropa 3:")).setBounds(30, 200, 100, 20);
        add(cbTropa3);

        cbTropa4 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa4.setBounds(30, 270, 150, 30);
        add(new JLabel("Tropa 4:")).setBounds(30, 250, 100, 20);
        add(cbTropa4);

        cbTropa5 = new JComboBox<>(new String[]{"Arquero", "Lanzatonio", "Espadachin"});
        cbTropa5.setBounds(30, 320, 150, 30);
        add(new JLabel("Tropa 5:")).setBounds(30, 300, 100, 20);
        add(cbTropa5);

        // ------------ IMÁGENES DERECHA ----------------
        lblRey = new JLabel(escalarImagen("stickman_rey.png", 120, 120));
        lblRey.setBounds(300, 225, 120, 120);
        add(lblRey);

        lblTropa1 = new JLabel(escalarImagen("stickman_tropa.png", 100, 100));
        lblTropa1.setBounds(480, 150, 100, 100);
        add(lblTropa1);

        lblTropa2 = new JLabel(escalarImagen("stickman_tropa.png", 100, 100));
        lblTropa2.setBounds(480, 300, 100, 100);
        add(lblTropa2);

        lblTropa3 = new JLabel(escalarImagen("stickman_tropa.png", 100, 100));
        lblTropa3.setBounds(650, 75, 100, 100);
        add(lblTropa3);

        lblTropa4 = new JLabel(escalarImagen("stickman_tropa.png", 100, 100));
        lblTropa4.setBounds(650, 225, 100, 100);
        add(lblTropa4);

        lblTropa5 = new JLabel(escalarImagen("stickman_tropa.png", 100, 100));
        lblTropa5.setBounds(650, 375, 100, 100);
        add(lblTropa5);

        // ------------ VIDA LABELS ----------------
        vidaRey = new JLabel("Vida: -");
        vidaRey.setBounds(300, 200, 120, 20);
        add(vidaRey);

        vidaT1 = new JLabel("Vida: -");
        vidaT1.setBounds(480, 130, 100, 20);
        add(vidaT1);

        vidaT2 = new JLabel("Vida: -");
        vidaT2.setBounds(480, 280, 100, 20);
        add(vidaT2);

        vidaT3 = new JLabel("Vida: -");
        vidaT3.setBounds(650, 55, 100, 20);
        add(vidaT3);

        vidaT4 = new JLabel("Vida: -");
        vidaT4.setBounds(650, 205, 100, 20);
        add(vidaT4);

        vidaT5 = new JLabel("Vida: -");
        vidaT5.setBounds(650, 355, 100, 20);
        add(vidaT5);

        // ------------ EVENTOS ----------------
        //lista de opciones del rey
        cbRey.addActionListener(e -> {
            String seleccion = cbRey.getSelectedItem().toString();
            switch (seleccion) {
                case "Rey Arquero":
                    this.nombre = seleccion;
                    lblRey.setIcon(escalarImagen("recursos/rey/rey_arquero.png", 120, 120));
                    vidaRey.setText("Vida: 700");
                    break;
                case "Rey Lanzatonio":
                    this.nombre = seleccion;
                    lblRey.setIcon(escalarImagen("recursos/rey/rey_lanzatonio.png", 120, 120));
                    vidaRey.setText("Vida: 950");
                    break;
                case "Rey Espadachin":
                    this.nombre = seleccion;
                    lblRey.setIcon(escalarImagen("recursos/rey/rey_espadachin.png", 120, 120));
                    vidaRey.setText("Vida: 850");
                    break;
            }
        });

        cbTropa1.addActionListener(e -> {
            String seleccion = cbTropa1.getSelectedItem().toString();
            switch (seleccion) {
                case "Arquero":
                    this.nombre1 = seleccion;
                    lblTropa1.setIcon(escalarImagen("recursos/Tropas/arquero_tropa.png", 120, 120));
                    vidaT1.setText("Vida: 300");
                    break;
                case "Lanzatonio":
                    this.nombre1 = seleccion;
                    lblTropa1.setIcon(escalarImagen("recursos/Tropas/lanzatonio_tropa.png", 120, 120));
                    vidaT1.setText("Vida: 450");
                    break;
                case "Espadachin":
                    this.nombre1 = seleccion;
                    lblTropa1.setIcon(escalarImagen("recursos/Tropas/espadachin_tropa.png", 120, 120));
                    vidaT1.setText("Vida: 320");
                    break;
            }
        });
        cbTropa2.addActionListener(e -> {
            String seleccion = cbTropa2.getSelectedItem().toString();
            switch (seleccion) {
                case "Arquero":
                    this.nombre2 = seleccion;
                    lblTropa2.setIcon(escalarImagen("recursos/Tropas/arquero_tropa.png", 120, 120));
                    vidaT2.setText("Vida: 300");
                    break;
                case "Lanzatonio":
                    this.nombre2 = seleccion;
                    lblTropa2.setIcon(escalarImagen("recursos/Tropas/lanzatonio_tropa.png", 120, 120));
                    vidaT2.setText("Vida: 450");
                    break;
                case "Espadachin":
                    this.nombre2 = seleccion;
                    lblTropa2.setIcon(escalarImagen("recursos/Tropas/espadachin_tropa.png", 120, 120));
                    vidaT2.setText("Vida: 320");
                    break;
            }
        });
        cbTropa3.addActionListener(e -> {
            String seleccion = cbTropa3.getSelectedItem().toString();
            switch (seleccion) {
                case "Arquero":
                    this.nombre3 = seleccion;
                    lblTropa3.setIcon(escalarImagen("recursos/Tropas/arquero_tropa.png", 120, 120));
                    vidaT3.setText("Vida: 300");
                    break;
                case "Lanzatonio":
                    this.nombre3 = seleccion;
                    lblTropa3.setIcon(escalarImagen("recursos/Tropas/lanzatonio_tropa.png", 120, 120));
                    vidaT3.setText("Vida: 450");
                    break;
                case "Espadachin":
                    this.nombre3 = seleccion;
                    lblTropa3.setIcon(escalarImagen("recursos/Tropas/espadachin_tropa.png", 120, 120));
                    vidaT3.setText("Vida: 320");
                    break;
            }
        });
        cbTropa4.addActionListener(e -> {
            String seleccion = cbTropa4.getSelectedItem().toString();
            switch (seleccion) {
                case "Arquero":
                    this.nombre4 = seleccion;
                    lblTropa4.setIcon(escalarImagen("recursos/Tropas/arquero_tropa.png", 120, 120));
                    vidaT4.setText("Vida: 300");
                    break;
                case "Lanzatonio":
                    this.nombre4 = seleccion;
                    lblTropa4.setIcon(escalarImagen("recursos/Tropas/lanzatonio_tropa.png", 120, 120));
                    vidaT4.setText("Vida: 450");
                    break;
                case "Espadachin":
                    this.nombre4 = seleccion;
                    lblTropa4.setIcon(escalarImagen("recursos/Tropas/espadachin_tropa.png", 120, 120));
                    vidaT4.setText("Vida: 320");
                    break;
            }
        });
        cbTropa5.addActionListener(e -> {
            String seleccion = cbTropa5.getSelectedItem().toString();
            switch (seleccion) {
                case "Arquero":
                    this.nombre5 = seleccion;
                    lblTropa5.setIcon(escalarImagen("recursos/Tropas/arquero_tropa.png", 120, 120));
                    vidaT5.setText("Vida: 300");
                    break;
                case "Lanzatonio":
                    this.nombre5 = seleccion;
                    lblTropa5.setIcon(escalarImagen("recursos/Tropas/lanzatonio_tropa.png", 120, 120));
                    vidaT5.setText("Vida: 450");
                    break;
                case "Espadachin":
                    this.nombre5 = seleccion;
                    lblTropa5.setIcon(escalarImagen("recursos/Tropas/espadachin_tropa.png", 120, 120));
                    vidaT5.setText("Vida: 320");
                    break;
            }
        });

        // ------------ BOTÓN GUARDAR ----------------
        JButton btnGuardar = new JButton("Guardar Ejército");
        btnGuardar.setBounds(30, 400, 150, 40);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            System.out.println(this.nombre);
            System.out.println(this.nombre1);
            System.out.println(this.nombre2);
            System.out.println(this.nombre3);
            System.out.println(this.nombre4);
            System.out.println(this.nombre5);
            dispose(); // 🔹 cie
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ----------- FUNCIÓN PARA ESCALAR IMÁGENES -----------
    private ImageIcon escalarImagen(String ruta, int ancho, int alto) {
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imgEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imgEscalada);
    }

    public static void mostrarTropasJugador(ArrayList<?> tropas) {
        System.out.println("=== Tropas seleccionadas ===");

    }

}
