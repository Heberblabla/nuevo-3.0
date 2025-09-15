package Prueba;

import Data.*;
import Herramientas.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Seleccion seleccion1 = new Seleccion(null, "Jugador 1");
        Seleccion seleccion2 = new Seleccion(null, "Jugador 2");

        Buscador buscador = new Buscador();
        List<Tropa> ejercito1 = buscador.obtenerTropas(seleccion1);
        List<Tropa> ejercito2 = buscador.obtenerTropas(seleccion2);

        Batalla_1 xd = new Batalla_1(ejercito1, ejercito2, null, "waza");

    }
}
