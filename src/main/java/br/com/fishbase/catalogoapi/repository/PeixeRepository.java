package br.com.fishbase.catalogoapi.repository;

import br.com.fishbase.catalogoapi.domain.Peixe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeixeRepository extends JpaRepository<Peixe, Long> {

    Page<Peixe> findAllByAtivoTrue(Pageable paginacao);

}
