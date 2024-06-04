package Juego.Jugador;

import Juego.Carta.Carta;
import Juego.Controlador.Juego;

public class Computador extends Jugador {
    /**
     * Constructor Computador
     *
     * @param nombre nombre del CPU
     */
    public Computador(String nombre) {
        super(nombre);
        tipo = "C";
    }

    private void mostrarTomarDecision() {
        ImpresoraCarta.mostrarMazo(mazo, false);
        System.out.print("El oponente esta tomando una seleccion");
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(750);
                System.out.print(".");
            }
            Thread.sleep(750);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println();
    }
    /**
     * El computador realiza una accion en su turno
     */
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
                    System.err.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("El oponente no tiene cartas para jugar");
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Juego.darCartas(this);
    }
    /**
     * El computador canta Uno
     * 
     * @return true
     */
    @Override
    public boolean cantarUno() {
        System.out.println("El COMPUTADOR CANTO UNO!");
        return true;
    }
}
