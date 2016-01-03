package org.framework.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author  admin
 * @date  15-10-31  下午10:05
 * @version v1.0
 */
public interface BaseDao<T,PK extends Serializable> {

	/**
	 * 增加实体
	 *
	 * @param object
	 */
	public int add(T object);

	/**
	 * 更新实体
	 *
	 * @param object
	 */
	public int update(T object);
	/**
	 * 按主键删除实体
	 *
	 * @param pk
	 */
	public int delete(PK pk, Class<T> cls);

	/**
	 * 按条件查询实体
	 *
	 * @param obj
	 * @return
	 */
	public List<T> findByCondition(T obj);

	/**
	 * 按条件查询实体并分页
	 *
	 * @param obj
	 * @return
	 */
	public List<T> findByCondition(T obj, int start, int limit);
	/**
	 * 按条件查询总记录数
	 *
	 * @param object
	 * @return
	 */
	public Integer getTotalCount(T object);

	/**
	 * 按主键查询
	 *
	 * @param pk
	 * @return
	 */
	public T findByPK(PK pk, Class<T> cls);
}
