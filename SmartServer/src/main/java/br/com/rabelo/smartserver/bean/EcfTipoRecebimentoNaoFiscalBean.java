package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfTipoRecebimentoNaoFiscalDAO;
import br.com.rabelo.smartserver.domain.EcfTipoRecebimentoNaoFiscal;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfTipoRecebimentoNaoFiscalBean implements Serializable {
	private EcfTipoRecebimentoNaoFiscal tipoRecebimentoNaoFiscal;
	private List<EcfTipoRecebimentoNaoFiscal> tipoRecebimentoNaoFiscais;

	public EcfTipoRecebimentoNaoFiscal getTipoRecebimentoNaoFiscal() {
		return tipoRecebimentoNaoFiscal;
	}

	public void setTipoRecebimentoNaoFiscal(EcfTipoRecebimentoNaoFiscal tipoRecebimentoNaoFiscal) {
		this.tipoRecebimentoNaoFiscal = tipoRecebimentoNaoFiscal;
	}

	public List<EcfTipoRecebimentoNaoFiscal> getTipoRecebimentoNaoFiscals() {
		return tipoRecebimentoNaoFiscais;
	}

	public void setTipoRecebimentoNaoFiscals(List<EcfTipoRecebimentoNaoFiscal> tipoRecebimentoNaoFiscais) {
		this.tipoRecebimentoNaoFiscais = tipoRecebimentoNaoFiscais;
	}

	public void novo() {
		tipoRecebimentoNaoFiscal = new EcfTipoRecebimentoNaoFiscal();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfTipoRecebimentoNaoFiscalDAO tipoRecebimentoNaoFiscalDAO = new EcfTipoRecebimentoNaoFiscalDAO();
			tipoRecebimentoNaoFiscais = tipoRecebimentoNaoFiscalDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os tipoRecebimentoNaoFiscais !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfTipoRecebimentoNaoFiscalDAO tipoRecebimentoNaoFiscalDAO = new EcfTipoRecebimentoNaoFiscalDAO();
			tipoRecebimentoNaoFiscalDAO.merge(tipoRecebimentoNaoFiscal);
			
			tipoRecebimentoNaoFiscal = new EcfTipoRecebimentoNaoFiscal();
			tipoRecebimentoNaoFiscais = tipoRecebimentoNaoFiscalDAO.listar();			
			Messages.addGlobalInfo("TipoRecebimentoNaoFiscal salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o tipoRecebimentoNaoFiscal !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			tipoRecebimentoNaoFiscal = (EcfTipoRecebimentoNaoFiscal) evento.getComponent().getAttributes().get("tipoRecebimentoNaoFiscalSelecionada");
			
			EcfTipoRecebimentoNaoFiscalDAO tipoRecebimentoNaoFiscalDAO = new EcfTipoRecebimentoNaoFiscalDAO();
			tipoRecebimentoNaoFiscalDAO.excluir(tipoRecebimentoNaoFiscal);
			tipoRecebimentoNaoFiscais = tipoRecebimentoNaoFiscalDAO.listar();

			Messages.addGlobalInfo("TipoRecebimentoNaoFiscal excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o tipoRecebimentoNaoFiscal !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			tipoRecebimentoNaoFiscal = (EcfTipoRecebimentoNaoFiscal) evento.getComponent().getAttributes().get("tipoRecebimentoNaoFiscalSelecionada");

			Messages.addGlobalInfo("TipoRecebimentoNaoFiscal excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o tipoRecebimentoNaoFiscal !");
			erro.printStackTrace();
		}
	}

}


