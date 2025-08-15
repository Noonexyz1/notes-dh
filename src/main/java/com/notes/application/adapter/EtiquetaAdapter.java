package com.notes.application.adapter;

import com.notes.domain.model.Etiqueta;
import com.notes.domain.port.in.EtiquetaService;
import com.notes.domain.port.out.persistence.EtiquetaAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class EtiquetaAdapter implements EtiquetaService {

    private final EtiquetaAbstract etiquetaAbstract;

    @Override
    public Etiqueta crearEtiqueta(Etiqueta etiqueta) {
        return this.etiquetaAbstract.crearEtiqueta(etiqueta);
    }

    @Override
    public Page<Etiqueta> listaDeEtiquetas(Pageable pageable) {
        return this.etiquetaAbstract.listaDeEtiquetas(pageable);
    }

    @Override
    public void eliminarEtiqueta(Long idEtiqueta) {
        this.etiquetaAbstract.eliminarEtiqueta(idEtiqueta);
    }
}
