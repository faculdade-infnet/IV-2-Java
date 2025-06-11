package org.example;

import org.example.client.HTTPClient;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import okhttp3.RequestBody;
import org.example.Tarefas.Tarefa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;



public class Etapa1Test {
    private final String URL_BASE ="http://localhost:7000";
    Javalin app = Etapa1.criarAplicacao();

    @Test
    @DisplayName("Etapa2 - item 1")
    public void testHelloEndpointReturnsHelloJavalin() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/hello");
            assertEquals(200, response.code());
            assertEquals("Hello, Javalin!", response.body().string());
        });
    }

    @DisplayName("Etapa2 - item 2")
    @Test
    public void testCreateItemReturnsStatus201() throws URISyntaxException, IOException {
        var tarefa = new Tarefa("Compra", "biscoito");

        var response = HTTPClient.post(URL_BASE + "/post", tarefa);
        //SimpleHttpClient.post(URL_BASE + "/post", tarefa);
    }

    @DisplayName("Etapa2 - item 3")
    @Test
    public void testGetItemByIdReturnsCorrectItem() {
        JavalinTest.test(app, (server, client) -> {
            var createResp = client.post("/tarefas", RequestBody.create("Item de Busca", null));
            String json = createResp.body().string();
            int id = Integer.parseInt(json.replaceAll("\\D+", "")); // extrai ID simples

            var getResp = client.get("/items/" + id);
            assertEquals(200, getResp.code());
            assertTrue(getResp.body().string().contains("Item de Busca"));
        });
    }


    @Test
    @DisplayName("Etapa2 - item 4")
    public void testListItemsReturnsNonEmptyArray() {
        JavalinTest.test(app, (server, client) -> {
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