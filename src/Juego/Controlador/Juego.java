package Juego.Controlador;

import Juego.Carta.Carta;
import Juego.Jugador.Jugador;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
    private static ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

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

        switch(scanner.nextLine()) {
            case "1":
                // Comenzar juego
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
        // Se instancian las cartas y se meten en la pila tomar

        // NOTA: Crear un for loop para instanciarlas, no estamos locos
        // -- CARTAS COLORADAS --
        // Dos cartas del 1 al 9 y una del 0
        // 2 Cartas de accion c/u
        // -- CARTAS COMODIN --
        // 4 Cartas Cambiar Color
        // 4 Cartas Toma Cuatro

        // NOTA: probablemente se deba extraer la lista jugadores a una clase aparte
        // Se instancian los jugadores y se meten aleatoriamente en la lista de jugadores,

        // Luego de instanciarse las cartas y los jugadores, se reparten las cartasentre los jugadores, 7 cartas c/u

        // NOTA: validar que la carta que se vaya a color en al pila jugar no sea un comodin
        // Luego de repartirse, se toma la primera carta de la pila tomar, y se coloca en la pila jugar

        // Comienza el loop del juego en si, iniciando con el jugador humano
    }

    public static boolean validar(Carta cartaAJugar) {
        // Si la carta es T4, siempre se juega

        // Si las cartas a tomar es mayor a 0, solo se puede jugar una carta de T2 (el caso de T4 ya fue cubierto)
        // Se revisa el color y pinta de la ultima carta para saber si se puede jugar

        // Si las cartas a tomar son menores de 0, se revisa si la carta es un comodin, siempre se juega
        // Si no es comodin, se revisa el color, si el color es igual, se juega
        // Si el color es diferente, se revisa el tipo, si el tipo es igual se juega

        // Si nada funciona retornar falso
        return false;
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
        }
        catch (final Exception e) { }
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
}
