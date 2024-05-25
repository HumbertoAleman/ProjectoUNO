package Juego.Carta;

public interface Carta {
    public void ejecutarAccion();

    // Al combinar la funcion getColor y getTipo, resulta la etiqueta que joselito especifico
    // EJEMPLO:
    // En una carta roja de skip, getColor retorna R, getTipo retorna S, se combinan y forma RS
    // EJEMPLO 2:
    // En una carta de comodin, cuyo color fue puesto en azul, getColor retorna B, getTipo retorna C

    public char getColor();
    public String getTipo();
}
