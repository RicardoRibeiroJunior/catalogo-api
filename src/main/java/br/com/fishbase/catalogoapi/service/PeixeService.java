package br.com.fishbase.catalogoapi.service;

import br.com.fishbase.catalogoapi.domain.Peixe;
import br.com.fishbase.catalogoapi.dto.DadosAtualizacaoPeixe;
import br.com.fishbase.catalogoapi.dto.DadosCadastroPeixe;
import br.com.fishbase.catalogoapi.dto.DadosDetalhePeixe;
import br.com.fishbase.catalogoapi.dto.DadosListagemPeixe;
import br.com.fishbase.catalogoapi.repository.PeixeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PeixeService {
    @Autowired
    private PeixeRepository peixeRepository;

    public DadosDetalhePeixe criarPeixe(DadosCadastroPeixe dto){
        Peixe peixe = peixeRepository.save(new Peixe(dto));
        return new DadosDetalhePeixe(peixe);
    }

    public Page<DadosListagemPeixe> obterTodos(Pageable paginacao){
        return peixeRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPeixe::new);
    }

    public DadosDetalhePeixe obterPorId(Long id) {
        Peixe peixe = peixeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Peixe não localizado."));
        return new DadosDetalhePeixe(peixe);
    }


    public Peixe atualizarPeixe(DadosAtualizacaoPeixe dados) {
        Peixe peixe = peixeRepository.getReferenceById(dados.id());
        peixe.atualizarInformacoes(dados);
        return peixe;
    }

    public void excluirPeixe(Long id) {
        Peixe peixe = peixeRepository.getReferenceById(id);
        peixe.excluir();
    }
}
