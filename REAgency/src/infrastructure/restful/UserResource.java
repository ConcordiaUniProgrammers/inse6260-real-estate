package infrastructure.restful;

import infrastructure.hib.DIConfiguration;
import infrastructure.hib.UnitOfWork;
import infrastructure.restful.viewmodels.TypeViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import core.contract.infracontract.IRETypeRepository;
import core.contract.infracontract.IUnitOfWork;
import core.contract.infracontract.IUserRepository;
import core.domain.kernel.User;
import core.domain.realestate.typeaggregate.REType;
import core.domainservice.imp.RETypeService;

@Path("user")
public class UserResource {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> getAllUser(){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIConfiguration.class);
		IUnitOfWork uow = context.getBean(UnitOfWork.class);
		
		List<User> users = uow.getUserRepository().findAll();
		uow.commit();
		context.close();
//		List<TypeViewModel> result = new ArrayList<>();
//		for(REType type: types){
//			TypeViewModel model = new TypeViewModel();
//			model.setType(type.getName());
//			model.setId(type.getId());
//			result.add(model);
//		}
//		
		return users;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("delete/{userId}")
	public String deleteType(@PathParam("userId") int userId){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIConfiguration.class);
		IUnitOfWork uow = context.getBean(UnitOfWork.class);
		
		boolean isDone = uow.getUserRepository().delete(userId);
		uow.commit();
		context.close();
		return (new Boolean(isDone).toString());
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/newuser")
	public String addNewUser(User newUser){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIConfiguration.class);
		IUnitOfWork uow = context.getBean(UnitOfWork.class);
		
		boolean isDone = uow.getUserRepository().save(newUser);
		uow.commit();
		context.close();
		return (new Boolean(isDone).toString());
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("update/user")
	public String updateType(User user){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIConfiguration.class);
		IUnitOfWork uow = context.getBean(UnitOfWork.class);
		IUserRepository repo = uow.getUserRepository();
		User original = repo.findById(user.getId());
		if( !original.getName().equalsIgnoreCase(user.getName())){
			original.setName(user.getName());
		}
//		if( !original.getName().equalsIgnoreCase(user.getName())){
//			original.setName(user.getName());
//		}if( !original.getName().equalsIgnoreCase(user.getName())){
//			original.setName(user.getName());
//		}if( !original.getName().equalsIgnoreCase(user.getName())){
//			original.setName(user.getName());
//		}if( !original.getName().equalsIgnoreCase(user.getName())){
//			original.setName(user.getName());
//		}
//		
		
		boolean isDone = true;
		uow.commit();
		context.close();
		return (new Boolean(isDone).toString());//taghir konad ba isDone
	}

}
