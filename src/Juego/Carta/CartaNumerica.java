package Juego.Carta;

public class CartaNumerica extends CartaColorada {
    private String numero;
    public String getNumero() { return this.numero; }
    public void setNumero(String numero) { this.numero = numero; }

    @Override
    public void ejecutarAccion() {
        // NOTA: La accion de las cartas numericas sera cambiar el
    }

    @Override
    public String getTipo() {
        return numero;
    }
}
