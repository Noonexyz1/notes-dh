package com.notes.infrastructure.persistence.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Lob
    @Column(nullable = false)
    private String contenido;

    private boolean estaArchivada;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;


    @ManyToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "nota")
    private List<NotaVersion> notaVersionList;
    @OneToMany(mappedBy = "nota")
    private List<DetalleNota> detalleNotaList;
    @OneToMany(mappedBy = "nota")
    private List<NotaArchivada> notaArchivadaList;
    @OneToMany(mappedBy = "nota")
    private List<NotaEtiqueta> notaEtiquetaList;
}
