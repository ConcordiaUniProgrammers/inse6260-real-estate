package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.ISellingOfferRepository;
import core.domain.realestate.offeringaggregate.SellingOffer;

public class SellingOfferRepository extends Repository<SellingOffer> implements
		ISellingOfferRepository {

	public SellingOfferRepository(Class<?> type) {
		super(type);
	}

}
