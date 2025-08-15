package com.notes.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class Nota {
    private Long id;
    private String titulo;
    private String contenido;
    private boolean estaArchivada;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Usuario usuario;
}
