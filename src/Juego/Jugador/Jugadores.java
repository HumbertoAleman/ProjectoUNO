package Juego.Jugador;

import Juego.Carta.Pila.PilaTomar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Jugadores {
    private List<Jugador> listaJugadores = new ArrayList<Jugador>();
    public List<Jugador> getListaJugadores() {
        return this.listaJugadores;
    }

    private int index = 0;
    private boolean order = true;

    public void cambiarOrden(){
        this.order = !order;
    }

    public void instanciarJugadores(){
        /*for(int i =0; i>numeroHumanos; i++){
            listaJugadores.add(new Humano());
        }*/
        //Implementacion para multijugador

        Jugador jugadorHumano = new Humano();
        Jugador jugadorComputador = new Computador();
        listaJugadores.add(jugadorHumano);
        listaJugadores.add(jugadorComputador);

    }

    public void jugadorActualTurno() {
        listaJugadores.get(index).tomarTurno();
    }

    public void siguienteJugador() {
        if (order) {
            index = (index + 1) % listaJugadores.size();
            return;
        }
        index = (index - 1) % listaJugadores.size();
    }

    public boolean validarJugadorHumano(Jugador jugador){
        //true si es humano, false si es computador

        return (jugador instanceof Humano);
    }

    public int size() {
        return listaJugadores.size();
    }
}
