package com.notes.infrastructure.persistence.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "nota_etiqueta")
public class NotaEtiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Etiqueta etiqueta;
    @ManyToOne
    private Nota nota;
}
