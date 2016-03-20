package org.framework.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * MyBatis DAO通用操作类
 * @author admin
 * @param <T>
 * @param <PK>
 * @Date 2007-07-02
 */
public interface MyBatisBaseDao<T,PK extends Serializable> extends BaseDao<T,PK>{
	/**
	 * 取得当前SqlManClient
	* @Title: getCurSqlSessionTemplate
	* @Description: TODO描述
	* @param @return    设定文件
	* @return SqlSessionTemplate    返回类型
	* @throws
	 */
	public SqlSessionTemplate getCurSqlSessionTemplate();
	
	public SqlSessionFactory getCurSqlSessionFactory();
	
}

