package org.framework.demo.service.impl;

import org.framework.demo.service.UserService;
import org.framework.service.impl.org.framework.services.MyBatisBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by junhuiji on 2016/1/7.
 */
@Service
public class UserServiceImpl<User,pk extends Serializable> extends MyBatisBaseServiceImpl implements UserService {
}
