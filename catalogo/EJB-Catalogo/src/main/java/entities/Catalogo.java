package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the catalogo database table.
 * 
 */
@Entity
@NamedQuery(name="Catalogo.findAll", query="SELECT c FROM Catalogo c")
public class Catalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcatalogo;

	private String director;

	private String nombre;

	//bi-directional many-to-one association to Genero
	@ManyToOne
	private Genero genero;

	public Catalogo() {
	}

	public int getIdcatalogo() {
		return this.idcatalogo;
	}

	public void setIdcatalogo(int idcatalogo) {
		this.idcatalogo = idcatalogo;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}