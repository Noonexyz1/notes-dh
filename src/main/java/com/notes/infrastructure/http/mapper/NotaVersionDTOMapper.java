package com.notes.infrastructure.http.mapper;

import com.notes.domain.model.Etiqueta;
import com.notes.domain.model.NotaVersion;
import com.notes.infrastructure.http.dto.EtiquetaDTO;
import com.notes.infrastructure.http.dto.NotaVersionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotaVersionDTOMapper {
    NotaVersionDTOMapper INSTANCE = Mappers.getMapper(NotaVersionDTOMapper.class);

    NotaVersion toNotaVersion(NotaVersionDTO notaVersionDTO);
    NotaVersionDTO toNotaVersionDto(NotaVersion notaVersion);
}
