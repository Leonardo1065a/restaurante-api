package br.com.silva.bakeryapi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.silva.bakeryapi.modal.Produto;
import br.com.silva.bakeryapi.repository.ProdutoRepository;

@Service
public class ProdutoBusiness {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> getAll(){
		return this.repository.findAll();
	}
	
	public Produto getById(Long id) {
		return this.repository.findOne(id);
	}
	
	public Produto save(Produto categoria) throws Exception{
		try {
			return this.repository.save(categoria);
		} catch (Exception e) {
			throw new Exception("Erro ao salvar", e);
		}
	}
	
	public void delete(Long id) {
		this.repository.delete(id);
	}
	
}
