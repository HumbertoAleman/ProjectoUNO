package Juego.Carta.Pila;

import Juego.Carta.Accion.CartaMasDos;
import Juego.Carta.Accion.CartaRevertir;
import Juego.Carta.Accion.CartaSaltar;
import Juego.Carta.Carta;
import Juego.Carta.CartaNumerica;
import Juego.Carta.Comodin.CartaCambiarColor;
import Juego.Carta.Comodin.CartaMasCuatro;

import java.util.Collections;
import java.util.Stack;

public class PilaTomar {
    private Stack<Carta> listaCartas = new Stack<>();

    public PilaTomar() {
    }

    public PilaTomar(Stack<Carta> listaCartas) {
        this.listaCartas = listaCartas;
    }

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

    public void shuffle(Stack<Carta> listaCartas) {
        Collections.shuffle(listaCartas);
    }

    public Carta tomarCarta() {
        return listaCartas.isEmpty() ? null : listaCartas.pop();
    }

    public void tomarCartas(Jugador jugador, int n) {
        for (int i = 0; i < n; i++) {
            if (!listaCartas.isEmpty()) {
                Carta carta = tomarCarta();
                jugador.agregarCarta(carta);
            } else {
                System.out.println("No hay más cartas en la pila para tomar.");
                break;
            }
        }
    }
    public void repartirCartas(List<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            tomarCartas(jugador, 7);
        }
    }
}
