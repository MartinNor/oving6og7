package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author nilstes
 */
@Path("/thepath/")
public class AService {
    static String meld;
    
    @GET 
    @Produces(MediaType.TEXT_PLAIN) 
    public String getSomething() { 
        return meld;
    }   
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void getSomethingelse(String a){
        meld=a;
    }
}
