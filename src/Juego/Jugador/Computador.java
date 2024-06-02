package Juego.Jugador;

import Juego.Carta.Carta;
import Juego.Controlador.Juego;

public class Computador extends Jugador {
    private void mostrarTomarDecision() {
        ImpresoraCarta.mostrarMazo(mazo, false);
        System.out.print("El oponente esta tomando una seleccion");
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
            Thread.sleep(500);
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println();
    }

    @Override
    public void tomarTurno() {
        mostrarTomarDecision();
        for (Carta carta : mazo) {
            if (Juego.jugarCarta(carta)) {
                mazo.remove(carta);
                System.out.println("El oponente ha jugado la carta: " + carta.getColor() + carta.getTipo());
                try {
                    Thread.sleep(1500);
                } catch (Exception e) {
                    System.err.println(e);
                }
                return;
            }
        }
        System.out.println("El oponente no tiene cartas para jugar");
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.err.println(e);
        }
        Juego.darCartas(this);
    }

    @Override
    public boolean cantarUno() {
        System.out.println("El COMPUTADOR CANTO UNO!");
        return true;
    }
}
