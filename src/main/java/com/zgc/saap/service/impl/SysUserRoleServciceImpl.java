package com.zgc.saap.service.impl;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.base.service.impl.BaseServiceImpl;
import com.zgc.saap.dao.SysUserDeptDao;
import com.zgc.saap.dao.SysUserRoleDao;
import com.zgc.saap.model.SysUserDept;
import com.zgc.saap.model.SysUserRole;
import com.zgc.saap.service.ISysUserDeptService;
import com.zgc.saap.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: HMSH
 * @description: 用户和角色
 * @author: laoyangtou
 * @create: 2018-07-06 15:53
 **/
@Service
public class SysUserRoleServciceImpl extends BaseServiceImpl<SysUserRole> implements ISysUserRoleService {
    @Autowired
    SysUserRoleDao sysUserRoleDao;
    @Override
    public BaseDao<SysUserRole> baseDao() {
        return sysUserRoleDao;
    }

    @Override
    public List<SysUserRole> getByUserId(int userId) {
        return sysUserRoleDao.getByUserId(userId);
    }
}



