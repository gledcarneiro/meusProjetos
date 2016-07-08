package br.com.rabelo.smartserver.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "colaborador", catalog = "retaguarda")
public class Colaborador extends GenericDomain {
	@ManyToOne
	@JoinColumn(name = "ID_CARGO", nullable = false)
	private Cargo cargo;

	@ManyToOne
	@JoinColumn(name = "ID_DEPARTAMENTO", nullable = false)
	private Setor idDepartamento;

	@ManyToOne
	@JoinColumn(name = "ID_PESSOA", nullable = false)
	private Pessoa pessoa;

	@Column(name = "FOTO_34", length = 100)
	private String foto34;

	@Column(name = "OBSERVACOES", length = 100)
	private String observacoes;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CADASTRO", length = 10)
	private Date dataCadastro;

	@Column(name = "HASH_TRIPA", length = 32)
	private String hashTripa;

	@Column(name = "HASH_INCREMENTO")
	private Integer hashIncremento;

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Setor getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Setor idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getFoto34() {
		return foto34;
	}

	public void setFoto34(String foto34) {
		this.foto34 = foto34;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
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
