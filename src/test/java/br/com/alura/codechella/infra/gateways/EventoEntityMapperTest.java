package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.evento.Categoria;
import br.com.alura.codechella.domain.evento.Endereco;
import br.com.alura.codechella.domain.evento.Evento;
import br.com.alura.codechella.domain.ingresso.Definicao;
import br.com.alura.codechella.domain.ingresso.Setor;
import br.com.alura.codechella.domain.ingresso.TipoIngresso;
import br.com.alura.codechella.infra.evento.EventoEntity;
import br.com.alura.codechella.infra.ingresso.TipoIngressoEntity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EventoEntityMapperTest {

    private final EventoEntityMapper mapper = new EventoEntityMapper();
    private Evento criarEvento() {
        Endereco endereco = new Endereco(
                "70000-000", 100, "Area de eventos"
        );

        Evento evento = new Evento(
                Categoria.FESTIVAL,
                "CodeChella",
                LocalDateTime.of(2026, 12, 20, 18, 0),
                endereco
        );

        evento.incluiNovoTipoDeIngressoAoEvento(
                new TipoIngresso(
                        Setor.PISTA,
                        Definicao.INTEIRA,
                        150.0,
                        100
                )
        );

        return evento;
    }
    @Test
    void deveConverterEventoParaEntity() {
        Evento evento = criarEvento();

        EventoEntity entity = mapper.toEntity(evento);

        assertEquals(evento.getUuid(), entity.getUuid());
        assertEquals(evento.getCategoria(), entity.getCategoria());
        assertEquals(evento.getDescricao(), entity.getDescricao());
        assertEquals(evento.getDateTime(), entity.getData());

        assertEquals("70000-000", entity.getEndereco().getCep());
        assertEquals(100, entity.getEndereco().getNumero());
        assertEquals("Area de eventos", entity.getEndereco().getComplemento());

        assertEquals(1, entity.getTipoIngressos().size());

        TipoIngressoEntity tipo = entity.getTipoIngressos().get(0);

        assertEquals(Setor.PISTA, tipo.getSetor());
        assertEquals(Definicao.INTEIRA, tipo.getDefinicao());
        assertEquals(150.0, tipo.getValor());
        assertEquals(100, tipo.getTotalDisponivel());

        assertSame(entity, tipo.getEvento());
    }

    @Test
    void deveConverterEntityParaEvento() {
        Evento original = criarEvento();
        EventoEntity entity = mapper.toEntity(original);
        Evento evento = mapper.toDomain(entity);
        assertEquals(original.getUuid(), evento.getUuid());
        assertEquals(original.getCategoria(), evento.getCategoria());
        assertEquals(original.getDescricao(), evento.getDescricao());
        assertEquals(original.getDateTime(), evento.getDateTime());
        assertEquals("70000-000", evento.getEndereco().getCep());
        assertEquals(100, evento.getEndereco().getNumero());
        assertEquals("Area de eventos", evento.getEndereco().getComplemento());

        assertEquals(1, evento.getTipoIngressos().size());

        TipoIngresso tipo = evento.getTipoIngressos().get(0);

        assertEquals(Setor.PISTA, tipo.getSetor());
        assertEquals(Definicao.INTEIRA, tipo.getDefinicao());
        assertEquals(150.0, tipo.getValor());
        assertEquals(100, tipo.getTotalDisponivel());
    }
}