package com.notes.infrastructure.http.controller;

import com.notes.domain.model.NotaVersion;
import com.notes.domain.port.in.NotaVersionService;
import com.notes.infrastructure.http.dto.NotaVersionDTO;
import com.notes.infrastructure.http.mapper.NotaVersionDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notaVersion")
public class NotaVersionController {

    @Autowired
    private NotaVersionService notaVersionService;

    // GET /api/v1/notas/1/versiones?page=0&size=10&sort=fechaModificacion,desc
    @GetMapping
    public ResponseEntity<Page<NotaVersionDTO>> obtenerVersionesDeNota(
            @PathVariable Long idNota,
            Pageable pageable) {

        Page<NotaVersion> versiones = notaVersionService.obtenerNotaVersion(idNota, pageable);
        Page<NotaVersionDTO> dtoPage = versiones.map(NotaVersionDTOMapper.INSTANCE::toNotaVersionDto);
        return ResponseEntity.ok(dtoPage);
    }
}
