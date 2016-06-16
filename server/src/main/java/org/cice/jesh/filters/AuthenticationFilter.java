package org.cice.jesh.filters;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.ws.rs.NameBinding;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cice.jesh.persistence.dao.impl.TokenDaoImpl;

/**
 *
 * @author Toni
 */
@Provider
@AuthenticationFilter.AuthenticationFilterImpl
public class AuthenticationFilter implements ContainerRequestFilter {

    static final Logger logger = LogManager.getLogger(AuthenticationFilter.class.getName());

    private final TokenDaoImpl tokenDaoImpl = new TokenDaoImpl();
    
    @NameBinding
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AuthenticationFilterImpl {
    }

    @Override
    public void filter(ContainerRequestContext request) throws IOException {

        String accessToken = request.getHeaderString("AccessToken");

        if (accessToken == null || tokenDaoImpl.validToken("token", accessToken) == null) {
            logger.info("Invalid access token or null.");
            String responseJSON = new Gson().toJson("Unauthorized");
            request.abortWith(Response.status(401).entity(responseJSON).build());
        }

    }
}
