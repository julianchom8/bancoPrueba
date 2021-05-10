
package co.banco.exception;

/**
 *
 * @author Julian Medina
 * @version 1.2.0
 */
public class ConstraintViolation extends RuntimeException{
    
    public ConstraintViolation(String message) {
        super(message);
    }
}
