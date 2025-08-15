package com.notes.infrastructure.persistence.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
