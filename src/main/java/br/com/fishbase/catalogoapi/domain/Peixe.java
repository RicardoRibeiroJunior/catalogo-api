package br.com.fishbase.catalogoapi.domain;

import br.com.fishbase.catalogoapi.dto.DadosAtualizacaoPeixe;
import br.com.fishbase.catalogoapi.dto.DadosCadastroPeixe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "peixes")
public class Peixe {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String nomeCientifico;
    private String nomeComum;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    public Peixe(DadosCadastroPeixe dados){
        this.nomeCientifico = dados.nomeCientifico();
        this.nomeComum = dados.nomeComum();
        this.tipo = dados.tipo();
        this.ativo = true;
    }

    public void excluir() {
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizacaoPeixe dados) {
        this.nomeCientifico = dados.nomeCientifico();
        this.nomeComum = dados.nomeComum();
        this.tipo = dados.tipo();
    }
}
