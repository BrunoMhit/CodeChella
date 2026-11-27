package br.com.alura.codechella.infra.evento;

import br.com.alura.codechella.domain.evento.Categoria;
import jakarta.persistence.*;

import java.time.LocalDateTime;
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
    private Endereco endereco;
    private LocalDateTime data;

    public EventoEntity(){}
    // Relacionamento com os tipos de ingresso.
    // Será implementado posteriormente.
    //    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    //    private List<TipoIngressoEntity> tipoIngressos = new ArrayList<>();



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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
