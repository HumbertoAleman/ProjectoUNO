package Juego.Controlador;
import Juego.Carta.Pila.PilaJugar;
import Juego.Carta.Pila.PilaTomar;
import Juego.Jugador.Jugadores;
import com.google.gson.Gson;

import java.io.*;
import java.sql.SQLOutput;

public class Guardador {
    static String listaJugadoresGuardar;
    static String pilaJugarGuardar;
    static String pilaTomarGuardar;

    static String juegoGuardar;

    private static Gson gson = new Gson();
    private Guardador() {}
    /**
     * Guarda la informacion del juego 
     */
    public static void guardarJuego() {
        // Guardamos la pila a tomar EN ORDEN
        // Guardamos la pila de juego EN ORDEN
        // Guardamos los jugadores como
        // "1": {
        //     "mazo": "R4 R5 B2 B1 CT4"
        //}
    }

    public static void guardarJuego(Jugadores listaJugadores, PilaJugar pilaJugar, PilaTomar pilaTomar, boolean saltarTurno) throws IOException {
        listaJugadoresGuardar = gson.toJson(listaJugadores);
        pilaJugarGuardar = gson.toJson(pilaJugar);
        pilaTomarGuardar = gson.toJson(pilaTomar);
        juegoGuardar = String.format("{ \"jugadores\": %s, \"pilaJugar\": %s, \"pilaTomar\": %s, \"saltarTurno\": %b}", listaJugadoresGuardar, pilaJugarGuardar, pilaTomarGuardar, saltarTurno);
        FileWriter fw = new FileWriter("C:\\Users\\10art\\Documents\\ProjectUNOCARDS\\src\\Juego\\Controlador\\juego.json");
        StringWriter sw = new StringWriter();
        sw.write(juegoGuardar);
        fw.write(sw.toString());
        fw.close();

    }
}
