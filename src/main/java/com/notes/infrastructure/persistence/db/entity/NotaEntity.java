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
public class NotaEntity {
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
    private UsuarioEntity usuario;
    @OneToMany(mappedBy = "nota")
    private List<NotaVersionEntity> notaVersionList;
    @OneToMany(mappedBy = "nota")
    private List<DetalleNotaEntity> detalleNotaList;
    @OneToMany(mappedBy = "nota")
    private List<NotaArchivadaEntity> notaArchivadaList;
    @OneToMany(mappedBy = "nota")
    private List<NotaEtiquetaEntity> notaEtiquetaList;
}
