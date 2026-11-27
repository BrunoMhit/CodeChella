package br.com.alura.codechella.domain.ingresso;

public class TipoIngresso {

    private Setor setor;
    private Definicao definicao;
    private Double valor;
    private int totalDisponivel;

    public TipoIngresso(Setor setor, Definicao definicao, Double valor, int totalDisponivel){
        this.setor = setor;
        this.definicao = definicao;
        this.valor = valor;
        this.totalDisponivel = totalDisponivel;
    }
    //Apenas os getters


    public Setor getSetor() {
        return setor;
    }

    public Definicao getDefinicao() {
        return definicao;
    }

    public Double getValor() {
        return valor;
    }

    public int getTotalDisponivel() {
        return totalDisponivel;
    }
}
