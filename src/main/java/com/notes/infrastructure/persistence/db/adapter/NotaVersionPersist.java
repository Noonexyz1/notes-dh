package com.notes.infrastructure.persistence.db.adapter;

import com.notes.domain.model.NotaVersion;
import com.notes.domain.port.out.persistence.NotaVersionAbstract;
import com.notes.infrastructure.persistence.db.entity.NotaVersionEntity;
import com.notes.infrastructure.persistence.db.mapper.NotaVersionMapper;
import com.notes.infrastructure.persistence.db.repository.NotaVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class NotaVersionPersist implements NotaVersionAbstract {

    @Autowired
    private NotaVersionRepository notaVersionRepository;

    @Override
    public Page<NotaVersion> obtenerNotaVersion(Long idNota, Pageable pageable) {
        Page<NotaVersionEntity> entities = notaVersionRepository.findByNotaId(idNota, pageable);
        return entities.map(NotaVersionMapper.INSTANCE::toNotaVersion);
    }
}
