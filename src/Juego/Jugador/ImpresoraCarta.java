package Juego.Jugador;

import Juego.Carta.Carta;

import java.util.ArrayList;

public class ImpresoraCarta {
    public ImpresoraCarta(){};

    public void mostrarMazo(ArrayList<Carta> cartas){
        String cartaActual;
        int indiceCartaActual = 0;
        int sizeMazoCartas = cartas.size();
        double ciclos = Math.ceil((double) sizeMazoCartas/3);
        //Dividimos entre 3 y usamos 3 en los ciclos internos
        //para mostrar las cartas de a tres, simple opcion estetica
        for (int i = 0; i< ciclos;i++){

            for(int j = 0; j <3; j++){
                if(j==sizeMazoCartas){
                    break;
                }
                System.out.print("+---+    ");
            }
            System.out.println();

            for (int j = 0; j<3; j++){
                if(j==sizeMazoCartas){
                    break;
                }
                cartaActual = cartas.get(indiceCartaActual).getTipo()+cartas.get(indiceCartaActual).getColor();
                if(cartaActual.length() <3){
                    cartaActual = cartaActual + " ";
                }
                System.out.print("|" + cartaActual +"|    ");
            }
            System.out.println();

            for(int j =0; j<3; j++){
                if(j==sizeMazoCartas){
                    return;
                }
                System.out.println("+---+    ");
            }
            System.out.println();
            sizeMazoCartas-=3;
        }
    }
}
