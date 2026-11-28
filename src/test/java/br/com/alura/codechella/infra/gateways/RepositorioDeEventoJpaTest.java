package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.evento.Evento;
import br.com.alura.codechella.infra.evento.EventoEntity;
import br.com.alura.codechella.infra.evento.EventoRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RepositorioDeEventoJpaTest {

    private final EventoRepository repository = mock(EventoRepository.class);
    private final EventoEntityMapper mapper = mock(EventoEntityMapper.class);
    private final RepositorioDeEventoJpa repositorio = new RepositorioDeEventoJpa(repository,mapper);

    @Test
    void deveListarTodosOsEventos() {
        EventoEntity entity = new EventoEntity();
        Evento evento = mock(Evento.class);

        when(repository.findAll()).thenReturn(List.of(entity));
        when(mapper.toDomain(entity)).thenReturn(evento);

        List<Evento> resultado = repositorio.listarTodos();

        assertEquals(1, resultado.size());
        assertSame(evento, resultado.get(0));

        verify(repository).findAll();
        verify(mapper).toDomain(entity);
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoExistiremEventos() {
        when(repository.findAll()).thenReturn(List.of());

        List<Evento> resultado = repositorio.listarTodos();

        assertTrue(resultado.isEmpty());

        verify(repository).findAll();
        verifyNoInteractions(mapper);
    }
}
