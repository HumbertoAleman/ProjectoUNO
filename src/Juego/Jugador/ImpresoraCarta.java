package Juego.Jugador;

import Juego.Carta.Carta;

import java.util.*;

public interface ImpresoraCarta {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_WHITE = "\u001B[37m";

    Map<Character, String> colorMap = new HashMap<Character, String>() {{
        put('B', ANSI_BLUE);
        put('R', ANSI_RED);
        put('Y', ANSI_YELLOW);
        put('G', ANSI_GREEN);
    }};

    static void mostrarMazo(LinkedList<Carta> cartas, boolean mostrada) {
        final int cartasPorFila = 7;
        for (int fila = 0; fila < Math.ceil((double) cartas.size() / cartasPorFila); fila++) {
            for (int i = 0; i < Math.min(cartasPorFila, cartas.size() - fila * cartasPorFila); i++)
                System.out.print("+---+    ");
            System.out.println();

            int from = fila * cartasPorFila;
            int to = Math.min(fila * cartasPorFila + cartasPorFila, cartas.size());
            for (Carta cartaActual : cartas.subList(from, to)) {
                String cartaMostrar;
                String codigoAnsi;
                if (mostrada) {
                    cartaMostrar = String.format("%-3s", cartaActual.getColor() + cartaActual.getTipo());
                    codigoAnsi = colorMap.getOrDefault(cartaActual.getColor(), ANSI_WHITE);
                } else {
                    cartaMostrar = "UNO";
                    codigoAnsi = ANSI_WHITE;
                }
                System.out.print("|" + codigoAnsi + cartaMostrar + ANSI_RESET + "|    ");
            }
            System.out.println();

            for (int i = 0; i < Math.min(cartasPorFila, cartas.size() - fila * cartasPorFila); i++)
                System.out.print("+---+    ");
            System.out.println();
        }
    }
}
