package infrastructure.hib.repo.imp;

import infrastructure.hib.Repository;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
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
					+ " order by rank");
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
					+ " where isArchived=0  order by rank");
			result = qu.list();
		} catch (Exception exp) {
			System.err.println("RETypeRepository: getTypes --> "
					+ exp.getMessage());
		}
		return result;
	}

	@Override
	public REType getLastType(String typeName) {
		REType type = null;
		try {
			Query qu = session.createQuery("from " + typeName
					+ " where isArchived=0 order by rank");
			List<REType> typeList = qu.list();
			if(typeList != null){
				type = typeList.get(typeList.size() -1);
			}
		} catch (Exception exp) {
			System.err.println("RETypeRepository: getLastType --> "
					+ exp.getMessage());
		}
		return type;
	}

	@Override
	public REType getFirstType(String typeName) {
		REType type = null;
		try {
			Query qu = session.createQuery("from " + typeName
					+ " where isArchived=0 order by rank");
			List<REType> typeList = qu.list();
			if(typeList != null){
				type = typeList.get(0);
			}
			
		} catch (Exception exp) {
			System.err.println("RETypeRepository: getFirstType --> "
					+ exp.getMessage());
		}
		return type;
	}

}
