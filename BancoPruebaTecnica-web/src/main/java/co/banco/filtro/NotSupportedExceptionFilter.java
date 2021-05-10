
package co.banco.filtro;

import co.banco.controller.pojo.ErrorWrraper;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Julian Medina
 * @version 1.2.0
 */
//Se enviea no Json
@Provider
public class NotSupportedExceptionFilter implements ExceptionMapper<NotSupportedException>{

    @Override
    public Response toResponse(NotSupportedException ex) {    
        System.out.println("Entro a NotSupportedException");
        ex.printStackTrace();                                
        
        ErrorWrraper error = new ErrorWrraper(ex.getMessage(), "415", "UNSUPPORTED_MEDIA_TYPE");
        return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).entity(error).build();
    }
    
} 