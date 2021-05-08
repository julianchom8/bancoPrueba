
package co.banco.service;

import co.banco.entity.Usuario;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Julian Medina
 * @version 1.0
 */
public interface IServiceUsuario {
    
      public void insertar(Usuario usuario) throws ConstraintViolationException;
     
}
