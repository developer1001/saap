package com.zgc.saap.service.impl;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.base.service.impl.BaseServiceImpl;
import com.zgc.saap.dao.SysUserDao;
import com.zgc.saap.model.SysUser;
import com.zgc.saap.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: HMSH
 * @description: 系统用户，SysUser
 * @author: laoyangtou
 * @create: 2018-07-06 14:26
 **/
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements ISysUserService {

    @Autowired
    SysUserDao sysUserDao;
    @Override
    public BaseDao<SysUser> baseDao() {
        return sysUserDao;
    }

}
