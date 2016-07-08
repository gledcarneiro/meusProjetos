package br.com.rabelo.smartserver.bean;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfDocumentosEmitidosDAO;
import br.com.rabelo.smartserver.domain.EcfDocumentosEmitidos;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfDocumentosEmitidosBean implements Serializable {
	private EcfDocumentosEmitidos documento;
	private List<EcfDocumentosEmitidos> documentos;

	public EcfDocumentosEmitidos getDocumento() {
		return documento;
	}

	public void setDocumento(EcfDocumentosEmitidos documento) {
		this.documento = documento;
	}

	public List<EcfDocumentosEmitidos> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<EcfDocumentosEmitidos> documentos) {
		this.documentos = documentos;
	}

	public void novo() {
		documento = new EcfDocumentosEmitidos();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfDocumentosEmitidosDAO documentoDAO = new EcfDocumentosEmitidosDAO();
			documentos = documentoDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os documentos !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfDocumentosEmitidosDAO documentoDAO = new EcfDocumentosEmitidosDAO();
			documentoDAO.merge(documento);
			
			documento = new EcfDocumentosEmitidos();
			documentos = documentoDAO.listar();			
			Messages.addGlobalInfo("Documento salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o documento !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			documento = (EcfDocumentosEmitidos) evento.getComponent().getAttributes().get("documentoSelecionada");
			
			EcfDocumentosEmitidosDAO documentoDAO = new EcfDocumentosEmitidosDAO();
			documentoDAO.excluir(documento);
			documentos = documentoDAO.listar();

			Messages.addGlobalInfo("Documento excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o documento !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			documento = (EcfDocumentosEmitidos) evento.getComponent().getAttributes().get("documentoSelecionada");

			Messages.addGlobalInfo("Documento excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o documento !");
			erro.printStackTrace();
		}
	}
}
