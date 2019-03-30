package dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class GenericDAO<T> {

	@PersistenceContext(unitName="JPU-Catalogo")
	EntityManager em;
	
	public T guardar(T entity) {
		
		this.em.persist(entity);
		this.em.flush();
		return entity;
		
	}
	
	public T actualizar(T entity) {
		
		this.em.merge(entity);
		this.em.flush();
		return entity;
		
	}
	
	public T buscarPorId(Class<?> type, Object id) {
		return (T) this.em.find(type, id);
	}
	
	public void eliminar(Class<?> type, Object id) {
		Object ref = this.em.getReference(type, id);
		this.em.remove(ref);
	}
	
	public List<T> buscarPorNamedQuery(String namedQuery) {
		Query query = em.createNamedQuery(namedQuery);
		return query.getResultList();
	}
	
	public List<T> buscarPorNamedQuery(String namedQuery,
			Map<String, Object> parameters) {
		return buscarPorNamedQuery(namedQuery, parameters, 0);
	}
	
	public List<T> buscarPorNamedQuery(String namedQuery,
			Map<String, Object> parameters, int resultLimit) {
		Set<Entry<String, Object>> rawParameters = parameters.entrySet();
		Query query = this.em.createNamedQuery(namedQuery);
		if (resultLimit > 0)
			query.setMaxResults(resultLimit);
		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		return query.getResultList();
	}
	
	
}
