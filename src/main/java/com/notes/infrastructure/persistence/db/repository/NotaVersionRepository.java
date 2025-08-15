package com.notes.infrastructure.persistence.db.repository;

import com.notes.infrastructure.persistence.db.entity.EtiquetaEntity;
import com.notes.infrastructure.persistence.db.entity.NotaVersionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaVersionRepository extends JpaRepository<NotaVersionEntity, Long> {
    Page<NotaVersionEntity> findByNotaId(Long idNota, Pageable pageable);
}
