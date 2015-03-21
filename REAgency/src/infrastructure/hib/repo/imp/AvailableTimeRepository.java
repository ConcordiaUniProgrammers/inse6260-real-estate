package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IAvailableTimeRepository;
import core.domain.realestate.offeringaggregate.AvailableTime;

public class AvailableTimeRepository extends Repository<AvailableTime>
		implements IAvailableTimeRepository {

	public AvailableTimeRepository(Class<?> type) {
		super(type);
	}

}
