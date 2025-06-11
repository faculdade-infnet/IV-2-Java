package org.example;

import io.javalin.Javalin;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Etapa1 {
    public static void main(String[] args) {
        criarAplicacao().start(7000);
    }

    public static Javalin criarAplicacao() {
        Javalin app = Javalin.create(
                javalinConfig -> javalinConfig.http.defaultContentType = "text/plain; charset=utf-8"
        );

        // Etapa1 - item 1
        app.get("/hello", ctx -> {
            ctx.result("Hello, Javalin!");
        });

        // Etapa1 - item 2
        app.get("/status", ctx -> {
            var status = Map.of(
                    "status", "ok",
                    "timestamp", ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            );
            ctx.json(status);
        });

        // Etapa1 - item 3
        app.post("/echo", ctx -> {
            String msg = ctx.body();
            Map body = ctx.bodyAsClass(Map.class);
            ctx.json(body);
        });

        // Etapa1 - item 4
        app.get("/saudacao/{nome}", ctx -> {
            ctx.contentType("application/json; charset=utf-8");
            String nome = ctx.pathParam("nome");
            String json = """
                    {
                        "mensagem": "Olá %s!"
                    }
                    """.formatted(nome);
            ctx.result(json);
        });

        return app;
    }
}