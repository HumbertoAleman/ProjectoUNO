package Juego.Jugador;

import Juego.Carta.Carta;
import Juego.Controlador.Juego;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Timer;

public class Humano extends Jugador {
    @Override
    public void tomarTurno() {
        Scanner scanner = new Scanner(System.in);
        Carta cartaSeleccionada = null;
        String seleccion = "";
        ImpresoraCarta impresoraCarta = new ImpresoraCarta();
        while (!Juego.jugarCarta(cartaSeleccionada) && !seleccion.equals("T")) {
            impresoraCarta.mostrarMazo(mazo);

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


    //Calcula el tiempo desde que se ejecuta la funcion hasta que se recibe la entrada del usuario
    //Si es menor a 3 segundos es considerado valido y retorna true
    public boolean cantarUno(){
        Scanner scanner = new Scanner(System.in);
        long tiempoInicio = System.currentTimeMillis();
        System.out.println("Es momento de cantar UNO!\nPresiona la tecla U rapido!");
        if(scanner.nextLine().equals("U")){
            long tiempoFinal = System.currentTimeMillis();
            return (tiempoFinal - tiempoInicio) <=3000;
        }else{
            System.out.println("No lo hiciste a tiempo :(");
            return false;
        }


    }
    public Humano(){};


}
