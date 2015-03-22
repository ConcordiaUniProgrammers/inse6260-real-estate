package infrastructure.hib;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.persistence.config.TunerType;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;

import core.contract.infracontract.IRepository;
import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;

public abstract class Repository<T extends IEntity & IArchivable> implements IRepository<T> {

	protected Session session;
	protected Class<?> type;
	public Repository(Class<?> type) {
		this.type = type;
	}
	
	@Override
	public boolean save(T entity) {
		boolean isDone = false;
		try {
			this.session.save(entity);
			isDone = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isDone;
	}

	@Override
	public boolean delete(int id) {
		boolean isDone = false;
		try {
			T entity = findById(id);
			if(entity != null){
				entity.setIsArchived(true);
				save(entity);
				isDone = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isDone;
	}

	@Override
	public boolean update(T entity) {
		boolean isDone = false;
		try {
			this.session.update(entity);
			isDone = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isDone;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(int id) {
		T entity = null;
		try {
			 entity= (T) this.session.get(this.type,id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		List<T> entities = new ArrayList<>();
		try {
			Criteria criteria = session.createCriteria(this.type);
			entities = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return entities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllByPage(int firstResult, int maxResult) {
		Criteria criteria = session.createCriteria(this.type);
		criteria.setFirstResult(firstResult).setMaxResults(maxResult);
		return criteria.list();
	}

	@Override
	public int countAll() {
		int count = 0;
		try {
			Criteria criteria = session.createCriteria(this.type);
			count = ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByExample(T entity) {
		List<T> result = new ArrayList<>();
		try {
			Example example = Example.create(entity);
			Criteria criteria = session.createCriteria(this.type).add(example);
			result = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByExampleByPage(T example, int firstResult, int maxResult) {
		Example ex = Example.create(example);
		Criteria criteria = session.createCriteria(this.type).add(ex);
		criteria.setFirstResult(firstResult).setMaxResults(maxResult);
		return criteria.list();
	}

	@Override
	public int countByExample(T entity) {
		int count = 0;
		try {
			Example example = Example.create(entity);
			Criteria criteria = session.createCriteria(this.type).add(example);
			count = ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	@Override
	public List<T> findByNamedQuery(String queryName, Object... params) {
		 
		return null;
	}

	@Override
	public List<T> findByNamedQueryByPage(String queryName, int firstResult,
			int maxResult, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByNamedQueryAndNamedParams(String queryName,
			Map<String, ? extends Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByNamedQueryAndNamedParamsByPage(String queryName,
			int firstResult, int maxResult, Map<String, ? extends Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void setObject(Object obj) {
		setSession((Session)obj);
		
	}
	

}
