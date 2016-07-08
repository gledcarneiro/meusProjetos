package br.com.rabelo.smartserver.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipo_endereco", catalog = "retaguarda")
public class TipoEndereco extends GenericDomain {
	@Column(name = "NOME", length = 30)
	private String nome;

	@Column(name = "DESCRICAO", length = 65535)
	private String descricao;

	@Column(name = "HASH_TRIPA", length = 32)
	private String hashTripa;

	@Column(name = "HASH_INCREMENTO")
	private Integer hashIncremento;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "idTipoEndereco")
	private List<PessoaEndereco> pessoaEnderecos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public List<PessoaEndereco> getPessoaEnderecos() {
		return pessoaEnderecos;
	}

	public void setPessoaEnderecos(List<PessoaEndereco> pessoaEnderecos) {
		this.pessoaEnderecos = pessoaEnderecos;
	}
}
