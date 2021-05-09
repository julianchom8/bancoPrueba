
package co.banco.filtro;

import co.banco.controller.pojo.ErrorWrraper;
import javax.ejb.ObjectNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
* @author Julian Medina
 * @version 1.0
 */
@Provider
public class ObjectNotFoundExceptionFiltro implements ExceptionMapper<ObjectNotFoundException>{

    @Override
    public Response toResponse(ObjectNotFoundException ex) {
     ErrorWrraper error = new ErrorWrraper(ex.getMessage(),"404","NOT FOUND");
     return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
    
}
