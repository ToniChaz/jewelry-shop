package org.cice.jesh.services;

import com.google.gson.Gson;
import org.cice.jesh.filters.AuthenticationFilter;
import org.cice.jesh.managers.CartManager;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by toni on 20/04/16.
 */
@Path("/cart")
public class CartService {

    CartManager cartManager = new CartManager();

    @GET
    @Path("{id}")
    @Produces("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response getCart(@PathParam("id") String id) throws Exception {

        Map<Object, Object> result = new HashMap<>(cartManager.getCart(id));
        String responseJSON = new Gson().toJson(result.get("response"));

        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }

    @PUT
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response updateCart(@PathParam("id") String id, String productId) throws Exception {

        Map<Object, Object> result = new HashMap<>(cartManager.update(id, productId));
        String responseJSON = new Gson().toJson(result.get("response"));

        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
    
    
}
