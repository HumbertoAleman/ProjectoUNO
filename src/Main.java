import Juego.Controlador.Juego;

import java.io.IOException;

public class Main {
    /**
     * Main del programa
     */
    public static void main(String[] args) throws IOException {
        boolean corriendo = true;
        while(corriendo) {
            corriendo = Juego.menuLoop();
        }
    }
}