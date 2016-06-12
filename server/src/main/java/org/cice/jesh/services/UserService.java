package org.cice.jesh.services;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.classfile.Field;
import org.cice.jesh.managers.UserManager;
import org.cice.jesh.persistence.entities.UserDto;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

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

        if (user == null || user.getName() == null || user.getSurname() == null || user.getEmail() == null || user.getAddress() == null || user.getbankAccount() == null || user.getPassword() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("All user data is required").build();
        } else {

            UserDto result = userManager.create(user);

            return Response.status(Response.Status.OK).entity(result).build();
        }
    }
}
