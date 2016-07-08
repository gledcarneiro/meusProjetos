package br.com.rabelo.smartserver.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory fabricaSessoes = criarFabricaSessoes();

	public static SessionFactory getFabricaSessoes() {
		return fabricaSessoes;
	}

	private static SessionFactory criarFabricaSessoes() {
		try {
			Configuration config = new Configuration().configure();
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
					.build();
			SessionFactory fabrica = config.buildSessionFactory(registro);
			return fabrica;
		} catch (Throwable ex) {
			System.err.println("Não pode ser criada a Fábrica de Sessões " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
