package test.infrastructure.restful;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import infrastructure.hib.DIConfiguration;
import infrastructure.hib.UnitOfWork;
import infrastructure.restful.viewmodels.TypeViewModel;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import core.contract.infracontract.IUnitOfWork;
import core.domain.realestate.typeaggregate.REType;
import core.domainservice.IRETypeService;
import core.domainservice.imp.RETypeService;

public class TypeResourceTest {

	private Client client;
	private WebTarget target;
	private IRETypeService service;
	
	@Before
	public void setUp(){
		try {
			this.client = ClientBuilder.newClient();
			this.target = client.target("http://localhost:8080/REAgency/webapi/");
			this.service = new RETypeService();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void getTypeByNameTest() {
		String typename = "ImageType";
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIConfiguration.class);
		IUnitOfWork uow = context.getBean(UnitOfWork.class);
		
		List<REType> actuals = uow.getrETypeRepository().getTypesOrderByRank(typename);
		uow.commit();
		List<REType> expected = this.target.path("type/" + typename).request(MediaType.APPLICATION_JSON).get(new GenericType<List<REType>>(){});
		assertEquals(expected.size(), actuals.size());
		context.close();
	}
	
	@Test
	public void deleteTypeTest(){
		int id = 1;
		Response response = this.target.path("type/delete/" + id).request(MediaType.APPLICATION_JSON).get();
		if(response.getStatus() != Status.OK.getStatusCode()){
			fail(response.getStatus() + " : there was an error!");
		}
		
		String result = response.readEntity(String.class);
		assertTrue(result.equals("true"));
	}
	
	@Test
	public void addNewTypeTest() {
		TypeViewModel type = new TypeViewModel();
		type.setNewTypeName("Home");
		type.setType("EstateType");
		Response response = this.target.path("type/newtype").request(MediaType.APPLICATION_JSON).post(Entity.entity(type, MediaType.APPLICATION_JSON));
		if(response.getStatus() != Status.OK.getStatusCode()){
			fail(response.getStatus() + " : there was an error!");
		}
		
		String result = response.readEntity(String.class);
		assertTrue(result.equals("true"));
	}
	
	@Test
	public void updateTypeTest() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIConfiguration.class);
		IUnitOfWork uow = context.getBean(UnitOfWork.class);
		
		REType type = uow.getrETypeRepository().getFirstType("EstateType");
		type.setName("testtttttttttttttttttt");
		type.setIsArchived(false);
		uow.commit();
		Response response = this.target.path("type/update/type").request(MediaType.APPLICATION_JSON).post(Entity.entity(type, MediaType.APPLICATION_JSON));
		if(response.getStatus() != Status.OK.getStatusCode()){
			fail(response.getStatus() + " : there was an error!");
		}
		
		String result = response.readEntity(String.class);
		assertTrue(result.equals("true"));
		context.close();
	}

}
