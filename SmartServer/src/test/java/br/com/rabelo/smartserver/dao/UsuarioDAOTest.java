package br.com.rabelo.smartserver.dao;

import java.util.Date;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import br.com.rabelo.smartserver.domain.Colaborador;
import br.com.rabelo.smartserver.domain.Papel;
import br.com.rabelo.smartserver.domain.Usuario;

public class UsuarioDAOTest {
	@Test
	public void salva() {
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
		Colaborador colaborador = colaboradorDAO.buscar(1);
		
		PapelDAO papelDAO = new PapelDAO();
		Papel papel = papelDAO.buscar(1);
		
		Usuario usuario = new Usuario();
		
		usuario.setPapel(papel);
		usuario.setColaborador(colaborador);
		usuario.setLogin("91033");

		usuario.setSenhaSemCriptografia("teste1979");
		SimpleHash hash = new SimpleHash("md5", usuario.getSenhaSemCriptografia());
		usuario.setSenha(hash.toHex());

		usuario.setDataCadastro(new Date());
		usuario.setNivelAutorizacaoEcf('B');
		usuario.setHashTripa(hash.toHex());
		usuario.setHashIncremento(0);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
	}
	
	@Test
	@Ignore
	public void autenticar(){
		String login = "91031";
		String senha = "gled1979";
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.autenticar(login, senha);
		
		System.out.println("Usuario autenticado " + usuario.getLogin());
		
	}
}
