package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IBookedTimeRepository;
import core.domain.realestate.offeringaggregate.BookedTime;

public class BookedTimeRepository extends Repository<BookedTime>
		implements IBookedTimeRepository {

	public BookedTimeRepository(Class<?> type) {
		super(type);
	}

}
