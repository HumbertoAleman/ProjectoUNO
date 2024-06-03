package Juego.Controlador;
import Juego.Carta.Pila.PilaJugar;
import Juego.Carta.Pila.PilaTomar;
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
    private String juego;

    public Cargador() {

    }

    public Jugadores cargarJugadores() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\10art\\Documents\\ProjectUNOCARDS\\src\\Juego\\Controlador\\listaJugadores.json");
        Object obj = jsonParser.parse(reader);
        JSONObject auxiliar = (JSONObject) obj;
        JSONArray lista = (JSONArray) auxiliar.get("listaJugadores");
        for(int i =0;i<lista.size(); i++){
            //Ya hay un JSONObject creado, necesitamos iterar sobre cada uno de los elementos del array
            //Y agregarlos, no podemos mapear de una vez el array
            //Intente usar la funcion de Gson que lo mapea si le pasas el nombre de la clase como argumento,
            //pero con constructores vacios es asi imposible usar esa funcion
        }
        //Lo puse por ahora para poder correr el codigo de guardar
        return null;
    }



}
