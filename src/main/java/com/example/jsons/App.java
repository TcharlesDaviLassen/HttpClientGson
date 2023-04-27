package com.example.jsons;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.print.DocFlavor.STRING;
import javax.xml.crypto.Data;

public final class App {

        private App() {
        }

        public static final String URL_POST = "https://brasilapi.com.br/api/feriados/v1/2023";
        // public static final String URL_POST =
        // "https://api.coingecko.com/api/v3/coins/list";
        // public static final String FILE_JSON =
        // "/home/jm/IdeaProjects/HttpExample/pedido.json";

        public static void main(String[] args) throws IOException, InterruptedException {
                // cliente HTTP
                // HttpClient client = HttpClient.newHttpClient();
                // HttpRequest request = (HttpRequest) HttpRequest.newBuilder();

                //// Exemplo Síncrono
                HttpClient client = HttpClient.newBuilder()
                                // .version(Version.HTTP_1_1)
                                // .followRedirects(Redirect.NORMAL)
                                // .connectTimeout(Duration.ofSeconds(20))
                                // .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
                                // .authenticator(Authenticator.getDefault())
                                .build();
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

                // Cria uma instância Gson
                Gson gson = new GsonBuilder()
                                .setPrettyPrinting()
                                .serializeNulls()
                                // .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                                .setLenient()
                                .create();

                // Serialize o objeto – Converta o objeto `Person` em uma string JSON
                String jsonString = gson.toJson(data);

                System.out.println("Converting object to JSON string:\n" + jsonString);

                // Desserialize o objeto – Converta a string JSON de volta para o objeto`
                String json = gson.fromJson(jsonString, String.class);
                
                // System.out.println("Start point: " + json);
                // json = json.substring(1, json.length() - 1);
                // System.out.println("Get without \": " + json);
                // json = json.replaceAll("\\\\\"", "\"");
                // System.out.println("Valid: " + json);

                // JsonReader reader = new JsonReader(new StringReader(json));
                // reader.setLenient(true);        
           

                JsonArray jsons = gson.fromJson(data, JsonArray.class);
                System.out.println("\n");
                for (JsonElement jsonElement : jsons) {
                        EntityFeriaDTO p = gson.fromJson(jsonElement, EntityFeriaDTO.class);
                        System.out.println(p.toString());

                        // System.out.println(p.getDate().toString().trim());
                        // System.out.println(p.getName().toString().trim());
                        // System.out.println(p.getType().toString().trim());
                }



                // System.out.println("Name: " + p.getDate());

                // if (jsonObject.isJsonObject()) {
                // JsonObject jsonObjects = jsonObject.getAsJsonObject();

                // JsonElement f1 = jsonObjects.get("f1");

                // JsonElement f2 = jsonObjects.get("date");

                // if (f2.isJsonObject()) {
                // JsonObject f2Obj = f2.getAsJsonObject();

                // JsonElement f3 = f2Obj.get("f3");
                // }

                // }

                // Gson gson = new Gson();

                // //// Pra ler um arquivo com um JSON
                // // try (Reader reader = new FileReader("c:\\Temp\\arquivo.json"))
                // try (Reader reader = new FileReader(response.body())) {

                // Type listType = new TypeToken<HashMap<String, HashMap<String,
                // List<String>>>>() { }.getType();

                // HashMap<String, HashMap<String, List<String>>> c = gson.fromJson(reader,
                // listType);
                // HashMap<String, List<String>> get = c.get("date");
                // Set<String> items = get.keySet();

                // for (String item : items) {
                // System.out.println(item);
                // // System.out.println(get.get(item));
                // System.out.println("-----------------------");
                // }
                // } catch (IOException e) {

                // }

                // Exemplo assíncrono
                // HttpRequest requestAsync = HttpRequest.newBuilder()
                // .uri(URI.create(URL_POST))
                // // .timeout(Duration.ofMinutes(2))
                // .header("Accept", "application/json")
                // .header("Content-Type", "application/json")
                // // .POST(BodyPublishers.ofFile(Paths.get("file.json")))
                // .build();
                // client.sendAsync(requestAsync, HttpResponse.BodyHandlers.ofString())
                // .thenApply(HttpResponse::body)
                // .thenAccept(System.out::println)
                // .join();

                //// criar a requisição
                // HttpRequest request = HttpRequest.newBuilder()
                // // .POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE_JSON)))
                // // .timeout(Duration.ofSeconds(10))
                // .uri(URI.create(URL_POST))
                // // .POST(URI.create(URL_POST))
                // .build();
                // System.out.println("Http => " + request);

                // client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                // .thenApply(HttpResponse::body)
                // .thenAccept(System.out::println)
                // .join();

                // System.out.println(request.bodyPublisher());

        }

