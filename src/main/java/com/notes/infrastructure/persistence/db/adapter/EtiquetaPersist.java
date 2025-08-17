package com.notes.infrastructure.persistence.db.adapter;

import com.notes.domain.model.Etiqueta;
import com.notes.domain.port.out.persistence.EtiquetaAbstract;
import com.notes.infrastructure.persistence.db.entity.EtiquetaEntity;
import com.notes.infrastructure.persistence.db.mapper.EtiquetaMapper;
import com.notes.infrastructure.persistence.db.repository.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EtiquetaPersist implements EtiquetaAbstract {

    @Autowired
    private EtiquetaRepository etiquetaRepository;


    @Override
    public Etiqueta crearEtiqueta(Etiqueta etiqueta) {
        EtiquetaEntity etiquetaEntity = EtiquetaMapper.INSTANCE.toEtiquetaEntity(etiqueta);
        this.etiquetaRepository.save(etiquetaEntity);
        return EtiquetaMapper.INSTANCE.toEtiqueta(etiquetaEntity);
    }

    @Override
    public Page<Etiqueta> listaDeEtiquetas(Pageable pageable) {
        Page<EtiquetaEntity> entityPage = etiquetaRepository.findAll(pageable);
        return entityPage.map(EtiquetaMapper.INSTANCE::toEtiqueta);
    }

    @Override
    public void eliminarEtiqueta(Long idEtiqueta) {
        if (!etiquetaRepository.existsById(idEtiqueta)) {
            throw new RuntimeException("Etiqueta no encontrada con id: " + idEtiqueta);
        }
        etiquetaRepository.deleteById(idEtiqueta);
    }

    @Override
    public Optional<Etiqueta> encontrarEtiquetaPorId(Long idEtiqueta) {
        Optional<EtiquetaEntity> etiqueta = this.etiquetaRepository.findById(idEtiqueta);
        return etiqueta.map(EtiquetaMapper.INSTANCE::toEtiqueta);
    }
}
