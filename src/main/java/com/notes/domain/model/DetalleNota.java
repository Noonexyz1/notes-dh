package com.notes.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class DetalleNota {
    private Long id;
    private String observaciones;
    private boolean esPrivado;
    private LocalDateTime fechaCreacion;

    private Nota nota;
}
