package br.com.fishbase.catalogoapi.dto;

import br.com.fishbase.catalogoapi.domain.Peixe;
import br.com.fishbase.catalogoapi.domain.Tipo;

public record DadosListagemPeixe(Long id, String nomeCientifico, String nomeComum, Boolean ativo, Tipo tipo) {

    public DadosListagemPeixe(Peixe peixe){
        this(peixe.getId(), peixe.getNomeCientifico(), peixe.getNomeComum(), peixe.getAtivo(), peixe.getTipo());
    }

}
