package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;

import java.util.List;

import org.hibernate.Hibernate;

import core.contract.infracontract.IEstateRepository;
import core.domain.realestate.estateaggregate.Estate;
import core.domain.realestate.estateaggregate.EstateFeature;

public class EstateRepository extends Repository<Estate> implements
		IEstateRepository {

	public EstateRepository(Class<?> type) {
		super(type);
	}
	public List<EstateFeature> loadRepresenters(Estate estate){
		Hibernate.initialize(estate.getFeatures());
		return estate.getFeatures();
	}

}
