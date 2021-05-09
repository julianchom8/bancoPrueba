
package co.banco.repo.impl;

import co.banco.entity.Usuario;
import co.banco.exception.NotAllowedException;
import co.banco.repo.AbstractFacade;
import co.banco.repo.IUsuarioRepo;
import java.util.List;
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
    public List<Usuario> listar() throws NotAllowedException {
    return listar("Usuario.listar");    
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
