package com.notes.infrastructure.persistence.db.adapter;

import com.notes.domain.model.Nota;
import com.notes.domain.port.out.persistence.NotaAbstract;
import com.notes.infrastructure.persistence.db.entity.NotaEntity;
import com.notes.infrastructure.persistence.db.mapper.NotaMapper;
import com.notes.infrastructure.persistence.db.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NotaPersist implements NotaAbstract {

    @Autowired
    private NotaRepository notaRepository;


    @Override
    public Nota crearNota(Nota nota) {
        NotaEntity notaEntity = NotaMapper.INSTANCE.toNotaEntity(nota);
        this.notaRepository.save(notaEntity);
        return NotaMapper.INSTANCE.toNota(notaEntity);
    }

    @Override
    public Page<Nota> listaDeNotas(Pageable pageable) {
        Page<NotaEntity> notaEntities = this.notaRepository.findAll(pageable);
        return notaEntities.map(NotaMapper.INSTANCE::toNota);
    }

    @Override
    public Optional<Nota> verNota(Long idNota) {
        return this.notaRepository.findById(idNota)
                .map(NotaMapper.INSTANCE::toNota);
    }

    @Override
    public Optional<Nota> encontrarNota(Long idNota) {
        return this.notaRepository.findById(idNota)
                .map(NotaMapper.INSTANCE::toNota);
    }

    @Override
    public Nota editarNota(Nota notaToEdit) {
        NotaEntity notaEntity = NotaMapper.INSTANCE.toNotaEntity(notaToEdit);
        this.notaRepository.save(notaEntity);
        return NotaMapper.INSTANCE.toNota(notaEntity);
    }

    @Override
    public void eliminarNota(Long idNota) {

    }

    @Override
    public void archivarNota(Nota notaToArchive) {
        NotaEntity notaEntity = NotaMapper.INSTANCE.toNotaEntity(notaToArchive);
        this.notaRepository.save(notaEntity);
    }

    @Override
    public Nota desarchivarNota(Nota notaToArchive) {
        NotaEntity notaEntity = NotaMapper.INSTANCE.toNotaEntity(notaToArchive);
        this.notaRepository.save(notaEntity);
        return NotaMapper.INSTANCE.toNota(notaEntity);
    }
}
