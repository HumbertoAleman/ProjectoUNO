package Juego.Carta.Accion;

import Juego.Controlador.Juego;

public class CartaSaltar extends CartaAccion {
    private static final String tipo = "S";
    public CartaSaltar() {
    }
    public CartaSaltar(char color) {
        super(color, tipo);
    }

    @Override
    public void ejecutarAccion() {
        Juego.setSaltarTurno(true);
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
