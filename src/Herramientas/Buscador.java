package Herramientas;

import java.util.ArrayList;
import java.util.List;
import Data.*;
import java.util.*;

public class Buscador {

    private final Map<String, Class<? extends Tropa>> mapa = new HashMap<>();

    public Buscador() {
        // Registrar clases
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

    private void registrar(Class<? extends Tropa> c) {
        mapa.put(c.getSimpleName(), c);
    }

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
