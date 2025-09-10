package Herramientas;

import Data.*;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Seleccion extends JDialog {

    // Desplegables
    private JComboBox<String> cbRey, cbTropa1, cbTropa2, cbTropa3, cbTropa4, cbTropa5;
    // Imágenes (aún no usas, pero las dejo declaradas)
    private JLabel lblRey, lblTropa1, lblTropa2, lblTropa3, lblTropa4, lblTropa5;
    // Textos de vida (igual declarados para más adelante)
    private JLabel vidaRey, vidaT1, vidaT2, vidaT3, vidaT4, vidaT5;

    private int countReyes;
    private int countTropas;
    private String[] nombresReyes;
    private String[] nombresTropas;

    private final Class<?>[] clases = {
        Arquero.class,
        Lanzatonio.class,
        Espadachin.class,
        Rey_Arquero.class,
        Rey_Lanzatonio.class,
        Rey_Espadachin.class,};

    public Seleccion(Frame parent, String titulo) {
        super(parent, titulo, true); // true = modal
        setSize(1000, 600);
        getContentPane().setBackground(Color.decode("#d8d197"));
        setLayout(null);

        JButton Empezar = new JButton("Empezar a escoger");
        Empezar.setBounds(30, 400, 180, 40);
        add(Empezar);
        Empezar.addActionListener(e -> {
            cargar();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cargar() {
        // Resetear contadores
        countReyes = 0;
        countTropas = 0;

        // Contar
        for (Class<?> c : clases) {
            if (c.getSimpleName().startsWith("Rey_")) {
                countReyes++;
            } else {
                countTropas++;
            }
        }

        // Inicializar arreglos
        nombresReyes = new String[countReyes];
        nombresTropas = new String[countTropas];

        // Llenar
        int idxRey = 0, idxTropa = 0;
        for (Class<?> c : clases) {
            String nombre = c.getSimpleName();
            if (nombre.startsWith("Rey_")) {
                nombresReyes[idxRey++] = nombre;
            } else {
                nombresTropas[idxTropa++] = nombre;
            }
        }

        // Mostrar combos
        desplegable(nombresReyes, nombresTropas);
        repaint();
    }

    private void desplegable(String[] nombresReyes, String[] nombresTropas) {
        // ------------ OPCIONES IZQUIERDA ----------------

        JLabel lblR = new JLabel("Rey:");
        lblR.setBounds(30, 50, 100, 20);
        add(lblR);

        cbRey = new JComboBox<>(nombresReyes);
        cbRey.setBounds(30, 70, 150, 30);
        add(cbRey);

        JLabel lblT1 = new JLabel("Tropa 1:");
        lblT1.setBounds(30, 100, 100, 20);
        add(lblT1);

        cbTropa1 = new JComboBox<>(nombresTropas);
        cbTropa1.setBounds(30, 120, 150, 30);
        add(cbTropa1);

        JLabel lblT2 = new JLabel("Tropa 2:");
        lblT2.setBounds(30, 150, 100, 20);
        add(lblT2);

        cbTropa2 = new JComboBox<>(nombresTropas);
        cbTropa2.setBounds(30, 170, 150, 30);
        add(cbTropa2);

        JLabel lblT3 = new JLabel("Tropa 3:");
        lblT3.setBounds(30, 200, 100, 20);
        add(lblT3);

        cbTropa3 = new JComboBox<>(nombresTropas);
        cbTropa3.setBounds(30, 220, 150, 30);
        add(cbTropa3);

        JLabel lblT4 = new JLabel("Tropa 4:");
        lblT4.setBounds(30, 250, 100, 20);
        add(lblT4);

        cbTropa4 = new JComboBox<>(nombresTropas);
        cbTropa4.setBounds(30, 270, 150, 30);
        add(cbTropa4);

        JLabel lblT5 = new JLabel("Tropa 5:");
        lblT5.setBounds(30, 300, 100, 20);
        add(lblT5);

        cbTropa5 = new JComboBox<>(nombresTropas);
        cbTropa5.setBounds(30, 320, 150, 30);
        add(cbTropa5);

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

        cbRey.addActionListener(e
                -> actualizarImagen(lblRey, (String) cbRey.getSelectedItem())
        );
        cbTropa1.addActionListener(e
                -> actualizarImagen(lblTropa1, (String) cbTropa1.getSelectedItem())
        );
        cbTropa2.addActionListener(e
                -> actualizarImagen(lblTropa2, (String) cbTropa2.getSelectedItem())
        );
        cbTropa3.addActionListener(e
                -> actualizarImagen(lblTropa3, (String) cbTropa3.getSelectedItem())
        );
        cbTropa4.addActionListener(e
                -> actualizarImagen(lblTropa4, (String) cbTropa4.getSelectedItem())
        );
        cbTropa5.addActionListener(e
                -> actualizarImagen(lblTropa5, (String) cbTropa5.getSelectedItem())
        );
    }

    private void actualizarImagen(JLabel lbl, String nombreClase) {
        try {
            // Buscar la clase correspondiente dentro de "clases"
            for (Class<?> c : clases) {
                if (c.getSimpleName().equals(nombreClase)) {
                    // Crear objeto
                    Object obj = c.getDeclaredConstructor().newInstance();

                    // Leer el campo "rutaviva"
                    java.lang.reflect.Field f = c.getDeclaredField("rutaviva");
                    f.setAccessible(true);
                    String ruta = (String) f.get(obj);

                    // Actualizar imagen
                    lbl.setIcon(escalarImagen(ruta, lbl.getWidth(), lbl.getHeight()));
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private ImageIcon escalarImagen(String ruta, int ancho, int alto) {
        ImageIcon iconoOriginal = new ImageIcon(ruta);
        Image imgEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imgEscalada);
    }
}
