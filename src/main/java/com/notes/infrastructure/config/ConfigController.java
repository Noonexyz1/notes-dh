package com.notes.infrastructure.config;

import com.notes.application.adapter.*;
import com.notes.domain.port.in.*;
import com.notes.domain.port.out.persistence.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigController {

    @Bean
    public EtiquetaService etiquetaServiceBean(EtiquetaAbstract etiquetaAbstract) {
        return new EtiquetaAdapter(etiquetaAbstract);
    }

    @Bean
    public NotaService notaServiceBean(
            NotaAbstract notaAbstract,
            UsuarioAbstract usuarioAbstract) {

        return new NotaAdapter(notaAbstract, usuarioAbstract);
    }

    @Bean
    public NotaVersionService notaVersionServiceBean(
            NotaVersionAbstract notaVersionAbstract,
            NotaAbstract notaAbstract) {

        return new NotaVersionAdapter(notaVersionAbstract, notaAbstract);
    }

    @Bean
    public UsuarioService usuarioServiceBean(
            UsuarioAbstract usuarioAbstract,
            PersonaAbstract personaAbstract) {

        return new UsuarioAdapter(usuarioAbstract, personaAbstract);
    }

    @Bean
    public RolService rolServiceBean(RolAbstract rolAbstract) {
        return new RolAdapter(rolAbstract);
    }
}
