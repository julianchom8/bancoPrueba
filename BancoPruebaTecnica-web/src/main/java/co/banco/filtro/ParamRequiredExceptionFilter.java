
package co.banco.filtro;

import co.banco.controller.pojo.ErrorWrraper;
import co.banco.exception.ParamRequiredException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Julian Medina
 * @version 1.0
 */
@Provider
public class ParamRequiredExceptionFilter implements ExceptionMapper<ParamRequiredException>{

    @Override
    public Response toResponse(ParamRequiredException ex) {
     ErrorWrraper error = new ErrorWrraper(ex.getMessage(),"400","BAD REQUEST");
     return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
