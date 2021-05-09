
package co.banco.filtro;

import co.banco.controller.pojo.ErrorWrraper;
import co.banco.exception.ParamRequiredException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Julian Medina
 * @version 1.0
 */
@Provider
public class ParamRequiredExceptionFilter1 implements ExceptionMapper<ParamRequiredException> {

    @Override
    public Response toResponse(ParamRequiredException ex) {
        System.out.println("Entro a ParamRequiredException");
        ex.printStackTrace();
        ErrorWrraper error = new ErrorWrraper(ex.getMessage(), "400", "BAD_REQUEST");
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}