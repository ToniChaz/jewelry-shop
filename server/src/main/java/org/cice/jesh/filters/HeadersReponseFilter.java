package org.cice.jesh.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Toni
 */
@Provider
public class HeadersReponseFilter implements ContainerResponseFilter {

    public void filter(ContainerRequestContext request, ContainerResponseContext response) {

        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, DELETE, PUT");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, AccessToken");
    }    
}
