package org.framework.service;

import org.apache.ibatis.session.SqlSessionFactory;
import org.framework.dao.BaseDao;
import org.mybatis.spring.SqlSessionTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jeffrey on 15-11-5.
 */
public interface BaseService <T,PK extends Serializable> {
    /**
     * 插入数据
     * @param object
     * @return  添加成功数量
     */
    public int save(T object);

    /**
     * 批量插入
     *
     * @param cls
     * @param domainList
     * @return 返回插入条数
     */
    public int saveBatch(Class<T> cls, List<T> domainList);

    /**
     * 批量插入
     * @param cls 更新SQL的ID（sqlMap中）
     * @param domainList 需要更新的集合
     * @param count 表示多少笔数据提交一次
     * @return 返回插入条数
     */
    public int saveBatch(Class<T> cls, List<T> domainList, Integer count);

    /**
     * 更新实体
     *
     * @param object
     * @return 更新数量
     */
    public int update(T object);

    /**
     * 批量更新
     * @param domainList
     * @return 更新数量
     */
    public int updateBatch(Class<T> cls, List<T> domainList);

    /**
     *  批量更新
     *
     * @author 	: <a href="mailto:dejianliu@ebnew.com">dejianliu</a>  2015-5-7 下午2:53:55
     * @param cls 类   更新SQL的ID（sqlMap中）
     * @param domainList 需要更新的集合
     * @param count 表示多少笔数据提交一次
     * @return
     */
    public int updateBatch(Class<T> cls, List<T> domainList, Integer count);

    /**
     * 按主键删除实体
     *
     * @param pk
     * @return  删除数量
     */
    public int delete(PK pk, Class<T> cls);

    /**
     * 批量删除
     * @param domainList
     * @param cls
     * @return
     */
    public int deleteBatch(Class<T> cls, List<T> domainList);

    /**
     *批量删除
     *
     * @author 	: <a href="mailto:dejianliu@ebnew.com">dejianliu</a>  2015-5-7 下午2:54:28
     * @param cls class 类
     * @param domainList 待删除的集合实体
     * @param count 每多少笔数据笔数据提交一次事务
     * @return 返回批量删除条数
     */
    public int deleteBatch(Class<T> cls, List<T> domainList, Integer count);

    /**
     * 按主键查询
     *
     * @param pk
     * @return
     */
    public T findByPK(PK pk, Class<T> cls);

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
    public Long findTotalCount(T object);


}
