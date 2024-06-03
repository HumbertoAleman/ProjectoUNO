import Juego.Carta.Pila.PilaTomar;
import Juego.Controlador.Juego;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    /**
     * Main del programa
     */
    public static void main(String[] args) throws IOException, ParseException {
        while(Juego.menuLoop());
    }
}