package core.domainservice.imp;

import infrastructure.hib.DIConfiguration;
import infrastructure.hib.UnitOfWork;

import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.UUID;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import core.contract.infracontract.IUnitOfWork;
import core.domain.realestate.typeaggregate.REType;
import core.domainservice.IRETypeService;

public class RETypeService implements IRETypeService {

	@Override
	public void AddNewTypeToOneApmaType(String newTypeName, String type) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIConfiguration.class);
		IUnitOfWork uow = context.getBean(UnitOfWork.class);
		try {
			Class<?> myClass = Class
					.forName("core.domain.realestate.typeaggregate.REType");
			Constructor<?> cons = myClass.getConstructors()[0];
			REType myType = (REType) cons.newInstance();

			myType.setName(newTypeName);
			myType.setIsArchived(false);
			myType.setDateOfArchive(new Date());
			myType.setAccessKey(myType.getClass().getSimpleName()
					+ UUID.randomUUID().toString());
			REType t = uow.getrETypeRepository().getLastType(type);
			if (t != null) {
				myType.setRank(t.getRank() + 1);
			} else {
				myType.setRank(1);
			}
			
			uow.getrETypeRepository().save(myType);
			uow.commit();
		} catch (Exception e) {
			System.err.println("RETypeService:AddNewTypeToOneApmaType --> "
					+ e.getMessage());
		}
	}
}
