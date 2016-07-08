package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfPosicaoComponentesDAO;
import br.com.rabelo.smartserver.domain.EcfPosicaoComponentes;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfPosicaoComponentesBean implements Serializable {
	private EcfPosicaoComponentes componente;
	private List<EcfPosicaoComponentes> componentes;

	public EcfPosicaoComponentes getPosicaoComponentes() {
		return componente;
	}

	public void setPosicaoComponentes(EcfPosicaoComponentes componente) {
		this.componente = componente;
	}

	public List<EcfPosicaoComponentes> getPosicaoComponentess() {
		return componentes;
	}

	public void setPosicaoComponentess(List<EcfPosicaoComponentes> componentes) {
		this.componentes = componentes;
	}

	public void novo() {
		componente = new EcfPosicaoComponentes();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfPosicaoComponentesDAO componenteDAO = new EcfPosicaoComponentesDAO();
			componentes = componenteDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os componentes !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfPosicaoComponentesDAO componenteDAO = new EcfPosicaoComponentesDAO();
			componenteDAO.merge(componente);
			
			componente = new EcfPosicaoComponentes();
			componentes = componenteDAO.listar();			
			Messages.addGlobalInfo("PosicaoComponentes salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o componente !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			componente = (EcfPosicaoComponentes) evento.getComponent().getAttributes().get("componenteSelecionada");
			
			EcfPosicaoComponentesDAO componenteDAO = new EcfPosicaoComponentesDAO();
			componenteDAO.excluir(componente);
			componentes = componenteDAO.listar();

			Messages.addGlobalInfo("PosicaoComponentes excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o componente !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			componente = (EcfPosicaoComponentes) evento.getComponent().getAttributes().get("componenteSelecionada");

			Messages.addGlobalInfo("PosicaoComponentes excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o componente !");
			erro.printStackTrace();
		}
	}

}
