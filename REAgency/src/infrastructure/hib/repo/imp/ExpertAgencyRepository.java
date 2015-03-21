package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IExpertAgencyRepository;
import core.domain.realestate.agantaggregate.ExpertAgency;

public class ExpertAgencyRepository extends Repository<ExpertAgency> implements
		IExpertAgencyRepository {

	public ExpertAgencyRepository(Class<?> type) {
		super(type);
	}

}
