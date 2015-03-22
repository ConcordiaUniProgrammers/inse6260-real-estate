package test.infrastructure.restful;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import infrastructure.restful.viewmodels.TypeViewModel;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;

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
		fail("Not yet implemented");
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

}
