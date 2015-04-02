package infrastructure.restful;

import infrastructure.hib.DIConfiguration;
import infrastructure.hib.UnitOfWork;
import infrastructure.restful.viewmodels.TypeViewModel;

import java.util.ArrayList;
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
	@Produces({MediaType.APPLICATION_JSON})
	@Path("{typeName}")
	public List<TypeViewModel> getTypeByName(@PathParam("typeName") String typeName){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIConfiguration.class);
		IUnitOfWork uow = context.getBean(UnitOfWork.class);
		
		List<REType> types = uow.getrETypeRepository().getTypesOrderByRank(typeName);
		List<TypeViewModel> result = new ArrayList<>();
		for(REType type : types){
			TypeViewModel t = new TypeViewModel();
			t.setId(type.getId());
			t.setType(type.getName());
			result.add(t);
		}
		uow.commit();
		context.close();
		return result;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
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
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{typeName}/newtype")
	public String addNewType(@PathParam("typeName") String typeName, TypeViewModel newType){
		boolean result = false;
		RETypeService service = new RETypeService();
		if(newType != null){
			result = service.AddNewTypeToOneREType(newType.getType(), typeName);
		}
		return (new Boolean(result).toString());
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("update/type")
	public String updateType(TypeViewModel type){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIConfiguration.class);
		IUnitOfWork uow = context.getBean(UnitOfWork.class);
		REType before = uow.getrETypeRepository().findById(type.getId());
		if(before != null){
			if( !before.getName().equalsIgnoreCase(type.getType())){
				before.setName(type.getType());
			}
		}
		
		boolean isDone = uow.getrETypeRepository().update(before);
		uow.commit();
		context.close();
		return (new Boolean(isDone).toString());
	}
	
}
