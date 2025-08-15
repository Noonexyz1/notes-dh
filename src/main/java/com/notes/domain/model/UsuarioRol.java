package com.notes.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class UsuarioRol {
    private Long id;
    private LocalDateTime createdAt;
    private boolean estaActivo;

    private Usuario usuario;
    private Rol rol;
}
