package Juego.Controlador;

import Juego.Carta.Accion.CartaMasDos;
import Juego.Carta.Accion.CartaRevertir;
import Juego.Carta.Accion.CartaSaltar;
import Juego.Carta.Carta;
import Juego.Carta.CartaNumerica;
import Juego.Carta.Comodin.CartaCambiarColor;
import Juego.Carta.Comodin.CartaMasCuatro;
import Juego.Carta.Pila.PilaJugar;
import Juego.Carta.Pila.PilaTomar;
import Juego.Jugador.Computador;
import Juego.Jugador.Humano;
import Juego.Jugador.Jugador;
import Juego.Jugador.Jugadores;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Cargador {
    public Cargador() {

    }

    /**
     * Transforma un string del camino al archivo .json en un JSONObject para lectura
     * @param path
     * @return
     * @throws IOException
     * @throws ParseException
     */
    private JSONObject fromPathToJSONObject(String path) throws IOException, ParseException {
        return (JSONObject) new JSONParser().parse(new FileReader(path));
    }

    /**
     * Transforma un objeto de tipo JSONObject en una Carta
     * @param carta
     * @return
     */
    private Carta fromJSONObjectToCarta(JSONObject carta) {
        String numero;
        String tipo;
        char color;

        if (carta.containsKey("tipo") && carta.containsKey("colorSeleccionado")) {
            tipo = carta.get("tipo").toString();
            color = carta.get("colorSeleccionado").toString().charAt(0);
            return tipo.equals("T4") ? new CartaMasCuatro(color) : new CartaCambiarColor(color);
        }

        if (carta.containsKey("color") && carta.containsKey("numero")) {
            numero = carta.get("numero").toString();
            color = carta.get("color").toString().charAt(0);
            return new CartaNumerica(color, numero);
        }

        tipo = carta.get("tipo").toString();
        color = carta.get("color").toString().charAt(0);
        switch (tipo) {
            case "R":
                return new CartaRevertir(color);
            case "T2":
                return new CartaMasDos(color);
            case "S":
                return new CartaSaltar(color);
        }
        return null;
    }

    /**
     * Metodo encargado de cargar los jugadores
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public Jugadores cargarJugadores() throws IOException, ParseException {
        JSONObject objeto = fromPathToJSONObject("src/Juego/Controlador/listaJugadores.json");
        JSONArray listaJugadoresJson = (JSONArray) objeto.get("listaJugadores");

        Jugadores listaJugadores = new Jugadores();
        listaJugadores.setIndex(objeto.containsKey("index") ? Integer.parseInt(objeto.get("index").toString()) : 0);

        for (Object jugadorObject : listaJugadoresJson) {
            JSONObject jugadorJSON = (JSONObject) jugadorObject;
            String nombreJugador = jugadorJSON.containsKey("nombre")
                    ? jugadorJSON.get("nombre").toString()
                    : "Jugador";
            Jugador jugador = jugadorJSON.containsKey("tipo") && jugadorJSON.get("tipo").equals("H")
                    ? new Humano(nombreJugador)
                    : new Computador("CPU");

            JSONArray mazoArray = (JSONArray) jugadorJSON.get("mazo");
            for (Object cartaObject : mazoArray)
                jugador.agregarCarta(fromJSONObjectToCarta((JSONObject) cartaObject));

            listaJugadores.agregarJugador(jugador);
        }
        return listaJugadores;
    }

    /**
     * Metodo encargado de cargar la Pila Tomar
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public PilaTomar cargarPilaTomar() throws IOException, ParseException {
        JSONObject objeto = fromPathToJSONObject("src/Juego/Controlador/pilaTomar.json");
        JSONArray listaCartas = (JSONArray) objeto.get("listaCartas");

        PilaTomar pilaTomar = new PilaTomar();
        for (Object cartaActual : listaCartas)
            pilaTomar.agregarCarta(fromJSONObjectToCarta((JSONObject) cartaActual));

        return pilaTomar;
    }

    /**
     * Metodo encargado de cargar la PilaJugar
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public PilaJugar cargarPilaJugar() throws IOException, ParseException {
        JSONObject objeto = fromPathToJSONObject("src/Juego/Controlador/pilaJugar.json");
        JSONArray listaCartas = (JSONArray) objeto.get("listaCartas");

        PilaJugar pilaJugar = new PilaJugar();
        for (Object cartaActual : listaCartas)
            pilaJugar.agregarCarta(fromJSONObjectToCarta((JSONObject) cartaActual));

        return pilaJugar;
    }

    /**
     * Metodo encargado de cargar si se esta saltando un turno
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public boolean cargarSaltarTurno() throws IOException, ParseException {
        JSONObject objeto = fromPathToJSONObject("src/Juego/Controlador/juego.json");
        return (boolean) objeto.get("saltarTurno");
    }

    /**
     * Metodo encargado de cargar las cartas que tiene que tomar el siguiente jugador
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public int cargarCartasAtomar() throws IOException, ParseException {
        JSONObject objeto = fromPathToJSONObject("src/Juego/Controlador/juego.json");
        return (int) (long) objeto.get("cartasATomar");
    }
}