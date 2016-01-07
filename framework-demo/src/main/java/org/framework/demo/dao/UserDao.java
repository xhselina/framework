package org.framework.demo.dao;

import org.framework.dao.BaseDao;
import org.framework.demo.model.User;

import java.io.Serializable;

/**
 *  userdao数据层接口
 * Created by junhuiji on 2016/1/7.
 */
public interface UserDao<User,PK extends Serializable> extends BaseDao{
}
