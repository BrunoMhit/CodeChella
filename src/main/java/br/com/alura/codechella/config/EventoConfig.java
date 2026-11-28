package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositorioDeEvento;
import br.com.alura.codechella.infra.evento.EventoRepository;
import br.com.alura.codechella.infra.gateways.EventoEntityMapper;
import br.com.alura.codechella.infra.gateways.RepositorioDeEventoJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventoConfig {
    @Bean
    RepositorioDeEvento criarRepositorioEventoJpa(EventoRepository repositorio, EventoEntityMapper mapper){
        return new RepositorioDeEventoJpa(repositorio, mapper);
    }

    @Bean
    EventoEntityMapper retornoEventoMapper(){
        return new EventoEntityMapper();
    }
}
