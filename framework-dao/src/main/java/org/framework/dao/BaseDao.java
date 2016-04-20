package org.framework.dao;

import java.io.Serializable;
import java.util.List;

/**
 * dao层接口
 * @param <T>
 * @param <PK>
 */
public interface BaseDao<T,PK extends Serializable> {
	/**
	 * 插入数据
	 * @param object
	 * @return  添加成功数量
	 */
	int insert(T object);
	/**
	 * 批量插入
	 *
	 * @param cls
	 * @param domainList
	 * @return 返回插入条数
	 */
	int insertBatch(Class<T> cls, List<T> domainList);

	/**
	 * 批量插入
	 * @param cls 更新SQL的ID（sqlMap中）
	 * @param domainList 需要更新的集合
	 * @param count 表示多少笔数据提交一次
	 * @return 返回插入条数
	 */
	int insertBatch(Class<T> cls, List<T> domainList, Integer count);

	/**
	 * 更新实体
	 *
	 * @param object
	 * @return 更新数量
	 */
	int update(T object);

	/**
	 * 批量更新
	 * @param domainList
	 * @return 更新数量
	 */
	int updateBatch(Class<T> cls, List<T> domainList);

	/**
	 * 批量更新
	 * @param cls
	 * @param domainList
	 * @param count
	 * @return
	 */
	int updateBatch(Class<T> cls, List<T> domainList, Integer count);

	/**
	 * 按主键删除实体
	 *
	 * @param pk
	 * @return  删除数量
	 */
	int delete(PK pk, Class<T> cls);

	/**
	 * 批量删除
	 * @param domainList
	 * @param cls
	 * @return
	 */
	int deleteBatch(Class<T> cls, List<T> domainList);

	/**
	 *批量删除
	 *
	 * @author 	: Jeffrey
	 * @param cls class 类
	 * @param domainList 待删除的集合实体
	 * @param count 每多少笔数据笔数据提交一次事务
	 * @return 返回批量删除条数
	 */
	int deleteBatch(Class<T> cls, List<T> domainList, Integer count);

	/**
	 * 按主键查询
	 *
	 * @param pk
	 * @return
	 */
	T findByPK(PK pk, Class<T> cls);

	/**
	 * 按条件查询实体
	 *
	 * @param obj
	 * @return
	 */
	List<T> findByCondition(T obj);

	/**
	 * 按条件查询实体并分页
	 *
	 * @param obj
	 * @return
	 */
	List<T> findByCondition(T obj, int start, int limit);
	/**
	 * 按条件查询总记录数
	 *
	 * @param object
	 * @return
	 */
	Long findTotalCount(T object);

}
