package com.zgc.saap.service.impl;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.base.service.impl.BaseServiceImpl;
import com.zgc.saap.dao.LoginDao;
import com.zgc.saap.model.SysUser;
import com.zgc.saap.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends BaseServiceImpl<SysUser> implements ILoginService {

    @Autowired
    LoginDao loginDao;

    /**
     * 登录校验
     * @param loginName
     * @param password
     * @return
     */
    @Override
    public SysUser login(String loginName, String password) {
        return loginDao.login(loginName,password);
    }

    @Override
    public BaseDao<SysUser> baseDao() {
        return null;
    }
}
