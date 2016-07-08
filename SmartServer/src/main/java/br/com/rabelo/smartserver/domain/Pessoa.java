package br.com.rabelo.smartserver.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa2", catalog = "retaguarda")
public class Pessoa extends GenericDomain {
	@Column(name = "CODIGO", length = 35)
	private String codigo;

	@Column(name = "NOME", length = 150)
	private String nome;

	@Column(name = "EMAIL", length = 250)
	private String email;

	@Column(name = "CPF_CNPJ", length = 14)
	private String cpfCnpj;

	@Column(name = "RG", length = 20)
	private String rg;

	@Column(name = "ORGAO_RG", length = 20)
	private String orgaoRg;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_EMISSAO_RG", length = 10)
	private Date dataEmissaoRg;

	@Column(name = "SEXO", length = 1)
	private Character sexo;

	@Column(name = "TIPO_PESSOA", length = 1)
	private Character tipoPessoa;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CADASTRO", length = 10)
	private Date dataCadastro;

	@Column(name = "FONE", length = 15)
	private String fone1;

	@Column(name = "CELULAR", length = 15)
	private String celular;

	@Column(name = "HASH_TRIPA", length = 32)
	private String hashTripa;

	@Column(name = "HASH_INCREMENTO")
	private Integer hashIncremento;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoRg() {
		return orgaoRg;
	}

	public void setOrgaoRg(String orgaoRg) {
		this.orgaoRg = orgaoRg;
	}

	public Date getDataEmissaoRg() {
		return dataEmissaoRg;
	}

	public void setDataEmissaoRg(Date dataEmissaoRg) {
		this.dataEmissaoRg = dataEmissaoRg;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Character getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(Character tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
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
