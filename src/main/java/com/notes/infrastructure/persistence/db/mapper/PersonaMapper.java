package com.notes.infrastructure.persistence.db.mapper;

import com.notes.domain.model.Persona;
import com.notes.domain.model.Usuario;
import com.notes.infrastructure.persistence.db.entity.PersonaEntity;
import com.notes.infrastructure.persistence.db.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    Persona toPersona(PersonaEntity personaEntity);
    PersonaEntity toPersonaEntity(Persona persona);
}
