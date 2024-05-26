package Juego.Carta.Comodin;

public class CartaCambiarColor extends CartaComodin {
    private static final String tipo = "C";
    public CartaCambiarColor() {
        super(CartaCambiarColor.tipo);
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
        System.out.print(this.getColor() + this.tipo + "  ");
    }
}
