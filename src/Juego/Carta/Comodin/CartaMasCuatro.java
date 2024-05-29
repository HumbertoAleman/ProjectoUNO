package Juego.Carta.Comodin;

import Juego.Controlador.Juego;

public class CartaMasCuatro extends CartaComodin {
    private static final String tipo = "T4";
    /**
     * Constructor de la carta mas cuatro
     */
    public CartaMasCuatro() {
        super(CartaMasCuatro.tipo);
    }
    /**
     * Ejecuta la accion de la carta
     */
    @Override
    public void ejecutarAccion() {
        changeColor();
        Juego.setCartasATomar(Juego.getCartasATomar() + 4);
    }

    /**
     * Obtiene el tipo de la carta
     * @return tipo de la carta
     */
    @Override
    public String getTipo() {
        return tipo;
    }

    /**
     * Muestra la carta
     */
    @Override
    public void mostrarCarta(){
        System.out.print(this.getColor() + this.tipo + "  ");
    }
}