package com.notes.infrastructure.persistence.db.mapper;

import com.notes.domain.model.Rol;
import com.notes.infrastructure.persistence.db.entity.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolMapper {
    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    Rol toRol(RolEntity rolEntity);
    RolEntity toRolEntity(Rol rol);
}
