
package co.banco.exception;

/**
 *
 * @author Julian Medina
 * @version 1.2.0
 */
public class WebApplicationException extends RuntimeException{
    public WebApplicationException(String message) {
        super(message);
    }
}
