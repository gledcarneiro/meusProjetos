package br.com.rabelo.smartserver.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.rabelo.smartserver.domain.EcfAliquotas;

public class EcfAliquotasDAOTest {
	@Test
	@Ignore
	public void salvar() {
		EcfAliquotas aliquota = new EcfAliquotas();

		aliquota.setTotalizadorParcial("06F0000");
		aliquota.setEcfIcmsSt("F7");
		aliquota.setPafPSt('N');
		aliquota.setCodigo(null);
		aliquota.setHashTripa("0462515bb1ef13512e474e0b1e4240a2");
		aliquota.setHashIncremento(0);

		EcfAliquotasDAO aliquotaDAO = new EcfAliquotasDAO();
		aliquotaDAO.salvar(aliquota);
	}

	@Test
	@Ignore
	public void listar() {
		EcfAliquotasDAO aliquotaDAO = new EcfAliquotasDAO();
		List<EcfAliquotas> resultado = aliquotaDAO.listar();

		System.out.println("Total de regostos " + resultado.size());

		for (EcfAliquotas aliquota : resultado) {
			System.out.println(aliquota.getTotalizadorParcial());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Integer id = 10;

		EcfAliquotasDAO aliquotaDAO = new EcfAliquotasDAO();
		EcfAliquotas aliquota = aliquotaDAO.buscar(id);

		if (aliquota == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println(aliquota.getTotalizadorParcial());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Integer id = 11;

		EcfAliquotasDAO aliquotaDAO = new EcfAliquotasDAO();
		EcfAliquotas aliquota = aliquotaDAO.buscar(id);

		if (aliquota == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			aliquotaDAO.excluir(aliquota);
			System.out.println(aliquota.getTotalizadorParcial());
		}
	}

	@Test
	@Ignore
	public void editar() {
		Integer id = 10;

		EcfAliquotasDAO aliquotaDAO = new EcfAliquotasDAO();
		EcfAliquotas aliquota = aliquotaDAO.buscar(id);

		if (aliquota == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			aliquota.setHashTripa("0000000000000000000");
			aliquotaDAO.editar(aliquota);
			System.out.println(aliquota.getTotalizadorParcial());
		}
	}

}
