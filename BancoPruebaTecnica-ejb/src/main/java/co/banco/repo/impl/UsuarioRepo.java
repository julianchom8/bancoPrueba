
package co.banco.repo.impl;

import co.banco.entity.Usuario;
import co.banco.repo.IUsuarioRepo;
import co.edu.unicundi.repo.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Julian Medina
 * @version 1.0
 */
@Stateless
public class UsuarioRepo extends AbstractFacade<Usuario, Integer> implements IUsuarioRepo{
    
     @PersistenceContext(unitName ="co.banco_BancoPruebaTecnica-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;
     private String query;
     
     public UsuarioRepo() {
        super(Usuario.class);
    }

    @Override
    public void insertar(Usuario usuario) throws ConstraintViolationException {
        entity.persist(usuario);
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
