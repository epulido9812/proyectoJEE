package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genero database table.
 * 
 */
@Entity
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idgenero;

	private String nombre;

	//bi-directional many-to-one association to Catalogo
	@OneToMany(mappedBy="genero")
	private List<Catalogo> catalogos;

	public Genero() {
	}

	public int getIdgenero() {
		return this.idgenero;
	}

	public void setIdgenero(int idgenero) {
		this.idgenero = idgenero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Catalogo> getCatalogos() {
		return this.catalogos;
	}

	public void setCatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	public Catalogo addCatalogo(Catalogo catalogo) {
		getCatalogos().add(catalogo);
		catalogo.setGenero(this);

		return catalogo;
	}

	public Catalogo removeCatalogo(Catalogo catalogo) {
		getCatalogos().remove(catalogo);
		catalogo.setGenero(null);

		return catalogo;
	}

}