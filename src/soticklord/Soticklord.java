package soticklord;

import Herramientas.*;
import Data.*;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Soticklord {

    private static JFrame frame; // referencia de la ventana
    private static JFrame Dificultad;
    static List<Tropa> ejercito1 = new ArrayList<>();
    static List<Tropa> ejercito2 = new ArrayList<>();
    private static final String URL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:6543/postgres";
    private static final String USER = "postgres.oxwodtlyumsrzwhrjcbh";
    private static final String PASSWORD = "Tuhermana1233456789";
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
            frame.dispose();
            JOptionPane.showMessageDialog(null, "Proximamente!!");

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
        JOptionPane.showMessageDialog(null, "Proximamente!!");
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

    public static void iniciar_sesion() {
        JFrame ventana = new JFrame("Ejemplo Cajón de Texto");
        ventana.setSize(800, 620);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null); // Usaremos coordenadas manuales

        // 📌 Imagen de fondo
        ImageIcon imagen = new ImageIcon("recursos/sesion.png"); // ruta de tu imagen
        Image imgEscalada = imagen.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        JLabel fondo = new JLabel(new ImageIcon(imgEscalada));
        fondo.setBounds(0, 0, 800, 600);

        // Crear un cajón de texto
        JTextField Nombre_De_Usuario = new JTextField();
        Nombre_De_Usuario.setBounds(380, 390, 150, 20); // x, y, ancho, alto
        JLabel texto1 = new JLabel("Usuario");
        texto1.setBounds(380, 330, 200, 100);
        texto1.setForeground(Color.BLACK);
        // Contraseña
        JPasswordField cajaPassword = new JPasswordField();
        cajaPassword.setBounds(380, 450, 150, 20);
        JLabel texto2 = new JLabel("Contraseña");
        texto2.setBounds(380, 390, 200, 100);

        //botones
        JButton iniciar_sesion = new JButton("Iniciar");
        iniciar_sesion.setBounds(570, 370, 100, 50); // x, y, ancho, alto
        iniciar_sesion.setVisible(true);

        JButton registrarse = new JButton("Registrase");
        registrarse.setBounds(570, 440, 100, 50); // x, y, ancho, alto
        registrarse.setVisible(true);
        ventana.add(registrarse);
        ventana.add(iniciar_sesion);
        texto2.setForeground(Color.BLACK);
        ventana.add(texto1);
        ventana.add(Nombre_De_Usuario);
        ventana.add(texto2);
        ventana.add(cajaPassword);
        ventana.add(fondo);

        iniciar_sesion.addActionListener(e -> {
            String usuario = Nombre_De_Usuario.getText();
            String contraseña = new String(cajaPassword.getPassword());
            boolean usuario_exite = verificarUsuario(usuario, contraseña);
            if (usuario_exite) {
                ventana.dispose();
                menu();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña mal!!");
            }

        });
        registrarse.addActionListener(e -> {
            String usuario = Nombre_De_Usuario.getText();
            String contraseña = new String(cajaPassword.getPassword());

            boolean usuario_exite = registrarUsuario(usuario, contraseña);
            if (usuario_exite) {
                JOptionPane.showMessageDialog(null, "Registrado correctamente ✅✅✅");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario Ya existe⚠️⚠️!!!");
            }
        });

        // Hacer visible la ventana
        ventana.setVisible(true);
    }

    private static String getSHA256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar hash SHA-256", e);
        }
    }

    public static boolean registrarUsuario(String nombre, String pass) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // Verificar si ya existe
            String check = "SELECT COUNT(*) FROM usuario_progreso WHERE nombre = ?";
            PreparedStatement psCheck = con.prepareStatement(check);
            psCheck.setString(1, nombre);
            ResultSet rs = psCheck.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                System.out.println("⚠️ Usuario ya existe.");
                return false;
            }

            // Insertar con contraseña hasheada
            String sql = "INSERT INTO usuario_progreso (nombre, contrasena, nivel) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, getSHA256(pass)); // 🔒 Guardar hash
            ps.setInt(3, 1);

            int filas = ps.executeUpdate();
            System.out.println("✅ Usuario registrado. Filas afectadas: " + filas);
            return true;

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            return false;
        }
    }

    public static boolean verificarUsuario(String nombre, String pass) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT contrasena FROM usuario_progreso WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String hashGuardado = rs.getString("contrasena");
                String hashInput = getSHA256(pass);

                if (hashGuardado.equals(hashInput)) {
                    System.out.println("✅ Login exitoso.");
                    return true;
                } else {
                    System.out.println("❌ Contraseña incorrecta.");
                    return false;
                }
            } else {
                System.out.println("⚠️ Usuario no encontrado.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            return false;
        }
    }

    
    public static void main(String[] args) {
        iniciar_sesion();
    }

}
