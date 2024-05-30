package Juego.Carta;

public interface Carta {
    /**
     * Ejecuta la accion de la carta
     */
    public void ejecutarAccion();

    // Al combinar la funcion getColor y getTipo, resulta la etiqueta que joselito especifico
    // EJEMPLO:
    // En una carta roja de skip, getColor retorna R, getTipo retorna S, se combinan y forma RS
    // EJEMPLO 2:
    // En una carta de comodin, cuyo color fue puesto en azul, getColor retorna B, getTipo retorna C
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
