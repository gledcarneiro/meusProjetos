package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfRecebimentoNaoFiscalPagamentoDAO;
import br.com.rabelo.smartserver.domain.EcfRecebimentoNaoFiscalPagamento;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfRecebimentoNaoFiscalPagamentoBean implements Serializable {
	private EcfRecebimentoNaoFiscalPagamento recebimentoNaoFiscalPagamento;
	private List<EcfRecebimentoNaoFiscalPagamento> recebimentoNaoFiscalPagamentos;

	public EcfRecebimentoNaoFiscalPagamento getRecebimentoNaoFiscalPagamento() {
		return recebimentoNaoFiscalPagamento;
	}

	public void setRecebimentoNaoFiscalPagamento(EcfRecebimentoNaoFiscalPagamento recebimentoNaoFiscalPagamento) {
		this.recebimentoNaoFiscalPagamento = recebimentoNaoFiscalPagamento;
	}

	public List<EcfRecebimentoNaoFiscalPagamento> getRecebimentoNaoFiscalPagamentos() {
		return recebimentoNaoFiscalPagamentos;
	}

	public void setRecebimentoNaoFiscalPagamentos(List<EcfRecebimentoNaoFiscalPagamento> recebimentoNaoFiscalPagamentos) {
		this.recebimentoNaoFiscalPagamentos = recebimentoNaoFiscalPagamentos;
	}

	public void novo() {
		recebimentoNaoFiscalPagamento = new EcfRecebimentoNaoFiscalPagamento();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfRecebimentoNaoFiscalPagamentoDAO recebimentoNaoFiscalPagamentoDAO = new EcfRecebimentoNaoFiscalPagamentoDAO();
			recebimentoNaoFiscalPagamentos = recebimentoNaoFiscalPagamentoDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os recebimentoNaoFiscalPagamentos !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfRecebimentoNaoFiscalPagamentoDAO recebimentoNaoFiscalPagamentoDAO = new EcfRecebimentoNaoFiscalPagamentoDAO();
			recebimentoNaoFiscalPagamentoDAO.merge(recebimentoNaoFiscalPagamento);
			
			recebimentoNaoFiscalPagamento = new EcfRecebimentoNaoFiscalPagamento();
			recebimentoNaoFiscalPagamentos = recebimentoNaoFiscalPagamentoDAO.listar();			
			Messages.addGlobalInfo("RecebimentoNaoFiscalPagamento salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o recebimentoNaoFiscalPagamento !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			recebimentoNaoFiscalPagamento = (EcfRecebimentoNaoFiscalPagamento) evento.getComponent().getAttributes().get("recebimentoNaoFiscalPagamentoSelecionada");
			
			EcfRecebimentoNaoFiscalPagamentoDAO recebimentoNaoFiscalPagamentoDAO = new EcfRecebimentoNaoFiscalPagamentoDAO();
			recebimentoNaoFiscalPagamentoDAO.excluir(recebimentoNaoFiscalPagamento);
			recebimentoNaoFiscalPagamentos = recebimentoNaoFiscalPagamentoDAO.listar();

			Messages.addGlobalInfo("RecebimentoNaoFiscalPagamento excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o recebimentoNaoFiscalPagamento !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			recebimentoNaoFiscalPagamento = (EcfRecebimentoNaoFiscalPagamento) evento.getComponent().getAttributes().get("recebimentoNaoFiscalPagamentoSelecionada");

			Messages.addGlobalInfo("RecebimentoNaoFiscalPagamento excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o recebimentoNaoFiscalPagamento !");
			erro.printStackTrace();
		}
	}

}

