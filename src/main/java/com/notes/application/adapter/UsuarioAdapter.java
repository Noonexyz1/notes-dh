package com.notes.application.adapter;

import com.notes.domain.model.Persona;
import com.notes.domain.model.Usuario;
import com.notes.domain.port.in.UsuarioService;
import com.notes.domain.port.out.persistence.PersonaAbstract;
import com.notes.domain.port.out.persistence.UsuarioAbstract;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UsuarioAdapter implements UsuarioService {

    private final UsuarioAbstract usuarioAbstract;
    private final PersonaAbstract personaAbstract;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        Persona personaSaved = this.personaAbstract
                .guardarPersona(usuario.getPersona());

        usuario.setPersona(personaSaved);
        return this.usuarioAbstract.crearUsuario(usuario);
    }

    @Override
    public Optional<Usuario> buscarUsuario(Long idUsuario) {
        return this.usuarioAbstract.buscarUsuario(idUsuario);
    }
}
