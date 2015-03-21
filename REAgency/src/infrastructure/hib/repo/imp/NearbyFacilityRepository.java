package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.INearbyFacilityRepository;
import core.domain.realestate.estateaggregate.NearbyFacility;

public class NearbyFacilityRepository extends Repository<NearbyFacility>
		implements INearbyFacilityRepository {

	public NearbyFacilityRepository(Class<?> type) {
		super(type);
	}

}
