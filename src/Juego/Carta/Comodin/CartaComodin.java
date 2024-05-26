package Juego.Carta.Comodin;

import Juego.Carta.Carta;

public abstract class CartaComodin implements Carta {
    private char colorSeleccionado = 'C';
    protected String tipo;

    public CartaComodin() {
    }
    public CartaComodin(String tipo) {
        this.tipo = tipo;
    }
    
    public char getColorSeleccionado() { 
        return colorSeleccionado; }
    public char getColor() { 
        return colorSeleccionado; }

    public void changeColor() {
        // Preguntar al jugador que color va a ser jugado, y poner la variable colorSeleccionado como ese color
        // Validar que el color sea R, B, Y, G
    }
}
