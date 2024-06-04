package Juego.Controlador;
import Juego.Carta.Pila.PilaJugar;
import Juego.Carta.Pila.PilaTomar;
import Juego.Jugador.Jugadores;
import com.google.gson.Gson;


import java.io.*;


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



    public static void guardarJuego(Jugadores listaJugadores, PilaJugar pilaJugar, PilaTomar pilaTomar, boolean saltarTurno, int cartasATomar) throws IOException {
        listaJugadoresGuardar = gson.toJson(listaJugadores);
        pilaJugarGuardar = gson.toJson(pilaJugar);
        pilaTomarGuardar = gson.toJson(pilaTomar);
        //Instancie el FileWriter una vez por cada archivo porque intente usar el flush,
        //Pero no se guardaban bien los datos

        FileWriter FWJugadores = new FileWriter("src/Juego/Controlador/listaJugadores.json");
        StringWriter SWJugadores = new StringWriter();
        SWJugadores.write(listaJugadoresGuardar);
        FWJugadores.write(SWJugadores.toString());
        FWJugadores.close();
        FileWriter FWPilaJugar = new FileWriter("src/Juego/Controlador/pilaJugar.json");
        StringWriter SWPilaJugar = new StringWriter();
        SWPilaJugar.write(pilaJugarGuardar);
        FWPilaJugar.write(SWPilaJugar.toString());
        FWPilaJugar.close();
        FileWriter FWPilaTomar = new FileWriter("src/Juego/Controlador/pilaTomar.json");
        StringWriter SWPilaTomar = new StringWriter();
        SWPilaTomar.write(pilaTomarGuardar);
        FWPilaTomar.write(SWPilaTomar.toString());
        FWPilaTomar.close();
        FileWriter FWJuego = new FileWriter("src/Juego/Controlador/juego.json");
        StringWriter SWJuego = new StringWriter();
        juegoGuardar  = String.format("{\"saltarTurno\":%b, \"cartasATomar\":%o }", saltarTurno, cartasATomar);
        SWJuego.write(juegoGuardar);
        FWJuego.write(SWJuego.toString());
        FWJuego.close();

    }
}
