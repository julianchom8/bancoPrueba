
package co.banco.filtro;

import co.banco.controller.pojo.ErrorWrraper;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Filtro que captura la excepcion que se dispara cuando ocurre un 404
 *
 * @author Julian Medina
 * @version 1.2.0
 */
@Provider
public class NotFoundExceptionFilter implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException ex) {
        String descripcion = "El recurso solicitado no ha sido encontrado";
        String codigo = Integer.toString(ex.getResponse().getStatus());
        String codigoNombre = ex.getResponse().getStatusInfo().getReasonPhrase();

        ErrorWrraper error = new ErrorWrraper(descripcion, codigo, codigoNombre);
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
