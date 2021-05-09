
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Julian Medina
 * @version 1.0
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.banco.controller.UsuarioController.class);
        resources.add(co.banco.exception.ObjectNotFoundException.class);
        resources.add(co.banco.filtro.ConstraintViolationFilter.class);
        resources.add(co.banco.filtro.NotAllowedExceptionFilter.class);
        resources.add(co.banco.filtro.NotFoundExceptionFilter.class);
        resources.add(co.banco.filtro.NotSupportedExceptionFilter.class);
        resources.add(co.banco.filtro.ObjectNotFoundExceptionFiltro.class);
        resources.add(co.banco.filtro.ParamRequiredExceptionFilter.class);
        resources.add(co.banco.filtro.ParamRequiredExceptionFilter1.class);
        resources.add(co.banco.filtro.WebApplicationExceptionFilter.class);
    }
    
}
