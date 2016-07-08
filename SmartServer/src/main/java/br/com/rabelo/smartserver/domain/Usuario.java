package br.com.rabelo.smartserver.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario", catalog = "retaguarda")
public class Usuario extends GenericDomain {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COLABORADOR", nullable = false)
	private Colaborador colaborador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PAPEL", nullable = false)
	private Papel papel;

	@Column(name = "LOGIN", length = 30, nullable = false)
	private String login;

	@Column(name = "SENHA", length = 32, nullable = false)
	private String senha;

	@Transient
	private String senhaSemCriptografia;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CADASTRO", length = 10)
	private Date dataCadastro;

	@Column(name = "NIVEL_AUTORIZACAO_ECF")
	private Character nivelAutorizacaoEcf;

	@Column(name = "HASH_TRIPA", length = 32)
	private String hashTripa;

	@Column(name = "HASH_INCREMENTO")
	private Integer hashIncremento;

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaSemCriptografia() {
		return senhaSemCriptografia;
	}

	public void setSenhaSemCriptografia(String senhaSemCriptografia) {
		this.senhaSemCriptografia = senhaSemCriptografia;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Character getNivelAutorizacaoEcf() {
		return nivelAutorizacaoEcf;
	}

	public void setNivelAutorizacaoEcf(Character nivelAutorizacaoEcf) {
		this.nivelAutorizacaoEcf = nivelAutorizacaoEcf;
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
