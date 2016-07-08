package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfEmpresaDAO;
import br.com.rabelo.smartserver.domain.EcfEmpresa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfEmpresaBean implements Serializable {
	private EcfEmpresa empresa;
	private List<EcfEmpresa> empresas;

	public EcfEmpresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EcfEmpresa empresa) {
		this.empresa = empresa;
	}

	public List<EcfEmpresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EcfEmpresa> empresas) {
		this.empresas = empresas;
	}

	public void novo() {
		empresa = new EcfEmpresa();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfEmpresaDAO empresaDAO = new EcfEmpresaDAO();
			empresas = empresaDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar as empresas !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {

			EcfEmpresaDAO empresaDAO = new EcfEmpresaDAO();
			empresaDAO.merge(empresa);

			empresa = new EcfEmpresa();
			empresas = empresaDAO.listar();
			Messages.addGlobalInfo("Empresa salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar a empresa !");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			empresa = (EcfEmpresa) evento.getComponent().getAttributes().get("empresaSelecionada");

			EcfEmpresaDAO empresaDAO = new EcfEmpresaDAO();
			empresaDAO.excluir(empresa);
			empresas = empresaDAO.listar();

			Messages.addGlobalInfo("Empresa excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir a empresa !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			empresa = (EcfEmpresa) evento.getComponent().getAttributes().get("empresaSelecionada");

			Messages.addGlobalInfo("Empresa editada com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao editar a empresa !");
			erro.printStackTrace();
		}
	}

}
