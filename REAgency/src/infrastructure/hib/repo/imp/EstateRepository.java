package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IEstateRepository;
import core.domain.realestate.estateaggregate.Estate;

public class EstateRepository extends Repository<Estate> implements
		IEstateRepository {

	public EstateRepository(Class<?> type) {
		super(type);
	}

}
