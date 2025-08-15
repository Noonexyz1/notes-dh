package com.notes.domain.port.out.persistence;

import com.notes.domain.model.NotaVersion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotaVersionAbstract {
    Page<NotaVersion> obtenerNotaVersion(Long idNota, Pageable pageable);
}
