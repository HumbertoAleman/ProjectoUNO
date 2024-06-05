package Juego.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jugadores {
    private List<Jugador> listaJugadores = new ArrayList<>();
    /**
     * Constructor jugadores
     */
    public Jugadores(){
    }
    /**
     * Constructor Jugadores
     * 
     * @param listaJugadores Lista de jugadores con los que inicializar la lista
     */
    public Jugadores(ArrayList<Jugador> listaJugadores){
        this.listaJugadores = listaJugadores;
    }
    /**
     * Obtiene la lista de jugadores
     * 
     * @return lista de jugadores
     */
    public List<Jugador> getListaJugadores() {
        return this.listaJugadores;
    }


    private int index = 0;
    private boolean order = true;
    /**
     * Cambia el turno de los jugaores
     */
    public void cambiarOrden() {
        this.order = !order;
    }
    /**
     * Instancia a los jugadores en una lista
     */
    public void instanciarJugadores() {
        /*for(int i =0; i>numeroHumanos; i++){
            listaJugadores.add(new Humano());
        }*/
        //Implementacion para multijugador
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre");
        Jugador jugadorHumano = new Humano(scanner.nextLine());
        Jugador jugadorComputador = new Computador("CPU");
        listaJugadores.add(jugadorHumano);
        listaJugadores.add(jugadorComputador);

    }
    /**
     * El jugador actual toma turno
     *
     * @return Retorna si el jugador va a salir al menu principal
     */
    public boolean jugadorActualTurno() {
        return listaJugadores.get(index).tomarTurno();
    }
    /**
     * Cambia el turno al siguiente jugador
     */
    public void siguienteJugador() {
        if (order) {
            index = (index + 1) % listaJugadores.size();
            return;
        }
        index = (index - 1) % listaJugadores.size();
    }
    /**
     * Obtiene el jugador actual
     *
     * @return Jugador actual
     */
    public Jugador getJugadorActual(){
        return listaJugadores.get(index);
    }
    /**
     * Valida si el jugador actual es humano
     * 
     * @return true si el jugador actual es humano, false si no
     */
    public boolean validarJugadorHumano() {
        return (listaJugadores.get(index) instanceof Humano);
    }
    /**
     * Valida si el jugador actual es un computador
     * 
     * @return true si el jugador actual es un computador, false si no
     */
    public boolean validarJugadorComputador() {
        return (listaJugadores.get(index) instanceof Computador);
    }
    /**
     * Obtiene la cantidad de cartas del mazo del jugador actual
     * 
     * @return cantidad de cartas 
     */
    public int getNumCartasJugadorActual() {
        return listaJugadores.get(index).getCantidadDeCartas();
    }
    /**
     * Obtiene la catidad de jugadores en la partida
     * 
     * @return cantidad de jugadores
     */
    public int size() {
        return listaJugadores.size();
    }


    //Esta funcion es unicamente usada al cargar
    /**
     * Agrega un jugador a la lista de jugadores
     * 
     * @param jugador un jugador
     */
    public void agregarJugador(Jugador jugador){
        listaJugadores.add(jugador);
    }
    /**
     * Asigna a quien le toca el turno
     * 
     * @param index posicion del turno del personaje actual
     */
    public void setIndex(int index){
        this.index = index;
    }
    /**
     * Asigna el orden de jugadores
     * 
     * @param order orden de jugadores
     */
    public void setOrder(boolean order){
        this.order = order;
    }
}
