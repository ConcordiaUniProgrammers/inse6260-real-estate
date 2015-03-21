package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import core.contract.infracontract.IRETypeRepository;
import core.domain.realestate.typeaggregate.REType;

public class RETypeRepository extends Repository<REType> implements
		IRETypeRepository {

	public RETypeRepository(Class<?> type) {
		super(type);
	}

	@Override
	public REType GetTypeByAccessKey(String accessKey) {
		try {
			Criteria criteria = this.session.createCriteria(REType.class)
					.add(Restrictions.eq("accessKey", accessKey))
					.add(Restrictions.eq("isArchived", false));
			return (REType) criteria.list().get(0);
		} catch (Exception exp) {
			System.err.println("RETypeRepository: GetTypeByAccessKey --> "
					+ exp.getMessage());
		}
		return null;
	}

	@Override
	public List<REType> getTypes(String typeName) {
		List<REType> result = null;
		try {
			Query qu = session.createQuery("from " + typeName
					+ " order by 'Rank'");
			result = qu.list();
		} catch (Exception exp) {
			System.err.println("RETypeRepository: getTypes --> "
					+ exp.getMessage());
		}
		return result;
	}

	@Override
	public List<REType> getTypesOrderByRank(String typeName) {
		List<REType> result = null;
		try {
			Query qu = session.createQuery("from " + typeName
					+ " where IsArchived=0  order by Rank");
			result = qu.list();
		} catch (Exception exp) {
			System.err.println("RETypeRepository: getTypes --> "
					+ exp.getMessage());
		}
		return result;
	}

	@Override
	public REType getLastType(String typeName) {
		try {
			Query qu = session.createQuery("from " + typeName
					+ " order by Rank Desc");
			List typeList = qu.list();
			if (typeList != null & typeList.size() > 0) {
				for (int i = 0; i < typeList.size(); i++) {
					REType type = (REType) typeList.get(i);
					if (!type.getIsArchived()) {
						return type;
					}
				}
			}
			
		} catch (Exception exp) {
			System.err.println("RETypeRepository: getLastType --> "
					+ exp.getMessage());
		}
		return null;
	}

	@Override
	public REType getFirstType(String typeName) {
		try {
			Query qu = session.createQuery("from " + typeName
					+ " order by Rank");
			List typeList = qu.list();

			if (typeList != null & typeList.size() > 0) {
				for (int i = 0; i < typeList.size(); i++) {
					REType type = (REType) typeList.get(i);
					if (!type.getIsArchived())
						return type;
				}
			}
			
		} catch (Exception exp) {
			System.err.println("RETypeRepository: getFirstType --> "
					+ exp.getMessage());
		}
		return null;
	}

}
