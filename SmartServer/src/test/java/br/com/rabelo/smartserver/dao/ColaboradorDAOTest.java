package br.com.rabelo.smartserver.dao;

import java.util.Date;

import org.junit.Test;

import br.com.rabelo.smartserver.dao.CargoDAO;
import br.com.rabelo.smartserver.dao.ColaboradorDAO;
import br.com.rabelo.smartserver.dao.PessoaDAO;
import br.com.rabelo.smartserver.dao.SetorDAO;
import br.com.rabelo.smartserver.domain.Cargo;
import br.com.rabelo.smartserver.domain.Colaborador;
import br.com.rabelo.smartserver.domain.Pessoa;
import br.com.rabelo.smartserver.domain.Setor;

public class ColaboradorDAOTest {
   @Test
   public void salvar(){
	   Colaborador colaborador = new Colaborador();
	   
	   CargoDAO cargoDAO = new CargoDAO();
	   Cargo cargo = cargoDAO.buscar(1);
	   
	   SetorDAO setorDAO = new SetorDAO();
	   Setor idDepartamento = setorDAO.buscar(1);
	   
	   PessoaDAO pessoaDAO = new PessoaDAO();
	   Pessoa pessoa = pessoaDAO.buscar(1);
	   
	   colaborador.setCargo(cargo);
	   colaborador.setIdDepartamento(idDepartamento);
	   colaborador.setPessoa(pessoa);
	   colaborador.setObservacoes("TESTE DE COLABORADOR");
	   colaborador.setDataCadastro(new Date());
	   
	   ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
	   colaboradorDAO.salvar(colaborador);	      
   }
}
