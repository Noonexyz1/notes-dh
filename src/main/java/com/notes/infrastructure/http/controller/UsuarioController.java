package com.notes.infrastructure.http.controller;

import com.notes.domain.model.Usuario;
import com.notes.domain.port.in.UsuarioService;
import com.notes.infrastructure.http.dto.UsuarioDTO;
import com.notes.infrastructure.http.mapper.UsuarioDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crearUsuario")
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioDTOMapper.INSTANCE.toUsuario(usuarioDTO);
        Usuario usuarioCreated = this.usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(
                UsuarioDTOMapper.INSTANCE.toUsuarioDto(usuarioCreated),
                HttpStatus.OK
        );
    }

    @GetMapping("/buscarUsuario/{idUsuario}")
    public ResponseEntity<UsuarioDTO> buscarUsuario(@PathVariable Long idUsuario) {
        Usuario usuario = this.usuarioService.buscarUsuario(idUsuario)
                .orElse(null);
        return new ResponseEntity<>(
                UsuarioDTOMapper.INSTANCE.toUsuarioDto(usuario),
                HttpStatus.OK
        );
    }

}
