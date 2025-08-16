package com.notes.infrastructure.persistence.db.adapter;

import com.notes.domain.model.Persona;
import com.notes.domain.port.out.persistence.PersonaAbstract;
import com.notes.infrastructure.persistence.db.entity.PersonaEntity;
import com.notes.infrastructure.persistence.db.mapper.PersonaMapper;
import com.notes.infrastructure.persistence.db.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonaPersist implements PersonaAbstract {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona guardarPersona(Persona persona) {
        PersonaEntity personaEntity = PersonaMapper.INSTANCE
                .toPersonaEntity(persona);
        this.personaRepository.save(personaEntity);
        return PersonaMapper.INSTANCE.toPersona(personaEntity);
    }
}
