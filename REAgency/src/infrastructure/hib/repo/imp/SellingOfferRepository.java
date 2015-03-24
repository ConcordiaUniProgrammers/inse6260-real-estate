package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;

import java.util.List;

import org.hibernate.Hibernate;

import core.contract.infracontract.ISellingOfferRepository;
import core.domain.realestate.offeringaggregate.Offer;
import core.domain.realestate.offeringaggregate.Representer;
import core.domain.realestate.offeringaggregate.SellingOffer;

public class SellingOfferRepository extends Repository<SellingOffer> implements
		ISellingOfferRepository {

	public SellingOfferRepository(Class<?> type) {
		super(type);
	}
	public List<Offer> loadOffers(SellingOffer sellingOffer){
		Hibernate.initialize(sellingOffer.getOffers());
		return sellingOffer.getOffers();
	}
	public List<Representer> loadRepresenters(SellingOffer sellingOffer){
		Hibernate.initialize(sellingOffer.getRepresenters());
		return sellingOffer.getRepresenters();
	}

}
