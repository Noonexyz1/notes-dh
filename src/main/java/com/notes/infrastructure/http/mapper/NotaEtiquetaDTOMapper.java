package com.notes.infrastructure.http.mapper;

import com.notes.domain.model.NotaEtiqueta;
import com.notes.infrastructure.http.dto.NotaEtiquetaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UsuarioDTOMapper.class})
public interface NotaEtiquetaDTOMapper {
    NotaEtiquetaDTOMapper INSTANCE = Mappers.getMapper(NotaEtiquetaDTOMapper.class);

    NotaEtiqueta toNotaEtiqueta(NotaEtiquetaDTO notaEtiquetaDTO);
    NotaEtiquetaDTO toNotaEtiquetaDTO(NotaEtiqueta notaEtiquetaSaved);
}
