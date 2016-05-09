package org.framework.dao.impl;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.ThreadLocalMap;
import org.framework.core.expections.FrameWorkDaoException;
import org.framework.dao.MyBatisBaseDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author jeffreyJi
 * @version Ver 1.0
 * @description: mybatis DAO 通用工具类
 * @Date   2015-12-3 下午4:40:35
 */
@Repository(value = "myBatisBaseDao")
public class MyBatisBaseDaoImpl<T, PK extends Serializable> implements MyBatisBaseDao<T, PK> {

    private static final Logger logger = Logger.getLogger(MyBatisBaseDaoImpl.class);
    // 自动提交设置true 类型是默认的 sqlsession
    public static final ThreadLocal<SqlSession> LOCAL_DEFAULT_HOLDER = new ThreadLocal<SqlSession>();
    // 自动提交设置false 类型为batch 的sqlsession
    public static final ThreadLocal<SqlSession> LOCAL_BATCH_HOLDER = new ThreadLocalMap();
    // 默认提交个数
    public static final Integer DEFAULT_COMMIT_NUM = 100;

    @Autowired
    protected SqlSessionFactory sqlSessionFactory;

    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

    /**
     * 插入
     */
    public String INSERT = ".insert";

    /**
     * 批量插入
     */
    public String INSERT_BATCH = ".insertBatch";

    /**
     * 更新
     */
    public String UPDATE = ".update";

    /**
     * 根据ID 删除
     */
    public String DELETE = ".delete";

    /**
     * 根据ID 查询
     */
    public String GETBYID = ".getById";

    /**
     * 根据条件 分页查询
     */
    public String COUNT = ".findPage_count";
    /**
     * 根据条件 分页查询
     */
    public String PAGESELECT = ".findPage";

    public int insert(T object) {
        beforeCheck(object);
        return sqlSessionTemplate.insert(object.getClass().getName() + INSERT, object);
    }

    public int insertBatch(Class<T> cls, List<T> domainList) {
        return insertBatch(cls,domainList,DEFAULT_COMMIT_NUM);
    }

    public int insertBatch(Class<T> cls, List<T> domainList, Integer count) {
        SqlSession sqlSession = null;
        try {
            if (domainList == null) {
                return 0;
            }
            sqlSession = getBatchSqlSession();
            int num = 0;
            for (T t : domainList) {
                sqlSession.insert(cls.getName() + INSERT, t);
                num++;
                if (count == num) {
                    sqlSession.commit();
                    num = 0;
                }
            }
            //  把最后的都提交完毕
            if ( num > 0) {
                sqlSession.commit();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            if (sqlSession != null)
                sqlSession.rollback(true);
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (sqlSession != null) sqlSession.close();
        }
        return domainList.size();

    }

    public int update(T object) {
        beforeCheck(object);
        return sqlSessionTemplate.update(object.getClass().getName() + UPDATE, object);

    }

    public int updateBatch(Class<T> cls, List<T> domainList) {
        return updateBatch(cls,domainList,DEFAULT_COMMIT_NUM);
    }

    public int updateBatch(Class<T> cls, List<T> domainList, Integer count) {
        SqlSession sqlSession = null;
        try {
            if (domainList == null) {
                return 0;
            }
            sqlSession = getBatchSqlSession();

            int num = 0;
            for (T t : domainList) {
                sqlSession.update(cls.getName() + UPDATE, t);
                num++;
                if (count == num) {
                    sqlSession.commit();
                    num = 0;
                }
            }
            if (num > 0) {
                sqlSession.commit();
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            if (sqlSession != null) {
                sqlSession.rollback(true);
            }
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return domainList.size();
    }


    public int delete(PK pk, Class<T> cls) {
        if (pk == null) {
            throw new FrameWorkDaoException(" pk can't null!");
        }
        return sqlSessionTemplate.delete(cls.getName() + DELETE, pk);
    }

    public int deleteBatch(Class<T> cls, List<T> domainList,Integer count) {
        SqlSession sqlSession = null;
        try {
            if (domainList == null) {
                return 0;
            }
            sqlSession = getBatchSqlSession();

            int num = 0;
            for (T t : domainList) {
                sqlSession.delete(cls.getName() + DELETE,t);
                num++;
                if (count == num) {
                    sqlSession.commit();
                    num = 0;
                }
            }
            if (num > 0) {
                sqlSession.commit();
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            if (sqlSession != null) {
                sqlSession.rollback(true);
            }
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return domainList.size();
    }

    public int deleteBatch(Class<T> cls, List<T> domainList) {

        return deleteBatch(cls,domainList,DEFAULT_COMMIT_NUM);
    }

    public List<T> findByCondition(T obj) {
        if (obj == null) {
            throw new FrameWorkDaoException(" condition can't null!");
        }
        return (List<T>) sqlSessionTemplate.selectList(obj.getClass().getName() + PAGESELECT, obj);
    }

    public List<T> findByCondition(T obj, int start, int limit) {
        if (obj == null) {
            throw new FrameWorkDaoException(" condition can't null!");
        }
        RowBounds rb = new RowBounds(start, limit);
        return (List<T>) sqlSessionTemplate.selectList(obj.getClass().getName() + PAGESELECT, obj, rb);
    }

    public Long findTotalCount(T object) {
        if (object == null) {
            throw new FrameWorkDaoException(" condition can't null!");
        }
        Object obj = sqlSessionTemplate.selectOne(object.getClass().getName() + COUNT, object);
        if (obj != null) {
            return Long.getLong(obj.toString());
        }
        return 0l;
    }

    public T findByPK(PK pk, Class<T> cls) {
        if (pk == null) {
            throw new FrameWorkDaoException(" pk can't null!");
        }
        return (T) sqlSessionTemplate.selectOne(cls.getName() + GETBYID, pk);
    }

    public SqlSessionTemplate getCurSqlSessionTemplate() {
        return this.sqlSessionTemplate;
    }

    public SqlSessionFactory getCurSqlSessionFactory() {
        return this.sqlSessionFactory;
    }


    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    private void beforeCheck(Object object){
        if (object == null){
            throw new FrameWorkDaoException("object can't null!");
        }
    }

    /**
     * 获取 sqlsession 默认是 自动提交
     * @return
     */
    private SqlSession getDefaultSqlSession(){
        if (LOCAL_DEFAULT_HOLDER.get() != null){
            return LOCAL_DEFAULT_HOLDER.get();
        }
        SqlSession sqlsession = sqlSessionFactory.openSession(true);
        LOCAL_DEFAULT_HOLDER.set(sqlsession);
        return sqlsession;
    }

    /**
     * 获取 类型是 batch 不自动提交的sqlsession
     * @return
     */
    private SqlSession getBatchSqlSession(){
        if (LOCAL_BATCH_HOLDER.get() != null){
            return LOCAL_BATCH_HOLDER.get();
        }
        SqlSession sqlsession = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
        LOCAL_BATCH_HOLDER.set(sqlsession);
        return sqlsession;
    }
}
