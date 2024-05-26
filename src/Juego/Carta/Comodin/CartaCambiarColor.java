package Juego.Carta.Comodin;

public class CartaCambiarColor extends CartaComodin {
    public CartaCambiarColor() {
    }
    public CartaCambiarColor(char colorSeleccionado, String tipo) {
        super(colorSeleccionado, tipo);
    }

    @Override
    public void ejecutarAccion() {
        changeColor();
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
