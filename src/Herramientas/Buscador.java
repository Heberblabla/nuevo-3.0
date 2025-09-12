package Herramientas;

import java.util.ArrayList;
import java.util.List;
import Data.*;

public class Buscador {

    private final Class<?>[] clases = {
        Arquero.class,
        Lanzatonio.class,
        Espadachin.class,
        Rey_Arquero.class,
        Rey_Lanzatonio.class,
        Rey_Espadachin.class
    };

    public List<Tropa> obtenerTropas(Seleccion seleccion) {
        List<Tropa> tropas = new ArrayList<>();

        // Meter el rey + 5 tropas en una lista de strings
        String[] nombres = {
            seleccion.getNombre_Rey(),
            seleccion.getNombre_tropa_1(),
            seleccion.getNombre_tropa_2(),
            seleccion.getNombre_tropa_3(),
            seleccion.getNombre_tropa_4(),
            seleccion.getNombre_tropa_5()
        };

        // Buscar en las clases e instanciar
        for (String nombre : nombres) {
            for (Class<?> c : clases) {
                if (c.getSimpleName().equals(nombre)) {
                    try {
                        Object obj = c.getDeclaredConstructor().newInstance();
                        if (obj instanceof Tropa) {
                            tropas.add((Tropa) obj);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return tropas;
    }
}
