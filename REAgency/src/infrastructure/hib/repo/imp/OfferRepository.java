package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IOfferRepository;
import core.domain.realestate.offeringaggregate.Offer;

public class OfferRepository extends Repository<Offer> implements
		IOfferRepository {

	public OfferRepository(Class<?> type) {
		super(type);
	}

}
