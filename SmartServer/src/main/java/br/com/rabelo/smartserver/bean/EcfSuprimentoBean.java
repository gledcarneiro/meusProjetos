package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfSuprimentoDAO;
import br.com.rabelo.smartserver.domain.EcfSuprimento;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfSuprimentoBean implements Serializable {
	private EcfSuprimento suprimento;
	private List<EcfSuprimento> suprimentos;

	public EcfSuprimento getSuprimento() {
		return suprimento;
	}

	public void setSuprimento(EcfSuprimento suprimento) {
		this.suprimento = suprimento;
	}

	public List<EcfSuprimento> getSuprimentos() {
		return suprimentos;
	}

	public void setSuprimentos(List<EcfSuprimento> suprimentos) {
		this.suprimentos = suprimentos;
	}

	public void novo() {
		suprimento = new EcfSuprimento();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfSuprimentoDAO suprimentoDAO = new EcfSuprimentoDAO();
			suprimentos = suprimentoDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os suprimentos !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfSuprimentoDAO suprimentoDAO = new EcfSuprimentoDAO();
			suprimentoDAO.merge(suprimento);
			
			suprimento = new EcfSuprimento();
			suprimentos = suprimentoDAO.listar();			
			Messages.addGlobalInfo("Suprimento salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o suprimento !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			suprimento = (EcfSuprimento) evento.getComponent().getAttributes().get("suprimentoSelecionada");
			
			EcfSuprimentoDAO suprimentoDAO = new EcfSuprimentoDAO();
			suprimentoDAO.excluir(suprimento);
			suprimentos = suprimentoDAO.listar();

			Messages.addGlobalInfo("Suprimento excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o suprimento !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			suprimento = (EcfSuprimento) evento.getComponent().getAttributes().get("suprimentoSelecionada");

			Messages.addGlobalInfo("Suprimento excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o suprimento !");
			erro.printStackTrace();
		}
	}

}


