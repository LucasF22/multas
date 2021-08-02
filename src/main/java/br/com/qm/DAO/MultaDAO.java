package br.com.qm.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.qm.entity.Condutor;
import br.com.qm.entity.Multa;

public class MultaDAO {
private EntityManager entityManager;
	
	public MultaDAO() {
		this.entityManager = Persistence.createEntityManagerFactory("multas").createEntityManager();
	}
	
	public boolean cadastraMulta(Multa multa) {
		VeiculoDAO veiculo =  new VeiculoDAO();
		if(veiculo.consultaVeiculo(multa.getVeiculo().getPlaca()) == null) {
			return false;
		}
		Condutor condutor = entityManager.find(Condutor.class, multa.getVeiculo().getCondutor().getNroCNH());
		condutor.setPontuacao(condutor.getPontuacao() + multa.getPontuacao());
		if(condutor.getPontuacao() >= 30) {
			condutor.setDesabilitada(true);
		}
		
		entityManager.getTransaction().begin();
		entityManager.persist(multa);
		entityManager.merge(condutor);
		entityManager.getTransaction().commit();
		return true;
	}
	public Multa consultaMulta(int codigoMulta) {
		return entityManager.find(Multa.class, codigoMulta);
	}
	public boolean removeMulta(int codigoMulta) {
		Multa multa = entityManager.find(Multa.class, codigoMulta);
		
		if(multa == null) {
			return false;//exceção
		}
		
		entityManager.getTransaction().begin();
		entityManager.remove(multa);
		entityManager.getTransaction().commit();
		return true;
	}
	public List<Multa> listarMulta(){
		Query query = entityManager.createQuery("select m from Multa as m");
		return query.getResultList();
	}
	public List<Multa> listarMultaPorVeiculo(String placa){
		Query query = entityManager.createQuery("Select m from Multa as m where m.veiculo = :placa");
		return query.getResultList();
	}
	public List<Multa> listarMultaPorVeiculoDebito(String placa){
		Query query = entityManager.createQuery("Select m from Multa as m where m.veiculo = :placa and m.paga = false");
		return query.getResultList();
	}
}
