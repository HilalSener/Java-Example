package wissen.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

//http://localhost:8080/HelloWS/api/service/Hello
@Path("/service")
public class Service 
{
    @Path("/hello")
    @GET
    public Response getGreeting()
    {
        String msg = "Hello";
        return Response.status(200).entity(msg).build();
    }
}
