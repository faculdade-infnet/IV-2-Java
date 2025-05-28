package org.example;

import com.google.gson.Gson;
import org.example.client.SimpleHTTPClient;
import org.example.dtos.PostRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PostJsonExample {
    public static void main(String[] args) {
        try {
            PostRequest postRequest = new PostRequest("Cavaleiros Templarios",
                    "Aprenda sobre os cavaleiros templarios dos Zodiacos",
                    1);

            String postResponse = SimpleHTTPClient.post("https://jsonplaceholder.typicode.com/posts", postRequest);
            System.out.println("postResponse: " + postResponse);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException((e));
        }
    }

    private static void testePostMunheca() throws URISyntaxException, IOException {
        URL url = new URI("https://jsonplaceholder.typicode.com/posts").toURL();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

//            String jsonInputString = """
//                {
//                    "title": "Olá Post",
//                    "body": "Essa é uma escrita muito legal",
//                    "userId": 1
//                }
//            """;

        Gson gson = new Gson();
        var postRequest = new PostRequest("Olá title", "Olá body do artigo", 2);
        String jsonInputString = gson.toJson(postRequest);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input);
        }

        int status = conn.getResponseCode();
        System.out.println("Código de resposta: " + status);

        String resposta = new String(conn.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        System.out.println("Resposta da API: " + resposta);

        conn.disconnect();
    }
}
