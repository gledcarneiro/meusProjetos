package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfTipoPagamentoDAO;
import br.com.rabelo.smartserver.domain.EcfTipoPagamento;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfTipoPagamentoBean implements Serializable {
	private EcfTipoPagamento tipoPagamento;
	private List<EcfTipoPagamento> tipoPagamentos;

	public EcfTipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(EcfTipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public List<EcfTipoPagamento> getTipoPagamentos() {
		return tipoPagamentos;
	}

	public void setTipoPagamentos(List<EcfTipoPagamento> tipoPagamentos) {
		this.tipoPagamentos = tipoPagamentos;
	}

	public void novo() {
		tipoPagamento = new EcfTipoPagamento();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfTipoPagamentoDAO tipoPagamentoDAO = new EcfTipoPagamentoDAO();
			tipoPagamentos = tipoPagamentoDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os tipoPagamentos !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfTipoPagamentoDAO tipoPagamentoDAO = new EcfTipoPagamentoDAO();
			tipoPagamentoDAO.merge(tipoPagamento);
			
			tipoPagamento = new EcfTipoPagamento();
			tipoPagamentos = tipoPagamentoDAO.listar();			
			Messages.addGlobalInfo("TipoPagamento salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o tipoPagamento !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			tipoPagamento = (EcfTipoPagamento) evento.getComponent().getAttributes().get("tipoPagamentoSelecionada");
			
			EcfTipoPagamentoDAO tipoPagamentoDAO = new EcfTipoPagamentoDAO();
			tipoPagamentoDAO.excluir(tipoPagamento);
			tipoPagamentos = tipoPagamentoDAO.listar();

			Messages.addGlobalInfo("TipoPagamento excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o tipoPagamento !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			tipoPagamento = (EcfTipoPagamento) evento.getComponent().getAttributes().get("tipoPagamentoSelecionada");

			Messages.addGlobalInfo("TipoPagamento excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o tipoPagamento !");
			erro.printStackTrace();
		}
	}

}


