package com.notes.infrastructure.http.controller;

import com.notes.domain.model.Etiqueta;
import com.notes.domain.port.in.EtiquetaService;
import com.notes.infrastructure.http.dto.EtiquetaDTO;
import com.notes.infrastructure.http.mapper.EtiquetaDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/etiqueta")
public class EtiquetaController {

    @Autowired
    private EtiquetaService etiquetaService;

    // POST /api/v1/etiquetas
    @PostMapping
    public ResponseEntity<EtiquetaDTO> crearEtiqueta(@RequestBody EtiquetaDTO etiquetaDTO) {
        Etiqueta etiqueta = EtiquetaDTOMapper.INSTANCE.toEtiqueta(etiquetaDTO);
        Etiqueta etiquetaCreada = etiquetaService.crearEtiqueta(etiqueta);
        EtiquetaDTO responseDTO = EtiquetaDTOMapper.INSTANCE.toEtiquetaDto(etiquetaCreada);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // GET /api/v1/etiquetas?page=0&size=10&sort=nombre,asc
    @GetMapping
    public ResponseEntity<Page<EtiquetaDTO>> listaDeEtiquetas(Pageable pageable) {
        Page<Etiqueta> etiquetas = etiquetaService.listaDeEtiquetas(pageable);
        Page<EtiquetaDTO> dtoPage = etiquetas.map(EtiquetaDTOMapper.INSTANCE::toEtiquetaDto);
        return ResponseEntity.ok(dtoPage);
    }

    // DELETE /api/v1/etiquetas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEtiqueta(@PathVariable Long id) {
        etiquetaService.eliminarEtiqueta(id);
        return ResponseEntity.noContent().build();
    }
}
