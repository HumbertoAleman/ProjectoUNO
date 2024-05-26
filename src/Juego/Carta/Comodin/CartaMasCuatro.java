package Juego.Carta.Comodin;

import Juego.Controlador.Juego;

public class CartaMasCuatro extends CartaComodin {
    private static final String tipo = "T4";
    public CartaMasCuatro() {
        super(CartaMasCuatro.tipo);
    }

    @Override
    public void ejecutarAccion() {
        changeColor();
        Juego.setCartasATomar(Juego.getCartasATomar() + 4);
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void mostrarCarta(){
        System.out.print(this.getColor() + this.tipo + "  ");
    }
}