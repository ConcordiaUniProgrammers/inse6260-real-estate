package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;

import java.util.List;

import org.hibernate.Hibernate;

import core.contract.infracontract.IUserRepository;
import core.domain.kernel.User;
import core.domain.realestate.offeringaggregate.BookedTime;
import core.domain.realestate.offeringaggregate.Offer;
import core.domain.realestate.offeringaggregate.SellingOffer;

public class UserRepository extends Repository<User> implements IUserRepository {

	public UserRepository(Class<?> type) {
		super(type);
	}
	public List<BookedTime> loadBookedTimes(User user){
		Hibernate.initialize(user.getBookedTimes());
		return user.getBookedTimes();
	}
	public List<SellingOffer> loadFavorites(User user){
		Hibernate.initialize(user.getFavorites());
		return user.getFavorites();
	}
	public List<Offer> loadOffers(User user){
		Hibernate.initialize(user.getOffers());
		return user.getOffers();
	}
	public List<BookedTime> loadSellingOffers(User user){
		Hibernate.initialize(user.getSellingOffers());
		return user.getBookedTimes();
	}

}
