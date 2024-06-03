package Juego.Controlador;

import Juego.Carta.Accion.CartaAccion;
import Juego.Carta.Carta;
import Juego.Carta.Comodin.CartaComodin;
import Juego.Carta.Pila.PilaJugar;
import Juego.Carta.Pila.PilaTomar;
import Juego.Jugador.Jugador;
import Juego.Jugador.Jugadores;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Juego.Controlador.*;
public class Juego {
    private Juego() {
    }

    private static int cartasATomar;
    /**
     * Obtiene las cartas a tomar
     * 
     * @return cantidad de cartas
     */
    public static int getCartasATomar() {
        return cartasATomar;
    }
    /**
     * Asigna la cantidad de cartas a tomar
     *
     * @param cartasATomar cartas a tomar
     */
    public static void setCartasATomar(int cartasATomar) {
        Juego.cartasATomar = cartasATomar;
    }

    private static boolean saltarTurno;
    /**
     * Revisa si se debe saltar un turno
     *
     * @return true si hay que saltar un turno, false si no
     */
    public static boolean isSaltarTurno() {
        return saltarTurno;
    }
    /**
     * Notifica si se debe de saltar el turno
     *
     * @param saltarTurno true si se debe saltar turno, false si no
     */
    public static void setSaltarTurno(boolean saltarTurno) {
        Juego.saltarTurno = saltarTurno;
    }
    /**
     * Revierte el orden de jugadores
     */
    public static void revertirOrden() {
        if (listaJugadores == null) return;
        listaJugadores.cambiarOrden();
    }

    private static Jugadores listaJugadores;
    /**
     * Obtiene la cantidad de jugadores en la partida
     * 
     * @return cantidad de jugadores
     */
    public static int getNumeroJugadores() {
        return listaJugadores == null ? 0 : listaJugadores.size();
    }
    /**
     * Revisa si el jugador actual es humano
     * 
     * @return true si el jugador es humano, false si no
     */
    public static boolean jugadorEsHumano() {
        return listaJugadores != null && listaJugadores.validarJugadorHumano();
    }
    /**
     * Revisa si el jugador actual es CPU
     * 
     * @return true si el jugador es CPU, false si no
     */
    public static boolean jugadorEsCPU() {
        return listaJugadores != null && listaJugadores.validarJugadorComputador();
    }

    private static PilaTomar pilaTomar;
    /**
     * Le da cartas a un jugador
     *
     * @param jugador un jugador
     */
    public static void darCartas(Jugador jugador) {
        pilaTomar.tomarCartas(jugador, cartasATomar == 0 ? 1 : cartasATomar);
        cartasATomar = 0;
    }

    private static PilaJugar pilaJugar;
    /**
     * Revisa si la carta se puede jugar
     *
     * @param carta una carta
     * @return true si se puede jugar la carta, false si no
     */
    public static boolean jugarCarta(Carta carta) {
        if (!pilaJugar.validarCarta(carta)) return false;
        pilaJugar.jugarCarta(carta);
        return true;
    }
    /**
     * Obtiene las cartas de la Pila jugar menos la del tope
     * 
     * @return lista de cartas
     */
    public static List<Carta> getCartasPorDebajo() {
        return pilaJugar.getCartasPorDebajo();
    }
    /**
     * Muestra el menu del juego
     */
    public static void mostrarMenu() {
        System.out.println("----------------------------------");
        System.out.format("| %4s %25s |%n", "1.", "Comenzar juego");
        System.out.format("| %4s %25s |%n", "2.", "Cargar juego");
        System.out.format("| %30s |%n", "");
        System.out.format("| %4s %25s |%n", "0.", "Salir del juego");
        System.out.println("----------------------------------");
        System.out.println();
        System.out.print("Seleccion: ");
    }
    /**
     * Permite escoger una opcion del menu
     * 
     * @return true para volver a mostrar el menu, false para no
     */
    public static boolean menuLoop() throws IOException {
        Scanner scanner = new Scanner(System.in);
        mostrarMenu();

        switch (scanner.nextLine()) {
            case "1":
                iniciarJuego();
                while (loopJuego()) {
                }
                break;
            case "2":
                // Cargar juego
                break;
            case "0":
                return false;
            default:
                return true;
        }
        return false;
    }
    /**
     * Instancia los objetos del juego
     */
    public static void iniciarJuego() {
        listaJugadores = new Jugadores();
        pilaTomar = new PilaTomar();
        pilaJugar = new PilaJugar();
        cartasATomar = 0;
        saltarTurno = false;

        pilaTomar.crearListaCartas();

        listaJugadores.instanciarJugadores();
        pilaTomar.repartirCartas(listaJugadores.getListaJugadores());

        Carta primeraCarta = null;
        while (primeraCarta == null ||
                primeraCarta instanceof CartaComodin ||
                primeraCarta instanceof CartaAccion) {
            primeraCarta = pilaTomar.tomarCarta();
            pilaJugar.jugarCarta(primeraCarta);
        }
    }
    /**
     * Comienza el juego 
     * 
     * @return true para que se siga jugando el juego, false para no
     */
    public static boolean loopJuego() throws IOException {
        limpiarConsola();
        if (saltarTurno) {
            listaJugadores.siguienteJugador();
            saltarTurno = false;
        }

        pilaJugar.mostrarCartaTope();
        System.out.println();

        listaJugadores.jugadorActualTurno();
        int cartas = listaJugadores.getNumCartasJugadorActual();

        if (cartas == 1) {
//            if(!listaJugadores.jugadorActualCantarUno()){
//                pilaTomar.tomarCartas(listaJugadores.jugadorActual(), 7);
//            }
        } else if (cartas == 0) {
            // FUNCION GANAR
            return false;
        }

        pilaJugar.usarEfectoDeCarta();

        listaJugadores.siguienteJugador();
        Guardador.guardarJuego(listaJugadores, pilaJugar, pilaTomar, saltarTurno);
        return true;
    }
    /**
     * Limpia la patalla
     */
    public final static void limpiarConsola() {
        // Esto es probablemente lo mas tonto que he hecho en mis 3.5 semestres que he estado en esta universidad
        // pero me da demasiada flojera encontrar una manera de limpiar la consola en java.
        // Si alguien encuentra una manera de limpiar la consola de verdad, y que funcione tanto en mac
        // como en windows se lo agradeceria.
        // - Humberto Aleman

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < 30; i++)
            out.append("\n");
        System.out.println(out);
    }
}