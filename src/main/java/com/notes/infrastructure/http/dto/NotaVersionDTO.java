package com.notes.infrastructure.http.dto;

import com.notes.domain.model.Nota;
import com.notes.domain.model.Usuario;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotaVersionDTO {
    private Long id;
    private String contenido;
    private LocalDateTime timestamp;

    private UsuarioDTO usuario;
    private NotaDTO nota;
}
