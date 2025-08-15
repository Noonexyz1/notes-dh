package com.notes.infrastructure.http.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {
    private Long id;
    private String correo;
    private String contrasena;

    private PersonaDTO persona;
}
