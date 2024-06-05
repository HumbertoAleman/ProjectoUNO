import Juego.Controlador.Juego;

public class Main {

    /**
     * Funcion Main
     * @param args Argumentos de la funcion Main
     */
    public static void main(String[] args) {
        boolean corriendo = true;
        while(corriendo) {
            corriendo = Juego.menuLoop();
        }
    }
}