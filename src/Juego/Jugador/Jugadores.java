package Juego.Jugador;

import Juego.Carta.Pila.PilaTomar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Jugadores {
    private List<Jugador> listaJugadores = new ArrayList<Jugador>();

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

    public boolean validarJugadorHumano(Jugador jugador){
        //true si es humano, false si es computador

        return (jugador instanceof Humano);
    }




}
