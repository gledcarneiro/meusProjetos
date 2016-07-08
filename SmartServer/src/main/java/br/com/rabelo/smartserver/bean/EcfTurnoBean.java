package br.com.rabelo.smartserver.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.rabelo.smartserver.dao.EcfTurnoDAO;
import br.com.rabelo.smartserver.domain.EcfTurno;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EcfTurnoBean implements Serializable {
	private EcfTurno turno;
	private List<EcfTurno> turnos;

	public EcfTurno getTurno() {
		return turno;
	}

	public void setTurno(EcfTurno turno) {
		this.turno = turno;
	}

	public List<EcfTurno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<EcfTurno> turnos) {
		this.turnos = turnos;
	}

	public void novo() {
		turno = new EcfTurno();
	}

	@PostConstruct
	public void listar() {
		try {
			EcfTurnoDAO turnoDAO = new EcfTurnoDAO();
			turnos = turnoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os turnos !");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EcfTurnoDAO turnoDAO = new EcfTurnoDAO();
			turnoDAO.merge(turno);

			turno = new EcfTurno();
			turnos = turnoDAO.listar();
			Messages.addGlobalInfo("Turno salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o turno !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			turno = (EcfTurno) evento.getComponent().getAttributes().get("turnoSelecionada");

			EcfTurnoDAO turnoDAO = new EcfTurnoDAO();
			turnoDAO.excluir(turno);
			turnos = turnoDAO.listar();

			Messages.addGlobalInfo("Turno excluida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o turno !");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			turno = (EcfTurno) evento.getComponent().getAttributes().get("turnoSelecionada");

			Messages.addGlobalInfo("Turno excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao excluir o turno !");
			erro.printStackTrace();
		}
	}
}
