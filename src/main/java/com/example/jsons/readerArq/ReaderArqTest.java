package com.example.jsons.readerArq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class ReaderArqTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        // String readerJson = String.join(" ",
        // Files.readAllLines(
        // Paths.get("./dadostes.json"),
        // StandardCharsets.UTF_8)
        // );

        // // Cria uma instância Gson
        // Gson gson = new GsonBuilder()
        // .setPrettyPrinting() //// Deixa a informação mais formatada.
        // .serializeNulls()
        // // .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        // // .setLenient() // sede a permisão pra aceitar as informações.
        // .create();

        // final GsonBuilder gsonBuilder = new GsonBuilder();
        // final Gson gson = gsonBuilder.create();

        //// Serialize o objeto – Converta o objeto em uma string JSON
        // String jsonString = gson.toJson(readerJson);
        // System.out.println("\nConverting object to JSON string:\n" + jsonString);

        //// Desserialize o objeto – Converta a string JSON de volta para o objeto`
        // DadostesteImpl json = gson.fromJson(readerJson, DadostesteImpl.class);
        // System.out.println("\nConverting JSON string to object:\n" +
        //// json.toString());

        try {
            File filePath = new File("src/main/java/com/example/jsons/dadostes.json");
            loadJSON(filePath);

        } catch (Exception e) {
            // Logger.getLogger(GsonExample.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR" + e.getMessage());
        }

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

    public static void createJSON() {
        // Pedido pedido = new Pedido();

        // Cliente cliente = new Cliente();
        // cliente.setId(12);
        // cliente.setNome("Guilherme Haynes");

        // pedido.setId(1234);
        // pedido.setCliente(cliente);

        // for (int i = 1; i <= 3; i++) {
        // ItemPedido item = new ItemPedido();
        // item.setId(i);
        // item.setDescricao("Item " + i);
        // item.setQtd(10);
        // pedido.getItens().add(item);
        // }

        // Gson gson = new Gson();
        // String json = gson.toJson(pedido);

        // System.out.println(json);
    }

    public static void loadJSON(File filePath) throws FileNotFoundException {

        Reader reader = new FileReader(filePath);

        Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .serializeNulls() 
        .create();

        JsonArray arrayJson = gson.fromJson(reader, JsonArray.class);

        int count = 0;
        for (JsonElement jsonElement : arrayJson) {
            count++;
            DadostesteImpl pedido = gson.fromJson(jsonElement, DadostesteImpl.class);

            System.out.println("\nArray: "+ count +" " + jsonElement+ "\n");

            // System.out.println("Pedido nº: " + pedido.get_Description());
            // System.out.println("Pedido nº: " + pedido.get_Fetched_at());
            // System.out.println("Pedido nº: " + pedido.get_Icon_url());
            // System.out.println("Pedido nº: " + pedido.get_Id());
            // System.out.println("Pedido nº: " + pedido.get_Language());
            // System.out.println("Pedido nº: " + pedido.get_Logo_url());
            // System.out.println("Pedido nº: " + pedido.get_Modified());
            // System.out.println("Pedido nº: " + pedido.get_Title());
            // System.out.println("Pedido nº: " + pedido.get_Updated_at());
            // System.out.println("Pedido nº: " + pedido.get_Url());
        }

        // System.out.println("Pedido nº: " + pedido.getId());
        // System.out.println("Cliente nº: " + pedido.getCliente().getId() + " | Nome: "
        // + pedido.getCliente().getNome());
        // System.out.println("Itens: ");
        // for (ItemPedido item : pedido.getItens()) {
        // System.out.println("----------------------------------------------------------");
        // System.out.println(" Ped. nº: " + item);
        // System.out.println(" Ped. nº: " + item.getId());
        // System.out.println(" Item: " + item.getDescricao());
        // System.out.println(" Qtd: " + item.getQtd());
        // }

    }

}
