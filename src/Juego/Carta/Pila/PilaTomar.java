package Juego.Carta.Pila;

import Juego.Carta.Accion.CartaMasDos;
import Juego.Carta.Accion.CartaRevertir;
import Juego.Carta.Accion.CartaSaltar;
import Juego.Carta.Carta;
import Juego.Carta.CartaNumerica;
import Juego.Carta.Comodin.CartaCambiarColor;
import Juego.Carta.Comodin.CartaMasCuatro;
import Juego.Controlador.Juego;
import Juego.Jugador.Jugador;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PilaTomar {
    /**
     * Constructor de la pila de cartas a tomar
     */
    public PilaTomar() {
    }

    private final Stack<Carta> listaCartas = new Stack<>();

    /**
     * crea una la lista de cartas
     */
    public void crearListaCartas() {
        for (char color : "BRYG".toCharArray()) {
            for (int j = 1; j < 20; j++)
                listaCartas.add(new CartaNumerica(color, Integer.toString(j % 10)));
            for (int i = 0; i < 2; i++) {
                listaCartas.add(new CartaRevertir(color));
                listaCartas.add(new CartaSaltar(color));
                listaCartas.add(new CartaMasDos(color));
            }
        }
        for (int i = 0; i < 4; i++) {
            listaCartas.add(new CartaCambiarColor());
            listaCartas.add(new CartaMasCuatro());
        }
        shuffle(listaCartas);
    }

    /**
     * baraja las cartas
     */
    public void shuffle(Stack<Carta> listaCartas) {
        Collections.shuffle(listaCartas);
    }

    /**
     * Toma una carta y se las da a un jugador
     *
     * @return lista de cartas
     */
    public Carta tomarCarta() {
        return listaCartas.isEmpty() ? null : listaCartas.pop();
    }

    /**
     * Toma las cartas y se las da a un jugador
     *
     * @param jugador un jugador
     * @param n       numero de cartas a tomar
     */
    public void tomarCartas(Jugador jugador, int n) {
        for (int i = 0; i < n; i++) {
            if (listaCartas.isEmpty()) listaCartas.addAll(Juego.getCartasPorDebajo());
            Carta carta = tomarCarta();
            jugador.agregarCarta(carta);
        }
    }

    /**
     * reparte 7 cartas a la lista de jugadores
     *
     * @param jugadores lista de jugadores
     */
    public void repartirCartas(List<Jugador> jugadores) {
        for (Jugador jugador : jugadores)
            tomarCartas(jugador, 1);
    }

    //Esta funcion es usada unicamente al cargar
    public void agregarCarta(Carta carta){
        listaCartas.add(carta);
    }

    public void revertirCartas(){
        Collections.reverse(listaCartas);
    }
}
