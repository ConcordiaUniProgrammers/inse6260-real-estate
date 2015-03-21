package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IRepresenterRepository;
import core.domain.realestate.offeringaggregate.Representer;

public class RepresenterRepository extends Repository<Representer> implements
		IRepresenterRepository {

	public RepresenterRepository(Class<?> type) {
		super(type);
	}

}
