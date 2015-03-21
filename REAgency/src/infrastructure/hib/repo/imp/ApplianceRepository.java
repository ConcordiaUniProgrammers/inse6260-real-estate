package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IApplianceRepository;
import core.domain.realestate.estateaggregate.Appliance;

public class ApplianceRepository extends Repository<Appliance> implements
		IApplianceRepository {

	public ApplianceRepository(Class<?> type) {
		super(type);
	}

}
