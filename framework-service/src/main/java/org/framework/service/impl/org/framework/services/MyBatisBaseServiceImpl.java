package org.framework.service.impl.org.framework.services;

import org.apache.ibatis.session.SqlSessionFactory;
import org.framework.dao.MyBatisBaseDao;
import org.framework.service.BaseService;
import org.mybatis.spring.SqlSessionTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jeffrey on 15-11-5.
 */
public class MyBatisBaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

    private MyBatisBaseDao myBatisBaseDao;
    public int add(T object) {
        return myBatisBaseDao.add(object);
    }

    public int update(T object) {
        return myBatisBaseDao.update(object);
    }

    public int delete(PK pk, Class<T> cls) {

        return myBatisBaseDao.delete(pk,cls);
    }

    public List<T> findByCondition(T obj) {

        return myBatisBaseDao.findByCondition(obj);
    }

    public List<T> findByCondition(T obj, int start, int limit) {
        return myBatisBaseDao.findByCondition(obj,start,limit);
    }

    public Integer getTotalCount(T object) {
        return myBatisBaseDao.getTotalCount(object);
    }

    public T findByPK(PK pk, Class<T> cls) {
        return (T)myBatisBaseDao.findByPK(pk,cls);
    }

    public int insertBatch(Class<T> cls, List<T> domainList, Integer count) {

        return myBatisBaseDao.insertBatch(cls,domainList,count);
    }

    public int insertBatch(Class<T> cls, List<T> domainList) {

        return myBatisBaseDao.insertBatch(cls,domainList);
    }

    public int updateBatch(Class<T> cls, List<T> domainList, Integer count) {

        return myBatisBaseDao.updateBatch(cls,domainList,count);
    }

    public int deleteBatch(Class<T> cls, List<T> domainList, Integer count) {

        return myBatisBaseDao.deleteBatch(cls,domainList,count);
    }

    public SqlSessionTemplate getCurSqlSessionTemplate() {
        return myBatisBaseDao.getCurSqlSessionTemplate();
    }

    public SqlSessionFactory getCurSqlSessionFactory() {
        return myBatisBaseDao.getCurSqlSessionFactory();
    }
}
