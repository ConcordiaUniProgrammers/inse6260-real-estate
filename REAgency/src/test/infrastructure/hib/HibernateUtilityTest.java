package test.infrastructure.hib;

import static org.junit.Assert.assertNotNull;
import infrastructure.hib.HibernateUtility;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilityTest {

	@Test
	public void testGetSessionFactory() {
		 Session session = HibernateUtility.getSessionFactory().openSession();
		 assertNotNull(session);
	}

}
