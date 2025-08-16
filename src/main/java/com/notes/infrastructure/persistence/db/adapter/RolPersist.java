package com.notes.infrastructure.persistence.db.adapter;

import com.notes.domain.model.Rol;
import com.notes.domain.port.out.persistence.RolAbstract;
import com.notes.infrastructure.persistence.db.entity.RolEntity;
import com.notes.infrastructure.persistence.db.mapper.RolMapper;
import com.notes.infrastructure.persistence.db.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class RolPersist implements RolAbstract {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Rol creaRol(Rol rol) {
        RolEntity rolEntity = RolMapper.INSTANCE.toRolEntity(rol);
        this.rolRepository.save(rolEntity);
        return RolMapper.INSTANCE.toRol(rolEntity);
    }

    @Override
    public Page<Rol> listaDeRoles(Pageable pageable) {
        Page<RolEntity> rolEntities = this.rolRepository.findAll(pageable);
        return rolEntities.map(RolMapper.INSTANCE::toRol);
    }

}
