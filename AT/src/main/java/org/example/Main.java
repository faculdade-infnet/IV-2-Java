package org.example;

import io.javalin.Javalin;
import org.example.etapa1.*;
import org.example.Tarefas.*;

public class Main {
    public static void main(String[] args) {
        // Descomnete aquilo que deseja rodar
        //Etapa1();

        Etapa3(args);
    }

    private static void Etapa1() {
        Javalin app = Javalin.create(
                javalinConfig -> javalinConfig.http.defaultContentType = "text/plain; charset=utf-8"
        ).start(7000);

        // Iniciar Servidor Etapa 1
        Endpoints.criarAplicacao(app);
    }


    private static void Etapa3(String[] args) {
        // Iniciar Servidor Etapa 3
        GerenciamentoDeTarefas.main(args);
    }
}
