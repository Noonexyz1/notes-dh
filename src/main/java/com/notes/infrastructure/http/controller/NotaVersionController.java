package com.notes.infrastructure.http.controller;

import com.notes.domain.model.NotaVersion;
import com.notes.domain.port.in.NotaVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notaVersion")
public class NotaVersionController {

    @Autowired
    private NotaVersionService notaVersionService;

    public void obtenerNotaVersion(Long idNota) {
        NotaVersion asdf = this.notaVersionService.obtenerNotaVersion(idNota);
    }
}
