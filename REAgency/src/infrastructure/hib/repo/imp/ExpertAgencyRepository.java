package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;

import java.util.List;

import org.hibernate.Hibernate;

import core.contract.infracontract.IExpertAgencyRepository;
import core.domain.realestate.agantaggregate.ExpertAgency;
import core.domain.realestate.estateaggregate.Estate;

public class ExpertAgencyRepository extends Repository<ExpertAgency> implements
		IExpertAgencyRepository {

	public ExpertAgencyRepository(Class<?> type) {
		super(type);
	}
	public List<Estate> loadRepresenters(ExpertAgency expertAgency){
		Hibernate.initialize(expertAgency.getApprovals());
		return expertAgency.getApprovals();
	}

}
