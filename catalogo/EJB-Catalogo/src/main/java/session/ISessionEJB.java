package session;

import java.util.List;

import javax.ejb.Local;

import entities.Genero;

@Local
public interface ISessionEJB {

	public Genero crearGenero(Genero genero);
	public Genero actualizarGenero(Genero genero);
	public void eliminarGenero(int idGenero);
	public Genero busrcarGenero(int idGenero);
	public List<Genero> buscarTodosGenero();
	
}
