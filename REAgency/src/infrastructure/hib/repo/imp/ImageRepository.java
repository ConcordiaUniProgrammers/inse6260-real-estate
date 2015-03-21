package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IImageRepository;
import core.domain.realestate.estateaggregate.Image;

public class ImageRepository extends Repository<Image> implements
		IImageRepository {

	public ImageRepository(Class<?> type) {
		super(type);
	}

}
