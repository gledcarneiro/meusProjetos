package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfRecebimentoNaoFiscalDAO;
import br.com.rabelo.smartserver.domain.EcfRecebimentoNaoFiscal;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfRecebimentoNaoFiscalBean implements Serializable {
	private EcfRecebimentoNaoFiscal recebimentoNaoFiscal;
	private List<EcfRecebimentoNaoFiscal> recebimentoNaoFiscais;

	public EcfRecebimentoNaoFiscal getRecebimentoNaoFiscal() {
		return recebimentoNaoFiscal;
	}

	public void setRecebimentoNaoFiscal(EcfRecebimentoNaoFiscal recebimentoNaoFiscal) {
		this.recebimentoNaoFiscal = recebimentoNaoFiscal;
	}

	public List<EcfRecebimentoNaoFiscal> getRecebimentoNaoFiscals() {
		return recebimentoNaoFiscais;
	}

	public void setRecebimentoNaoFiscals(List<EcfRecebimentoNaoFiscal> recebimentoNaoFiscais) {
		this.recebimentoNaoFiscais = recebimentoNaoFiscais;
	}

	public void novo() {
		recebimentoNaoFiscal = new EcfRecebimentoNaoFiscal();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfRecebimentoNaoFiscalDAO recebimentoNaoFiscalDAO = new EcfRecebimentoNaoFiscalDAO();
			recebimentoNaoFiscais = recebimentoNaoFiscalDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os recebimentoNaoFiscais !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfRecebimentoNaoFiscalDAO recebimentoNaoFiscalDAO = new EcfRecebimentoNaoFiscalDAO();
			recebimentoNaoFiscalDAO.merge(recebimentoNaoFiscal);
			
			recebimentoNaoFiscal = new EcfRecebimentoNaoFiscal();
			recebimentoNaoFiscais = recebimentoNaoFiscalDAO.listar();			
			Messages.addGlobalInfo("RecebimentoNaoFiscal salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o recebimentoNaoFiscal !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			recebimentoNaoFiscal = (EcfRecebimentoNaoFiscal) evento.getComponent().getAttributes().get("recebimentoNaoFiscalSelecionada");
			
			EcfRecebimentoNaoFiscalDAO recebimentoNaoFiscalDAO = new EcfRecebimentoNaoFiscalDAO();
			recebimentoNaoFiscalDAO.excluir(recebimentoNaoFiscal);
			recebimentoNaoFiscais = recebimentoNaoFiscalDAO.listar();

			Messages.addGlobalInfo("RecebimentoNaoFiscal excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o recebimentoNaoFiscal !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			recebimentoNaoFiscal = (EcfRecebimentoNaoFiscal) evento.getComponent().getAttributes().get("recebimentoNaoFiscalSelecionada");

			Messages.addGlobalInfo("RecebimentoNaoFiscal excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o recebimentoNaoFiscal !");
			erro.printStackTrace();
		}
	}

}
