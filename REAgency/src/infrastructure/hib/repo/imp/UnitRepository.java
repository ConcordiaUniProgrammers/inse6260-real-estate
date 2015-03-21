package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IUnitRepository;
import core.domain.realestate.estateaggregate.Unit;

public class UnitRepository extends Repository<Unit> implements IUnitRepository {

	public UnitRepository(Class<?> type) {
		super(type);
	}

}
