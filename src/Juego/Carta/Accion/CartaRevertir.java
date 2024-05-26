package Juego.Carta.Accion;

import Juego.Controlador.Juego;

public class CartaRevertir extends CartaAccion {
    private static final String tipo = "R";
    public CartaRevertir() {
    }
    public CartaRevertir(char color) {
        super(color, CartaRevertir.tipo);
    }

    @Override
    public void ejecutarAccion() {
        /* TODO: Falta hacer un checkeo de si la cantidad de jugadores es == 2, en ese caso no cambiar la direccion
         * sino activar el efecto de saltar turno
         */
        Juego.setDireccionPositiva(!Juego.isDireccionPositiva());
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
