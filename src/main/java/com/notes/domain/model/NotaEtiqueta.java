package com.notes.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class NotaEtiqueta {
    private Long id;
    private LocalDateTime createdAt;

    private Etiqueta etiqueta;
    private Nota nota;
}
