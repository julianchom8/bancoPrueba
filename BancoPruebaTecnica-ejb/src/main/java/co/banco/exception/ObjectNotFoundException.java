
package co.banco.exception;

import javax.ws.rs.ext.Provider;

/**
 *
 * @author Julian Medina
 * @version 1.2.0
 */
@Provider
public class ObjectNotFoundException extends Exception {

    public ObjectNotFoundException(String message) {
        super(message);
    }
    
}
