package Juego.Jugador;

import Juego.Carta.Carta;

import java.util.LinkedList;

public abstract class Jugador {
        protected String tipo;

        protected LinkedList<Carta> mazo = new LinkedList<>();
        /**
         * Agrega una carta al mazo
         *
         * @param carta una carta
         */
        public void agregarCarta(Carta carta) {
                if (carta == null) return;
                mazo.add(carta);
        }
        /**
         * Valida si el jugador tiene una carta
         * 
         * @return true si el jugador tiene una carta, false si no
         */
        public boolean validarUno(){
            return mazo.size() == 1;
        }

        /**
         * Revisa si el jugador canta uno 
         * 
         * @return true si canta uno, false si no
         */
        public abstract boolean cantarUno();

        /**
         * Obtiene la cantidad de cartas del mazo del jugador
         * 
         * @return cantidad de cartas del mazo
         */
        public int getCantidadDeCartas() {
                return mazo.size();
        }
        /**
         * Toma el turno del jugador
         */
        public abstract void tomarTurno();
}
