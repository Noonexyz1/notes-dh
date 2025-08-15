package com.notes.infrastructure.persistence.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "detalle_nota")
public class DetalleNotaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String observaciones;

    private boolean esPrivado;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaCreacion;

    @ManyToOne
    private NotaEntity nota;
}
