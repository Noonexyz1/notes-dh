package com.notes.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class NotaVersion {
    private Long id;
    private String contenido;
    private LocalDateTime timestamp;

    private Usuario usuario;
    private Nota nota;
}
