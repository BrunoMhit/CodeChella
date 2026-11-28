package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.evento.Evento;

import java.util.List;

public interface RepositorioDeEvento {
    List<Evento> listarTodos();
}
