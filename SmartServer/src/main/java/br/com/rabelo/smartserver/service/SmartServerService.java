package br.com.rabelo.smartserver.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("smartserver")
public class SmartServerService {
	@GET
	public String exibir(){
		return "TEste REst";
	}
}
