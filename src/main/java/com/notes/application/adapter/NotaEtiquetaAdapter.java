package com.notes.application.adapter;

import com.notes.domain.model.Etiqueta;
import com.notes.domain.model.Nota;
import com.notes.domain.model.NotaEtiqueta;
import com.notes.domain.port.in.NotaEtiquetaService;
import com.notes.domain.port.out.persistence.EtiquetaAbstract;
import com.notes.domain.port.out.persistence.NotaAbstract;
import com.notes.domain.port.out.persistence.NotaEtiquetaAbstract;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class NotaEtiquetaAdapter implements NotaEtiquetaService {

    private final NotaEtiquetaAbstract notaEtiquetaAbstract;
    private final EtiquetaAbstract etiquetaAbstract;
    private final NotaAbstract notaAbstract;

    @Override
    public NotaEtiqueta crearNotaEtiqueta(NotaEtiqueta notaEtiqueta) {

        Optional<Etiqueta> etiqueta = this.etiquetaAbstract
                .encontrarEtiquetaPorId(notaEtiqueta.getEtiqueta().getId());
        Optional<Nota> nota = this.notaAbstract
                .encontrarNota(notaEtiqueta.getNota().getId());

        if (etiqueta.isEmpty() && nota.isEmpty()) {
            throw new RuntimeException("Esta etiqueta y nota no existe");
        }

        notaEtiqueta.setEtiqueta(etiqueta.get());
        notaEtiqueta.setNota(nota.get());
        return this.notaEtiquetaAbstract.crearNotaEtiqueta(notaEtiqueta);
    }
}
