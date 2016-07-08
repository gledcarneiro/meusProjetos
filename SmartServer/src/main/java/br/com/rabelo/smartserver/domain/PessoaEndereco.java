package br.com.rabelo.smartserver.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_endereco", catalog = "retaguarda")
public class PessoaEndereco extends GenericDomain {
	@ManyToOne
	@JoinColumn(name = "ID_PESSOA", nullable = false)
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_ENDERECO", nullable = false)
	private TipoEndereco idTipoEndereco;

	@Column(name = "LOGRADOURO", length = 250)
	private String logradouro;

	@Column(name = "NUMERO", length = 6)
	private String numero;

	@Column(name = "COMPLEMENTO", length = 50)
	private String complemento;

	@Column(name = "CEP", length = 8)
	private String cep;

	@Column(name = "BAIRRO", length = 100)
	private String bairro;

	@Column(name = "CIDADE", length = 100)
	private String cidade;

	@Column(name = "UF", length = 2)
	private String uf;

	@Column(name = "CODIGO_IBGE_CIDADE")
	private Integer codigoIbgeCidade;

	@Column(name = "CODIGO_IBGE_UF")
	private Integer codigoIbgeUf;

	@Column(name = "HASH_TRIPA", length = 32)
	private String hashTripa;

	@Column(name = "HASH_INCREMENTO")
	private Integer hashIncremento;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoEndereco getIdTipoEndereco() {
		return idTipoEndereco;
	}

	public void setIdTipoEndereco(TipoEndereco idTipoEndereco) {
		this.idTipoEndereco = idTipoEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getCodigoIbgeCidade() {
		return codigoIbgeCidade;
	}

	public void setCodigoIbgeCidade(Integer codigoIbgeCidade) {
		this.codigoIbgeCidade = codigoIbgeCidade;
	}

	public Integer getCodigoIbgeUf() {
		return codigoIbgeUf;
	}

	public void setCodigoIbgeUf(Integer codigoIbgeUf) {
		this.codigoIbgeUf = codigoIbgeUf;
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
