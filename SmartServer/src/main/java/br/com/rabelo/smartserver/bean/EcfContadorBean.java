package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfContadorDAO;
import br.com.rabelo.smartserver.domain.EcfContador;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfContadorBean implements Serializable {
	private EcfContador contador;
	private List<EcfContador> contadores;

	public EcfContador getContador() {
		return contador;
	}

	public void setContador(EcfContador contador) {
		this.contador = contador;
	}

	public List<EcfContador> getContadors() {
		return contadores;
	}

	public void setContadors(List<EcfContador> contadores) {
		this.contadores = contadores;
	}

	public void novo() {
		contador = new EcfContador();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfContadorDAO contadorDAO = new EcfContadorDAO();
			contadores = contadorDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar as contadores !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfContadorDAO contadorDAO = new EcfContadorDAO();
			contadorDAO.merge(contador);

			contador = new EcfContador();
			contadores = contadorDAO.listar();
			Messages.addGlobalInfo("Contador salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o contador !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			contador = (EcfContador) evento.getComponent().getAttributes().get("contadorSelecionada");

			EcfContadorDAO contadorDAO = new EcfContadorDAO();
			contadorDAO.excluir(contador);
			contadores = contadorDAO.listar();

			Messages.addGlobalInfo("Contador excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o contador !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			contador = (EcfContador) evento.getComponent().getAttributes().get("contadorSelecionada");

			Messages.addGlobalInfo("Contador excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o contador !");
			erro.printStackTrace();
		}
	}

}
