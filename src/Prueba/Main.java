package Prueba;

import Data.*;
import Herramientas.Seleccion;

import java.util.List;

import Herramientas.*;

public class Main {

    public static void main(String[] args) {

        Seleccion seleccion1 = new Seleccion(null, "Jugador 1");
        Seleccion seleccion2 = new Seleccion(null, "Jugador 2");

        Buscador buscador = new Buscador();
        List<Tropa> ejercito1 = buscador.obtenerTropas(seleccion1);
        List<Tropa> ejercito2 = buscador.obtenerTropas(seleccion2);

        System.out.println(ejercito1.get(0).getAtaque_base());
        System.out.println(ejercito1.get(1).getAtaque_base());
        System.out.println(ejercito1.get(2).getAtaque_base());
        System.out.println(ejercito1.get(3).getAtaque_base());
        System.out.println(ejercito1.get(4).getAtaque_base());
        System.out.println(ejercito1.get(5).getAtaque_base());
        

    }
}
