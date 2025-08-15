package com.notes.domain.port.out.persistence;

import com.notes.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioAbstract {
    Usuario crearUsuario(Usuario usuario);
    Optional<Usuario> buscarUsuario(Long idUsuario);
}
