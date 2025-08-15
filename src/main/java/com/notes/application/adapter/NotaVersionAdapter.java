package com.notes.application.adapter;

import com.notes.domain.model.Nota;
import com.notes.domain.model.NotaVersion;
import com.notes.domain.port.in.NotaVersionService;
import com.notes.domain.port.out.persistence.NotaAbstract;
import com.notes.domain.port.out.persistence.NotaVersionAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@RequiredArgsConstructor
public class NotaVersionAdapter implements NotaVersionService {

    private final NotaVersionAbstract notaVersionAbstract;
    private final NotaAbstract notaAbstract;

    @Override
    public Page<NotaVersion> obtenerNotaVersion(Long idNota, Pageable pageable) {
        Optional<Nota> nota = this.notaAbstract.encontrarNota(idNota);
        if (nota.isEmpty()) {
            throw new RuntimeException("Este id de no ta no existe");
        }
        return this.notaVersionAbstract.obtenerNotaVersion(idNota, pageable);
    }
}
