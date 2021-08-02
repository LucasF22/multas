package br.com.qm.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;


import br.com.qm.entity.Condutor;


public class CondutorDAO {
	private EntityManager entityManager;
	
	public CondutorDAO() {
		this.entityManager = Persistence.createEntityManagerFactory("multas").createEntityManager();
	}
	
	public boolean cadastraCondutor(Condutor condutor) {
		entityManager.getTransaction().begin();
		entityManager.persist(condutor);
		entityManager.getTransaction().commit();
		return true;
	}
	public Condutor consultaCondutro(int nroCNH) {
		return entityManager.find(Condutor.class, nroCNH);
	}
	public boolean removeCondutor(int nroCNH) {
		Condutor condutor = entityManager.find(Condutor.class, nroCNH);
		
		if(condutor == null) {
			return false;//exceção
		}
		
		entityManager.getTransaction().begin();
		entityManager.remove(condutor);
		entityManager.getTransaction().commit();
		return true;
	}
	public List<Condutor> listarCondutor(){
		Query query = entityManager.createQuery("select c from Condutor as c");
		return query.getResultList();
	}

	
}
