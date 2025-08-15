package com.notes.domain.model;

import lombok.*;

@Data
@Builder
public class NotaArchivada {
    private Long id;

    private Nota nota;
}
