package org.example.client;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SimpleHTTPClient {
    private static final Gson gson = new Gson();

    public static String get(String urlStr) throws URISyntaxException, IOException {
        HttpURLConnection conn = getConnection(urlStr, "GET");
        return lerResposta(conn);
    }

    public static String post(String urlStr, Object body) throws URISyntaxException, IOException {
        HttpURLConnection conn = getConnection(urlStr, "POST");

        String jsonInputString = gson.toJson(body);
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input);
        }

        int status = conn.getResponseCode();
        if (status != 200 && status != 201) {
            if (status >= 500 && status <= 599) {
                post(urlStr, body);
            }
                throw new RuntimeException("Erro na requisição POST. Código de resposta : " + status);
        }

        return lerResposta(conn);
    }

    private static HttpURLConnection getConnection(String urlStr, String requestMethod) throws URISyntaxException, IOException {
        URL url = new URI(urlStr).toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(requestMethod);
        conn.setRequestProperty("Accept", "application/json");

        if (requestMethod.equals("POST")) {
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
        }


        return conn;
    }


    private static String lerResposta(HttpURLConnection conn) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine).append("\n");
        }

        in.close();
        conn.disconnect();
        return content.toString();
    }
}
