package Juego.Carta;

public class CartaNumerica extends CartaColorada {
    private String numero;
    /**
     * Constructor de la carta numerica
     */
    public CartaNumerica() {
    }
    /**
     * Constructor de la carta numerica
     * @param color color de la carta
     * @param numero numero de la carta
     */
    public CartaNumerica(char color, String numero) {
        super(color);
        this.numero = numero;
    }
    /**
     * Obtiene el numero de la carta
     * @return numero de la carta
     */
    public String getNumero() { 
        return this.numero; }
    /**
     * Asigna un numero a la carta
     * @param numero numero a asignar a la carta
     */
    public void setNumero(String numero) { 
        this.numero = numero; }
    /**
     * Ejecuta la accion de la carta
     */
    @Override
    public void ejecutarAccion() {
        // Las cartas numericas no tienen accion
    }
    /**
     * Obtiene el tipo de la carta
     * @return tipo de la carta
     */
    @Override
    public String getTipo() {
        return numero;
    }
    /**
     * Muestra la carta
     */
    @Override
    public void mostrarCarta(){
        System.out.print(this.color + this.numero + "  ");
    }
}
