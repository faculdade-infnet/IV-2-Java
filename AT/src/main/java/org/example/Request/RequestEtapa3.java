package org.example.Request;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public record RequestEtapa3(
        UUID id,
        String titulo,
        String descricao,
        boolean concluida,
        String dataCriacao
) {
}