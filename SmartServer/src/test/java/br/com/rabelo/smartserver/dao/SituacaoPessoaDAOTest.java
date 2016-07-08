package br.com.rabelo.smartserver.dao;

import java.util.List;

import org.junit.Test;

import br.com.rabelo.smartserver.domain.SituacaoPessoa;

public class SituacaoPessoaDAOTest {
	@Test
	public void listar(){
		SituacaoPessoaDAO situacaoPessoaDAO = new SituacaoPessoaDAO();
		List<SituacaoPessoa> resultado = situacaoPessoaDAO.listar();
		
		System.out.println("total de Situacoe cadastrada " + resultado.size());		
	}
}
