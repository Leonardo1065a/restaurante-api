package br.com.silva.bakeryapi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.silva.bakeryapi.modal.Categoria;
import br.com.silva.bakeryapi.repository.CategoriaRepository;


@Service
public class CategoriaBusiness {

	private @Autowired CategoriaRepository repository;
	
	public List<Categoria> getAll(){
		return this.repository.findAll();
	}
	
	public Categoria getById(Long id) {
		return this.repository.findOne(id);
	}
	
	public Categoria save(Categoria categoria) throws Exception{
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
