package com.notes.infrastructure.http.mapper;

import com.notes.domain.model.Nota;
import com.notes.infrastructure.http.dto.NotaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotaDTOMapper {
    NotaDTOMapper INSTANCE = Mappers.getMapper(NotaDTOMapper.class);

    Nota toNota(NotaDTO notaDTO);
    NotaDTO toNotaDTO(Nota nota);
}
