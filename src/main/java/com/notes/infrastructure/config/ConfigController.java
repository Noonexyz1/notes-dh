package com.notes.infrastructure.config;

import com.notes.application.adapter.EtiquetaAdapter;
import com.notes.application.adapter.NotaAdapter;
import com.notes.application.adapter.NotaVersionAdapter;
import com.notes.application.adapter.UsuarioAdapter;
import com.notes.domain.port.in.EtiquetaService;
import com.notes.domain.port.in.NotaService;
import com.notes.domain.port.in.NotaVersionService;
import com.notes.domain.port.in.UsuarioService;
import com.notes.domain.port.out.persistence.EtiquetaAbstract;
import com.notes.domain.port.out.persistence.NotaAbstract;
import com.notes.domain.port.out.persistence.NotaVersionAbstract;
import com.notes.domain.port.out.persistence.UsuarioAbstract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigController {

    @Bean
    public EtiquetaService etiquetaServiceBean(EtiquetaAbstract etiquetaAbstract) {
        return new EtiquetaAdapter(etiquetaAbstract);
    }

    @Bean
    public NotaService notaServiceBean(NotaAbstract notaAbstract) {
        return new NotaAdapter(notaAbstract);
    }

    @Bean
    public NotaVersionService notaVersionServiceBean(
            NotaVersionAbstract notaVersionAbstract,
            NotaAbstract notaAbstract) {

        return new NotaVersionAdapter(notaVersionAbstract, notaAbstract);
    }

    @Bean
    public UsuarioService usuarioServiceBean(UsuarioAbstract usuarioAbstract) {
        return new UsuarioAdapter(usuarioAbstract);
    }

}
