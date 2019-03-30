package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import entities.Catalogo;



@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CatalogoDAO extends GenericDAO<Catalogo> {

	public Catalogo guardarCatalogo(Catalogo catalogo) {
		return guardar(catalogo);
	}
	
	public Catalogo actualizarCatalogo(Catalogo catalogo) {
		return actualizar(catalogo);
	}
	
	public void eliminarCatalogo(int idCatalogo) {
		
		eliminar(Catalogo.class, idCatalogo);
	}
	
	public Catalogo buscarCatalogoPorId(int idCatalogo) {
		
		return buscarPorId(Catalogo.class, idCatalogo);
	}
	
	public List<Catalogo> buscarTodosCatalogo(){
		return buscarPorNamedQuery(Catalogo.buscarTodosCatalogo);
	}
	
}
