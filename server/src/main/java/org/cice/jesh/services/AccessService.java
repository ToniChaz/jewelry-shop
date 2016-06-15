package org.cice.jesh.services;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.cice.jesh.filters.AuthenticationFilter;
import org.cice.jesh.managers.AccessManager;

/**
 *
 * @author Toni
 */
@Path("/access")
public class AccessService {
    
    AccessManager accessManager = new AccessManager();
    
    @POST
    @Path("/login")
    @Produces("application/json")
    @Consumes("application/json")
    public Response login() {
        
        Map<Object, Object> result = new HashMap<>(accessManager.login());
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
    
    @GET
    @Path("/logout")
    @Produces("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response logout() {
        
        Map<Object, Object> result = new HashMap<>(accessManager.logout());
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
}
