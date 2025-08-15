package com.notes.domain.port.in;

import com.notes.domain.model.Nota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NotaService {
    Nota crearNota(Nota nota);
    Page<Nota> listaDeNotas(Pageable pageable);
    Optional<Nota> verNota(Long idNota);
    Nota editarNota(Long idNota, Nota notaEditada);
    void eliminarNota(Long idNota);
    void archivarNota(Long idNota);
    Nota desarchivarNota(Long idNota);
}
