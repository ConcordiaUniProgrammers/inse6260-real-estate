package infrastructure.restful;

import infrastructure.restful.viewmodels.TypeViewModel;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import core.domain.realestate.typeaggregate.REType;
import core.domainservice.IRETypeService;
import core.domainservice.imp.RETypeService;

@Path("type")
public class TypeResource {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<REType> getTypeByName(){
		return null;
		
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("newtype")
	public String addNewType(TypeViewModel newType){
		boolean result = false;
		RETypeService service = new RETypeService();
		if(newType != null){
			result = service.AddNewTypeToOneREType(newType.getNewTypeName(), newType.getType());
		}
		return (new Boolean(result).toString());
	}
	
}
