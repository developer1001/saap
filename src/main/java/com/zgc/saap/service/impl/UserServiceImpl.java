package com.zgc.saap.service.impl;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.base.service.impl.BaseServiceImpl;
import com.zgc.saap.dao.UserDao;
import com.zgc.saap.model.User;
import com.zgc.saap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public BaseDao<User> baseDao() {
        return userDao;
    }

    @Override
    public User findById(int id) {
        return super.findById(id);
    }

    @Override
    public int add(User user) {
        return super.add(user);
    }

    @Override
    public int update(User user) {
        return super.update(user);
    }

    @Override
    public int deleteById(int id) {
        return super.deleteById(id);
    }

}
