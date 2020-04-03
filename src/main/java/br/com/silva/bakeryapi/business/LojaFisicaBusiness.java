package br.com.silva.bakeryapi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.silva.bakeryapi.modal.LojaFisica;
import br.com.silva.bakeryapi.repository.LojaFisicaRepository;

@Service
public class LojaFisicaBusiness {

	@Autowired
	private LojaFisicaRepository repository;
	
	public List<LojaFisica> getAll() {
		return this.repository.findAll();
	}
	
	public LojaFisica getOne(Long id) {
		return this.repository.findOne(id);
	}
	
	public LojaFisica save(LojaFisica lojaFisica) throws Exception{
		try {
			return this.repository.save(lojaFisica);
		} catch (Exception e) {
			throw new Exception("Erro ao Salvar", e);
		}
	}
	
	public void delete(Long id) {
		this.repository.delete(id);
	} 
	
}
