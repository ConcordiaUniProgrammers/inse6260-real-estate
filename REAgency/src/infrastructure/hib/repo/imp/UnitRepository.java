package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;

import java.util.List;

import org.hibernate.Hibernate;

import core.contract.infracontract.IUnitRepository;
import core.domain.realestate.estateaggregate.Appliance;
import core.domain.realestate.estateaggregate.Image;
import core.domain.realestate.estateaggregate.Piece;
import core.domain.realestate.estateaggregate.Unit;

public class UnitRepository extends Repository<Unit> implements IUnitRepository {

	public UnitRepository(Class<?> type) {
		super(type);
	}
	
	public List<Appliance> loadAppliances(Unit unit){
		Hibernate.initialize(unit.getAppliances());
		return unit.getAppliances();
	}
	public List<Image> loadImages(Unit unit){
		Hibernate.initialize(unit.getImages());
		return unit.getImages();
	}
	public List<Piece> loadPieces(Unit unit){
		Hibernate.initialize(unit.getPieces());
		return unit.getPieces();
	}

}
