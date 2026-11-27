package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.evento.Endereco;
import br.com.alura.codechella.domain.evento.Evento;
import br.com.alura.codechella.domain.ingresso.TipoIngresso;
import br.com.alura.codechella.infra.evento.EventoEntity;
import br.com.alura.codechella.infra.evento.EnderecoEmbeddable;
import br.com.alura.codechella.infra.ingresso.TipoIngressoEntity;

import java.util.ArrayList;
import java.util.List;

public class EventoEntityMapper {

    public EventoEntity toEntity(Evento evento){
        EventoEntity entity = new EventoEntity();
        entity.setUuid(evento.getUuid());
        entity.setCategoria(evento.getCategoria());
        entity.setDescricao(evento.getDescricao());
        entity.setData(evento.getDateTime());

        Endereco endereco = evento.getEndereco();
        entity.setEndereco(
                new EnderecoEmbeddable(
                        endereco.getCep(),
                        endereco.getNumero(),
                        endereco.getComplemento()
                )
        );

        List<TipoIngressoEntity> tipos = new ArrayList<>();
        for (TipoIngresso tipo: evento.getTipoIngressos()){
            tipos.add(new TipoIngressoEntity(
                    tipo.getSetor(),
                    tipo.getDefinicao(),
                    tipo.getValor(),
                    tipo.getTotalDisponivel()
            ));
        }

        entity.setTipoIngressos(tipos);
        return entity;
    }
    public Evento toDomain(EventoEntity entity) {
        Endereco endereco = new Endereco(
                entity.getEndereco().getCep(),
                entity.getEndereco().getNumero(),
                entity.getEndereco().getComplemento()
        );
        Evento evento = new Evento(
                entity.getUuid(),
                entity.getCategoria(),
                entity.getDescricao(),
                entity.getData(),
                endereco
        );
        for (TipoIngressoEntity tipo : entity.getTipoIngressos()) {
            evento.incluiNovoTipoDeIngressoAoEvento(
                    new TipoIngresso(
                            tipo.getSetor(),
                            tipo.getDefinicao(),
                            tipo.getValor(),
                            tipo.getTotalDisponivel()
                    )
            );
        }
        return evento;
    }
}
