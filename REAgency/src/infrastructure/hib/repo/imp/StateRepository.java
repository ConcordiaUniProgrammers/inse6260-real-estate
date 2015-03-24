package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;

import java.util.List;

import org.hibernate.Hibernate;

import core.contract.infracontract.IStateRepository;
import core.domain.realestate.areaaggregate.City;
import core.domain.realestate.areaaggregate.State;

public class StateRepository extends Repository<State> implements
		IStateRepository {

	public StateRepository(Class<?> type) {
		super(type);
	}

	public List<City> loadAppliances(State state){
		Hibernate.initialize(state.getCities());
		return state.getCities();
	}

}
