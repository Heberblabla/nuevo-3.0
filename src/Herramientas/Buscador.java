package Herramientas;

import java.util.*;
import Data.*;

public class Buscador {

    //Instancia única
    private static final Buscador instancia = new Buscador();

    //Mapa de clases registradas
    private final Map<String, Class<? extends Tropa>> mapa = new HashMap<>();

    //Constructor privado
    public Buscador() {
        registrar(Arquero.class);
        registrar(Lanzatonio.class);
        registrar(Espadachin.class);
        registrar(Gigante.class);
        registrar(Rey_Arquero.class);
        registrar(Rey_Lanzatonio.class);
        registrar(Rey_de_los_Gigantes.class);
        registrar(Rey_Goku.class);
        registrar(Rey_Espadachin.class);
    }

    //Obtener la instancia global
    public static Buscador getInstancia() {
        return instancia;
    }

    //Registrar una clase
    private void registrar(Class<? extends Tropa> c) {
        mapa.put(c.getSimpleName(), c);
    }

    //Obtener una clase por nombre
    public Class<? extends Tropa> obtenerClase(String nombre) {
        return mapa.get(nombre);
    }

    //Obtener todas las clases registradas
    public Class<?>[] obtenerTodas() {
        return mapa.values().toArray(new Class<?>[0]);
    }

    //Crear instancias desde una selección
    public List<Tropa> obtenerTropas(Seleccion seleccion) {
        List<Tropa> tropas = new ArrayList<>();
        String[] nombres = {
            seleccion.getNombre_Rey(),
            seleccion.getNombre_tropa_1(),
            seleccion.getNombre_tropa_2(),
            seleccion.getNombre_tropa_3(),
            seleccion.getNombre_tropa_4(),
            seleccion.getNombre_tropa_5()
        };

        for (String nombre : nombres) {
            Class<? extends Tropa> c = mapa.get(nombre);
            if (c != null) {
                try {
                    tropas.add(c.getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return tropas;
    }
}
