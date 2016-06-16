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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.cice.jesh.filters.AuthenticationFilter;
import org.cice.jesh.managers.ProductManager;
import org.cice.jesh.persistence.entities.ProductDto;

/**
 * Created by toni on 20/04/16.
 */
@Path("/product")
public class ProductService {
    ProductManager productManager = new ProductManager();

    @GET
    @Produces("application/json")
    public Response getAllProducts() {
        
        Map<Object, Object> result = new HashMap<>(productManager.getAllProducts());
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
    
    @GET
    @Path("/find")
    @Produces("application/json")
    public Response findProduct(@QueryParam("query") String query) {
        
        Map<Object, Object> result = new HashMap<>(productManager.findProduct(query));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getProduct(@PathParam("id") String id) throws Exception {

        Map<Object, Object> result = new HashMap<>(productManager.getProduct(id));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json") 
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response addProduct(ProductDto product) {

        Map<Object, Object> result = new HashMap<>(productManager.create(product));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }

    @PUT
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response updateProduct(@PathParam("id") String id, ProductDto product) throws Exception {

        Map<Object, Object> result = new HashMap<>(productManager.update(id, product));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
    
    @DELETE
    @Path("{id}")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response updateProduct(@PathParam("id") String id) throws Exception {

        Map<Object, Object> result = new HashMap<>(productManager.delete(id));
        String responseJSON = new Gson().toJson(result.get("response"));
        
        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
}