        // HttpURLConnection con = null;

        // try {
        // URL url = new URL(URL_POST);
        // con = (HttpURLConnection) url.openConnection();
        // con.setRequestMethod("GET");
        // con.connect();

        // switch (con.getResponseCode()) {
        // case 200:
        // System.out.println("JSON recebido!");
        // String json = getJson(url);

        // JsonParser parser = new JsonParser();
        // JsonObject obj = (JsonObject) parser.parse(json);

        // Set<Entry<String, JsonElement>> el = obj.entrySet();

        // for (Entry<String, JsonElement> els : el) {
        // if (els.getKey().equals("status")) {
        // System.out.println(els.getKey() + ":" + els.getValue().getAsBoolean());
        // } else if (els.getKey().equals("valores")) {
        // JsonElement e = els.getValue();
        // JsonObject jobj = e.getAsJsonObject();
        // Set<Entry<String, JsonElement>> props = jobj.entrySet();
        // for (Entry<String, JsonElement> prop : props) {
        // System.out.println(prop.getKey() + ":" + String.valueOf(prop.getValue()));
        // }
        // }
        // }
        // break;
        // case 500:
        // System.out.println("Status 500");
        // break;
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // } finally {
        // if (con != null)
        // con.disconnect();
        // }

        // }

        // public static String getJson(URL url) {
        // if (url == null)
        // throw new RuntimeException("URL é null");

        // String html = null;
        // StringBuilder sB = new StringBuilder();
        // try (BufferedReader bR = new BufferedReader(new
        // InputStreamReader(url.openStream()))) {
        // while ((html = bR.readLine()) != null)
        // sB.append(html);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        // return sB.toString();
        // }

        // private String autenticateExample() {
        // final var empr = SessionUtils.getEmpresa();

        // try {
        // final var auth = new AtmAuth();
        // auth.usuario = empr.getAverbacaoUsuario();
        // auth.senha = empr.getAverbacaoSenha();
        // auth.codigoatm = empr.getAverbacaoCodigo();

        // final var client = new OkHttpClient.Builder().readTimeout(10,
        // TimeUnit.MINUTES).build();
        // final var requestBody = RequestBody.create(null, JsonUtils.toString(auth));
        // final var headers = new Headers.Builder()
        // .add("Accept", "application/json")
        // .add("Content-Type", "application/json")
        // .build();
        // final var request = new Request.Builder()
        // .url("http://webserver.averba.com.br/rest/Auth")
        // .headers(headers)
        // .post(requestBody)
        // .build();
        // final var response = client.newCall(request).execute();
        // final var body = response.body().string();
        // final var atmResponse = JsonUtils.toObject(body, AtmAuthResponse.class);

        // if (StringUtils.isEmpty(atmResponse.Bearer)) {
        // throw new BusinessException("error.blank",
        // MessageUtils.addUnparseTag(JsonUtils.beautify(body)));
        // } else {
        // return atmResponse.Bearer;
        // }
        // } catch (BusinessException e) {
        // throw new BusinessException(e.getMessage(), e.getArgs());
        // } catch (Exception e) {
        // e.printStackTrace();

        // throw new BusinessException("error.blank", e.getMessage());
        // }
        // }
}
