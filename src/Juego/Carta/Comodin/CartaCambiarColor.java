package Juego.Carta.Comodin;

public class CartaCambiarColor extends CartaComodin {
    @Override
    public void ejecutarAccion() {
        changeColor();
    }

    @Override
    public String getTipo() {
        return null;
    }
}
