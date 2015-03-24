package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;

import java.util.List;

import org.hibernate.Hibernate;

import core.contract.infracontract.IAvailableTimeRepository;
import core.domain.realestate.offeringaggregate.AvailableTime;
import core.domain.realestate.offeringaggregate.BookedTime;

public class AvailableTimeRepository extends Repository<AvailableTime>
		implements IAvailableTimeRepository {

	public AvailableTimeRepository(Class<?> type) {
		super(type);
	}
	public List<BookedTime> loadRepresenters(AvailableTime availableTime){
		Hibernate.initialize(availableTime.getBookedTimes());
		return availableTime.getBookedTimes();
	}

}
