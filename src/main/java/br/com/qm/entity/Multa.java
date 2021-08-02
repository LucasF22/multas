package br.com.qm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Multa {
	
	@Id
	@Column (name = "codigo_multa")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigoMulta;
	
	private float valor;
	private int pontuacao;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "veiculo_fk", referencedColumnName = "placa")
	private Veiculo veiculo;
	private boolean paga;
	
	public Multa( float valor, int pontuacao, Veiculo veiculo, boolean paga) {
		this.valor = valor;
		this.pontuacao = pontuacao;
		this.veiculo = veiculo;
		this.paga = paga;
	}
	
	public Multa() {
		// TODO Auto-generated constructor stub
	}

	public boolean isPaga() {
		return paga;
	}

	public void setPaga(boolean paga) {
		this.paga = paga;
	}

	public int getCodigoMulta() {
		return codigoMulta;
	}
	public void setCodigoMulta(int codigoMulta) {
		this.codigoMulta = codigoMulta;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
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
	
	
	
}
