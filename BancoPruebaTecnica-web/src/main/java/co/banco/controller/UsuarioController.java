/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.banco.controller;

import co.banco.entity.Usuario;
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
 * @author usuario
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
    
}
