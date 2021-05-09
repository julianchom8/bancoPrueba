
package co.banco.controller;

import co.banco.entity.Usuario;
import co.banco.exception.ObjectNotFoundException;
import co.banco.exception.ParamRequiredException;
import co.banco.service.IServiceUsuario;
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
    
}

