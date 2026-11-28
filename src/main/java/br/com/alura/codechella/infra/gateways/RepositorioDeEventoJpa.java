package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeEvento;
import br.com.alura.codechella.domain.evento.Evento;
import br.com.alura.codechella.infra.evento.EventoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeEventoJpa implements RepositorioDeEvento {
    private final EventoRepository repositorio;
    private final EventoEntityMapper mapper;

    public RepositorioDeEventoJpa(EventoRepository repositorio, EventoEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Evento> listarTodos() {
        return repositorio.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
