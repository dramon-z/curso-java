package mx.gob.tabasco.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;

import mx.gob.tabasco.entities.Asegurado;
import mx.gob.tabasco.services.AseguradoService;

@Service
public class AseguradoServiceImpl implements AseguradoService {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public List<Asegurado> findAll() {
		EntityManager em = emf.createEntityManager();
		
		return em.createNamedQuery("Asegurado.findAll", Asegurado.class).getResultList();
	}

	@Override
	public Asegurado getById(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		return em.find(Asegurado.class, id);
	}

	@Override
	public void save(Asegurado asegurado) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(asegurado);
		em.getTransaction().commit();
	}

}
