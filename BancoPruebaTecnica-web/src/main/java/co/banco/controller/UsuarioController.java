
package co.banco.controller;

import co.banco.dto.UsuarioPaginadoDto;
import co.banco.entity.Usuario;
import co.banco.exception.ObjectNotFoundException;
import co.banco.exception.ParamRequiredException;
import co.banco.service.IServiceUsuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Julian Medina
 * @version 1.2.0
 */
@Stateless
@Path("/usuario")
public class UsuarioController {
    
    @EJB
    private IServiceUsuario service;
    
    
    @Path("/insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarUsuario(@Valid Usuario usuario) throws ParamRequiredException {
        
        service.insertar(usuario);
        return Response.status(Response.Status.CREATED).build();
    }
    @Path("/editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(Usuario usuario) throws ParamRequiredException, ObjectNotFoundException {
    
        service.editar(usuario);
        return Response.status(Response.Status.OK).build();
    }

    @Path("eliminar/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") int id) throws ObjectNotFoundException {
       service.eliminar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    @Path("/retornarPorId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarPorId(@PathParam("id") Integer id)throws ObjectNotFoundException {
       Usuario usuario = service.listarPorId(id);
        return Response.status(Response.Status.OK).entity(usuario).build();
       
    }
    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarProfesor() throws ObjectNotFoundException {
        List<Usuario> listaProfesor = service.listar();
         return Response.status(Response.Status.OK).entity(listaProfesor).build();
    }
    @Path("/retornarPaginado/{page}/{size}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarPorId(@PathParam("page") Integer page, @PathParam("size") Integer size)  {
        UsuarioPaginadoDto lista = service.listarPaginado(page, size);
        return Response.status(Response.Status.OK).entity(lista).build();       
    }
}

