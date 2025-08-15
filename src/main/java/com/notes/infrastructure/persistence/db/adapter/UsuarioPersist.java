package com.notes.infrastructure.persistence.db.adapter;

import com.notes.domain.model.Usuario;
import com.notes.domain.port.out.persistence.UsuarioAbstract;
import com.notes.infrastructure.persistence.db.entity.UsuarioEntity;
import com.notes.infrastructure.persistence.db.mapper.UsuarioMapper;
import com.notes.infrastructure.persistence.db.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioPersist implements UsuarioAbstract {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = UsuarioMapper.INSTANCE
                .toUsuarioEntity(usuario);
        this.usuarioRepository.save(usuarioEntity);
        return UsuarioMapper.INSTANCE.toUsuario(usuarioEntity);
    }

    @Override
    public Optional<Usuario> buscarUsuario(Long idUsuario) {
        Optional<UsuarioEntity> usuarioEncontrado = this.usuarioRepository
                .findById(idUsuario);
        return usuarioEncontrado.map(UsuarioMapper.INSTANCE::toUsuario);
    }
}
