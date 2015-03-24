package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;

import java.util.List;

import org.hibernate.Hibernate;

import core.contract.infracontract.IRepresenterRepository;
import core.domain.realestate.offeringaggregate.AvailableTime;
import core.domain.realestate.offeringaggregate.Representer;

public class RepresenterRepository extends Repository<Representer> implements
		IRepresenterRepository {

	public RepresenterRepository(Class<?> type) {
		super(type);
	}
	public List<AvailableTime> loadRepresenters(Representer representer){
		Hibernate.initialize(representer.getAvailableTimes());
		return representer.getAvailableTimes();
	}

}
