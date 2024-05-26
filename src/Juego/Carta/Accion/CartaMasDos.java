package Juego.Carta.Accion;

import Juego.Controlador.Juego;

public class CartaMasDos extends CartaAccion {
    private static final String tipo = "T2";
    public CartaMasDos() {
    }
    public CartaMasDos(char color) {
        super(color, CartaMasDos.tipo);
    }

    @Override
    public void ejecutarAccion() {
        Juego.setCartasATomar(Juego.getCartasATomar() + 2);
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void mostrarCarta(){
        System.out.print(this.color + this.tipo + "  ");
    }
}
