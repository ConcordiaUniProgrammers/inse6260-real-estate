package core.contract.infracontract;

import java.util.List;
import java.util.Map;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;

public interface IRepository<T extends IEntity & IArchivable> {
	
	public boolean save(T entity);
	public boolean delete(int id);
	public boolean update(T entity);
	public T findById(int id);
	public List<T> findAll();
	public List<T> findAllByPage(int firstResult, int maxResult);
	public int countAll();
	public List<T> findByExample(T example);
	public List<T> findByExampleByPage(T example, int firstResult, int maxResult);
	public int countByExample(final T example);
	public List<T> findByNamedQuery(String queryName, Object... params);
	public List<T> findByNamedQueryByPage(String queryName, int firstResult, int maxResult, Object... params);
	public List<T> findByNamedQueryAndNamedParams(String queryName, Map<String, ? extends Object> params);
	public List<T> findByNamedQueryAndNamedParamsByPage(String queryName, int firstResult, int maxResult, Map<String, ? extends Object> params);
	public void setObject(Object obj);
}
