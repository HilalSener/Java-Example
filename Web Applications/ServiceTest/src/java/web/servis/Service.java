package web.servis;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ws")
public class Service {

    @GET
    @Path("/hello")
    public String sayHi() {
        return "Merhaba naber :P";
    }
}
