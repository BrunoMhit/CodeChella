package br.com.alura.codechella.domain.evento;

import br.com.alura.codechella.Categoria;
import br.com.alura.codechella.domain.ingresso.TipoIngresso;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Evento {
    private UUID uuid;
    private Categoria categoria;
    private String descricao;
    private LocalDateTime dateTime;
    private Endereco endereco;
    private List<TipoIngresso> tipoIngressos = new ArrayList<>();

    public Evento(Categoria categoria, String descricao, LocalDateTime dateTime, Endereco endereco) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.dateTime = dateTime;
        this.endereco = endereco;

        gerarIdentificador();
    }

    private void gerarIdentificador() {
        this.uuid = UUID.randomUUID();
    }

    public void incluiNovoTipoDeIngressoAoEvento(TipoIngresso tipoIngresso){
        this.tipoIngressos.add(tipoIngresso);
    }

    public void aumentaNumeroDeIngressoPorTipo(){
        //implementar aqui, uma classe não poded só ter get e set, regra de negócio vai aqui
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<TipoIngresso> getTipoIngressos() {
        return tipoIngressos;
    }
}
