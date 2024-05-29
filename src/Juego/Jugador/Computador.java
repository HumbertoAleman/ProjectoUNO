package Juego.Jugador;

import Juego.Carta.Carta;
import Juego.Carta.Comodin.CartaComodin;
import Juego.Carta.Pila.PilaJugar;
import Juego.Controlador.Juego;

public class Computador extends Jugador {
    @Override
    public void tomarTurno() {
        for (Carta carta : mazo) {
            if (Juego.jugarCarta(carta)) {
                System.out.println("EL CPU JUGO");
                mazo.remove(carta);
                return;
            }
        }
        Juego.darCartas(this);
    }

    @Override
    public boolean cantarUno(){
        System.out.println("El COMPUTADOR CANTO UNO!");
        return true;
    }
}
