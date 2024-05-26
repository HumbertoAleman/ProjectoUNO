package Juego.Carta.Pila;

import Juego.Carta.Carta;
import java.util.Collections;
import java.util.Stack;

public class PilaTomar {
    private Stack<Carta> listaCartas = new Stack<Carta>();

public PilaTomar() {
    }
    public PilaTomar(Stack<Carta> listaCartas) {
        this.listaCartas = listaCartas;
    }

    public static void crearListaCartas(Stack<Carta> listaCartas){
        char color;
        for(int i = 1; i <= 4; i++){
            if(i == 1)
                color = 'B';
            else if(i == 2)
                color = 'R';
            else if(i == 3)
                color = 'Y';
            else
                color = 'G';
            listaCartas.add(new CartaNumerica(color,"0"));
            for(int j = 1; j <= 9; j++){
                listaCartas.add(new CartaNumerica(color,Integer.toString(j)));
                listaCartas.add(new CartaNumerica(color,Integer.toString(j)));
            }
            listaCartas.add(new CartaRevertir(color,"R"));
            listaCartas.add(new CartaRevertir(color,"R"));
            listaCartas.add(new CartaSaltar(color,"S"));
            listaCartas.add(new CartaSaltar(color,"S"));
            listaCartas.add(new CartaMasDos(color,"T2"));
            listaCartas.add(new CartaMasDos(color,"T2"));
        }
        for(int i = 1; i <= 4; i++){
            listaCartas.add(new CartaCambiarColor('C',"C"));
        }
        for(int i = 1; i <= 4; i++){
            listaCartas.add(new CartaMasCuatro('C',"T4"));
        }
        shuffle(listaCartas);
    }
    
    public static void shuffle(Stack<Carta> listaCartas) {
        Collections.shuffle(listaCartas);
    }

    public Carta tomarCarta() {
        return null;
    }

}
