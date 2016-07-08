package br.com.rabelo.smartserver.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.rabelo.smartserver.domain.Pessoa;

public class PessoaDAOTest {
	@Test
	public void salvar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setCodigo("91122");
		pessoa.setNome("CELIA DOS SANTOS LIMA");
		pessoa.setEmail("celia@rabelo.com.br");
		pessoa.setCpfCnpj("63257980310");
		pessoa.setRg("283933929");
		pessoa.setOrgaoRg("SSP-CE");
		pessoa.setDataEmissaoRg(new Date());
		pessoa.setSexo('F');
		pessoa.setTipoPessoa('U');
		pessoa.setDataCadastro(new Date());
		pessoa.setFone1("8534659000");
		pessoa.setCelular("859893067475");

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
	}

	@Test
	@Ignore
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();

		System.out.println("Total de pessoas " + resultado.size());

		for (Pessoa pessoa : resultado) {
			System.out.println(pessoa.getNome());
		}
	}
}
