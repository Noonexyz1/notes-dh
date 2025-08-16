package com.notes.infrastructure.http.controller;

import com.notes.domain.model.Rol;
import com.notes.domain.port.in.RolService;
import com.notes.infrastructure.http.dto.RolDTO;
import com.notes.infrastructure.http.mapper.RolDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    // POST /api/v1/roles
    @PostMapping
    public ResponseEntity<RolDTO> crearRol(@RequestBody RolDTO rolDTO) {
        Rol rol = RolDTOMapper.INSTANCE.toRol(rolDTO);
        Rol rolCreado = rolService.creaRol(rol);
        RolDTO responseDTO = RolDTOMapper.INSTANCE.toRolDTO(rolCreado);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // GET /api/v1/roles?page=0&size=10&sort=nombre,asc
    @GetMapping
    public ResponseEntity<Page<RolDTO>> listaDeRoles(Pageable pageable) {
        Page<Rol> roles = rolService.listaDeRoles(pageable);
        Page<RolDTO> dtoPage = roles.map(RolDTOMapper.INSTANCE::toRolDTO);
        return ResponseEntity.ok(dtoPage);
    }
}
