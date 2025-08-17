package com.notes.infrastructure.http.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotaEtiquetaDTO {
    private Long id;

    private EtiquetaDTO etiqueta;
    private NotaDTO nota;
}
