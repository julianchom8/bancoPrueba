
package co.banco.filtro;

import co.banco.controller.pojo.ErrorWrraper;
import co.banco.exception.ParamUsedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Julian Medina
 * @version 1.2.0
 */
@Provider
public class ParamUsedExceptionFilter implements ExceptionMapper<ParamUsedException> {

    @Override
    public Response toResponse(ParamUsedException ex) {
     ErrorWrraper error = new ErrorWrraper(ex.getMessage(),"400","BAD_REQUEST");
     return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
