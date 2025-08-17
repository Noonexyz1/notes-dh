package com.notes.infrastructure.persistence.db.mapper;

import com.notes.domain.model.NotaEtiqueta;
import com.notes.infrastructure.persistence.db.entity.NotaEtiquetaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotaEtiquetaMapper {
    NotaEtiquetaMapper INSTANCE = Mappers.getMapper(NotaEtiquetaMapper.class);

    NotaEtiqueta toNotaEtiqueta(NotaEtiquetaEntity notaEtiquetaSave);
    NotaEtiquetaEntity toNotaEtiquetaEntity(NotaEtiqueta notaEtiqueta);
}
