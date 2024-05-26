package Juego.Carta.Accion;

public class CartaRevertir extends CartaAccion {
    public CartaRevertir() {
    }
    public CartaRevertir(char color, String tipo) {
        super(color, tipo);
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
