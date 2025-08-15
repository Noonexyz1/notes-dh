package com.notes.domain.port.in;

import com.notes.domain.model.NotaVersion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotaVersionService {
    Page<NotaVersion> obtenerNotaVersion(Long idNota, Pageable pageable);
}
