package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.venda.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vendas")
public class VendaController {
    @Autowired
    private VendaService service;

//    @PostMapping
//    @Transactional
//    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroVenda dadosVenda, UriComponentsBuilder uriBuilder) {
//        DadosVenda venda = service.cadastrarVenda(dadosVenda);
//        var uri = uriBuilder.path("/vendas/{id}").buildAndExpand(venda.id()).toUri();
//
//        return ResponseEntity.created(uri).body(venda);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<DadosVenda>> listar() {
//        return ResponseEntity.ok(service.listarTodas());
//    }
}
