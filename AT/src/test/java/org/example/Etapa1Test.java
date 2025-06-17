package org.example;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.example.Tarefas.*;
import org.example.etapa1.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

public class Etapa1Test {
    private static final String URL_BASE ="http://localhost:7000";

    private Javalin createApp() {
        Javalin app = Javalin.create(config -> {
            config.http.defaultContentType = "text/plain; charset=utf-8";
        });
        Endpoints.criarAplicacao(app);
        return app;
    }

    @Test
    @DisplayName("Etapa2 - item 1")
    public void testHelloEndpointReturnsHelloJavalin() {
        JavalinTest.test(createApp(), (server, client) -> {
            var response = client.get("/hello");
            assertEquals(200, response.code());
            assertEquals("Hello, Javalin!", response.body().string());
        });
    }

    @Test
    @DisplayName("Etapa2 - item 2")
    public void testCreateItemReturnsStatus201() throws URISyntaxException, IOException, InterruptedException {
        GerenciamentoDeTarefas.main(null);

        String json = """
            {
                "titulo": "Minha tarefa teste",
                "descricao": "Descrição da tarefa"
            }
            """;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE + "/tarefas"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(201, response.statusCode());
    }

    @Test
    @DisplayName("Etapa2 - item 3")
    public void testGetItemByIdReturnsCorrectItem() throws URISyntaxException, IOException, InterruptedException {
        GerenciamentoDeTarefas.main(null);

        String json = """
            {
                "titulo": "Minha tarefa teste",
                "descricao": "Descrição da tarefa"
            }
            """;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE + "/tarefas"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(201, response.statusCode());

        // Extrai o id da tarefa criada da resposta (assumindo JSON {"id": <id>, ...})
        String responseBody = response.body();
        String id = responseBody.replaceAll(".*\"id\"\\s*:\\s*\"([^\"]+)\".*", "$1");

        // Envia GET para buscar a tarefa pelo id
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI(URL_BASE + "/tarefas/" + id))
                .GET()
                .build();

        HttpResponse<String> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
        assertEquals(200, getResponse.statusCode(), "Status do GET deve ser 200");
        String bodyGet = getResponse.body();

        // Verifica se o corpo da resposta contém os dados que criamos
        assertTrue(bodyGet.contains("Minha tarefa teste"), "Resposta deve conter o título");
        assertTrue(bodyGet.contains("Descrição da tarefa"), "Resposta deve conter a descrição");
    }


    @Test
    @DisplayName("Etapa2 - item 4")
    public void testListItemsReturnsNonEmptyArray() {
        JavalinTest.test(createApp(), (server, client) -> {
            // Cria um item
            client.post("/tarefa", RequestBody.create("Tarefa na Lista", null));

            // Lista os itens
            var listResp = client.get("/tarefas");
            assertEquals(200, listResp.code());
            String responseBody = listResp.body().string();
            assertTrue(responseBody.contains("Item na Lista"));
            assertTrue(responseBody.startsWith("["));
        });
    }
}