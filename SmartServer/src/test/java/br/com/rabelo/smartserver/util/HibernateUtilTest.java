package br.com.rabelo.smartserver.util;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

public class HibernateUtilTest {
	@Test
	@Ignore
	public void conectar() {
		Session sessao = HibernateUtil.getFabricaSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaSessoes().close();
	}
}
