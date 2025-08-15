package com.notes.infrastructure.http.controller;

import com.notes.domain.model.Nota;
import com.notes.domain.port.in.NotaService;
import com.notes.infrastructure.http.dto.NotaDTO;
import com.notes.infrastructure.http.mapper.NotaDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/nota")
public class NotaController {

    @Autowired
    private NotaService notaService;

    // POST /api/v1/notas
    @PostMapping
    public ResponseEntity<NotaDTO> crearNota(@RequestBody NotaDTO notaDTO) {
        Nota nota = NotaDTOMapper.INSTANCE.toNota(notaDTO);
        Nota notaCreada = notaService.crearNota(nota);
        NotaDTO responseDTO = NotaDTOMapper.INSTANCE.toNotaDTO(notaCreada);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // GET /api/v1/notas?page=0&size=10&sort=createdAt,desc
    @GetMapping
    public ResponseEntity<Page<NotaDTO>> listaDeNotas(Pageable pageable) {
        Page<Nota> notas = notaService.listaDeNotas(pageable);
        Page<NotaDTO> dtoPage = notas.map(NotaDTOMapper.INSTANCE::toNotaDTO);
        return ResponseEntity.ok(dtoPage);
    }

    // GET /api/v1/notas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<NotaDTO> verNota(@PathVariable Long id) {
        Optional<Nota> nota = notaService.verNota(id);
        return nota.map(n -> ResponseEntity.ok(NotaDTOMapper.INSTANCE.toNotaDTO(n)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT /api/v1/notas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<NotaDTO> editarNota(
            @PathVariable Long id,
            @RequestBody NotaDTO notaDTO ) {

        Nota nota = NotaDTOMapper.INSTANCE.toNota(notaDTO);
        Nota notaActualizada = notaService.editarNota(id, nota);
        NotaDTO responseDTO = NotaDTOMapper.INSTANCE.toNotaDTO(notaActualizada);
        return ResponseEntity.ok(responseDTO);
    }

    // DELETE /api/v1/notas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNota(@PathVariable Long id) {
        notaService.eliminarNota(id);
        return ResponseEntity.noContent().build();
    }

    // PATCH /api/v1/notas/{id}/archivar
    @PatchMapping("/{id}/archivar")
    public ResponseEntity<Void> archivarNota(@PathVariable Long id) {
        notaService.archivarNota(id);
        return ResponseEntity.noContent().build();
    }

    // PATCH /api/v1/notas/{id}/desarchivar
    @PatchMapping("/{id}/desarchivar")
    public ResponseEntity<NotaDTO> desarchivarNota(@PathVariable Long id) {
        Nota nota = notaService.desarchivarNota(id);
        NotaDTO responseDTO = NotaDTOMapper.INSTANCE.toNotaDTO(nota);
        return ResponseEntity.ok(responseDTO);
    }
}
