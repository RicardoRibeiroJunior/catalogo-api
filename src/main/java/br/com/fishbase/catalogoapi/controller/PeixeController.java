package br.com.fishbase.catalogoapi.controller;

import br.com.fishbase.catalogoapi.dto.DadosAtualizacaoPeixe;
import br.com.fishbase.catalogoapi.dto.DadosCadastroPeixe;
import br.com.fishbase.catalogoapi.dto.DadosDetalhePeixe;
import br.com.fishbase.catalogoapi.dto.DadosListagemPeixe;
import br.com.fishbase.catalogoapi.service.PeixeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/peixes")
public class PeixeController {

    @Autowired
    private PeixeService peixeService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhePeixe> cadastar(@RequestBody @Valid DadosCadastroPeixe dados, UriComponentsBuilder uriBuilder){
        DadosDetalhePeixe dadosDetalhePeixe = peixeService.criarPeixe(dados);
        URI uri = uriBuilder.path("peixes/{id}").buildAndExpand(dadosDetalhePeixe.id()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhePeixe);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPeixe>> listar(@PageableDefault(size=10, sort= {"id"}, page=0) Pageable paginacao){
        return ResponseEntity.ok(peixeService.obterTodos(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhePeixe> detalhar(@PathVariable @NotNull Long id){
        return ResponseEntity.ok(peixeService.obterPorId(id));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhePeixe> atualizar(@RequestBody @Valid DadosAtualizacaoPeixe dados){
        return ResponseEntity.ok(new DadosDetalhePeixe(peixeService.atualizarPeixe(dados)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id){
        peixeService.excluirPeixe(id);
        return ResponseEntity.noContent().build();
    }

}
