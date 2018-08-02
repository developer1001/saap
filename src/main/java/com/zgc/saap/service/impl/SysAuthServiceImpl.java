package com.zgc.saap.service.impl;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.base.service.impl.BaseServiceImpl;
import com.zgc.saap.dao.SysAuthDao;
import com.zgc.saap.dao.SysUserDao;
import com.zgc.saap.model.SysAuth;
import com.zgc.saap.model.SysUser;
import com.zgc.saap.service.ISysAuthService;
import com.zgc.saap.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: HMSH
 * @description: 系统权限，SysAuth
 * @author: laoyangtou
 * @create: 2018-07-06 14:26
 **/
@Service
public class SysAuthServiceImpl extends BaseServiceImpl<SysAuth> implements ISysAuthService {

    @Autowired
    SysAuthDao sysAuthDao;

    @Override
    public List<SysAuth> getByRoleId(List<Integer> roleIdList) {
        return sysAuthDao.getByRoleId(roleIdList);
    }

    @Override
    public BaseDao<SysAuth> baseDao() {
        return sysAuthDao;

    }
}
