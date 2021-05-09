
package co.banco.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
/**
 *
 * @author Julian Medina
 */
public abstract class AbstractFacade<T, V> {
      
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();  
    
    protected abstract String getQuery();
    public List<T> listarPaginado(int page, int size) {
        CriteriaQuery query =  getEntityManager().getCriteriaBuilder().createQuery();
        query.select(query.from(entityClass));
        Query q = getEntityManager().createQuery(query);
        q.setFirstResult((page -1) * size);
        q.setMaxResults(size);
        return q.getResultList();
    }
    public List<T> listar(String leer) {
        TypedQuery<T> lista = getEntityManager().createNamedQuery(leer, entityClass);                
        return lista.getResultList(); 
    }
    
    public T listarPorId(V id) {
        return getEntityManager().find(entityClass, id);
    }
    
    public void insertar(T entity) {
        getEntityManager().persist(entity);
    }
    
    public void editar(T entity) {
         getEntityManager().merge(entity);
    }
   
    public void eliminar(T entity) {
        getEntityManager().remove(entity);
    }
    
    
}
