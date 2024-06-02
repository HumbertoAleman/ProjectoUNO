package Juego.Carta;

public interface Carta {
    /**
     * Ejecuta la accion de la carta
     */
    public void ejecutarAccion();

    /**
     * Obtiene el color de la carta
     * @return color de la carta
     */
    public char getColor();
    /**
     * Obtiene el tipo de la carta
     * @return tipo de la carta
     */
    public String getTipo();

    /**
     * Muestra la carta
     */
    public void mostrarCarta();
}
