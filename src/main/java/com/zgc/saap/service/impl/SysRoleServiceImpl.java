package com.zgc.saap.service.impl;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.base.service.impl.BaseServiceImpl;
import com.zgc.saap.dao.SysRoleDao;
import com.zgc.saap.model.SysRole;
import com.zgc.saap.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: HMSH
 * @description: 系统角色
 * @author: laoyangtou
 * @create: 2018-07-06 15:49
 **/
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements ISysRoleService {
    @Autowired
    SysRoleDao sysRoleDao;
    @Override
    public BaseDao<SysRole> baseDao() {
        return sysRoleDao;
    }
}

