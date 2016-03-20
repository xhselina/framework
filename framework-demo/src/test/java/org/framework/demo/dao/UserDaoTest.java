package org.framework.demo.dao;

import org.framework.demo.dao.UserDao;
import org.framework.demo.dao.impl.UserDaoImpl;
import org.framework.demo.model.User;
import org.framework.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by JeffreyJi on 2016/3/20.${Time}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/appliccation*.xml"})
public class UserDaoTest extends AbstractJUnit4SpringContextTests{

//    @Resource
//   private UserDao userDao;
//
//    @Test
//    public void saveTest(){
//        User user = new User();
//        user.setName("hello，junit 测试");
//        userDao.insert(user);
//    }
}
