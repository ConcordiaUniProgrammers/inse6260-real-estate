package infrastructure.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("mysource")
public class Sample {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getData(){
		return "salam";
	}
	
}
