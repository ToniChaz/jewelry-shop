package org.cice.jesh.services;

import com.google.gson.Gson;
import org.cice.jesh.managers.UserManager;
import org.cice.jesh.persistence.entities.UserDto;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by toni on 20/04/16.
 */
@Path("/user")
public class UserService {

    UserManager userManager = new UserManager();

    @GET
    @Produces("application/json")
    public Response getAllUsers() {

        List<UserDto> result = userManager.getAllUsers();
        String listJSON = new Gson().toJson(result);

        return Response.ok().entity(listJSON).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addUser(UserDto user) {

        Map<Object, Object> result = new HashMap<>(userManager.create(user));

        return Response.status((Integer) result.get("statusCode")).entity(result.get("response")).build();
    }

    @PUT
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateUser(@PathParam("id") String id, UserDto user) throws Exception {

        Map<Object, Object> result = new HashMap<>(userManager.update(id, user));

        return Response.status((Integer) result.get("statusCode")).entity(result.get("response")).build();
    }
}
