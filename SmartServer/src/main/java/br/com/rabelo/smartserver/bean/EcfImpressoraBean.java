package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfImpressoraDAO;
import br.com.rabelo.smartserver.domain.EcfImpressora;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfImpressoraBean implements Serializable {
	private EcfImpressora impressora;
	private List<EcfImpressora> impressoras;

	public EcfImpressora getImpressora() {
		return impressora;
	}

	public void setImpressora(EcfImpressora impressora) {
		this.impressora = impressora;
	}

	public List<EcfImpressora> getImpressoras() {
		return impressoras;
	}

	public void setImpressoras(List<EcfImpressora> impressoras) {
		this.impressoras = impressoras;
	}

	public void novo() {
		impressora = new EcfImpressora();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfImpressoraDAO impressoraDAO = new EcfImpressoraDAO();
			impressoras = impressoraDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os impressoras !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfImpressoraDAO impressoraDAO = new EcfImpressoraDAO();
			impressoraDAO.merge(impressora);
			
			impressora = new EcfImpressora();
			impressoras = impressoraDAO.listar();			
			Messages.addGlobalInfo("Impressora salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o impressora !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			impressora = (EcfImpressora) evento.getComponent().getAttributes().get("impressoraSelecionada");
			
			EcfImpressoraDAO impressoraDAO = new EcfImpressoraDAO();
			impressoraDAO.excluir(impressora);
			impressoras = impressoraDAO.listar();

			Messages.addGlobalInfo("Impressora excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o impressora !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			impressora = (EcfImpressora) evento.getComponent().getAttributes().get("impressoraSelecionada");

			Messages.addGlobalInfo("Impressora excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o impressora !");
			erro.printStackTrace();
		}
	}

}
