package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfCaixaDAO;
import br.com.rabelo.smartserver.domain.EcfCaixa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfCaixaBean implements Serializable {
	private EcfCaixa caixa;
	private List<EcfCaixa> caixas;

	public EcfCaixa getCaixa() {
		return caixa;
	}

	public void setCaixa(EcfCaixa caixa) {
		this.caixa = caixa;
	}

	public List<EcfCaixa> getCaixas() {
		return caixas;
	}

	public void setCaixas(List<EcfCaixa> caixas) {
		this.caixas = caixas;
	}

	public void novo() {
		caixa = new EcfCaixa();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfCaixaDAO caixaDAO = new EcfCaixaDAO();
			caixas = caixaDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os caixas !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfCaixaDAO caixaDAO = new EcfCaixaDAO();
			caixaDAO.merge(caixa);
			
			caixa = new EcfCaixa();
			caixas = caixaDAO.listar();			
			Messages.addGlobalInfo("Caixa salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o caixa !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			caixa = (EcfCaixa) evento.getComponent().getAttributes().get("caixaSelecionada");
			
			EcfCaixaDAO caixaDAO = new EcfCaixaDAO();
			caixaDAO.excluir(caixa);
			caixas = caixaDAO.listar();

			Messages.addGlobalInfo("Caixa excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o caixa !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			caixa = (EcfCaixa) evento.getComponent().getAttributes().get("caixaSelecionada");

			Messages.addGlobalInfo("Caixa excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o caixa !");
			erro.printStackTrace();
		}
	}

}
