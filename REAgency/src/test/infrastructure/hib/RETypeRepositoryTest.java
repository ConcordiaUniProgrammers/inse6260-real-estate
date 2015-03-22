package test.infrastructure.hib;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import infrastructure.hib.DIConfiguration;
import infrastructure.hib.UnitOfWork;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import core.contract.infracontract.IUnitOfWork;
import core.domain.realestate.typeaggregate.REType;

public class RETypeRepositoryTest {
	private AnnotationConfigApplicationContext context;
	private IUnitOfWork uow;

	@Before
	public void setUp() throws Exception {
		try {
			 this.context = new AnnotationConfigApplicationContext(DIConfiguration.class);
			 this.uow = context.getBean(UnitOfWork.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@After
	public void tearDown() throws Exception {
		this.context.close();
	}


	@Test
	public void testGetTypeByAccessKey() {
		REType type = uow.getrETypeRepository().GetTypeByAccessKey("EstateType8f26be60-99eb-498c-9d12-701bdfdb27ae");
		assertTrue(type.getName().equals("test"));
	}

	@Test
	public void testGetTypes() {
		List<REType> types = uow.getrETypeRepository().getTypes("ImageType");
		assertTrue(types.size() == 2);
	}

	@Test
	public void testGetTypesOrderByRank() {
		List<REType> types = uow.getrETypeRepository().getTypesOrderByRank("ImageType");
		assertTrue(types.size() == 2);
		
	}

	@Test
	public void testGetLastType() {
		REType type = uow.getrETypeRepository().getLastType("ImageType");
		assertTrue(type.getName().equals("Condo") && type.getId() == 3);
	}

	@Test
	public void testGetFirstType() {
		REType type = uow.getrETypeRepository().getFirstType("ImageType");
		assertTrue(type.getName().equals("Condo") && type.getId() == 2);
	}

}
