package com.notes.application.adapter;

import com.notes.domain.model.Nota;
import com.notes.domain.model.Usuario;
import com.notes.domain.port.in.NotaService;
import com.notes.domain.port.out.persistence.NotaAbstract;
import com.notes.domain.port.out.persistence.UsuarioAbstract;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@RequiredArgsConstructor
public class NotaAdapter implements NotaService {

    private final NotaAbstract notaAbstract;
    private final UsuarioAbstract usuarioAbstract;

    @Override
    public Nota crearNota(Nota nota) {
        Optional<Usuario> usuario = this.usuarioAbstract
                .buscarUsuario(nota.getUsuario().getId());

        if (usuario.isEmpty()) {
            throw new RuntimeException("Usuario con este id no existe");
        }

        nota.setUsuario(usuario.get());
        Nota nota1 = this.notaAbstract.crearNota(nota);
        nota1.getUsuario().setContrasena(null);
        return nota1;
    }

    @Override
    public Page<Nota> listaDeNotas(Pageable pageable) {
        return this.notaAbstract.listaDeNotas(pageable);
    }

    @Override
    public Optional<Nota> verNota(Long idNota) {
        return this.notaAbstract.verNota(idNota);
    }

    @Override
    public Nota editarNota(Long idNota, Nota notaEditada) {
        Optional<Nota> notaEncontrada = this.notaAbstract.encontrarNota(idNota);
        if (notaEncontrada.isEmpty()) {
            throw new RuntimeException("Esta nota no existe");
        }
        notaEditada.setId(notaEncontrada.get().getId());
        notaEditada.setUsuario(notaEncontrada.get().getUsuario());
        return this.notaAbstract.editarNota(notaEditada);
    }

    @Override
    public void eliminarNota(Long idNota) {
        this.notaAbstract.eliminarNota(idNota);
    }

    @Override
    public void archivarNota(Long idNota) {
        Optional<Nota> notaEncontrada = this.notaAbstract.encontrarNota(idNota);
        if (notaEncontrada.isEmpty()) {
            throw new RuntimeException("Esta nota no existe");
        }
        Nota notaToArchive = notaEncontrada.get();
        notaToArchive.setEstaArchivada(true);
        this.notaAbstract.archivarNota(notaToArchive);
    }

    @Override
    public Nota desarchivarNota(Long idNota) {
        Optional<Nota> notaEncontrada = this.notaAbstract.encontrarNota(idNota);
        if (notaEncontrada.isEmpty()) {
            throw new RuntimeException("Esta nota no existe");
        }
        Nota notaToArchive = notaEncontrada.get();
        notaToArchive.setEstaArchivada(false);
        notaToArchive = this.notaAbstract.desarchivarNota(notaToArchive);
        return notaToArchive;
    }
}
