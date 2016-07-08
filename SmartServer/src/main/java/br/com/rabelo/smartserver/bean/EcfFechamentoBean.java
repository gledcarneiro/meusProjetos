package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfFechamentoDAO;
import br.com.rabelo.smartserver.domain.EcfFechamento;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfFechamentoBean implements Serializable {
	private EcfFechamento fechamento;
	private List<EcfFechamento> fechamentos;

	public EcfFechamento getFechamento() {
		return fechamento;
	}

	public void setFechamento(EcfFechamento fechamento) {
		this.fechamento = fechamento;
	}

	public List<EcfFechamento> getFechamentos() {
		return fechamentos;
	}

	public void setFechamentos(List<EcfFechamento> fechamentos) {
		this.fechamentos = fechamentos;
	}

	public void novo() {
		fechamento = new EcfFechamento();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfFechamentoDAO fechamentoDAO = new EcfFechamentoDAO();
			fechamentos = fechamentoDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os fechamentos !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfFechamentoDAO fechamentoDAO = new EcfFechamentoDAO();
			fechamentoDAO.merge(fechamento);
			
			fechamento = new EcfFechamento();
			fechamentos = fechamentoDAO.listar();			
			Messages.addGlobalInfo("Fechamento salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o fechamento !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			fechamento = (EcfFechamento) evento.getComponent().getAttributes().get("fechamentoSelecionada");
			
			EcfFechamentoDAO fechamentoDAO = new EcfFechamentoDAO();
			fechamentoDAO.excluir(fechamento);
			fechamentos = fechamentoDAO.listar();

			Messages.addGlobalInfo("Fechamento excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o fechamento !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			fechamento = (EcfFechamento) evento.getComponent().getAttributes().get("fechamentoSelecionada");

			Messages.addGlobalInfo("Fechamento excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o fechamento !");
			erro.printStackTrace();
		}
	}

}
