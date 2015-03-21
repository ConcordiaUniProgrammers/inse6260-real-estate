package infrastructure.hib;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtility {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	static{ 
		    File f = new File("src/infrastructure/hib/hibernate.cfg.xml");
			Configuration configuration =  new Configuration().configure(f);
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

}
