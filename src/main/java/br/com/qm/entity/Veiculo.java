package br.com.qm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Veiculo {
	
	@Id
	@Column 
	private String placa;
	private int ano;
	private String modelo;
	private String marca;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "condutor_fk", referencedColumnName = "nro_cnh")
	private Condutor  condutor;
	@OneToMany( mappedBy = "veiculo")
	private List<Multa> multas;
	
	public Veiculo(String placa, int ano, String modelo, String marca, Condutor condutor) {
		super();
		this.placa = placa;
		this.ano = ano;
		this.modelo = modelo;
		this.marca = marca;
		this.condutor = condutor;
	}
	public Veiculo(double d, int i, String string) {
		// TODO Auto-generated constructor stub
	}
	public Veiculo(String string, int i, String string2, String string3, int i2) {
		// TODO Auto-generated constructor stub
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Condutor getCondutor() {
		return condutor;
	}
	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}
	public List<Multa> getMultas() {
		return multas;
	}
	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}
	
	
	
	
	
}
