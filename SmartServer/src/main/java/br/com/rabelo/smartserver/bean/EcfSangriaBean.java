package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfSangriaDAO;
import br.com.rabelo.smartserver.domain.EcfSangria;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfSangriaBean implements Serializable {
	private EcfSangria sangria;
	private List<EcfSangria> sangrias;

	public EcfSangria getSangria() {
		return sangria;
	}

	public void setSangria(EcfSangria sangria) {
		this.sangria = sangria;
	}

	public List<EcfSangria> getSangrias() {
		return sangrias;
	}

	public void setSangrias(List<EcfSangria> sangrias) {
		this.sangrias = sangrias;
	}

	public void novo() {
		sangria = new EcfSangria();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfSangriaDAO sangriaDAO = new EcfSangriaDAO();
			sangrias = sangriaDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os sangrias !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfSangriaDAO sangriaDAO = new EcfSangriaDAO();
			sangriaDAO.merge(sangria);
			
			sangria = new EcfSangria();
			sangrias = sangriaDAO.listar();			
			Messages.addGlobalInfo("Sangria salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o sangria !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			sangria = (EcfSangria) evento.getComponent().getAttributes().get("sangriaSelecionada");
			
			EcfSangriaDAO sangriaDAO = new EcfSangriaDAO();
			sangriaDAO.excluir(sangria);
			sangrias = sangriaDAO.listar();

			Messages.addGlobalInfo("Sangria excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o sangria !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			sangria = (EcfSangria) evento.getComponent().getAttributes().get("sangriaSelecionada");

			Messages.addGlobalInfo("Sangria excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o sangria !");
			erro.printStackTrace();
		}
	}

}

