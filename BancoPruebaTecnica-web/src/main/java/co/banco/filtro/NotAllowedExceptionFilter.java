
package co.banco.filtro;

import co.banco.controller.pojo.ErrorWrraper;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Julian Medina
 * @version 1.0
 */
//Es Get y se envia POST con o sin raw
@Provider
public class NotAllowedExceptionFilter implements ExceptionMapper<NotAllowedException> {


    @Override
    public Response toResponse(NotAllowedException ex) {
        System.out.println("Entro a NotAllowedExceptionFilter");
        ex.printStackTrace();                        
        ErrorWrraper error = new ErrorWrraper(ex.getMessage(), "405", "METHOD_NOT_ALLOWED");
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(error).build();
    }
}