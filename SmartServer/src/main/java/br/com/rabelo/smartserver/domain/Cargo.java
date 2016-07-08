package br.com.rabelo.smartserver.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "cargo", catalog = "retaguarda")
public class Cargo extends GenericDomain {

	@Column(name = "NOME", length = 50)
	private String nome;

	@Column(name = "SALARIO", precision = 18, scale = 6)
	private BigDecimal salario;

	@Column(name = "DESCRICAO", length = 50)
	private String descricao;

	@Column(name = "HASH_TRIPA", length = 32)
	private String hashTripa;

	@Column(name = "HASH_INCREMENTO")
	private Integer hashIncremento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHashTripa() {
		return hashTripa;
	}

	public void setHashTripa(String hashTripa) {
		this.hashTripa = hashTripa;
	}

	public Integer getHashIncremento() {
		return hashIncremento;
	}

	public void setHashIncremento(Integer hashIncremento) {
		this.hashIncremento = hashIncremento;
	}
}
