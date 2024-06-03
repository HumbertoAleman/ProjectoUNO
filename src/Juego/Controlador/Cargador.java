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
import Juego.Jugador.Humano;
import Juego.Jugador.Jugador;
import Juego.Jugador.Jugadores;
import com.google.gson.Gson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
        FileReader reader = new FileReader("C:\\Users\\10art\\Documents\\ProjectUNOCARDS\\src\\Juego\\Controlador\\listaJugadores.json");
        Object obj = jsonParser.parse(reader);
        JSONObject objeto = (JSONObject) obj;
        JSONArray listaJugadoresJson = (JSONArray) objeto.get("listaJugadores");
        for(int i = 0; i<listaJugadoresJson.size(); i++){
            JSONArray mazo = (JSONArray) listaJugadoresJson.get(i);
            //Top idioteces que he hecho, para la proxima entrega deberiamos de colocar un distinctivo entre humanos y computadores en el JSON
            //Para instanciarlos de manera distinta al crear. Si queda tiempo lo implementamos debidamente.
            //Aqui se asume que el jugador en index 0 es el humano
            if (i == 0){
                Jugador humano = new Humano();
                for (int j = 0; j<mazo.size(); j++){
                    carta = (JSONObject) mazo.get(j);
                    if(carta.containsKey("tipo") && carta.containsKey("colorSeleccionado") && carta.get("tipo") == "T4"){
                        humano.agregarCarta(new CartaMasCuatro());
                    } else if (carta.containsKey("tipo") && carta.containsKey("colorSeleccionado")) {
                        humano.agregarCarta(new CartaCambiarColor());
                    } else if(carta.containsKey("numero")){
                        color = carta.get("color").toString().charAt(0);
                        humano.agregarCarta(new CartaNumerica(color, carta.get("numero").toString()));
                    }else if (carta.containsKey("tipo")){
                        tipo = carta.get("tipo").toString();
                        switch(tipo){
                            case "R":
                                humano.agregarCarta(new CartaRevertir(carta.get("color").toString().charAt(0)));
                                break;
                            case "T2":
                                humano.agregarCarta(new CartaMasDos(carta.get("color").toString().charAt(0)));
                                break;
                            case "S":
                                humano.agregarCarta(new CartaSaltar(carta.get("color").toString().charAt(0)));
                        }

                    }
                }

            }else{

            }

        }
        return listaJugadores;
    }



}
