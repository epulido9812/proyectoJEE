package session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.CatalogoDAO;
import dao.GeneroDAO;
import entities.Catalogo;
import entities.Genero;

@Stateless
public class SessionEJB implements ISessionEJB {

	@EJB
	GeneroDAO genDAO;

	@EJB
	CatalogoDAO catDAO;

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

	@Override
	public Catalogo crearCatalogo(Catalogo catalogo) {
		return catDAO.guardarCatalogo(catalogo);
	}

	@Override
	public Catalogo actualizarCatalogo(Catalogo catalogo) {
		return catDAO.actualizarCatalogo(catalogo);
	}

	@Override
	public void eliminarCatalogo(int idCatalogo) {
		catDAO.eliminarCatalogo(idCatalogo);

	}

	@Override
	public Catalogo busrcarCatalogo(int idCatalogo) {
		return catDAO.buscarCatalogoPorId(idCatalogo);
	}

	@Override
	public List<Catalogo> buscarTodosCatalogo() {
		return catDAO.buscarTodosCatalogo();
	}

}
