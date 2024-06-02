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

    public ImpresoraCarta() {
    }

    private static final Map<Character, String> colorMap = new HashMap<Character, String>() {{
        put('B', ANSI_BLUE);
        put('R', ANSI_RED);
        put('Y', ANSI_YELLOW);
        put('G', ANSI_GREEN);
    }};

    public void mostrarMazo(LinkedList<Carta> cartas) {
        final int cartasPorFila = 7;
        for (int fila = 0; fila < Math.ceil((double) cartas.size() / cartasPorFila); fila++) {
            for (int i = 0; i < Math.min(cartasPorFila, cartas.size() - fila * cartasPorFila); i++)
                System.out.print("+---+    ");
            System.out.println();

            int from = fila * cartasPorFila;
            int to = Math.min(fila * cartasPorFila + cartasPorFila, cartas.size());
            for (Carta cartaActual : cartas.subList(from, to)) {
                String cartaMostrar = String.format("%-3s", cartaActual.getColor() + cartaActual.getTipo());
                String codigoAnsi = colorMap.getOrDefault(cartaActual.getColor(), ANSI_WHITE);
                System.out.print("|" + codigoAnsi + cartaMostrar + ANSI_RESET + "|    ");
            }
            System.out.println();

            for (int i = 0; i < Math.min(cartasPorFila, cartas.size() - fila * cartasPorFila); i++)
                System.out.print("+---+    ");
            System.out.println();
        }
    }
}
