package com.notes.infrastructure.persistence.db.repository;

import com.notes.infrastructure.persistence.db.entity.NotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<NotaEntity, Long> {
}
