package com.notes.infrastructure.http.controller;

import com.notes.domain.model.Etiqueta;
import com.notes.domain.port.in.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/etiqueta")
public class EtiquetaController {

    @Autowired
    private EtiquetaService etiquetaService;

    public void crearEtiqueta(Etiqueta etiqueta) {
        Etiqueta easdf = this.etiquetaService.crearEtiqueta(etiqueta);
    }

    public void listaDeEtiquetas(Pageable pageable) {
        Page<Etiqueta> asdf = this.etiquetaService.listaDeEtiquetas(pageable);
    }

    public void eliminarEtiqueta(Long idEtiqueta) {
        this.etiquetaService.eliminarEtiqueta(idEtiqueta);
    }
}
