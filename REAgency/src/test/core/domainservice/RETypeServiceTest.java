package test.core.domainservice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.domainservice.imp.RETypeService;

public class RETypeServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddNewTypeToOneApmaType() {
		RETypeService service = new RETypeService();
		service .AddNewTypeToOneREType("Condo", "EstateType");
	}

}
