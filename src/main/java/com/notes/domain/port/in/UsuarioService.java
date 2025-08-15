package com.notes.domain.port.in;

import com.notes.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    Optional<Usuario> buscarUsuario(Long idUsuario);
}
