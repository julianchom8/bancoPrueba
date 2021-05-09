
package co.banco.service;

import co.banco.entity.Usuario;
import co.banco.exception.ObjectNotFoundException;
import co.banco.exception.ParamRequiredException;
import java.util.List;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Julian Medina
 * @version 1.0
 */
public interface IServiceUsuario {
    
      public void insertar(Usuario usuario) throws ConstraintViolationException;
      public void editar(co.banco.entity.Usuario usuario) throws ObjectNotFoundException, ParamRequiredException;
      public void eliminar(Integer id) throws ObjectNotFoundException;
      public List<Usuario> listar() throws ObjectNotFoundException;
      public Usuario listarPorId(Integer id) throws ObjectNotFoundException;
}
