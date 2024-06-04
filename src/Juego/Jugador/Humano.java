package Juego.Jugador;

import Juego.Carta.Carta;
import Juego.Controlador.Juego;

import java.util.Scanner;

public class Humano extends Jugador {
    /**
     * Costructor de humano
     *
     * @param nombre nombre del jugador
     */
    public Humano(String nombre) {
        super(nombre);
        tipo = "H";
    }
    /**
     * El jugador realiza una accion en su turno
     */
    @Override
    public void tomarTurno() {
        Scanner scanner = new Scanner(System.in);
        Carta cartaSeleccionada = null;
        String seleccion = "";

        while (!Juego.jugarCarta(cartaSeleccionada) && !seleccion.equals("T")) {
            ImpresoraCarta.mostrarMazo(mazo, true);

            System.out.println();
            System.out.println("Es el turno de: " + getNombre());
            if (Juego.getCartasATomar() > 0)
                System.out.println("Ingrese T para tomar " + Juego.getCartasATomar() + " cartas");
            else System.out.println("Ingrese T para tomar una carta");
            System.out.println();

            System.out.print("Escriba la carta a jugar: ");
            seleccion = scanner.nextLine();

            // Esta linea existe porque por alguna razon si usamos una variable dentro de una lamda function
            // tiene que ser de esta manera
            String finalSeleccion = seleccion;
            cartaSeleccionada = mazo.stream().filter(carta -> (carta.getColor() + carta.getTipo()).equals(finalSeleccion)).findFirst().orElse(null);
        }

        if (seleccion.equals("T")) {
            Juego.darCartas(this);
            return;
        }

        mazo.remove(cartaSeleccionada);
    }


    //Calcula el tiempo desde que se ejecuta la funcion hasta que se recibe la entrada del usuario
    //Si es menor a 3 segundos es considerado valido y retorna true
    /**
     * Le da 3 segundos al jugador para cantar uno, sino agarrara cartas
     *
     * @return true si el jugador canta uno en menos de 3 segundos, false si no lo hace a tiempo
     */
    public boolean cantarUno() {
        Scanner scanner = new Scanner(System.in);
        long tiempoInicio = System.currentTimeMillis();
        System.out.println("Es momento de cantar UNO!\nPresiona la tecla U rapido!");
        if (scanner.nextLine().equals("U")) {
            long tiempoFinal = System.currentTimeMillis();
            return (tiempoFinal - tiempoInicio) <= 3000;
        } else {
            System.out.println("No lo hiciste a tiempo :(");
            return false;
        }
    }
}
