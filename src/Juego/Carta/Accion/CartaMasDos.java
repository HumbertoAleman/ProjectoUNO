package Juego.Carta.Accion;

public class CartaMasDos extends CartaAccion {
    public CartaMasDos() {
    }
    public CartaMasDos(char color, String tipo) {
        super(color, tipo);
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
