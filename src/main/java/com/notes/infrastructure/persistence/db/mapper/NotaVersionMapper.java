package com.notes.infrastructure.persistence.db.mapper;

import com.notes.domain.model.Nota;
import com.notes.domain.model.NotaVersion;
import com.notes.domain.port.in.NotaVersionService;
import com.notes.infrastructure.persistence.db.entity.NotaEntity;
import com.notes.infrastructure.persistence.db.entity.NotaVersionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotaVersionMapper {
    NotaVersionMapper INSTANCE = Mappers.getMapper(NotaVersionMapper.class);

    NotaVersion toNotaVersion(NotaVersionEntity notaVersionEntity);
    NotaVersionEntity toNotaVersionEntity(NotaVersion notaVersion);
}
