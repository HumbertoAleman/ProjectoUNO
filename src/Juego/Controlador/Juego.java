package Juego.Controlador;

import Juego.Carta.Accion.CartaAccion;
import Juego.Carta.Carta;
import Juego.Carta.Comodin.CartaComodin;
import Juego.Carta.Pila.PilaJugar;
import Juego.Carta.Pila.PilaTomar;
import Juego.Jugador.Jugador;
import Juego.Jugador.Jugadores;

import java.util.Scanner;

public class Juego {
    // Deberiamos cambiar esto a su propia clase para poder controlarlo mejor
    // Como hicimos con pilarTomar y pilaJugar
    private static Jugadores listaJugadores;
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
            primeraCarta.mostrarCarta();
        }

        // Comienza el loop del juego en si, iniciando con el jugador humano
    }

    public static boolean loopJuego() {
        // El loop de juego tiene tres partes

        // 1.1- Revisar si se salta el turno, si es el caso, simplemente saltar
        // 1.2- Revisar si cartas a tomar es mayor a 0, si es mayor a 0 presentar la opcion de tomarlas
        // y esconder la opcion de tomar de la pila
        // 1.3- Revisar si el reverso esta activo, si la cantidad de jugadores es = 2, saltar turno, else
        // hacer que el indice de jugador -= 2, para seleccionar al jugador anterior al que jugo la carta, y
        // cambiar la flag de reverso para que el indice no suba, sino baje

        // 2.0 - Aqui es donde guardamos el juego, antes de que el usuario pueda seleccionar una carta
        // 2.1 - tomar input del jugador, presentar opciones para
        // Jugar carta
        // SI EL CARTAS A TOMAR ES MENOR A 1, Tomar carta de pila
        // SI EL CARTAS A TOMAR ES MAYOR A 0, tomar las cartas necesarias, y perder el turno

        // 3.1 - Si el jugador tiene una sola carta, presentar opcion para decir UNO
        // 3.2 - Aplicar los efectos de las cartas acorde, esto se hace con la interfaz ejecutarAccion, esa funcion
        // debe modificar los valores de Juego.java de acuerdo con la carta (la implementacion de la interfaz se
        // encuentra en las clases hijas)

        return false;
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

    public static boolean jugadorEsCPU() {
        return false;
    }
}
