package org.example.Tarefas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Tarefa {
    public UUID id;
    public String titulo;
    public String descricao;
    public boolean concluida;
    public String dataCriacao;

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao) {
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false;
        this.dataCriacao = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
