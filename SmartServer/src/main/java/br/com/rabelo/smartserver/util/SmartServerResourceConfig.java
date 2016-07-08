package br.com.rabelo.smartserver.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class SmartServerResourceConfig extends ResourceConfig {
	public SmartServerResourceConfig() {
		packages("br.com.rabelo.smartserver.service");
	}
}
