package com.notes.application.adapter;

import com.notes.domain.model.Nota;
import com.notes.domain.port.in.NotaService;
import com.notes.domain.port.out.persistence.NotaAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@RequiredArgsConstructor
public class NotaAdapter implements NotaService {

    private final NotaAbstract notaAbstract;

    @Override
    public Nota crearNota(Nota nota) {
        return this.notaAbstract.crearNota(nota);
    }

    @Override
    public Page<Nota> listaDeNotas(Pageable pageable) {
        return this.notaAbstract.listaDeNotas(pageable);
    }

    @Override
    public Optional<Nota> verNota(Long idNota) {
        return this.notaAbstract.verNota(idNota);
    }

    @Override
    public Nota editarNota(Long idNota, Nota notaEditada) {
        Optional<Nota> notaEncontrada = this.notaAbstract.encontrarNota(idNota);
        if (notaEncontrada.isEmpty()) {
            throw new RuntimeException("Esta nota no existe");
        }
        Nota notaToEdit = notaEncontrada.get();
        notaToEdit = this.notaAbstract.editarNota(notaToEdit);
        return notaToEdit;
    }

    @Override
    public void eliminarNota(Long idNota) {
        this.notaAbstract.eliminarNota(idNota);
    }

    @Override
    public void archivarNota(Long idNota) {
        Optional<Nota> notaEncontrada = this.notaAbstract.encontrarNota(idNota);
        if (notaEncontrada.isEmpty()) {
            throw new RuntimeException("Esta nota no existe");
        }
        Nota notaToArchive = notaEncontrada.get();
        notaToArchive.setEstaArchivada(true);
        this.notaAbstract.archivarNota(notaToArchive);
    }

    @Override
    public Nota desarchivarNota(Long idNota) {
        Optional<Nota> notaEncontrada = this.notaAbstract.encontrarNota(idNota);
        if (notaEncontrada.isEmpty()) {
            throw new RuntimeException("Esta nota no existe");
        }
        Nota notaToArchive = notaEncontrada.get();
        notaToArchive.setEstaArchivada(false);
        notaToArchive = this.notaAbstract.desarchivarNota(notaToArchive);
        return notaToArchive;
    }
}
