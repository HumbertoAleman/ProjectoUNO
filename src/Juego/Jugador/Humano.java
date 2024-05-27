package Juego.Jugador;

import Juego.Carta.Carta;
import Juego.Controlador.Juego;

import java.util.Scanner;

public class Humano extends Jugador {
    @Override
    public void tomarTurno() {
        Scanner scanner = new Scanner(System.in);
        Carta cartaSeleccionada = null;
        String seleccion = "";

        while (!Juego.jugarCarta(cartaSeleccionada) && !seleccion.equals("T")) {
            for (Carta carta : mazo) {
                // TODO: Hacer una mejor manera de mostrar el mazo del jugador
                // Probablemente tambien tengamos que extraer mazo a una clase externa
                carta.mostrarCarta();
                System.out.print(", ");
            }

            System.out.println();
            if (Juego.getCartasATomar() > 0)
                System.out.println("Ingrese T para tomar " + Juego.getCartasATomar() + "cartas");
            else
                System.out.println("Ingrese T para tomar una carta");
            System.out.println();

            System.out.print("Escriba la carta a jugar: ");
            seleccion = scanner.nextLine();

            // Esta linea existe porque por alguna razon si usamos una variable dentro de una lamda function
            // tiene que ser de esta manera
            String finalSeleccion = seleccion;
            cartaSeleccionada = mazo.stream().filter(carta -> (carta.getColor() + carta.getTipo()).equals(finalSeleccion))
                    .findFirst()
                    .orElse(null);
        }

        if (seleccion.equals("T")) {
            Juego.darCartas(this);
            return;
        }

        mazo.remove(cartaSeleccionada);
    }

    public Humano(){};
}
