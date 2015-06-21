package mx.gob.tabasco.services;

import java.util.List;

import mx.gob.tabasco.entities.Asegurado;

public interface AseguradoService {

	public List<Asegurado> findAll();
	
	public Asegurado getById(Integer id);
	
	public void save(Asegurado asegurado);
	
}
