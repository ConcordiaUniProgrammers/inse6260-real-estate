package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IUserRepository;
import core.domain.kernel.User;

public class UserRepository extends Repository<User> implements IUserRepository {

	public UserRepository(Class<?> type) {
		super(type);
	}

}
