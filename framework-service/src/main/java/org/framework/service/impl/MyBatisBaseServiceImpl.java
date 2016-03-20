package org.framework.service.impl;

import org.framework.dao.MyBatisBaseDao;
import org.framework.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jeffrey on 15-11-5.
 */
@Service
public class MyBatisBaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {
    @Autowired
    private MyBatisBaseDao myBatisBaseDao;

    /**
     * 插入数据
     *
     * @param object
     * @return 添加成功数量
     */
    @Override
    public int save(T object) {
        return myBatisBaseDao.insert(object);
    }

    /**
     * 批量插入
     *
     * @param cls
     * @param domainList
     * @return 返回插入条数
     */
    @Override
    public int saveBatch(Class<T> cls, List<T> domainList) {
        return myBatisBaseDao.insertBatch(cls,domainList);
    }

    /**
     * 批量插入
     *
     * @param cls        更新SQL的ID（sqlMap中）
     * @param domainList 需要更新的集合
     * @param count      表示多少笔数据提交一次
     * @return 返回插入条数
     */
    @Override
    public int saveBatch(Class<T> cls, List<T> domainList, Integer count) {
        return myBatisBaseDao.insertBatch(cls,domainList,count);
    }

    /**
     * 更新实体
     *
     * @param object
     * @return 更新数量
     */
    @Override
    public int update(T object) {
        return myBatisBaseDao.update(object);
    }

    /**
     * 批量更新
     *
     * @param cls
     * @param domainList
     * @return 更新数量
     */
    @Override
    public int updateBatch(Class<T> cls, List<T> domainList) {
        return myBatisBaseDao.updateBatch(cls,domainList);
    }

    /**
     * 批量更新
     *
     * @param cls        类   更新SQL的ID（sqlMap中）
     * @param domainList 需要更新的集合
     * @param count      表示多少笔数据提交一次
     * @return
     * @author : <a href="mailto:dejianliu@ebnew.com">dejianliu</a>  2015-5-7 下午2:53:55
     */
    @Override
    public int updateBatch(Class<T> cls, List<T> domainList, Integer count) {
        return myBatisBaseDao.updateBatch(cls,domainList,count);
    }

    /**
     * 按主键删除实体
     *
     * @param pk
     * @param cls
     * @return 删除数量
     */
    @Override
    public int delete(PK pk, Class<T> cls) {
        return myBatisBaseDao.delete(pk,cls);
    }

    /**
     * 批量删除
     *
     * @param cls
     * @param domainList
     * @return
     */
    @Override
    public int deleteBatch(Class<T> cls, List<T> domainList) {
        return myBatisBaseDao.deleteBatch(cls,domainList);
    }

    /**
     * 批量删除
     *
     * @param cls        class 类
     * @param domainList 待删除的集合实体
     * @param count      每多少笔数据笔数据提交一次事务
     * @return 返回批量删除条数
     * @author : <a href="mailto:dejianliu@ebnew.com">dejianliu</a>  2015-5-7 下午2:54:28
     */
    @Override
    public int deleteBatch(Class<T> cls, List<T> domainList, Integer count) {
        return myBatisBaseDao.deleteBatch(cls,domainList,count);
    }

    /**
     * 按主键查询
     *
     * @param pk
     * @param cls
     * @return
     */
    @Override
    public T findByPK(PK pk, Class<T> cls) {
        return (T)myBatisBaseDao.findByPK(pk,cls);
    }

    /**
     * 按条件查询实体
     *
     * @param obj
     * @return
     */
    @Override
    public List<T> findByCondition(T obj) {
        return myBatisBaseDao.findByCondition(obj);
    }

    /**
     * 按条件查询实体并分页
     *
     * @param obj
     * @param start
     * @param limit @return
     */
    @Override
    public List<T> findByCondition(T obj, int start, int limit) {
        return myBatisBaseDao.findByCondition(obj,start,limit);
    }

    /**
     * 按条件查询总记录数
     *
     * @param object
     * @return
     */
    @Override
    public Long findTotalCount(T object) {
        return myBatisBaseDao.findTotalCount(object);
    }
}
