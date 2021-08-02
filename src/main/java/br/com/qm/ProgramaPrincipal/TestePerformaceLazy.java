package br.com.qm.ProgramaPrincipal;

import java.util.List;

import br.com.qm.DAO.MultaDAO;
import br.com.qm.entity.Multa;

public class TestePerformaceLazy {

	public static void main(String[] args) {
		//Multa multa = new Multa();
		MultaDAO multaDAO = new MultaDAO();
		
//		long inicio = System.nanoTime();
//		for(int i = 0; i < 300; i++) {
//			multaDAO.cadastraMulta(new Multa(99.90, 3, "xpt-00"+i));
//		}
		
//		for(int i = 0; i <300; i++) {
//			multaDAO.consultaMulta(i);
//		}
//		
//		List<Multa> multa = multaDAO.listarMulta();
//		long fim = System.nanoTime();
//		System.out.println("Tempo decorrido: "+(fim - inicio));
}
}
