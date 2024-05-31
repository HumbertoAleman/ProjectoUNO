package Juego.Jugador;

import Juego.Carta.Carta;

import java.util.ArrayList;

public class ImpresoraCarta {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public ImpresoraCarta(){};


    public void mostrarMazo(ArrayList<Carta> cartas){
        String cartaActual;
        char colorActual;
        String codigoAnsi;
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

                colorActual = cartas.get(indiceCartaActual).getColor();
                switch (colorActual){
                    case 'B':
                        codigoAnsi = ANSI_BLUE;
                        break;
                    case 'R':
                        codigoAnsi = ANSI_RED;
                        break;
                    case 'Y':
                        codigoAnsi = ANSI_YELLOW;
                        break;
                    case 'G':
                        codigoAnsi = ANSI_GREEN;
                        break;
                    default:
                        codigoAnsi = ANSI_WHITE;
                }

                cartaActual = cartas.get(indiceCartaActual).getColor()+cartas.get(indiceCartaActual).getTipo();
                if(cartaActual.length() <3){
                    cartaActual = cartaActual + " ";
                }
                System.out.print("|"+codigoAnsi + cartaActual +ANSI_RESET+"|    ");
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
