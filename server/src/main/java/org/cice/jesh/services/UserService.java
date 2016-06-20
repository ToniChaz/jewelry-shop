package org.cice.jesh.services;

import com.google.gson.Gson;
import org.cice.jesh.managers.UserManager;
import org.cice.jesh.persistence.entities.UserDto;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import org.cice.jesh.filters.AuthenticationFilter;

/**
 * Created by toni on 20/04/16.
 */
@Path("/user")
public class UserService {

    UserManager userManager = new UserManager();

    @GET
    @Produces("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response getAllUsers() {
        
        Map<Object, Object> result = new HashMap<>(userManager.getAllUsers());
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response getUser(@PathParam("id") String id) throws Exception {

        Map<Object, Object> result = new HashMap<>(userManager.getUser(id));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")    
    public Response addUser(UserDto user) {

        Map<Object, Object> result = new HashMap<>(userManager.create(user));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }

    @PUT
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response updateUser(@PathParam("id") String id, UserDto user) throws Exception {

        Map<Object, Object> result = new HashMap<>(userManager.update(id, user));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
    
    @DELETE
    @Path("{id}")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response deleteUser(@PathParam("id") String id) throws Exception {

        Map<Object, Object> result = new HashMap<>(userManager.delete(id));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
}
