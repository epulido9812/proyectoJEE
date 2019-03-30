package dao;



import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import entities.Genero;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class GeneroDAO extends GenericDAO<Genero> {
	
	public Genero guardarGenero(Genero genero) {
		return guardar(genero);
	}
	
	public Genero actualizarGenero(Genero genero) {
		return actualizar(genero);
	}
	
	public void eliminarGenero(int idGenero) {
		
		eliminar(Genero.class, idGenero);
	}
	
	public Genero buscarGeneroPorId(int idGenero) {
		
		return buscarPorId(Genero.class, idGenero);
	}
	
	public List<Genero> buscarTodosGenero(){
		return buscarPorNamedQuery(Genero.buscarTodosGenero);
	}
	
	
}
