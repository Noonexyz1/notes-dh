package com.notes.infrastructure.http.controller;

import com.notes.domain.model.NotaEtiqueta;
import com.notes.domain.port.in.NotaEtiquetaService;
import com.notes.infrastructure.http.dto.NotaEtiquetaDTO;
import com.notes.infrastructure.http.mapper.NotaEtiquetaDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notaEtiqueta")
public class NotaEtiquetaController {

    @Autowired
    private NotaEtiquetaService notaEtiquetaService;

    @PostMapping
    public ResponseEntity<NotaEtiquetaDTO> crearNotaEtiqueta(@RequestBody NotaEtiquetaDTO notaEtiquetaDTO) {
        NotaEtiqueta notaEtiqueta = NotaEtiquetaDTOMapper.INSTANCE
                .toNotaEtiqueta(notaEtiquetaDTO);
        NotaEtiqueta notaEtiquetaSaved = this.notaEtiquetaService
                .crearNotaEtiqueta(notaEtiqueta);
        NotaEtiquetaDTO notaEtiquetaDTOResponse = NotaEtiquetaDTOMapper.INSTANCE
                .toNotaEtiquetaDTO(notaEtiquetaSaved);
        return new ResponseEntity<>(notaEtiquetaDTOResponse, HttpStatus.CREATED);
    }
}
