package com.notes.infrastructure.http.mapper;

import com.notes.domain.model.Rol;
import com.notes.infrastructure.http.dto.RolDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UsuarioDTOMapper.class})
public interface RolDTOMapper {
    RolDTOMapper INSTANCE = Mappers.getMapper(RolDTOMapper.class);

    Rol toRol(RolDTO rolDTO);
    RolDTO toRolDTO(Rol rol);
}
