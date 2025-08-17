package com.notes.infrastructure.persistence.db.repository;

import com.notes.infrastructure.persistence.db.entity.NotaEtiquetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaEtiquetaRespository extends JpaRepository<NotaEtiquetaEntity, Long> {
}
