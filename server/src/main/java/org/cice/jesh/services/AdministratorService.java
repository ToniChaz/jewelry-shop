package org.cice.jesh.services;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.cice.jesh.filters.AuthenticationFilter;
import org.cice.jesh.managers.AdministratorManager;
import org.cice.jesh.persistence.entities.AdministratorDto;

/**
 * Created by toni on 20/04/16.
 */
@Path("/administrator")
public class AdministratorService {

    AdministratorManager administratorManager = new AdministratorManager();

    @GET
    @Produces("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response getAllAdministrators() {
        
        Map<Object, Object> result = new HashMap<>(administratorManager.getAllAdministrators());
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response getAdministrator(@PathParam("id") String id) throws Exception {

        Map<Object, Object> result = new HashMap<>(administratorManager.getAdministrator(id));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response addAdministrator(AdministratorDto user) {

        Map<Object, Object> result = new HashMap<>(administratorManager.create(user));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }

    @PUT
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response updateAdministrator(@PathParam("id") String id, AdministratorDto user) throws Exception {

        Map<Object, Object> result = new HashMap<>(administratorManager.update(id, user));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
    
    @DELETE
    @Path("{id}")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response deleteAdministrator(@PathParam("id") String id) throws Exception {

        Map<Object, Object> result = new HashMap<>(administratorManager.delete(id));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
}

