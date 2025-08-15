package com.notes.infrastructure.persistence.db.mapper;

import com.notes.domain.model.Nota;
import com.notes.domain.model.Usuario;
import com.notes.infrastructure.persistence.db.entity.NotaEntity;
import com.notes.infrastructure.persistence.db.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotaMapper {
    NotaMapper INSTANCE = Mappers.getMapper(NotaMapper.class);

    Nota toNota(NotaEntity nota);
    NotaEntity toNotaEntity(Nota nota);
}
