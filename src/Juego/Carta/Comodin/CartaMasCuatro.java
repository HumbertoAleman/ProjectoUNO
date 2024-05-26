package Juego.Carta.Comodin;

public class CartaMasCuatro extends CartaComodin {
    private static final String tipo = "T4";
    public CartaMasCuatro() {
        super(CartaMasCuatro.tipo);
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