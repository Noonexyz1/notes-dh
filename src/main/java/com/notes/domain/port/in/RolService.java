package com.notes.domain.port.in;

import com.notes.domain.model.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RolService {
    Rol creaRol(Rol rol);
    Page<Rol> listaDeRoles(Pageable pageable);
}
