package Clases.Shared;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import Clases.ComunidadesYMiembros.Localizacion;
import Clases.ComunidadesYMiembros.RepositorioLocalizaciones;

public class LlamadorDeAPI {

    public static void llamarGeoREF(){
        RepositorioLocalizaciones repoLocalizaciones = new RepositorioLocalizaciones();
        String apiUrl = "https://apis.datos.gob.ar/georef/api/localidades?campos=departamento,id,municipio,nombre,provincia&max=4142";

        try {
            // Crear una URL con la dirección de la API
            URL url = new URL(apiUrl);

            // Abrir una conexión HTTP
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Configurar la solicitud
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            System.out.println(conn.getResponseCode());
            // Leer la respuesta
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            // Analizar la respuesta JSON
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(response.toString());
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            // Imprimir la respuesta JSON
            System.out.println(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void llamarGoogleAuth(){
        //esto lo hacemos la entrega que viene
    }
}