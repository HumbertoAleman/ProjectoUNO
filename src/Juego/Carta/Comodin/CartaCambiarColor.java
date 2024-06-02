package Juego.Carta.Comodin;

public class CartaCambiarColor extends CartaComodin {
    private static final String tipo = "C";

    /**
     * Constructor de la carta cambiar color
     */
    public CartaCambiarColor() {
        super(CartaCambiarColor.tipo);
    }

    /**
     * Ejecuta la accion de la carta
     */
    @Override
    public void ejecutarAccion() {
        changeColor();
    }

    /**
     * Obtiene el tipo de la carta
     *
     * @return tipo de la carta
     */
    @Override
    public String getTipo() {
        return tipo;
    }

    /**
     * Muestra la carta
     */
    @Override
    public void mostrarCarta() {
        System.out.print(this.getColor() + tipo + "  ");
    }
}
