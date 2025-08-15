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
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String contrasena;

    @ManyToOne
    private PersonaEntity persona;
    @OneToMany(mappedBy = "usuario")
    private List<UsuarioRolEntity> usuarioRolList;
    @OneToMany(mappedBy = "usuario")
    private List<NotaEntity> notaList;
    @OneToMany(mappedBy = "usuario")
    private List<NotaVersionEntity> notaVersionList;
}
