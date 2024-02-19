package br.com.fishbase.catalogoapi.dto;

import br.com.fishbase.catalogoapi.domain.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPeixe(

        @NotNull(message = "O campo id é obrigatório.")
        Long id,
        @NotBlank(message = "O campo nome científico é obrigatório.")
        String nomeCientifico,
        @NotBlank(message = "O campo nome comum é obrigatório.")
        String nomeComum,
        @NotNull(message = "O campo tipo é obrigatório.")
        Tipo tipo
) {
}
