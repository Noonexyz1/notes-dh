package com.notes.infrastructure.http.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolDTO {
    private Long id;
    private String nombre;
    private String descripcion;
}
