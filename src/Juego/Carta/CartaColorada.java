package Juego.Carta;

public abstract class CartaColorada implements Carta {
    protected char color;
    /**
     * Constructor de la carta colorada
     */
    public CartaColorada() {
    }
    /**
     * Constructor de la carta colorada
     * @param color color de la carta
     */
    public CartaColorada(char color) {
        this.color = color;
    }
    /**
     * Obtiene el color de la carta
     * @return color de la carta
     */
    public char getColor() { 
        return color; }
    /**
     * Asigna un color a la carta colorada
     * @param color color a asignar a la carta
     */
    public void setColor(char color) { 
        this.color = color; }
}
