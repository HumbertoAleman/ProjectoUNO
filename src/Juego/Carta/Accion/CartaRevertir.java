package Juego.Carta.Accion;

import Juego.Controlador.Juego;

public class CartaRevertir extends CartaAccion {
    private static final String tipo = "R";
    /**
     * Constructor de la carta revertir
     */
    public CartaRevertir() {
    }
    /**
     * Constructor de la carta revertir
     * @param color color de la carta
     */
    public CartaRevertir(char color) {
        super(color, CartaRevertir.tipo);
    }
    /**
     * Ejecuta la accion de la carta revertir
     */
    @Override
    public void ejecutarAccion() {
        if (Juego.getNumeroJugadores() == 2){
            Juego.setSaltarTurno(true);
            return;
        }
        Juego.revertirOrden();
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
     * Muestra la carta revertir
     */
    @Override
    public void mostrarCarta(){
        System.out.print(this.color + this.tipo + "  ");
    }
}
