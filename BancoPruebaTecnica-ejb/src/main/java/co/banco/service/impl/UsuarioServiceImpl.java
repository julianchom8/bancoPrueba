package co.banco.service.impl;

import co.banco.dto.UsuarioDto;
import co.banco.dto.UsuarioPaginadoDto;
import co.banco.entity.Usuario;
import co.banco.exception.ObjectNotFoundException;
import co.banco.exception.ParamRequiredException;
import co.banco.exception.ParamUsedException;
import co.banco.repo.IUsuarioRepo;
import co.banco.service.IServiceUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolationException;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Julian Medina
 * @version 1.2.0
 */
@Stateless
public class UsuarioServiceImpl implements IServiceUsuario {

    @EJB
    private IUsuarioRepo repo;

    @Override
    public void insertar(Usuario usuario) throws ConstraintViolationException {
         System.out.println("entro a guardar");
             try {
               validarCamposGuardar(usuario);
            System.out.println("valido campos");
        repo.insertar(usuario);validarCamposGuardar(usuario);
            System.out.println("valido campos");
        repo.insertar(usuario);
             } catch (ParamUsedException ex) {
                 Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
           
    }

    @Override
    public void editar(Usuario usuario) throws ParamRequiredException, ObjectNotFoundException {
        if (usuario.getId() == null) {
            throw new ParamRequiredException("El Id es requerido para editar");
        } else {
            this.listarPorId(usuario.getId());
            try {
                validarCampos(usuario);
            } catch (ParamUsedException ex) {
                Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            repo.editar(usuario);

        }

    }

    @Override
    public Usuario listarPorId(Integer id) throws ObjectNotFoundException {
        Usuario usuario = repo.listarPorId(id);
        if (usuario != null) {
            return usuario;
        } else {
            throw new ObjectNotFoundException("usuario no existe");
        }
    }

    @Override
    public void eliminar(Integer id) throws ObjectNotFoundException {
        Usuario usuario = this.listarPorId(id);
        if (usuario != null) {
            repo.eliminar(usuario);
        } else {
            throw new ObjectNotFoundException("usuario no existe");
        }

    }

    @Override
    public List<Usuario> listar() throws ObjectNotFoundException {
        return repo.listar();

    }

    @Override
    public UsuarioPaginadoDto listarPaginado(int page, int size) {
        List<Usuario> listaUsuario = repo.listarPaginado(page, size);
        List<UsuarioDto> autorDto = new ArrayList<>();
        for (Usuario lista : listaUsuario) {
            ModelMapper modelMapper = new ModelMapper();
            UsuarioDto autor = modelMapper.map(lista, UsuarioDto.class);
            autorDto.add(autor);
        }

        UsuarioPaginadoDto paginado = new UsuarioPaginadoDto();
        paginado.setContent(autorDto);
        paginado.setCantidad(repo.cantidadTotal());

        return paginado;

    }

    private void validarCampos(Usuario usuario) throws ParamUsedException {
        System.out.println("");
        Integer validacion = repo.validarCedula(usuario.getCedula(), usuario.getId());
        if (validacion != 0) {
            throw new ParamUsedException("cedula ya se encuentra registrada");
        }
    }

    private void validarCamposGuardar(Usuario usuario) throws ParamUsedException {
        System.out.println("entro a validar campos");
        Integer validacion = repo.validarCedulaGuardar(usuario.getCedula());
        if (validacion != 0) {
            System.out.println("entro a el if1");
            throw new ParamUsedException("cedula ya se encuentra registrada");

        }
    }

}
