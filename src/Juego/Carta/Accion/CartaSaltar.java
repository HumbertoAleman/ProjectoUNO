package Juego.Carta.Accion;

public class CartaSaltar extends CartaAccion {
    private static final String tipo = "S";
    public CartaSaltar() {
    }
    public CartaSaltar(char color) {
        super(color, tipo);
    }

    @Override
    public void ejecutarAccion() {
        System.out.println("Accion carta saltar");
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
