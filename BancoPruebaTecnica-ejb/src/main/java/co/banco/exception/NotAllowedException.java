
package co.banco.exception;

/**
 *
 * @author Julian Medina
 * @version 1.2.0
 */
public class NotAllowedException extends RuntimeException{
    public NotAllowedException(String message) {
        super(message);
    }
}
