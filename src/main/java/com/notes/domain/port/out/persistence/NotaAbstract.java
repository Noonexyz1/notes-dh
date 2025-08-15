package com.notes.domain.port.out.persistence;

import com.notes.domain.model.Nota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NotaAbstract {
    Nota crearNota(Nota nota);
    Page<Nota> listaDeNotas(Pageable pageable);
    Optional<Nota> verNota(Long idNota);
    Optional<Nota> encontrarNota(Long idNota);
    Nota editarNota(Nota notaToEdit);
    void eliminarNota(Long idNota);
    void archivarNota(Nota notaToArchive);
    Nota desarchivarNota(Nota notaToArchive);
}
