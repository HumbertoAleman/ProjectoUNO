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
import com.google.gson.Gson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Cargador {
    private Gson gson = new Gson();
    private char color;
    private String tipo;
    private JSONObject carta;
    private String juego;

    public Cargador() {

    }

    public Jugadores cargarJugadores() throws IOException, ParseException {
        Jugadores listaJugadores = new Jugadores();
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/Juego/Controlador/listaJugadores.json");
        Object obj = jsonParser.parse(reader);
        JSONObject objeto = (JSONObject) obj;
        JSONArray listaJugadoresJson = (JSONArray) objeto.get("listaJugadores");
        Jugador humano = new Humano();
        Jugador computador = new Computador();
        Jugador jugador;
        for (int i = 0; i < listaJugadoresJson.size(); i++) {
            JSONObject jugadorJSON = (JSONObject) listaJugadoresJson.get(i);
            JSONArray mazo = (JSONArray) jugadorJSON.get("mazo");
            //Top idioteces que he hecho, para la proxima entrega deberiamos de colocar un distinctivo entre humanos y computadores en el JSON
            //Para instanciarlos de manera distinta al crear. Si queda tiempo lo implementamos debidamente.
            //Aqui se asume que el jugador en index 0 es el hum
            int j;
            if (i == 0) {
                jugador = humano;
            } else {
                jugador = computador;
            }
            for (j = 0; j < mazo.size(); j++) {
                carta = (JSONObject) mazo.get(j);
                if (carta.containsKey("tipo") && carta.containsKey("colorSeleccionado")) {
                    if (carta.get("tipo") == "T4") {
                        jugador.agregarCarta(new CartaMasCuatro());
                    } else {
                        jugador.agregarCarta(new CartaCambiarColor());
                    }
                } else if (carta.containsKey("numero")) {
                    jugador.agregarCarta(new CartaNumerica(carta.get("color").toString().charAt(0), carta.get("numero").toString()));
                } else if (carta.containsKey("tipo")) {
                    tipo = carta.get("tipo").toString();
                    switch (tipo) {
                        case "R":
                            jugador.agregarCarta(new CartaRevertir(carta.get("color").toString().charAt(0)));
                            break;
                        case "T2":
                            jugador.agregarCarta(new CartaMasDos(carta.get("color").toString().charAt(0)));
                            break;
                        case "S":
                            jugador.agregarCarta(new CartaSaltar(carta.get("color").toString().charAt(0)));
                    }
                }
            }

        }
        listaJugadores.agregarJugador(humano);
        listaJugadores.agregarJugador(computador);
        return listaJugadores;

    }

    public PilaTomar cargarPilaTomar() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        PilaTomar pilaTomar = new PilaTomar();

        FileReader reader = new FileReader("src/Juego/Controlador/pilaTomar.json");
        Object obj = jsonParser.parse(reader);
        JSONObject objeto = (JSONObject) obj;
        JSONArray listaCartas = (JSONArray) objeto.get("listaCartas");
        for (Object cartaActual : listaCartas) {
            carta = (JSONObject) cartaActual;
            if (carta.containsKey("tipo") && carta.containsKey("colorSeleccionado")) {
                if (carta.get("tipo") == "T4") {
                    pilaTomar.agregarCarta(new CartaMasCuatro());
                } else {
                    pilaTomar.agregarCarta(new CartaCambiarColor());
                }
            } else if (carta.containsKey("numero")) {
                pilaTomar.agregarCarta(new CartaNumerica(carta.get("color").toString().charAt(0), carta.get("numero").toString()));
            } else if (carta.containsKey("tipo")) {
                tipo = carta.get("tipo").toString();
                switch (tipo) {
                    case "R":
                        pilaTomar.agregarCarta(new CartaRevertir(carta.get("color").toString().charAt(0)));
                        break;
                    case "T2":
                        pilaTomar.agregarCarta(new CartaMasDos(carta.get("color").toString().charAt(0)));
                        break;
                    case "S":
                        pilaTomar.agregarCarta(new CartaSaltar(carta.get("color").toString().charAt(0)));
                }

            }

        }

        return pilaTomar;
    }

    public PilaJugar cargarPilaJugar() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        PilaJugar pilaJugar = new PilaJugar();

        FileReader reader = new FileReader("src/Juego/Controlador/pilaJugar.json");
        Object obj = jsonParser.parse(reader);
        JSONObject objeto = (JSONObject) obj;
        JSONArray listaCartas = (JSONArray) objeto.get("listaCartas");
        for (Object cartaActual : listaCartas) {
            carta = (JSONObject) cartaActual;
            if (carta.containsKey("tipo") && carta.containsKey("colorSeleccionado")) {
                if (carta.get("tipo") == "T4") {
                    pilaJugar.agregarCarta(new CartaMasCuatro());
                } else {
                    pilaJugar.agregarCarta(new CartaCambiarColor());
                }
            } else if (carta.containsKey("numero")) {
                pilaJugar.agregarCarta(new CartaNumerica(carta.get("color").toString().charAt(0), carta.get("numero").toString()));
            } else if (carta.containsKey("tipo")) {
                tipo = carta.get("tipo").toString();
                switch (tipo) {
                    case "R":
                        pilaJugar.agregarCarta(new CartaRevertir(carta.get("color").toString().charAt(0)));
                        break;
                    case "T2":
                        pilaJugar.agregarCarta(new CartaMasDos(carta.get("color").toString().charAt(0)));
                        break;
                    case "S":
                        pilaJugar.agregarCarta(new CartaSaltar(carta.get("color").toString().charAt(0)));
                }

            }

        }

        return pilaJugar;
    }

    public boolean cargarSaltarTurno () throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/Juego/Controlador/juego.json");
        Object obj = jsonParser.parse(reader);
        JSONObject objeto = (JSONObject) obj;
        return (boolean) objeto.get("saltarTurno");

    }

    public int cargarCartasAtomar() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/Juego/Controlador/juego.json");
        Object obj = jsonParser.parse(reader);
        JSONObject objeto = (JSONObject) obj;
        return (int)(long) objeto.get("cartasATomar");
    }
}
