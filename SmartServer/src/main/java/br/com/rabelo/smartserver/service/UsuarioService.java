package br.com.rabelo.smartserver.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.com.rabelo.smartserver.dao.UsuarioDAO;
import br.com.rabelo.smartserver.domain.Usuario;

@Path("usuario")
public class UsuarioService {
	// http://localhost:8080/SmartServer/rest/usuario
	@GET
	public String listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarios = usuarioDAO.listar();
		
		System.out.println(usuarios.size());
		
		Gson  gson = new Gson();
		String json = gson.toJson(usuarios);
		
		System.out.println("json obtido ->" + json);
		
		return json;
	}

}
