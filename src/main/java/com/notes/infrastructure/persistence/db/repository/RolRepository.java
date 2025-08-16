package com.notes.infrastructure.persistence.db.repository;

import com.notes.infrastructure.persistence.db.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long> {
}
