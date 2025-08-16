package com.notes.infrastructure.persistence.db.repository;

import com.notes.infrastructure.persistence.db.entity.NotaEntity;
import com.notes.infrastructure.persistence.db.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
