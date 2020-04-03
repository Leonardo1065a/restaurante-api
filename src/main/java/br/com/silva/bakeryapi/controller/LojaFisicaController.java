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

import br.com.silva.bakeryapi.business.LojaFisicaBusiness;
import br.com.silva.bakeryapi.modal.LojaFisica;

@RestController
@RequestMapping(value = "lojas-fisicas")
public class LojaFisicaController {

	@Autowired
	private LojaFisicaBusiness business;
	
	@GetMapping
	public ResponseEntity<List<LojaFisica>> list(){
		return ResponseEntity.ok(this.business.getAll());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<LojaFisica> findById(@PathVariable("id") Long id){
		LojaFisica lojaFisica = this.business.getOne(id);
		return lojaFisica != null ? ResponseEntity.ok(lojaFisica) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();			
	}
	
	@PostMapping
	public ResponseEntity<LojaFisica> save(@RequestBody LojaFisica lojaFisica) throws Exception{
		Boolean isSave = lojaFisica.getId() != null ? true : false; 
		LojaFisica lojaFisicaSalva = this.business.save(lojaFisica);
		return isSave ? ResponseEntity.status(HttpStatus.OK).body(lojaFisicaSalva) : 
			ResponseEntity.status(HttpStatus.CREATED).body(lojaFisicaSalva);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		this.business.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
