package com.notes.infrastructure.persistence.db.adapter;

import com.notes.domain.model.NotaEtiqueta;
import com.notes.domain.port.out.persistence.NotaEtiquetaAbstract;
import com.notes.infrastructure.persistence.db.entity.NotaEtiquetaEntity;
import com.notes.infrastructure.persistence.db.mapper.NotaEtiquetaMapper;
import com.notes.infrastructure.persistence.db.repository.NotaEtiquetaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotaEtiquetaPersist implements NotaEtiquetaAbstract {

    @Autowired
    private NotaEtiquetaRespository notaEtiquetaRespository;

    @Override
    public NotaEtiqueta crearNotaEtiqueta(NotaEtiqueta notaEtiqueta) {
        NotaEtiquetaEntity notaEtiquetaSave = NotaEtiquetaMapper.INSTANCE
                .toNotaEtiquetaEntity(notaEtiqueta);
        this.notaEtiquetaRespository.save(notaEtiquetaSave);
        return NotaEtiquetaMapper.INSTANCE
                .toNotaEtiqueta(notaEtiquetaSave);
    }
}
