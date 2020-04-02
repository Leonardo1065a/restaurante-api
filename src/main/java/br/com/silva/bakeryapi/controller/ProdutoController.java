package br.com.silva.bakeryapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.silva.bakeryapi.business.ProdutoBusiness;
import br.com.silva.bakeryapi.modal.Produto;

@RestController
@RequestMapping(value = "produtos")
public class ProdutoController {

	@Autowired
	private ProdutoBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Produto>> list(){
		return ResponseEntity.ok(this.business.getAll());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Produto> findById(@PathVariable("id") Long id){
		Produto produto = this.business.getById(id);
		return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();			
	}
	
	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody Produto produto) throws Exception{
		Boolean isSave = produto.getId() != null ? true : false; 
		Produto produtoSalva = this.business.save(produto);
		return isSave ? ResponseEntity.status(HttpStatus.OK).body(produtoSalva) : 
			ResponseEntity.status(HttpStatus.CREATED).body(produtoSalva);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		this.business.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
