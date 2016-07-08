package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfResolucaoDAO;
import br.com.rabelo.smartserver.domain.EcfResolucao;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfResolucaoBean implements Serializable {
	private EcfResolucao resolucao;
	private List<EcfResolucao> resolucoes;

	public EcfResolucao getResolucao() {
		return resolucao;
	}

	public void setResolucao(EcfResolucao resolucao) {
		this.resolucao = resolucao;
	}

	public List<EcfResolucao> getResolucaos() {
		return resolucoes;
	}

	public void setResolucaos(List<EcfResolucao> resolucoes) {
		this.resolucoes = resolucoes;
	}

	public void novo() {
		resolucao = new EcfResolucao();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfResolucaoDAO resolucaoDAO = new EcfResolucaoDAO();
			resolucoes = resolucaoDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os resolucoes !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfResolucaoDAO resolucaoDAO = new EcfResolucaoDAO();
			resolucaoDAO.merge(resolucao);
			
			resolucao = new EcfResolucao();
			resolucoes = resolucaoDAO.listar();			
			Messages.addGlobalInfo("Resolucao salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o resolucao !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			resolucao = (EcfResolucao) evento.getComponent().getAttributes().get("resolucaoSelecionada");
			
			EcfResolucaoDAO resolucaoDAO = new EcfResolucaoDAO();
			resolucaoDAO.excluir(resolucao);
			resolucoes = resolucaoDAO.listar();

			Messages.addGlobalInfo("Resolucao excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o resolucao !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			resolucao = (EcfResolucao) evento.getComponent().getAttributes().get("resolucaoSelecionada");

			Messages.addGlobalInfo("Resolucao excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o resolucao !");
			erro.printStackTrace();
		}
	}

}

