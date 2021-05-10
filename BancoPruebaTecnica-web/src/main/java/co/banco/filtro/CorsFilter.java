
package co.banco.filtro;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;


/**
 *
 * @author usuario
 */
@Provider
public class CorsFilter implements ContainerResponseFilter {
    
@Override
public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext cres)
throws IOException {
cres.getHeaders().add("Access-Control-Allow-Origin", "*"); // Update specific domains instead of giving to all
cres.getHeaders().add("Access-Control-Allow-Headers", "Origin,Content-Type,Accept,Authorization,content-type");
cres.getHeaders().add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD");
cres.getHeaders().add("Access-Control-Max-Age", "1209500");
}

}
