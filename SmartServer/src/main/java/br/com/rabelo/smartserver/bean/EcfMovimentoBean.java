package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfMovimentoDAO;
import br.com.rabelo.smartserver.domain.EcfMovimento;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfMovimentoBean implements Serializable {
	private EcfMovimento movimento;
	private List<EcfMovimento> movimentos;

	public EcfMovimento getMovimento() {
		return movimento;
	}

	public void setMovimento(EcfMovimento movimento) {
		this.movimento = movimento;
	}

	public List<EcfMovimento> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(List<EcfMovimento> movimentos) {
		this.movimentos = movimentos;
	}

	public void novo() {
		movimento = new EcfMovimento();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfMovimentoDAO movimentoDAO = new EcfMovimentoDAO();
			movimentos = movimentoDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os movimentos !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfMovimentoDAO movimentoDAO = new EcfMovimentoDAO();
			movimentoDAO.merge(movimento);
			
			movimento = new EcfMovimento();
			movimentos = movimentoDAO.listar();			
			Messages.addGlobalInfo("Movimento salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o movimento !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			movimento = (EcfMovimento) evento.getComponent().getAttributes().get("movimentoSelecionada");
			
			EcfMovimentoDAO movimentoDAO = new EcfMovimentoDAO();
			movimentoDAO.excluir(movimento);
			movimentos = movimentoDAO.listar();

			Messages.addGlobalInfo("Movimento excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o movimento !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			movimento = (EcfMovimento) evento.getComponent().getAttributes().get("movimentoSelecionada");

			Messages.addGlobalInfo("Movimento excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o movimento !");
			erro.printStackTrace();
		}
	}

}
