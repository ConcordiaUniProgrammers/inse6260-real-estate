package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.ICountryRepository;
import core.domain.realestate.areaaggregate.Country;

public class CountryRepository extends Repository<Country> implements
		ICountryRepository {

	public CountryRepository(Class<?> type) {
		super(type);
	}

}
