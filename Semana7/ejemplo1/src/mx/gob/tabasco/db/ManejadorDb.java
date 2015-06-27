package mx.gob.tabasco.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mx.gob.tabasco.entities.Asegurado;

public class ManejadorDb {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ejemplo1");
		return entityManagerFactory.createEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<Asegurado> findAllAsegurados() {
		EntityManager em = getEntityManager();
		
		return em.createNamedQuery("Asegurado.findAll").getResultList();
	}
	
	public Asegurado findAseguradoById(Integer id) {
		EntityManager em = getEntityManager();
		
		return em.find(Asegurado.class, id);
	}
	
	public void saveAsegurado(Asegurado asegurado) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(asegurado);
		em.getTransaction().commit();
	}
	
}
