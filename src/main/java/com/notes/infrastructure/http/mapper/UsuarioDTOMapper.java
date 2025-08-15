package com.notes.infrastructure.http.mapper;

import com.notes.domain.model.Usuario;
import com.notes.infrastructure.http.dto.UsuarioDTO;
import com.notes.infrastructure.persistence.db.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioDTOMapper {
    UsuarioDTOMapper INSTANCE = Mappers.getMapper(UsuarioDTOMapper.class);

    Usuario toUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO toUsuarioDto(Usuario usuario);
}
