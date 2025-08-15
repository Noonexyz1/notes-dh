package com.notes.infrastructure.persistence.db.repository;

import com.notes.infrastructure.persistence.db.entity.EtiquetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<EtiquetaEntity, Long> {
}
