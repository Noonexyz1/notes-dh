package com.notes.infrastructure.http.mapper;

import com.notes.domain.model.Etiqueta;
import com.notes.domain.model.Nota;
import com.notes.infrastructure.http.dto.EtiquetaDTO;
import com.notes.infrastructure.http.dto.NotaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EtiquetaDTOMapper {
    EtiquetaDTOMapper INSTANCE = Mappers.getMapper(EtiquetaDTOMapper.class);

    Etiqueta toEtiqueta(EtiquetaDTO etiquetaDTO);
    EtiquetaDTO toEtiquetaDto(Etiqueta etiqueta);
}
