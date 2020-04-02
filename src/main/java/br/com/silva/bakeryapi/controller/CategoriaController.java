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

import br.com.silva.bakeryapi.business.CategoriaBusiness;
import br.com.silva.bakeryapi.modal.Categoria;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaController {

	@Autowired
	private CategoriaBusiness business;

	@GetMapping
	public ResponseEntity<List<Categoria>> list(){
		return ResponseEntity.ok(this.business.getAll());
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Categoria> findById(@PathVariable("id") Long id){
		Categoria categoria = this.business.getById(id);
		return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();			
	}

	@PostMapping
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) throws Exception{
		Boolean isSave = categoria.getId() != null ? true : false; 
		Categoria categoriaSalva = this.business.save(categoria);
		return isSave ? ResponseEntity.status(HttpStatus.OK).body(categoriaSalva) : 
			ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);	
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		this.business.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
