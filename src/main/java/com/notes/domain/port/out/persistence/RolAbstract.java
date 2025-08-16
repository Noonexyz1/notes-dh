package com.notes.domain.port.out.persistence;

import com.notes.domain.model.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RolAbstract {
    Rol creaRol(Rol rol);
    Page<Rol> listaDeRoles(Pageable pageable);
}
