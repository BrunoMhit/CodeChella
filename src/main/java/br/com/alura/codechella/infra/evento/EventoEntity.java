package br.com.alura.codechella.infra.evento;

import br.com.alura.codechella.domain.evento.Categoria;
import br.com.alura.codechella.infra.ingresso.TipoIngressoEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "eventos")
public class EventoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private String descricao;

    @Embedded
    private EnderecoEmbeddable endereco;
    private LocalDateTime data;

    public EventoEntity(){}
    @OneToMany(mappedBy = "evento")
    private List<TipoIngressoEntity> tipoIngressos = new ArrayList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EnderecoEmbeddable getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEmbeddable endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public List<TipoIngressoEntity> getTipoIngressos(){
        return tipoIngressos;
    }

    public void setTipoIngressos(List<TipoIngressoEntity> tipoIngressos){
        tipoIngressos.forEach(tipo -> tipo.setEvento(this));
        this.tipoIngressos = tipoIngressos;
    }
}
