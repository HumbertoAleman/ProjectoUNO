package Juego.Carta.Comodin;

public class CartaMasCuatro extends CartaComodin {
    @Override
    public void ejecutarAccion() {
        changeColor();
        // Ademas de cambiar el color, la carta deberia aumentar el numero de cartas a tomar por 4
    }

    @Override
    public String getTipo() {
        return null;
    }
}