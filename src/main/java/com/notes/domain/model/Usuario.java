package com.notes.domain.model;

import lombok.*;

@Data
@Builder
public class Usuario {
    private Long id;
    private String correo;
    private String contrasena;

    private Persona persona;
}
