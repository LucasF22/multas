package br.com.qm.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.qm.entity.Condutor;
import br.com.qm.entity.Veiculo;

public class VeiculoDAO {
private EntityManager entityManager;
	
	public VeiculoDAO() {
		this.entityManager = Persistence.createEntityManagerFactory("multas").createEntityManager();
	}
	
	public boolean cadastraVeiculo(Veiculo veiculo) {
		entityManager.getTransaction().begin();
		entityManager.persist(veiculo);
		entityManager.getTransaction().commit();
		return true;
	}
	public Veiculo consultaVeiculo(String placa) {
		return entityManager.find(Veiculo.class, placa);
	}
	public boolean alteraCondutorVeiculo(int cnhOrigem, int cnhDestino, String placa) {
		CondutorDAO condutorOrigem = new CondutorDAO();
		condutorOrigem.consultaCondutro(cnhOrigem);
		if(condutorOrigem.consultaCondutro(cnhOrigem) == null ) {
			return false;
		}
		CondutorDAO condutorDestino = new CondutorDAO();
		if(condutorDestino.consultaCondutro(cnhOrigem) == null) {
			return false;
		}
		Veiculo veiculo = entityManager.find(Veiculo.class, placa);
		if(veiculo == null) {
			return false;
		}
		if(cnhOrigem != veiculo.getCondutor().getNroCNH()) {
			return false;
		}
		MultaDAO multas = new MultaDAO();
		if(multas.listarMultaPorVeiculoDebito(placa) != null) {
			return false;
		}
		
		entityManager.getTransaction().begin();
		entityManager.merge(veiculo);
		entityManager.getTransaction().commit();
		return true;
	}
	public boolean removeVeiculo(String placa) {
		Veiculo veiculo = entityManager.find(Veiculo.class, placa);
		
		if(veiculo == null) {
			return false;//exceção
		}
		
		entityManager.getTransaction().begin();
		entityManager.remove(veiculo);
		entityManager.getTransaction().commit();
		return true;
	}
	public List<Veiculo> listarVeiculo(){
		Query query = entityManager.createQuery("select v from Veiculo as v");
		return query.getResultList();
	}
}
