
package co.banco.service.impl;


import co.banco.entity.Usuario;
import co.banco.exception.ObjectNotFoundException;
import co.banco.exception.ParamRequiredException;
import co.banco.repo.IUsuarioRepo;
import co.banco.service.IServiceUsuario;
import java.util.List;
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
    @Override
    public void editar(Usuario usuario) throws ParamRequiredException, ObjectNotFoundException {
       if(usuario.getId() == null){
           throw new ParamRequiredException("El Id es requerido para editar");
       }else{
           repo.editar(usuario);
          
       }
        
    }
    @Override
    public Usuario listarPorId(Integer id) throws ObjectNotFoundException {
        Usuario usuario = repo.listarPorId(id);
        if(usuario != null){
            return usuario;
        }else{
            throw new ObjectNotFoundException("usuario no existe");
        }
    }
    @Override
    public void eliminar(Integer id) throws ObjectNotFoundException {
        Usuario usuario = this.listarPorId(id);
         if(usuario != null){
            repo.eliminar(usuario);
        }else{
            throw new ObjectNotFoundException("usuario no existe");
        }
        
    }
    @Override
    public List<Usuario> listar() throws ObjectNotFoundException {
        return repo.listar();
   
    }
    
}