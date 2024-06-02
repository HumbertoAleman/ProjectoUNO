package Juego.Controlador;

import Juego.Carta.Accion.CartaAccion;
import Juego.Carta.Carta;
import Juego.Carta.Comodin.CartaComodin;
import Juego.Carta.Pila.PilaJugar;
import Juego.Carta.Pila.PilaTomar;
import Juego.Jugador.Jugador;
import Juego.Jugador.Jugadores;

import java.util.List;
import java.util.Scanner;

public class Juego {
    private Juego() {
    }

    private static int cartasATomar;

    public static int getCartasATomar() {
        return cartasATomar;
    }

    public static void setCartasATomar(int cartasATomar) {
        Juego.cartasATomar = cartasATomar;
    }

    private static boolean saltarTurno;

    public static boolean isSaltarTurno() {
        return saltarTurno;
    }

    public static void setSaltarTurno(boolean saltarTurno) {
        Juego.saltarTurno = saltarTurno;
    }

    public static void revertirOrden() {
        if (listaJugadores == null) return;
        listaJugadores.cambiarOrden();
    }

    private static Jugadores listaJugadores;

    public static int getNumeroJugadores() {
        return listaJugadores == null ? 0 : listaJugadores.size();
    }

    public static boolean jugadorEsHumano() {
        return listaJugadores != null && listaJugadores.validarJugadorHumano();
    }

    public static boolean jugadorEsCPU() {
        return listaJugadores != null && listaJugadores.validarJugadorComputador();
    }

    private static PilaTomar pilaTomar;

    public static void darCartas(Jugador jugador) {
        pilaTomar.tomarCartas(jugador, cartasATomar == 0 ? 1 : cartasATomar);
        cartasATomar = 0;
    }

    private static PilaJugar pilaJugar;

    public static boolean jugarCarta(Carta carta) {
        if (!pilaJugar.validarCarta(carta)) return false;
        pilaJugar.jugarCarta(carta);
        return true;
    }

    public static List<Carta> getCartasPorDebajo() {
        return pilaJugar.getCartasPorDebajo();
    }

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

    public static boolean menuLoop() {
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

    public static boolean loopJuego() {
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
        return true;
    }

    public final static void limpiarConsola() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
                Runtime.getRuntime().exec("cls");
            else
                Runtime.getRuntime().exec("clear");
        } catch (final Exception e) {
        }
    }

}