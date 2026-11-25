package br.com.alura.codechella.infra.evento;

import br.com.alura.codechella.domain.evento.Categoria;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "eventos")
public class EventoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public EventoEntity(){}
//    private String descricao;
//    @Embedded
//    private Endereco endereco;
//    private LocalDateTime data;
//    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Tipo> tipoIngressos = new ArrayList<>();
//

//
//    public Evento(DadosCadastroEvento dados) {
//        this.categoria = dados.categoria();
//        this.descricao = dados.descricao();
//        this.endereco = new Endereco(dados.endereco());
//        this.data = dados.data();
//
//        List<Tipo> tipoIngresso = dados.tipoIngressos().stream()
//                .map(i -> new Tipo(i.setor(), i.definicao(), i.valor(), i.totalDisponivel()))
//                .collect(Collectors.toList());
//
//        this.setTipoIngressos(tipoIngresso);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//    public Endereco getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(Endereco endereco) {
//        this.endereco = endereco;
//    }
//
//    public LocalDateTime getData() {
//        return data;
//    }
//
//    public void setData(LocalDateTime data) {
//        this.data = data;
//    }
//
//    public List<Tipo> getTipoIngressos() {
//        return tipoIngressos;
//    }
//
//    public void setTipoIngressos(List<Tipo> tipoIngressos) {
//        tipoIngressos.forEach(i -> i.setEvento(this));
//        this.tipoIngressos = tipoIngressos;
//    }
}
