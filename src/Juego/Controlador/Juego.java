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
    // Deberiamos cambiar esto a su propia clase para poder controlarlo mejor
    // Como hicimos con pilarTomar y pilaJugar
    private static Jugadores listaJugadores = new Jugadores();
    public static int getNumeroJugadores() {
        if (listaJugadores == null) return 0;
        return listaJugadores.size();
    }

    private static PilaTomar pilaTomar;
    private static PilaJugar pilaJugar;

    public static boolean jugarCarta(Carta carta) {
        if (!pilaJugar.validarCarta(carta)) return false;
        pilaJugar.jugarCarta(carta);
        return true;
    }

    public static void darCartas(Jugador jugador) {
        pilaTomar.tomarCartas(jugador, cartasATomar == 0 ? 1 : cartasATomar);
        if (cartasATomar > 0) cartasATomar = 0;
    }

    public static List<Carta> getCartasPorDebajo() {
        return pilaJugar.getCartasPorDebajo();
    }


    private static int cartasATomar;
    private static boolean saltarTurno;
    private static boolean direccionPositiva;

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
                while(loopJuego()) { }
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
        pilaTomar = new PilaTomar();
        pilaJugar = new PilaJugar();
        listaJugadores = listaJugadores;

        pilaTomar.crearListaCartas(); // Este metodo crea las cartas dentro de la pila

        listaJugadores.instanciarJugadores();
        pilaTomar.repartirCartas(listaJugadores.getListaJugadores()); // Repartimos 7 cartas a c/u

        Carta primeraCarta = null;
        while (primeraCarta == null || primeraCarta instanceof CartaComodin || primeraCarta instanceof CartaAccion) {
            // Juega una carta hasta que NO sea o comodin o accion
            primeraCarta = pilaTomar.tomarCarta();
            pilaJugar.jugarCarta(primeraCarta);
        }

        // Comienza el loop del juego en si, iniciando con el jugador humano
    }

    public static boolean loopJuego() {
        if (saltarTurno){
            listaJugadores.siguienteJugador();
            saltarTurno = false;
        }

        pilaJugar.mostrarCartaTope();
        System.out.println();
        // GUARDAR AQUI
        listaJugadores.jugadorActualTurno();
        int cartas = listaJugadores.getNumCartasJugadorActual();

        if (cartas == 1) {
            // CANTAR UNO
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

    public static int getCartasATomar() {
        return cartasATomar;
    }

    public static void setCartasATomar(int cartasATomar) {
        Juego.cartasATomar = cartasATomar;
    }

    public static boolean isSaltarTurno() {
        return saltarTurno;
    }

    public static void setSaltarTurno(boolean saltarTurno) {
        Juego.saltarTurno = saltarTurno;
    }

    public static boolean isDireccionPositiva() {
        return direccionPositiva;
    }

    public static void setDireccionPositiva(boolean direccionPositiva) {
        Juego.direccionPositiva = direccionPositiva;
    }

    public static boolean jugadorEsHumano() {
        return listaJugadores.validarJugadorHumano();
    }
}