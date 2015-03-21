package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IEstateFeatureRepository;
import core.domain.realestate.estateaggregate.EstateFeature;

public class EstateFeatureRepository extends Repository<EstateFeature>
		implements IEstateFeatureRepository {

	public EstateFeatureRepository(Class<?> type) {
		super(type);
	}

}
