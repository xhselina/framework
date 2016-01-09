package org.framework.dao.impl;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.framework.core.expections.FrameWorkDaoException;
import org.framework.dao.MyBatisBaseDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.List;
import java.util.Vector;

/**
 * @author <a href="mailto:dejian.liu@ebnew.com">dejian.liu</a>
 * @version Ver 1.0
 * @description: mybatis DAO 通用工具类
 * @Date 2012    2012-8-3		下午4:40:35
 * @since Ver 1.0
 */
@Repository(value = "myBatisBaseDao")
public class MyBatisBaseDaoImpl<T, PK extends Serializable> implements MyBatisBaseDao<T, PK> {

    private static Logger logger = Logger.getLogger(MyBatisBaseDaoImpl.class);
    public static final ThreadLocal<Vector<SqlSession>> LOCAL_CONNECTION_HOLDER = new ThreadLocal<Vector<SqlSession>>();

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

    private Object target;

    private Method invokingMethod;

    public int add(T object) {
        if (object == null) {
            throw new FrameWorkDaoException(" object can't null!");
        }
        if (LOCAL_CONNECTION_HOLDER.get() != null) {
            SqlSession session = getSqlSession(false);
            setAutoCommit(session.getConnection(), false);
            LOCAL_CONNECTION_HOLDER.get().add(session);
            return session.insert(object.getClass().getName() + INSERT, object);
        } else {
            return sqlSessionTemplate.insert(object.getClass().getName() + INSERT, object);
        }
    }

    public int update(T object) {
        if (object == null) {
            throw new FrameWorkDaoException(" object can't null!");
        }
        if (LOCAL_CONNECTION_HOLDER.get() != null) {
            SqlSession session = getSqlSession(false);
            setAutoCommit(session.getConnection(), false);
            LOCAL_CONNECTION_HOLDER.get().add(session);
            return session.update(object.getClass().getName() + UPDATE, object);
        } else {
            return sqlSessionTemplate.update(object.getClass().getName() + UPDATE, object);

        }
    }

    public int delete(PK pk, Class<T> cls) {
        if (pk == null) {
            throw new FrameWorkDaoException(" pk can't null!");
        }
        if (LOCAL_CONNECTION_HOLDER.get() != null) {
            SqlSession session = getSqlSession(false);
            setAutoCommit(session.getConnection(), false);
            LOCAL_CONNECTION_HOLDER.get().add(session);
            return session.delete(cls.getName() + DELETE, pk);
        } else {
            return sqlSessionTemplate.delete(cls.getName() + DELETE, pk);
        }

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

    public Integer getTotalCount(T object) {
        if (object == null) {
            throw new FrameWorkDaoException(" condition can't null!");
        }
        Object obj = sqlSessionTemplate.selectOne(object.getClass().getName() + COUNT, object);
        if (obj != null) {
            return Integer.parseInt(obj.toString());
        }
        return 0;
    }

    public T findByPK(PK pk, Class<T> cls) {
        if (pk == null) {
            throw new FrameWorkDaoException(" pk can't null!");
        }
        return (T) sqlSessionTemplate.selectOne(cls.getName() + GETBYID, pk);
    }

    public int insertBatch(Class<T> cls, List<T> domainList, Integer count) {
        SqlSession sqlSession = null;
        try {
            if (domainList == null) {
                return 0;
            }
            sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
            if (LOCAL_CONNECTION_HOLDER.get() != null) {
                setAutoCommit(sqlSession.getConnection(), false);
                LOCAL_CONNECTION_HOLDER.get().add(sqlSession);
            }

            int num = 0;
            for (T t : domainList) {

                sqlSession.insert(cls.getName() + INSERT, t);
                num++;
                if (count == num) {
                    sqlSession.commit();
                    num = 0;
                }
            }

            if (LOCAL_CONNECTION_HOLDER.get() == null || num > 0) {
                sqlSession.commit();
            }
        } catch (Exception e) {
            if (LOCAL_CONNECTION_HOLDER.get() == null) {
                if (sqlSession != null) {
                    sqlSession.rollback(true);
                }
            }
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (LOCAL_CONNECTION_HOLDER.get() == null) {
                if (sqlSession != null) {
                    sqlSession.close();
                }
            }
        }
        return domainList.size();

    }

    public int insertBatch(Class<T> cls, List<T> domainList) {
        if (null == domainList || domainList.size() == 0) return 0;
        return sqlSessionTemplate.insert(cls.getName() + INSERT_BATCH, domainList);
    }

    public int updateBatch(Class<T> cls, List<T> domainList, Integer count) {
        SqlSession sqlSession = null;
        try {
            if (domainList == null) {
                return 0;
            }
            sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
            if (LOCAL_CONNECTION_HOLDER.get() != null) {
                setAutoCommit(sqlSession.getConnection(), false);
                LOCAL_CONNECTION_HOLDER.get().add(sqlSession);
            }

            int num = 0;
            for (T t : domainList) {
                sqlSession.update(cls.getName() + UPDATE, t);
                num++;
                if (count == num) {
                    sqlSession.commit();
                    num = 0;
                }
            }
            if (LOCAL_CONNECTION_HOLDER.get() == null || num > 0) {
                sqlSession.commit();
            }

        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback(true);
            }
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return domainList.size();
    }

    public int deleteBatch(Class<T> cls, List<T> domainList, Integer count) {
        SqlSession sqlSession = null;
        try {
            if (domainList == null) {
                return 0;
            }
            sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
            setAutoCommit(sqlSession.getConnection(), false);

            int num = 0;
            for (T t : domainList) {
                sqlSession.delete(cls.getName() + DELETE, t);
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
            if (sqlSession != null) {
                sqlSession.rollback(true);
            }
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return domainList.size();
    }

    public SqlSessionTemplate getCurSqlSessionTemplate() {
        return this.sqlSessionTemplate;
    }

    public SqlSessionFactory getCurSqlSessionFactory() {
        return this.sqlSessionFactory;
    }


    private SqlSession getSqlSession(boolean flag) {
        return sqlSessionFactory.openSession(flag);
    }

    private void setAutoCommit(Connection con, boolean autoCommit) {
        try {
            if (con != null) {
                con.setAutoCommit(autoCommit);
            } else {
                sqlSessionFactory.openSession().getConnection().setAutoCommit(autoCommit);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
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
}
