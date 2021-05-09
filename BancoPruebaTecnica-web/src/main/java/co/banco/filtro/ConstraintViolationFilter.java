
package co.banco.filtro;

import co.banco.controller.pojo.ErrorWrraper;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Julian Medina
 * @version 1.0
 */
//Error de validaciones
@Provider
public class ConstraintViolationFilter implements ExceptionMapper<ConstraintViolationException>{


    @Override
    public Response toResponse(ConstraintViolationException ex) {
        System.out.println("Entro a ConstraintViolationFilter");
        ex.printStackTrace();        
        ErrorWrraper error = new ErrorWrraper(prepareMessage(ex), "400", "BAD_REQUEST");
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();        
    }
    
     private String prepareMessage(ConstraintViolationException exception) {
        String msg = "";
        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
            msg+=cv.getPropertyPath()+" "+cv.getMessage()+"\n";
        }
        return msg;
    }    
    
}

