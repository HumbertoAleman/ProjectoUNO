package Juego.Jugador;

import Juego.Carta.Carta;

import java.util.LinkedList;

public abstract class Jugador {
        public LinkedList<Carta> mazo = new LinkedList<Carta>();
        public void agregarCarta(Carta carta) {
                if (carta == null) return;
                mazo.add(carta);
        }

        public abstract void tomarTurno();
}
