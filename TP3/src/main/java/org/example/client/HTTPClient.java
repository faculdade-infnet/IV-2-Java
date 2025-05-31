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

public class HTTPClient {
    private static final Gson gson = new Gson();

    // Obtém os itens
    public static String[] get(String urlStr) throws URISyntaxException, IOException {
        HttpURLConnection conn = getConnection(urlStr, "GET");

        int statusCode = conn.getResponseCode();
        String responseMessage = conn.getResponseMessage();
        String body = null;
        if (statusCode != 404) {
            body = lerResposta(conn);
        }

        return new String[]{body, String.valueOf(statusCode), responseMessage};
    }

    // Adiciona um novo item
    public static String[] post(String urlStr, Object body) throws URISyntaxException, IOException {
        HttpURLConnection conn = getConnection(urlStr, "POST");

        // Converte o objeto java para uma String JSON
        String jsonInputString = gson.toJson(body);
        // Converte a String JSON (jsonInputString) em um array de bytes usando a codificação UTF-8
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input);
        }

        int statusCode = conn.getResponseCode();
        String responseMessage = conn.getResponseMessage();

        int status = conn.getResponseCode();
        if (status != 200 && status != 201) {
            if (status >= 500 && status <= 599) {
                post(urlStr, body);
            }
            throw new RuntimeException("Erro na requisição POST. Código de resposta : " + status);
        }

        String responseBody = lerResposta(conn);
        return new String[]{responseBody, String.valueOf(statusCode), responseMessage};
    }

    // Atualiza um item
    public static String[] put(String urlStr, Object body) throws URISyntaxException, IOException {
        HttpURLConnection conn = getConnection(urlStr, "PUT");

        String jsonInputString = gson.toJson(body);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input);
        }

        int statusCode = conn.getResponseCode();
        String responseMessage = conn.getResponseMessage();

        if (statusCode != 200 && statusCode != 201) {
            throw new RuntimeException("Erro na requisição PUT. Código de resposta : " + statusCode);
        }

        String responseBody = lerResposta(conn);
        return new String[]{responseBody, String.valueOf(statusCode), responseMessage};
    }

    // Remove um item
    public static String[] delete(String urlStr) throws URISyntaxException, IOException {
        HttpURLConnection conn = getConnection(urlStr, "DELETE");

        int statusCode = conn.getResponseCode();
        String responseMessage = conn.getResponseMessage();
        String body = null;
        if (statusCode != 404 && statusCode != 204) {
            body = lerResposta(conn);
        }

        return new String[]{body, String.valueOf(statusCode), responseMessage};
    }


    // Cria a conexão com API
    private static HttpURLConnection getConnection(String urlStr, String requestMethod) throws URISyntaxException, IOException {
        URL url = new URI(urlStr).toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // Define o método da requisição GET / POST / PUT / DELETE
        conn.setRequestMethod(requestMethod);
        // Adiciona um cabeçalho informando ao servidor que espera como resposta um JSON
        conn.setRequestProperty("Accept", "application/json");

        // Caso a requisção seja = POST  adiciona o corpo nao envio da requisição
        if (requestMethod.equals("POST") || requestMethod.equals("PUT")) {
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            // informa que a conexão vai enviar dados no copo da requisição
            conn.setDoOutput(true);
        }

        return conn;
    }

    // Obtém a resposta da requisição, fazendo a descerialização dela
    private static String lerResposta(HttpURLConnection conn) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

        // Armazena o retorno lina a linha
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
