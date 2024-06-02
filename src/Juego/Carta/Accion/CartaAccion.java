package Juego.Carta.Accion;

import Juego.Carta.CartaColorada;

public abstract class CartaAccion extends CartaColorada {
    protected String tipo;

    /**
     * Constructor de la carta accion
     */
    public CartaAccion() {
    }

    /**
     * Constructor de la carta accion
     *
     * @param color color de la carta
     * @param tipo  tipo de la carta
     */
    public CartaAccion(char color, String tipo) {
        super(color);
        this.tipo = tipo;
    }
}
