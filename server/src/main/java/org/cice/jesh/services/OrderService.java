package org.cice.jesh.services;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.cice.jesh.filters.AuthenticationFilter;
import org.cice.jesh.managers.OrderManager;
import org.cice.jesh.persistence.entities.OrderDto;

/**
 * Created by toni on 20/04/16.
 */
@Path("/order")
public class OrderService {
    
    OrderManager orderManager = new OrderManager();

    @GET
    @Produces("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response getAllOrders() {
        
        Map<Object, Object> result = new HashMap<>(orderManager.getAllOrders());
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response getOrder(@PathParam("id") String id) throws Exception {

        Map<Object, Object> result = new HashMap<>(orderManager.getOrder(id));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")    
    public Response addOrder(OrderDto order) {

        Map<Object, Object> result = new HashMap<>(orderManager.create(order));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }

    @PUT
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response updateOrder(@PathParam("id") String id, OrderDto order) throws Exception {

        Map<Object, Object> result = new HashMap<>(orderManager.update(id, order));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
}
