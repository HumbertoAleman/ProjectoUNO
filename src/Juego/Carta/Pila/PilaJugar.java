package Juego.Carta.Pila;

import Juego.Carta.Carta;

import java.util.List;
import java.util.Stack;

public class PilaJugar {
    private Stack<Carta> listaCartas = new Stack<Carta>();

    public boolean validarCarta(Carta carta) {  //True=SI se puede jugar - False=NO se puede juegar
        if(carta.getTipo() == "T4" || carta.getTipo() == "C")
            return true;
        if(listaCartas.peek().getColor() == carta.getColor() || listaCartas.peek().getTipo() == carta.getTipo())
            return true;
        return false;
    }

    public void jugarCarta(Carta carta) {
        listaCartas.push(carta);
    }
}
