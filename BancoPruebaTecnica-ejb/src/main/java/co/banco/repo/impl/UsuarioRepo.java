
package co.banco.repo.impl;

import co.banco.entity.Usuario;
import co.banco.exception.NotAllowedException;
import co.banco.repo.AbstractFacade;
import co.banco.repo.IUsuarioRepo;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Julian Medina
 * @version 1.2.0
 */
@Stateless
public class UsuarioRepo extends AbstractFacade<Usuario, Integer> implements IUsuarioRepo{
    
     @PersistenceContext(unitName ="co.banco_BancoPruebaTecnica-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;
     
     public UsuarioRepo() {
        super(Usuario.class);
    }

    @Override
    public List<Usuario> listar() throws NotAllowedException {
    return listar("Usuario.listar");    
    }
    @Override
    protected EntityManager getEntityManager() {
        return entity;
    }

    @Override
    protected String getQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
    @Override
    public Integer cantidadTotal() {
        this.entity.getEntityManagerFactory().getCache().evictAll();
        Query query = this.entity.createNamedQuery("Usuario.cantidadTotal", Integer.class);      
        Integer total = Integer.parseInt(query.getSingleResult().toString());
        return total;                
    }
    @Override
    public Integer validarCedula(String cedula, Integer id) {
        Query query = this.entity.createNamedQuery("Usuario.validarCedula", Integer.class);
        query.setParameter("cedula", cedula);
        query.setParameter("id", id);
        String p = query.getSingleResult().toString();
        return parseInt(p);
    }

    @Override
    public Integer validarCedulaGuardar(String cedula) {
        Query  query = this.entity.createNamedQuery("Usuario.validarCedulaGuardar", Integer.class);
        query.setParameter("cedula", cedula);
        String p = query.getSingleResult().toString();
        return parseInt(p);
    }
    

}
