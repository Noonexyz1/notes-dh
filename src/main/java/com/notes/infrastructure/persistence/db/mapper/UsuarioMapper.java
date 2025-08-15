package com.notes.infrastructure.persistence.db.mapper;

import com.notes.domain.model.Usuario;
import com.notes.infrastructure.persistence.db.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toUsuario(UsuarioEntity usuarioEntity);
    UsuarioEntity toUsuarioEntity(Usuario usuario);
}
