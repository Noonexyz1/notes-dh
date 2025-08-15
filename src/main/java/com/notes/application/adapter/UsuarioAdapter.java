package com.notes.application.adapter;

import com.notes.domain.model.Usuario;
import com.notes.domain.port.in.UsuarioService;
import com.notes.domain.port.out.persistence.UsuarioAbstract;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UsuarioAdapter implements UsuarioService {

    private final UsuarioAbstract usuarioAbstract;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return this.usuarioAbstract.crearUsuario(usuario);
    }

    @Override
    public Optional<Usuario> buscarUsuario(Long idUsuario) {
        return this.usuarioAbstract.buscarUsuario(idUsuario);
    }
}
