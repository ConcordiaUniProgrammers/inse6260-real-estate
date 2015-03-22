package infrastructure.restful;

import infrastructure.hib.DIConfiguration;
import infrastructure.hib.UnitOfWork;
import infrastructure.restful.viewmodels.TypeViewModel;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import core.contract.infracontract.IUnitOfWork;
import core.domain.realestate.typeaggregate.REType;
import core.domainservice.imp.RETypeService;

@Path("type")
public class TypeResource {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{typeName}")
	public List<REType> getTypeByName(@PathParam("typeName") String typeName){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIConfiguration.class);
		IUnitOfWork uow = context.getBean(UnitOfWork.class);
		
		List<REType> result = uow.getrETypeRepository().getTypesOrderByRank(typeName);
		uow.commit();
		context.close();
		return result;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("delete/{typeId}")
	public String deleteType(@PathParam("typeId") int typeId){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIConfiguration.class);
		IUnitOfWork uow = context.getBean(UnitOfWork.class);
		
		boolean isDone = uow.getrETypeRepository().delete(typeId);
		uow.commit();
		context.close();
		return (new Boolean(isDone).toString());
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
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("update/type")
	public String updateType(REType type){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIConfiguration.class);
		IUnitOfWork uow = context.getBean(UnitOfWork.class);
		
		boolean isDone = uow.getrETypeRepository().update(type);
		uow.commit();
		context.close();
		return (new Boolean(isDone).toString());
	}
	
}
