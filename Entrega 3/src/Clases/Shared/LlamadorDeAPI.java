package Clases.Shared;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import Clases.ComunidadesYMiembros.Localizacion;
import Clases.ComunidadesYMiembros.TipoLocalizacion;
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

              // Leer la respuesta
              BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
              StringBuilder response = new StringBuilder();
              String inputLine;
              while ((inputLine = br.readLine()) != null) {
                  response.append(inputLine);
              }
              br.close();

              try {
                  JSONObject apiResponse = new JSONObject(response.toString());
                  JSONArray localidades = apiResponse.getJSONArray("localidades");

                  for (int i = 0; i < localidades.length(); i++) {
                	  JSONObject localidad = localidades.getJSONObject(i);
                	  
                      Localizacion locaProvincia = new Localizacion();                      
                      JSONObject provincia = localidad.optJSONObject("provincia");
                      locaProvincia.setNombre(provincia.optString("nombre", "N/A"));
                      locaProvincia.setTipoLocalizacion(TipoLocalizacion.PROVINCIA);
                      locaProvincia.setLocalizacionSuperior(null);
                      
                      Localizacion locaDepartamento = new Localizacion();                 
                      JSONObject departamento = localidad.optJSONObject("departamento");
                      locaDepartamento.setNombre(departamento.optString("nombre", "N/A"));
                      locaDepartamento.setTipoLocalizacion(TipoLocalizacion.DEPARTAMENTO);
                      locaDepartamento.setLocalizacionSuperior(locaProvincia);

                      Localizacion locaMunicipio = new Localizacion();
                      JSONObject municipio = localidad.optJSONObject("municipio");
                      locaMunicipio.setNombre(municipio.optString("nombre", "N/A"));
                      locaMunicipio.setTipoLocalizacion(TipoLocalizacion.MUNICIPIO);
                      locaMunicipio.setLocalizacionSuperior(locaDepartamento);

                      repoLocalizaciones.addLocalizaciones(locaMunicipio);                     
                  }

              } catch (JSONException e) {
                  e.printStackTrace();
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
    }

    public static void llamarGoogleAuth(){
        //esto lo hacemos la entrega que viene
    }
}