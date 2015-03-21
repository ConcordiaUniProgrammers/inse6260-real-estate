package core.contract.infracontract;

import java.util.List;

import core.domain.realestate.typeaggregate.REType;

public interface IRETypeRepository extends IRepository<REType> {

	List<REType> getTypes(String typeName);

	REType GetTypeByAccessKey(String accessKey);

	List<REType> getTypesOrderByRank(String typeName);

	REType getLastType(String typeName);

	REType getFirstType(String typeName);

}
