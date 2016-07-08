package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfTipoRelatorioGerencialDAO;
import br.com.rabelo.smartserver.domain.EcfTipoRelatorioGerencial;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfTipoRelatorioGerencialBean implements Serializable {
	private EcfTipoRelatorioGerencial tipoRelatorioGerencial;
	private List<EcfTipoRelatorioGerencial> tipoRelatorioGerenciais;

	public EcfTipoRelatorioGerencial getTipoRelatorioGerencial() {
		return tipoRelatorioGerencial;
	}

	public void setTipoRelatorioGerencial(EcfTipoRelatorioGerencial tipoRelatorioGerencial) {
		this.tipoRelatorioGerencial = tipoRelatorioGerencial;
	}

	public List<EcfTipoRelatorioGerencial> getTipoRelatorioGerencials() {
		return tipoRelatorioGerenciais;
	}

	public void setTipoRelatorioGerencials(List<EcfTipoRelatorioGerencial> tipoRelatorioGerenciais) {
		this.tipoRelatorioGerenciais = tipoRelatorioGerenciais;
	}

	public void novo() {
		tipoRelatorioGerencial = new EcfTipoRelatorioGerencial();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfTipoRelatorioGerencialDAO tipoRelatorioGerencialDAO = new EcfTipoRelatorioGerencialDAO();
			tipoRelatorioGerenciais = tipoRelatorioGerencialDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os tipoRelatorioGerenciais !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfTipoRelatorioGerencialDAO tipoRelatorioGerencialDAO = new EcfTipoRelatorioGerencialDAO();
			tipoRelatorioGerencialDAO.merge(tipoRelatorioGerencial);
			
			tipoRelatorioGerencial = new EcfTipoRelatorioGerencial();
			tipoRelatorioGerenciais = tipoRelatorioGerencialDAO.listar();			
			Messages.addGlobalInfo("TipoRelatorioGerencial salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o tipoRelatorioGerencial !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			tipoRelatorioGerencial = (EcfTipoRelatorioGerencial) evento.getComponent().getAttributes().get("tipoRelatorioGerencialSelecionada");
			
			EcfTipoRelatorioGerencialDAO tipoRelatorioGerencialDAO = new EcfTipoRelatorioGerencialDAO();
			tipoRelatorioGerencialDAO.excluir(tipoRelatorioGerencial);
			tipoRelatorioGerenciais = tipoRelatorioGerencialDAO.listar();

			Messages.addGlobalInfo("TipoRelatorioGerencial excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o tipoRelatorioGerencial !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			tipoRelatorioGerencial = (EcfTipoRelatorioGerencial) evento.getComponent().getAttributes().get("tipoRelatorioGerencialSelecionada");

			Messages.addGlobalInfo("TipoRelatorioGerencial excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o tipoRelatorioGerencial !");
			erro.printStackTrace();
		}
	}

}


