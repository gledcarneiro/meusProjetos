package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import br.com.rabelo.smartserver.dao.EcfAliquotasDAO;
import br.com.rabelo.smartserver.domain.EcfAliquotas;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfAliquotasBean implements Serializable {
	private EcfAliquotas aliquota;
	private List<EcfAliquotas> aliquotas;

	public EcfAliquotas getAliquota() {
		return aliquota;
	}

	public void setAliquota(EcfAliquotas aliquota) {
		this.aliquota = aliquota;
	}

	public List<EcfAliquotas> getAliquotas() {
		return aliquotas;
	}

	public void setAliquotas(List<EcfAliquotas> aliquotas) {
		this.aliquotas = aliquotas;
	}

	public void novo() {
		aliquota = new EcfAliquotas();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfAliquotasDAO aliquotasDAO = new EcfAliquotasDAO();
			aliquotas = aliquotasDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao lsitar as aliquotas !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfAliquotasDAO aliquotasDAO = new EcfAliquotasDAO();
			aliquotasDAO.merge(aliquota);

			aliquota = new EcfAliquotas();
			aliquotas = aliquotasDAO.listar();

			Messages.addGlobalInfo("Aliquota salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salva o aliquota !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			aliquota = (EcfAliquotas) evento.getComponent().getAttributes().get("aliquotaSelecionada");

			EcfAliquotasDAO aliquotasDAO = new EcfAliquotasDAO();
			aliquotasDAO.excluir(aliquota);
			
			aliquotas = aliquotasDAO.listar();

			Messages.addGlobalInfo("Aliquota excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir a aliquota !");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		try {
			aliquota = (EcfAliquotas) evento.getComponent().getAttributes().get("aliquotaSelecionada");

			Messages.addGlobalInfo("Aliquota excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir a aliquota !");
			erro.printStackTrace();
		}
	}
	
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Aliquota Select", ((EcfAliquotas) event.getObject()).getCodigo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((EcfAliquotas) event.getObject()).getCodigo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
