package Juego.Carta.Comodin;

import Juego.Carta.Carta;
import Juego.Controlador.Juego;

import java.util.Scanner;

public abstract class CartaComodin implements Carta {
    private char colorSeleccionado = 'C';
    public char getColor() { return colorSeleccionado; }
    protected String tipo;
    public CartaComodin(String tipo) {
        this.tipo = tipo;
    }

    private static void cambiarColorDialogo() {
        System.out.println("Colores: ");
        System.out.println("R. Rojo");
        System.out.println("B. Azul");
        System.out.println("Y. Amarillo");
        System.out.println("G. Verde");
        System.out.println();
        System.out.print("Ingrese el color a jugar: ");
    }

    protected void changeColor() {
        Scanner scanner = new Scanner(System.in);
        while(this.colorSeleccionado == 'C') {
            Juego.limpiarConsola();
            cambiarColorDialogo();
            switch (scanner.nextLine().toLowerCase()) {
                case "r":
                case "rojo":
                case "red":
                    this.colorSeleccionado = 'R';
                    break;
                case "b":
                case "blue":
                case "azul":
                    this.colorSeleccionado = 'B';
                    break;
                case "y":
                case "yellow":
                case "amarillo":
                    this.colorSeleccionado = 'Y';
                    break;
                case "g":
                case "green":
                case "verde":
                    this.colorSeleccionado = 'G';
                    break;
                default :
                    this.colorSeleccionado = 'C';
                    System.out.println();
                    System.out.println("La opcion seleccionada es invalida");
                    scanner.nextLine();
            }
        }
    }
}
