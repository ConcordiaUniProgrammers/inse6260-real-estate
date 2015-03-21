package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;
import core.contract.infracontract.IRoleRepository;
import core.domain.kernel.Role;

public class RoleRepository extends Repository<Role> implements IRoleRepository {

	public RoleRepository(Class<?> type) {
		super(type);
	}

	
}
