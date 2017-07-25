/*
Kullanıcı işlemlerinin yapılacapı web service
Bu sınıfın adının ne olduğu web erişiminde önemli değil
Erişim adresini belirleyen @Path annotation larıdır.
*/
package ws.ornekleri;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class Users 
{
    //ws/user/show?id=x
    @GET
    @Path("/show")
    public String showUser(@QueryParam("id") int id)
    {
        if(id == 1) return "Sercan Tuncay";
        if(id == 2) return "Efe Selim";
        else return "NAN";
    }
    
    //ws/user/add?fn=x&ln=y
    @POST
    @Path("/add")
    public String addUser(@QueryParam("fn") String fn, @QueryParam("ln") String ln)
    {
        return "New User: " + fn + " " + ln + " Created";
    }
    
    //ws/user/new
    @POST
    @Path("/new")
    public String newUser(@FormParam("ad") String ad, @FormParam("soyad") String soyad)
    {
        return ad + " " + soyad + " : Merhaba";
    }
    
    //ws/user/putUser/1993/Hilal/Sener
    @PUT
    @Path("/putUser/{bd}/{ad}/{soyad}")
    public String show(@PathParam("ad") String ad, 
                       @PathParam("soyad") String soyad,
                       @PathParam("bd") int dogumYili)
    {
        return "Yeni user " + ad + " " + soyad + " @" + dogumYili;
    }
    
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserData()
    {
        User u = new User("Fatih", "Kirbaci", 1985);
        return u;
    }
    
    @GET
    @Path("/json_list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersData()
    {
        List<User> users = new ArrayList<User>();
        users.add(new User("Fatih", "Kirbaci", 1985));
        users.add(new User("Hilal", "Sener", 1985));
        users.add(new User("Aysu", "Sener", 1985));
        return users;
    }
}
