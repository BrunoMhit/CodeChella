package br.com.alura.codechella.application.ingresso;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroIngresso(
        @NotNull(message = "O código ingresso é obrigatório")
        Integer codigo,
        @NotNull(message = "o id do tipo é um campo obrigatório")
        Long tipo_id
) {
}
