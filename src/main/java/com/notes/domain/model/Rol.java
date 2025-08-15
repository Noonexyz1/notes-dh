package com.notes.domain.model;

import lombok.*;

@Data
@Builder
public class Rol {
    private Long id;
    private String nombre;
    private String descripcion;
}
