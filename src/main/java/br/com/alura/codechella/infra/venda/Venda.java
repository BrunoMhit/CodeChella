package br.com.alura.codechella.infra.venda;

import br.com.alura.codechella.infra.ingresso.IngressoEntity;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<IngressoEntity> ingressos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public List<IngressoEntity> getIngressos() {
        return ingressos;
    }

//    public void setIngressos(List<Ingresso> ingressos) {
//        ingressos.forEach(i -> i.setVenda(this));
//        this.ingressos = ingressos;
//    }

}