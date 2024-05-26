package Juego.Carta.Accion;

public class CartaMasDos extends CartaAccion {
    private static final String tipo = "T2";
    public CartaMasDos() {
    }
    public CartaMasDos(char color) {
        super(color, CartaMasDos.tipo);
    }

    @Override
    public void ejecutarAccion() {
        System.out.println("Accion de la carta mas dos");
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
