package org.example.etapa1;

import io.javalin.Javalin;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Endpoints {
    public static Javalin criarAplicacao(Javalin app) {
        // Endpoints - item 1
        app.get("/hello", ctx -> {
            ctx.result("Hello, Javalin!");
        });

        // Endpoints - item 2
        app.get("/status", ctx -> {
            var status = Map.of(
                    "status", "ok",
                    "timestamp", ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            );
            ctx.json(status);
        });

        // Endpoints - item 3
        app.post("/echo", ctx -> {
            String msg = ctx.body();
            Map body = ctx.bodyAsClass(Map.class);
            ctx.json(body);
        });

        // Endpoints - item 4
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