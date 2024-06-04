import Juego.Controlador.Juego;

public class Main {
    /**
     * Main del programa
     */
    public static void main(String[] args) {
        boolean corriendo = true;
        while(corriendo) {
            corriendo = Juego.menuLoop();
        }
    }
}