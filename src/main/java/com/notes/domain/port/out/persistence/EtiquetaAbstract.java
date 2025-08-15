package com.notes.domain.port.out.persistence;

import com.notes.domain.model.Etiqueta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EtiquetaAbstract {
    Etiqueta crearEtiqueta(Etiqueta etiqueta);
    Page<Etiqueta> listaDeEtiquetas(Pageable pageable);
    void eliminarEtiqueta(Long idEtiqueta);
}
