package br.com.silva.bakeryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.silva.bakeryapi.modal.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
