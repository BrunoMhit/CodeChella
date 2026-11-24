package br.com.alura.codechella.application.evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoService service;

//    @PostMapping
//    @Transactional
//    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEvento dadosCadastro, UriComponentsBuilder uriBuilder) {
//        DadosEvento dadosEvento = service.cadastrarEvento(dadosCadastro);
//        var uri = uriBuilder.path("/eventos/{id}").buildAndExpand(dadosEvento.id()).toUri();
//        return ResponseEntity.created(uri).body(dadosEvento);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<DadosEvento>> listar() {
//        return ResponseEntity.ok(service.listarTodos());
//    }
}
