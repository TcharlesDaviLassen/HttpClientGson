package com.example.jsons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class testeSinc {

    public static final String URL_POST = "https://brasilapi.com.br/api/feriados/v1/2023";

    public static void main(String[] args) throws IOException, InterruptedException {
        // cliente HTTP
            // HttpClient client = HttpClient.newHttpClient();
            // HttpRequest request = (HttpRequest) HttpRequest.newBuilder();

        //// Exemplo Síncrono
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                .uri(URI.create(URL_POST))
                // .timeout(Duration.ofMinutes(2))
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        // System.out.println(response.statusCode());
        // System.out.println(response.body());

        String data = response.body();

        // Cria a instancia pro formato JSON
        // EntityFeriaDTO feriads = new EntityFeriaDTO("99/99/9999","JONH", "nacional");

        // Cria uma instância Gson
        Gson gson = new GsonBuilder()
                .setPrettyPrinting() //// Deixa a informação mais formatada.
                .serializeNulls() 
                // .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                // .setLenient() // sede a permisão pra aceitar as informações.
                .create();

        // final GsonBuilder gsonBuilder = new GsonBuilder();
        // final Gson gson = gsonBuilder.create();

        //// Serialize o objeto – Converta o objeto em uma string JSON
        String jsonString = gson.toJson(data);
        System.out.println("\nConverting object to JSON string:\n" + jsonString);

        //// Desserialize o objeto – Converta a string JSON de volta para o objeto`
        String json = gson.fromJson(jsonString, String.class);
        System.out.println("\nConverting JSON string to Person object:\n" + json.toString());


        // Mesma coisa que o fromJson faz.
        // System.out.println("\nStart point: \n" + jsonString);
        // jsonString = jsonString.substring(1, jsonString.length() - 1);
        // System.out.println("\nGet without \n\": " + jsonString);
        // jsonString = jsonString.replaceAll("\\\\\"", "\"");
        // System.out.println("\nValid: \n" + jsonString);


        // Usa quando for analizar dados JSON de uma matriz, você deverá usar um JsonArray ou um tipo que pode ser desserializado de uma matriz JSON, 
        // como a List ou uma matriz.
        JsonArray jsons = gson.fromJson(data, JsonArray.class);
        System.out.println("\nJson array : \n" + jsons);

        System.out.println("\n");
        for (JsonElement element : jsons) {
            EntityFeriaDTO feriadosDTO = gson.fromJson(element, EntityFeriaDTO.class);
            System.out.println(feriadosDTO.toString());

            // System.out.println(person.getDate().toString().trim());
            // System.out.println(person.getName().toString().trim());
            // System.out.println(person.getType().toString().trim());
        }


        // String urlParaChamada = URL_POST ;
        // URL url = new URL(urlParaChamada);
        // HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        //// Deserializa atraves do BufferedReader
        // BufferedReader resposta = new BufferedReader(new
        // InputStreamReader((conexao.getInputStream())));
        // String jsonEmString = Util.converteJsonEmString(resposta);
        // System.out.println("urlParaChamada: "+ jsonEmString);

        // Type collectionType = new TypeToken<Collection<EntityFeriaDTO>>(){}.getType();
        // Collection<EntityFeriaDTO> enums = gson.fromJson(jsonEmString, collectionType);
        // System.out.println("enums" + enums);




        // JsonReader reader = new JsonReader(new StringReader(json));
        // reader.setLenient(true);
        // String p = gson.fromJson(jsonEmString, String.class);
        // System.out.println("dados: " + p.toString());

        // for (int i = 0; i < enums.toString().length(); i++) {
        // System.out.println("\nConverting JSON string to object:\n" +
        // enums.toString());
        // System.out.println("\nConverting JSON string to object:\n" +
        // enums.getName().toString().trim());
        // System.out.println("\nConverting JSON string to object:\n" +
        // enums.getType().toString().trim());
        // }

        // String jsonStrings = gson.toJson(p);
        // System.out.println("Converting object to JSON string:\n" + jsonStrings);

        // System.out.println("\nConverting JSON string to object:\n" +
        // p.getDate().toString().trim());
        // System.out.println("\nConverting JSON string to object:\n" +
        // p.getName().toString().trim());
        // System.out.println("\nConverting JSON string to object:\n" +
        // p.getType().toString().trim());

    }

    public static class Util {

        public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
            String resposta, jsonEmString = "";
            while ((resposta = buffereReader.readLine()) != null) {
                jsonEmString += resposta;
            }

            return jsonEmString;
        }
    }

}
