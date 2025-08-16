package com.notes.application.adapter;

import com.notes.domain.model.Rol;
import com.notes.domain.port.in.RolService;
import com.notes.domain.port.out.persistence.RolAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class RolAdapter implements RolService {

    private final RolAbstract rolAbstract;


    @Override
    public Rol creaRol(Rol rol) {
        return this.rolAbstract.creaRol(rol);
    }

    @Override
    public Page<Rol> listaDeRoles(Pageable pageable) {
        return this.rolAbstract.listaDeRoles(pageable);
    }
}
