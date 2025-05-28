package org.example;

import com.google.gson.Gson;
import org.example.client.SimpleHTTPClient;
import org.example.dtos.AgePrediction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        try {
            String ageJson = SimpleHTTPClient.get("https://api.agify.io/?name=bernardo");
            System.out.println("Idade esimada: " + ageJson);

            Gson gson = new Gson();
            AgePrediction agePrediction = gson.fromJson(ageJson, AgePrediction.class);

            System.out.println("Nome: " + agePrediction.name());
            System.out.println("Idade Estimada: " + agePrediction.age());
            System.out.println("Contador: " + agePrediction.count());
        } catch (Exception e) {
            throw new RuntimeException((e));
        }
    }

    private static void agifyExample() throws URISyntaxException, IOException {
        URL url = new URI("https://api.agify.io/?name=bernardo").toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine).append("\n");
        }

        in.close();
        conn.disconnect();

        System.out.println("IDADE ESTIMADA: " + content);
    }

    private static void jsonPlaceHolderExample() throws URISyntaxException, IOException {
        URL url = new URI("https://jsonplaceholder.typicode.com/posts/1").toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Content-Type", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine).append("\n");
        }

        in.close();
        conn.disconnect();

        System.out.println("Resposta JSON: " + content);
    }

    private static void RestAPIExample() throws URISyntaxException, IOException {
        //1. Criar URL
        URL url = new URI("http://api.exemplo.com/dados").toURL();

        //2. Abrir conexão
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        //3. Definir método
        conn.setRequestMethod("GET");

        //4. Definir headers
        conn.setRequestProperty("Accept", "application/json");

        //5. Obter Status HTTP
        int status = conn.getResponseCode();

        //6. Ler resposta
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        //7. Fechar recursos
        in.close();
        conn.disconnect();

        System.out.println(content);
    }
}