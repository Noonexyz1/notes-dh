package com.notes.infrastructure.http.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotaDTO {
    private Long id;
    private String titulo;
    private String contenido;
    private boolean estaArchivada;

    private UsuarioDTO usuario;
}
