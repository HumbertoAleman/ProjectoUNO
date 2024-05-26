package Juego.Carta;

public class CartaNumerica extends CartaColorada {
    private String numero;

    public CartaNumerica() {
    }
    public CartaNumerica(char color, String numero) {
        super(color);
        this.numero = numero;
    }

    public String getNumero() { 
        return this.numero; }
    public void setNumero(String numero) { 
        this.numero = numero; }

    @Override
    public void ejecutarAccion() {
        // Las cartas numericas no tienen accion
    }

    @Override
    public String getTipo() {
        return numero;
    }

    @Override
    public void mostrarCarta(){
        System.out.print(this.color + this.numero + "  ");
    }
}
