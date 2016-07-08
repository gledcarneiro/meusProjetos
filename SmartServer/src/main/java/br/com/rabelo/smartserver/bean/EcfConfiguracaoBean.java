package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfConfiguracaoDAO;
import br.com.rabelo.smartserver.domain.EcfConfiguracao;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfConfiguracaoBean implements Serializable {
	private EcfConfiguracao configuracao;
	private List<EcfConfiguracao> configuracoes;

	public EcfConfiguracao getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(EcfConfiguracao configuracao) {
		this.configuracao = configuracao;
	}

	public List<EcfConfiguracao> getConfiguracaos() {
		return configuracoes;
	}

	public void setConfiguracaos(List<EcfConfiguracao> configuracoes) {
		this.configuracoes = configuracoes;
	}

	public void novo() {
		configuracao = new EcfConfiguracao();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfConfiguracaoDAO configuracaoDAO = new EcfConfiguracaoDAO();
			configuracoes = configuracaoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar as configuracoess !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfConfiguracaoDAO configuracaoDAO = new EcfConfiguracaoDAO();
			configuracaoDAO.merge(configuracao);

			configuracao = new EcfConfiguracao();
			configuracoes = configuracaoDAO.listar();
			Messages.addGlobalInfo("Configuracao salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o configuracao !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			configuracao = (EcfConfiguracao) evento.getComponent().getAttributes().get("configuracaoSelecionada");

			EcfConfiguracaoDAO configuracaoDAO = new EcfConfiguracaoDAO();
			configuracaoDAO.excluir(configuracao);
			configuracoes = configuracaoDAO.listar();

			Messages.addGlobalInfo("Configuracao excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o configuracao !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			configuracao = (EcfConfiguracao) evento.getComponent().getAttributes().get("configuracaoSelecionada");

			Messages.addGlobalInfo("Configuracao excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o configuracao !");
			erro.printStackTrace();
		}
	}
}
