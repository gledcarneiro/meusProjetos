package br.com.rabelo.smartserver.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.rabelo.smartserver.dao.EcfAliquotasDAO;
import br.com.rabelo.smartserver.domain.EcfAliquotas;

@Path("aliquota")
public class AliquotaService {
	// http://localhost:8080/SmartServer/rest/aliquota
	@GET
	public String listar() {
		EcfAliquotasDAO aliquotaDAO = new EcfAliquotasDAO();
		List<EcfAliquotas> aliquotas = aliquotaDAO.listar();
		
		Gson gson = new Gson();
		String json = gson.toJson(aliquotas);
		
		return json;
	}
	
	// http://localhost:8080/SmartServer/rest/aliquota/10
	@GET
	@Path("{id}")
	public String buscar(@PathParam("id") int id){
		EcfAliquotasDAO aliquotaDAO = new EcfAliquotasDAO();
		EcfAliquotas aliquota = aliquotaDAO.buscar(id);

		Gson gson = new Gson();
		String json = gson.toJson(aliquota);
		
		return json;
		
	}
}
