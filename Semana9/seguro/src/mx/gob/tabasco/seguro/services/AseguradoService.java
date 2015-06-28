package mx.gob.tabasco.seguro.services;

import mx.gob.tabasco.seguro.entities.Asegurado;
import mx.gob.tabasco.seguro.repositories.AseguradoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AseguradoService {

	@Autowired
	private AseguradoRepository aseguradoRepository;
	
	@Transactional
	public void save(Asegurado asegurado) {
		aseguradoRepository.save(asegurado);
	}
	
	@Transactional(readOnly = true)
	public Iterable<Asegurado> findAll() {
		return aseguradoRepository.findAll();
	}
	
	@Transactional
	public Asegurado getById(Integer id) {
		return aseguradoRepository.findOne(id);
	}
	
}
