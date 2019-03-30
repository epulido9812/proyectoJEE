package session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import dao.GeneroDAO;
import entities.Genero;

@Stateless
public class SessionEJB implements ISessionEJB {

	@EJB
	GeneroDAO genDAO;

	@Override
	public Genero crearGenero(Genero genero) {

		return genDAO.guardarGenero(genero);
	}

	@Override
	public Genero actualizarGenero(Genero genero) {
		return genDAO.actualizarGenero(genero);
	}

	@Override
	public void eliminarGenero(int idGenero) {

		genDAO.eliminarGenero(idGenero);
	}

	@Override
	public Genero busrcarGenero(int idGenero) {

		return genDAO.buscarGeneroPorId(idGenero);
	}

	@Override
	public List<Genero> buscarTodosGenero() {

		return genDAO.buscarTodosGenero();

	}

}
