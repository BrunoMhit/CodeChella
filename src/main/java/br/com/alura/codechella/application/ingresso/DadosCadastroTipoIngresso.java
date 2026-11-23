package br.com.alura.codechella.application.ingresso;

import br.com.alura.codechella.domain.ingresso.Definicao;
import br.com.alura.codechella.domain.ingresso.Setor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroTipoIngresso(
        @NotNull(message = "O setor associado ao ingresso é obrigatório!")
        Setor setor,
        @NotNull(message = "A definição do tipo de ingresso associado é obrigatório")
        Definicao definicao,
        @NotNull
        Double valor,
        @Positive
        int totalDisponivel
) {
}
