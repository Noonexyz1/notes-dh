package com.notes.infrastructure.http.controller;

import com.notes.domain.model.Nota;
import com.notes.domain.port.in.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/nota")
public class NotaController {

    @Autowired
    private NotaService notaService;

    public void crearNota(Nota nota) {
        Nota nota1 = this.notaService.crearNota(nota);
    }

    //Con este pageable hacermos la parte de busqueda avanzada
    public void listaDeNotas(Pageable pageable) {
        Page<Nota> asdf = this.notaService.listaDeNotas(pageable);
    }

    public void verNota(Long idNota) {
        Nota nota1 = this.notaService.verNota(idNota);
    }


    public void editarNota(Long idNota, Nota notaEditada) {
        Nota nota1 = this.notaService.editarNota(idNota, notaEditada);
    }

    public void eliminarNota(Long idNota) {
        this.notaService.eliminarNota(idNota);
    }


    public void archivarNota(Long idNota) {
        this.notaService.archivarNota(idNota);
    }

    public void desarchivarNota(Long idNota) {
        Nota asdf = this.notaService.desarchivarNota(idNota);
    }
}
