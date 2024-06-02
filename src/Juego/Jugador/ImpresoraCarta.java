package Juego.Jugador;

import Juego.Carta.Carta;

import java.util.*;

public class ImpresoraCarta {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public ImpresoraCarta() { };

    private static final Map<Character, String> colorMap = new HashMap<Character, String>() {{
        put('B', ANSI_BLUE);
        put('R', ANSI_RED);
        put('Y', ANSI_YELLOW);
        put('G', ANSI_GREEN);
    }};


    public void mostrarMazo(LinkedList<Carta> cartas){
        for (int fila = 0; fila < Math.ceil(cartas.size() / 3.0); fila++){
            for(int i = 0; i < Math.min(3, cartas.size() - fila * 3); i++)
                System.out.print("+---+    ");
            System.out.println();

            for (Carta cartaActual : cartas.subList(fila * 3, Math.min(fila * 3 + 3, cartas.size()))) {
                String cartaMostrar = String.format("%-3s", cartaActual.getColor() + cartaActual.getTipo());
                String codigoAnsi = colorMap.getOrDefault(cartaActual.getColor(), ANSI_WHITE);
                System.out.print("|" + codigoAnsi + cartaMostrar + ANSI_RESET + "|    ");
            }
            System.out.println();

            for(int i = 0; i < Math.min(3, cartas.size() - fila * 3); i++)
                System.out.print("+---+    ");
            System.out.println();
        }
    }
}
