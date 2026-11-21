package br.com.alura.codechella.application.venda;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record DadosEndereco(
        @NotBlank(message = "O CEP é obrigatório")
        String cep,
        @Positive(message = "O número do endereço é obrigatório!")
        Integer numero,
        String complemento
) {
}
