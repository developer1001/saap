package com.zgc.saap.service.impl;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.base.service.impl.BaseServiceImpl;
import com.zgc.saap.dao.SysRoleDao;
import com.zgc.saap.dao.SysUserDeptDao;
import com.zgc.saap.model.SysRole;
import com.zgc.saap.model.SysUserDept;
import com.zgc.saap.service.ISysRoleService;
import com.zgc.saap.service.ISysUserDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: HMSH
 * @description: 用户和部门
 * @author: laoyangtou
 * @create: 2018-07-06 15:51
 **/
@Service
public class SysUserDeptServiceImpl extends BaseServiceImpl<SysUserDept> implements ISysUserDeptService {
    @Autowired
    SysUserDeptDao sysUserDeptDao;
    @Override
    public BaseDao<SysUserDept> baseDao() {
        return sysUserDeptDao;
    }
}


