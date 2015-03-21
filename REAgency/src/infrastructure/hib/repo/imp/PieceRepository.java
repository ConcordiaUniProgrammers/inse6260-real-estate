package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IPieceRepository;
import core.domain.realestate.estateaggregate.Piece;

public class PieceRepository extends Repository<Piece> implements
		IPieceRepository {

	public PieceRepository(Class<?> type) {
		super(type);
	}

}
