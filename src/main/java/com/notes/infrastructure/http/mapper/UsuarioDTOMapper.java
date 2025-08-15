package com.notes.infrastructure.http.mapper;

import com.notes.domain.model.Usuario;
import com.notes.infrastructure.http.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioDTOMapper {
    UsuarioDTOMapper INSTANCE = Mappers.getMapper(UsuarioDTOMapper.class);

    Usuario toUsuario(UsuarioDTO usuarioDTO);

    @Mapping(target = "contrasena", ignore = true)
    UsuarioDTO toUsuarioDto(Usuario usuario);
}
