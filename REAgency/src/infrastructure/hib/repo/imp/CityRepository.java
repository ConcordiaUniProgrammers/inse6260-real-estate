package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.ICityRepository;
import core.domain.realestate.areaaggregate.City;

public class CityRepository extends Repository<City> implements ICityRepository {

	public CityRepository(Class<City> type) {
		super(type);
	}

}
