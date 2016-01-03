package org.framework.dao.impl;//package org.framework.dao.impl;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//import javax.annotation.Resource;
//
//import org.framework.core.common.PageCommon;
//import org.framework.core.util.ReflectUtils;
//import org.framework.dao.BaseDao;
//import org.framework.model.BaseEntity;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//
//public class BaseDAOImpl<T extends BaseEntity> implements BaseDao<T> {
//
//	private Class<T> clazz;
//	@Resource
//	private SessionFactory sessionFactory;
//
//	public BaseDAOImpl() {
////		this.clazz = (Class<T>) ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
//		this.clazz = ReflectUtils.getClassGenricType(getClass());;
//	}
//
//	/**
//	 * 获取session
//	 *
//	 * @return
//	 */
//	private Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}
//
//	@Override
//	public void add(T entity) {
//		getSession().save(entity);
//	}
//
//	@Override
//	public void update(T entity) {
//		getSession().update(entity);
//	}
//
//	@Override
//	public void delete(T entity) {
//		getSession().delete(entity);
//
//	}
//
//	@Override
//	public void delete(int id) {
//		getSession().delete(id+"", clazz);
//	}
//
//	@Override
//	public void executeByHsql(String hsql, Objects... objects) {
//		Query query = getSession().createQuery(hsql);
//		if (objects != null && objects.length > 0) {
//			for (int i = 0; i < objects.length; i++) {
//				query.setParameter(i, objects[i]);
//			}
//		}
//		query.executeUpdate();
//	}
//
//	@Override
//	public void executeBySql(String hsql, Objects... objects) {
//		Query query = getSession().createSQLQuery(hsql);
//		if (objects != null && objects.length > 0) {
//			for (int i = 0; i < objects.length; i++) {
//				query.setParameter(i, objects[i]);
//			}
//		}
//		query.executeUpdate();
//
//	}
//
//	@Override
//	public long findTotal(String hsql, Object... objects) {
//		Query query = getSession().createQuery(hsql);
//		if (objects != null && objects.length > 0) {
//			for (int i = 0; i < objects.length; i++) {
//				query.setParameter(i, objects[i]);
//			}
//		}
//		@SuppressWarnings({ "rawtypes" })
//		List list = query.list();
//		return null == list ? 0 : list.size();
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public T findById(int id) {
//		return (T) getSession().get(clazz, id);
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<T> findByHsql(String hsql) {
//		Query query = getSession().createQuery(hsql);
//		return (List<T>) query.list();
//	}
//
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Override
//	public List<T> findByHsql(String hsql, Object... objects) {
//		Query query = getSession().createQuery(hsql);
//		if (objects != null && objects.length > 0) {
//			for (int i = 0; i < objects.length; i++) {
//				query.setParameter(i, objects[i]);
//			}
//		}
//		List list = query.list();
//		return list;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public Map<String, Object> findByObjects(String hsql, int firstResult, int maxResults, Object... objects) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		long count = 0l;
//		List<T> list;
//		Query query = getSession().createQuery(hsql);
//		if (objects != null && objects.length > 0) {
//			for (int i = 0; i < objects.length; i++) {
//				query.setParameter(i, objects[i]);
//			}
//		}
//		list = query.list();
//		// 获取总数
//		count = null == list ? 0 : list.size();
//		// 设置分页
//		query.setFirstResult(firstResult);
//		query.setMaxResults(maxResults);
//		list = query.list();
//		map.put(PageCommon.PAGE_DATA, list);
//		map.put(PageCommon.PAGE_COUNT, count);
//		return map;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<T> findAll() {
//		return (List<T>)getSession().createCriteria(clazz).list();
//	}
//
//	@Override
//	public List<T> find(String hsql, Object[] value, int firstResult, int maxResults) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<T> findByExample(T exampleInstance, String... excludeProperty) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<T> findByObjects(Object obj) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
