package org.cice.jesh.services;

import com.google.gson.Gson;
import org.cice.jesh.filters.AuthenticationFilter;
import org.cice.jesh.managers.DashboardManager;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by toni on 25/06/16.
 */
@Path("/dashboard")
public class DashboardService {

    DashboardManager dashboardManager = new DashboardManager();

    @GET
    @Produces("application/json")
    @AuthenticationFilter.AuthenticationFilterImpl
    public Response logout(@HeaderParam("AccessToken") String accessToken) {

        Map<Object, Object> result = new HashMap<>(dashboardManager.get());
        String responseJSON = new Gson().toJson(result.get("response"));

        return Response.status((Integer) result.get("statusCode")).entity(responseJSON).build();
    }
}
