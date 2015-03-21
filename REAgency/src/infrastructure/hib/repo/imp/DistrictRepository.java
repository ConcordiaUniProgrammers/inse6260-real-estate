package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IDistrictRepository;
import core.domain.realestate.areaaggregate.District;

public class DistrictRepository extends Repository<District> implements
		IDistrictRepository {

	public DistrictRepository(Class<?> type) {
		super(type);
	}

}
