package Juego.Jugador;

import Juego.Carta.Carta;

import java.util.LinkedList;

public abstract class Jugador {
        protected LinkedList<Carta> mazo = new LinkedList<Carta>();
        public void agregarCarta(Carta carta) {
                if (carta == null) return;
                mazo.add(carta);
        }

        public boolean validarUno(){
            return mazo.size() == 1;

        }
        public abstract boolean cantarUno();

        public int getCantidadDeCartas() {
                return mazo.size();
        }

        public abstract void tomarTurno();
}
