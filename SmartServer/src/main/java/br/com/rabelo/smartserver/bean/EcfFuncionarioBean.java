package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfFuncionarioDAO;
import br.com.rabelo.smartserver.domain.EcfFuncionario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfFuncionarioBean implements Serializable {
	private EcfFuncionario funcionario;
	private List<EcfFuncionario> funcionarios;

	public EcfFuncionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(EcfFuncionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<EcfFuncionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<EcfFuncionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void novo() {
		funcionario = new EcfFuncionario();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfFuncionarioDAO funcionarioDAO = new EcfFuncionarioDAO();
			funcionarios = funcionarioDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os funcionarios !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfFuncionarioDAO funcionarioDAO = new EcfFuncionarioDAO();
			funcionarioDAO.merge(funcionario);
			
			funcionario = new EcfFuncionario();
			funcionarios = funcionarioDAO.listar();			
			Messages.addGlobalInfo("Funcionario salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o funcionario !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			funcionario = (EcfFuncionario) evento.getComponent().getAttributes().get("funcionarioSelecionada");
			
			EcfFuncionarioDAO funcionarioDAO = new EcfFuncionarioDAO();
			funcionarioDAO.excluir(funcionario);
			funcionarios = funcionarioDAO.listar();

			Messages.addGlobalInfo("Funcionario excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o funcionario !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			funcionario = (EcfFuncionario) evento.getComponent().getAttributes().get("funcionarioSelecionada");

			Messages.addGlobalInfo("Funcionario excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o funcionario !");
			erro.printStackTrace();
		}
	}

}
