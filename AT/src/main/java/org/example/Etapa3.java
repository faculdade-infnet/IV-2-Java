package org.example;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Etapa3 {
    private static final String BASE_URL = "http://localhost:7000";

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("----- POST /tarefas -----");
        HttpURLConnection conn = configuracoes();

        // ETAPA3 - ITEM 1
        postNovaTarefa(conn,"Estudar Javalin2", "Criar API REST com Javalin");

        // ETAPA3 - ITEM 2
        //getAllItems(conn);

        // ETAPA3 - ITEM 3
        //getTarefaPorId("76cedcee-13f4-4a3f-bb4a-ac07e5b280e2");

        // ETAPA3 - ITEM 4
        //getStatus();
    }

    // Setup
    static HttpURLConnection configuracoes() throws IOException {
        URL url = new URL(BASE_URL + "/tarefas");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        return conn;
    }

    // 1. POST /tarefas
    public static void postNovaTarefa(HttpURLConnection conn, String titulo, String descricao) throws IOException {
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        String itemNovo = String.format("{\"titulo\":\"%s\",\"descricao\":\"%s\"}", titulo, descricao);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = itemNovo.getBytes(StandardCharsets.UTF_8);
            os.write(input);
        }

        System.out.println("Código HTTP: " + conn.getResponseCode());
        conn.disconnect();
    }

    // 2. GET /tarefas
    public static void getAllItems(HttpURLConnection conn) throws IOException {
        conn.setRequestMethod("GET");

        int status = conn.getResponseCode();
        System.out.println("Código HTTP: " + status);

        InputStream inputStream = (status >= 200 && status < 300) ?
                conn.getInputStream() : conn.getErrorStream();

        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        conn.disconnect();

        // Imprime o conteúdo retornado
        System.out.println("Resposta do servidor:");
        System.out.println(content.toString());
    }

    // 3. GET /tarefas/:id
    public static void getTarefaPorId(String id) throws IOException {
        URL url = new URL("http://localhost:7000/tarefas/" + id); // path param
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int status = conn.getResponseCode();
        System.out.println("Código HTTP: " + status);

        InputStream inputStream = (status >= 200 && status < 300) ?
                conn.getInputStream() : conn.getErrorStream();

        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();
        conn.disconnect();

        System.out.println("Resposta do servidor:");
        System.out.println(response.toString());
    }

    // 4. GET /status
    public static void getStatus() throws IOException {
        URL url = new URL(BASE_URL + "/status");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String linha;
        StringBuilder resposta = new StringBuilder();
        while ((linha = in.readLine()) != null) {
            resposta.append(linha);
        }
        in.close();

        System.out.println("Resposta do servidor:");
        System.out.println(resposta.toString());

        conn.disconnect();
    }
}