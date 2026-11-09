package br.com.alura.codechella.application.Evento;

import br.com.alura.codechella.domain.evento.Endereco;

public interface RpositorioDeEvento {
    Evento buscarEventoPorCidade(Endereco cep);
}
