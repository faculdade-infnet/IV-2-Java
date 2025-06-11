package org.example;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import okhttp3.RequestBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Etapa1Test {
    private Javalin app;

    @BeforeEach
    void setUp() {
        app = Etapa1.criarAplicacao();
    }


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
    public void testCreateItemReturnsStatus201() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.post("/items", RequestBody.create("Novo Item", null));
            assertEquals(201, response.code());
            assertTrue(response.body().string().contains("Novo Item"));
        });
    }

    @DisplayName("Etapa2 - item 3")
    @Test
    public void testGetItemByIdReturnsCorrectItem() {
        JavalinTest.test(app, (server, client) -> {
            var createResp = client.post("/items", RequestBody.create("Item de Busca", null));
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
            client.post("/items", RequestBody.create("Item na Lista", null));

            // Lista os itens
            var listResp = client.get("/items");
            assertEquals(200, listResp.code());
            String responseBody = listResp.body().string();
            assertTrue(responseBody.contains("Item na Lista"));
            assertTrue(responseBody.startsWith("["));
        });
    }
}