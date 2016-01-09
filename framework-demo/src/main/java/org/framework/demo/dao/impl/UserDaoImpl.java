package org.framework.demo.dao.impl;

import org.framework.dao.BaseDao;
import org.framework.dao.impl.MyBatisBaseDaoImpl;
import org.framework.demo.dao.UserDao;
import org.framework.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by junhuiji on 2016/1/7.
 */
@Repository
public class UserDaoImpl extends MyBatisBaseDaoImpl<User,Long> implements UserDao {
}
