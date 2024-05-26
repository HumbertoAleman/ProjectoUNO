package Juego.Carta.Comodin;

public class CartaMasCuatro extends CartaComodin {
    public CartaMasCuatro() {
    }
    public CartaMasCuatro(char colorSeleccionado, String tipo) {
        super(colorSeleccionado, tipo);
    }

    @Override
    public void ejecutarAccion() {
        changeColor();
        // Ademas de cambiar el color, la carta deberia aumentar el numero de cartas a tomar por 4
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void mostrarCarta(){
        System.out.print(this.getColorSeleccionado() + this.tipo + "  ");
    }
}