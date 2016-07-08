package br.com.rabelo.smartserver.dao;

import org.junit.Test;

import br.com.rabelo.smartserver.dao.PapelDAO;
import br.com.rabelo.smartserver.domain.Papel;

public class PapelDAOTest {
	@Test
	public void salvar() {
		Papel papel = new Papel();
		papel.setNome("USARIO");
		papel.setDescricao("USUARIO SIMPLES DE SISTEMA");

		PapelDAO papelDAO = new PapelDAO();
		papelDAO.salvar(papel);
	}
}
