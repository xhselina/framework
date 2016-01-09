package org.framework.demo.service.impl;

import org.framework.demo.model.User;
import org.framework.demo.service.UserService;
import org.framework.service.impl.MyBatisBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by junhuiji on 2016/1/7.
 */
@Service
public class UserServiceImpl extends MyBatisBaseServiceImpl<User,Long> implements UserService {
}
