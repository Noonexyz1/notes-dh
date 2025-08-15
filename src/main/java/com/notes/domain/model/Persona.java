package com.notes.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
