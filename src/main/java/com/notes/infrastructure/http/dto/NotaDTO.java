package com.notes.infrastructure.http.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotaDTO {
    private Long id;
    private String titulo;
    private String contenido;
    private boolean estaArchivada;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private UsuarioDTO usuario;
}
