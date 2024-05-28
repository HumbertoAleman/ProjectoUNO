package Juego.Carta.Pila;

import Juego.Carta.Carta;
import Juego.Controlador.Juego;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class PilaJugar {
    private final Stack<Carta> listaCartas = new Stack<Carta>();

    public List<Carta> getCartasPorDebajo() {
        Carta primeraCarta = listaCartas.pop();
        LinkedList<Carta> cartasPorDebajo = new LinkedList<>(listaCartas);
        listaCartas.clear();
        listaCartas.add(primeraCarta);
        return cartasPorDebajo;
    }

    public boolean validarCarta(Carta carta) {
        if (carta == null)
            return false;

        if (Objects.equals(carta.getTipo(), "T4"))
            return true;

        if (Juego.getCartasATomar() > 0 && listaCartas.peek().getColor() == carta.getColor())
           return true;

        return carta.getTipo().equals("C") ||
                listaCartas.peek().getColor() == carta.getColor() ||
                listaCartas.peek().getTipo().equals(carta.getTipo());
    }

    public void jugarCarta(Carta carta) {
        listaCartas.push(carta);
    }
}
