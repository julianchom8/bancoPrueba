/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.banco.repo;

import co.banco.entity.Usuario;
import co.banco.exception.NotAllowedException;
import co.banco.exception.ObjectNotFoundException;
import java.util.List;
import javax.ejb.Local;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Julian Medina
 * @version 1.0
 */
@Local
public interface IUsuarioRepo {
    
    public void insertar(Usuario usuario) throws ConstraintViolationException;
    

}
