package Juego.Carta.Accion;

public class CartaRevertir extends CartaAccion {
    private static final String tipo = "R";
    public CartaRevertir() {
    }
    public CartaRevertir(char color) {
        super(color, CartaRevertir.tipo);
    }

    @Override
    public void ejecutarAccion() {
        System.out.println("Accion carta revertir");
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
