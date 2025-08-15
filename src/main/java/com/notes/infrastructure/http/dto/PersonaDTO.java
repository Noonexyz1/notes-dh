package com.notes.infrastructure.http.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PersonaDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
