package Juego.Carta.Accion;

import Juego.Carta.CartaColorada;

public abstract class CartaAccion extends CartaColorada {
    protected String tipo;

    public CartaAccion() {
    }
    public CartaAccion(char color, String tipo) {
        super(color);
        this.tipo = tipo;
    }
}
