package br.com.rabelo.smartserver.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "papel_funcao", catalog = "retaguarda")
public class PapelFuncao  extends GenericDomain{
	@ManyToOne
	@JoinColumn(name = "ID_PAPEL", nullable = false)
	private Papel papel;

	@Column(name = "PODE_CONSULTAR", length = 1)
	private Character podeConsultar;
	
	@Column(name = "PODE_INSERIR", length = 1)
	private Character podeInserir;
	
	@Column(name = "PODE_ALTERAR", length = 1)
	private Character podeAlterar;
	
	@Column(name = "PODE_EXCLUIR", length = 1)
	private Character podeExcluir;
	
	@Column(name = "FORMULARIO", length = 50)
	private String formulario;
	
	@Column(name = "HASH_TRIPA")
	private String hashTripa;
	
	@Column(name = "HASH_INCREMENTO")
	private Integer hashIncremento;

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public Character getPodeConsultar() {
		return podeConsultar;
	}

	public void setPodeConsultar(Character podeConsultar) {
		this.podeConsultar = podeConsultar;
	}

	public Character getPodeInserir() {
		return podeInserir;
	}

	public void setPodeInserir(Character podeInserir) {
		this.podeInserir = podeInserir;
	}

	public Character getPodeAlterar() {
		return podeAlterar;
	}

	public void setPodeAlterar(Character podeAlterar) {
		this.podeAlterar = podeAlterar;
	}

	public Character getPodeExcluir() {
		return podeExcluir;
	}

	public void setPodeExcluir(Character podeExcluir) {
		this.podeExcluir = podeExcluir;
	}

	public String getFormulario() {
		return formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
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
