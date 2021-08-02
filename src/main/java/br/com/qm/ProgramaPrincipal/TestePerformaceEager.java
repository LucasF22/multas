package br.com.qm.ProgramaPrincipal;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.qm.DAO.CondutorDAO;

import br.com.qm.DAO.VeiculoDAO;
import br.com.qm.entity.Condutor;

import br.com.qm.entity.Veiculo;

public class TestePerformaceEager {

	public static void main(String[] args) {
		
//		EntityManagerFactory ef = Persistence.createEntityManagerFactory("multas");
//		VeiculoDAO veiculoDAO = new VeiculoDAO();
		CondutorDAO condutorDAO = new CondutorDAO();
//		
			condutorDAO.cadastraCondutor(new Condutor(1, LocalDate.of(2021, 10, 1), "ssp", 40, null, false));
		
//		long inicio = System.nanoTime();
//		for(int i = 1; i < 300; i++) {
//			veiculoDAO.cadastraVeiculo(new Veiculo("xpt-00"+1, 20, "Siena", "Fiat", i));
//		}
//		
//		for(int i = 0; i <300; i++) {
//			veiculoDAO.consultaVeiculo("xpt-"+i);
//		}
//		
//		List<Veiculo> multa = veiculoDAO.listarVeiculo();
//		long fim = System.nanoTime();
//		System.out.println("Tempo decorrido: "+(fim - inicio));

	}

}
