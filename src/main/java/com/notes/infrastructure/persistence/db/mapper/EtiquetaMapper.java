package com.notes.infrastructure.persistence.db.mapper;

import com.notes.domain.model.Etiqueta;
import com.notes.domain.model.Nota;
import com.notes.infrastructure.persistence.db.entity.EtiquetaEntity;
import com.notes.infrastructure.persistence.db.entity.NotaEntity;
import org.hibernate.engine.spi.EntityEntry;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EtiquetaMapper {
    EtiquetaMapper INSTANCE = Mappers.getMapper(EtiquetaMapper.class);

    Etiqueta toEtiqueta(EtiquetaEntity etiquetaEntity);
    EtiquetaEntity toEtiquetaEntity(Etiqueta etiqueta);
}
