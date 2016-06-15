package org.cice.jesh.filters;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.ws.rs.NameBinding;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Toni
 */
@Provider
@AuthenticationFilter.AuthenticationFilterImpl
public class AuthenticationFilter implements ContainerRequestFilter {

    static final Logger logger = LogManager.getLogger(AuthenticationFilter.class.getName());
    
    @NameBinding
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AuthenticationFilterImpl {}
    
    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        logger.info("********************* THIS RESOURCE NEED AUTH ********************");        
    }
    
}
