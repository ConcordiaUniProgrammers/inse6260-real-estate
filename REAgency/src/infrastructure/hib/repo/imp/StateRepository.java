package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IStateRepository;
import core.domain.realestate.areaaggregate.State;

public class StateRepository extends Repository<State> implements
		IStateRepository {

	public StateRepository(Class<?> type) {
		super(type);
	}

}
