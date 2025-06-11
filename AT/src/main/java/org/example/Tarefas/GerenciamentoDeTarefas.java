package org.example.Tarefas;

import io.javalin.Javalin;
import io.javalin.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class GerenciamentoDeTarefas {
    public static void main(String[] args) {
        List<Tarefa> tarefas = new ArrayList<>();

        Javalin app = Javalin.create(
                javalinConfig -> javalinConfig.http.defaultContentType = "application/json; charset=utf-8"
        ).start(7000);

        // Etapa1 - item 5
        app.post("/tarefas", ctx -> {
            var body = ctx.bodyAsClass(Tarefa.class);

            if (body.titulo == null || body.titulo.isBlank()) {
                ctx.status(HttpStatus.BAD_REQUEST).result("Campo 'titulo' é obrigatório.");
                return;
            }

            Tarefa nova = new Tarefa(body.titulo, body.descricao);
            tarefas.add(nova);

            ctx.status(HttpStatus.CREATED).json(nova);
        });

        // Etapa1 - item 6 - Buscar todos os itens
        app.get("/tarefas", ctx -> ctx.json(tarefas));

        // Etapa1 - item 6 - buscar por ID
        app.get("/tarefas/{id}", ctx -> {
            //UUID id = UUID.fromString(ctx.pathParam("id"));
            String idStr = ctx.pathParam("id");
            UUID id;

            try {
                id = UUID.fromString(idStr);
            } catch (IllegalArgumentException e) {
                ctx.status(HttpStatus.NOT_FOUND).result("ID inválido");
                return;
            }

            var tarefa = tarefas.stream()
                    .filter(t -> t.id.equals(id))
                    .findFirst()
                    .orElse(null);

            ctx.json(tarefa);
        });

        app.get("/status", ctx -> ctx.json(Map.of(
                "status", "ok",
                "timestamp", java.time.Instant.now().toString()
        )));
    }
}
