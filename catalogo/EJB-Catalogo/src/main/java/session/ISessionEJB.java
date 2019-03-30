package session;

import java.util.List;

import javax.ejb.Local;

import entities.Catalogo;
import entities.Genero;

@Local
public interface ISessionEJB {

	public Genero crearGenero(Genero genero);
	public Genero actualizarGenero(Genero genero);
	public void eliminarGenero(int idGenero);
	public Genero busrcarGenero(int idGenero);
	public List<Genero> buscarTodosGenero();
	
	
	public Catalogo crearCatalogo(Catalogo catalogo);
	public Catalogo actualizarCatalogo(Catalogo catalogo);
	public void eliminarCatalogo(int idCatalogo);
	public Catalogo busrcarCatalogo(int idCatalogo);
	public List<Catalogo> buscarTodosCatalogo();
	
}
