package br.com.qm.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Condutor {
	@Id
	@Column (name = "nro_cnh")
	private int nroCNH;
	@Column(name ="data_emissao")
	private LocalDate dataEmiss�o;
	@Column(name ="orgao_emissor")
	private String orgaoEmissor;
	private int pontuacao;
	@OneToMany(mappedBy = "condutor")
	private Veiculo veiculo;
	private boolean desabilitada;
	
	
	public Condutor(int nroCNH, LocalDate dataEmiss�o, String orgaoEmissor, int pontuacao, Veiculo veiculo,
			boolean desabilitada) {
		super();
		this.nroCNH = nroCNH;
		this.dataEmiss�o = dataEmiss�o;
		this.orgaoEmissor = orgaoEmissor;
		this.pontuacao = pontuacao;
		this.veiculo = veiculo;
		this.desabilitada = desabilitada;
	}
	
	public Condutor() {
		// TODO Auto-generated constructor stub
	}

	public int getNroCNH() {
		return nroCNH;
	}
	public void setNroCNH(int nroCNH) {
		this.nroCNH = nroCNH;
	}
	public LocalDate getDataEmiss�o() {
		return dataEmiss�o;
	}
	public void setDataEmiss�o(LocalDate dataEmiss�o) {
		this.dataEmiss�o = dataEmiss�o;
	}
	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}
	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public boolean isDesabilitada() {
		return desabilitada;
	}

	public void setDesabilitada(boolean desabilitada) {
		this.desabilitada = desabilitada;
	}
	

}
