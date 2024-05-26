package Juego.Carta;

public abstract class CartaColorada implements Carta {
    protected char color;

    public CartaColorada() {
    }
    public CartaColorada(char color) {
        this.color = color;
    }

    public char getColor() { 
        return color; }
    public void setColor(char color) { 
        this.color = color; }
}
