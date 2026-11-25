package br.com.alura.codechella.infra.ingresso;

import br.com.alura.codechella.infra.venda.VendaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "ingressos")
public class IngressoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int codigo;
    @ManyToOne
    private TipoIngressoEntity tipo;
    @ManyToOne
    @JsonIgnore
    private VendaEntity venda;

    public IngressoEntity() {}

    public IngressoEntity(int codigo, TipoIngressoEntity tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public TipoIngressoEntity getTipo() {
        return tipo;
    }

    public void setTipo(TipoIngressoEntity tipo) {
        this.tipo = tipo;
    }

    public VendaEntity getVenda() {
        return venda;
    }

    public void setVenda(VendaEntity venda) {
        this.venda = venda;
    }
}
