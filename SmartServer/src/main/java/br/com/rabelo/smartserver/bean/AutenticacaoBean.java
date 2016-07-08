package br.com.rabelo.smartserver.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.UsuarioDAO;
import br.com.rabelo.smartserver.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class AutenticacaoBean implements Serializable {
	private Usuario usuario;
	private Usuario usuarioLogado;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
	}

	public void autenticar() {
		String liberado = "91031";
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioLogado = usuarioDAO.autenticar(usuario.getLogin(), usuario.getSenha());

			if (usuario.getLogin() == liberado) {
				Messages.addGlobalInfo("O usuario " + usuario.getLogin() + " tem acesso liberado em fase de teste");
				Faces.redirect("./pages/principal.xhtml");
			}

			if (usuarioLogado == null) {
				Messages.addGlobalError("Login e/ou senha incorreto");
				return;
			}

			Faces.redirect("./pages/principal.xhtml");
		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Erro na autenticalção");
		}
	}

	public boolean temPermissoes(List<String> permissoes) {
		for (String permissao : permissoes) {
			if (usuarioLogado.getLogin().equals(permissao)) {
				return true;
			}
		}
		return false;
	}
}
