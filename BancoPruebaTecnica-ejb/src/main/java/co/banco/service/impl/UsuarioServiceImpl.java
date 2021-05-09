
package co.banco.service.impl;


import co.banco.entity.Usuario;
import co.banco.repo.IUsuarioRepo;
import co.banco.service.IServiceUsuario;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Julian Medina
 * @version 1.0
 */
@Stateless
public class UsuarioServiceImpl implements IServiceUsuario{

    @EJB
    private IUsuarioRepo repo;
    
    @Override
    public void insertar(Usuario usuario) throws ConstraintViolationException {
        System.out.println("entro a guardar");
        repo.insertar(usuario);
    }

}