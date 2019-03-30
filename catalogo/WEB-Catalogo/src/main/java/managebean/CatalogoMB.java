package managebean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.Genero;
import session.ISessionEJB;

@ManagedBean
@ViewScoped
public class CatalogoMB {

	@EJB
	ISessionEJB iSessionEJB;

	String txtIdGenero;
	String txtNombreGenero;
	boolean blHabilitarId;
	Genero genero;
	List<Genero> lGenero;

	@PostConstruct
	public void init() {
		blHabilitarId = false;
	}

	public void guardarGenero() {

		if (!blHabilitarId) {
			Genero genero = new Genero();
			genero.setIdgenero(Integer.parseInt(txtIdGenero));
			genero.setNombre(txtNombreGenero);
			iSessionEJB.crearGenero(genero);
			blHabilitarId = true;
		} else {
			actualizarGenero();
		}
	}

	public void actualizarGenero() {

		Genero genero = new Genero();
		genero.setIdgenero(Integer.parseInt(txtIdGenero));
		genero.setNombre(txtNombreGenero);
		iSessionEJB.actualizarGenero(genero);
	}

	public void buscarTodosGenero() {

		if (lGenero == null) {
			lGenero = iSessionEJB.buscarTodosGenero();
		}
	}
	
	public void seleccionarGenero() {

		txtIdGenero=genero.getIdgenero()+"";
		txtNombreGenero=genero.getNombre();
		blHabilitarId=true;
	}

	public void limpiar() {

		blHabilitarId = false;
		txtIdGenero = "";
		txtNombreGenero = "";
		genero = null;
		lGenero = null;
	}

	public String getTxtIdGenero() {
		return txtIdGenero;
	}

	public void setTxtIdGenero(String txtIdGenero) {
		this.txtIdGenero = txtIdGenero;
	}

	public String getTxtNombreGenero() {
		return txtNombreGenero;
	}

	public void setTxtNombreGenero(String txtNombreGenero) {
		this.txtNombreGenero = txtNombreGenero;
	}

	public boolean isBlHabilitarId() {
		return blHabilitarId;
	}

	public void setBlHabilitarId(boolean blHabilitarId) {
		this.blHabilitarId = blHabilitarId;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Genero> getlGenero() {
		return lGenero;
	}

	public void setlGenero(List<Genero> lGenero) {
		this.lGenero = lGenero;
	}

}
