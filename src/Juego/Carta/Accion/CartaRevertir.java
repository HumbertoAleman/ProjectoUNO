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
        if (Juego.getNumeroJugadores() == 2){
            Juego.setSaltarTurno(true);
            return;
        }
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
