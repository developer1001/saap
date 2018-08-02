package com.zgc.saap.service.impl;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.base.service.impl.BaseServiceImpl;
import com.zgc.saap.dao.SysDeptDao;
import com.zgc.saap.dao.SysRoleAuthDao;
import com.zgc.saap.model.SysDept;
import com.zgc.saap.model.SysRoleAuth;
import com.zgc.saap.service.ISysDeptService;
import com.zgc.saap.service.ISysRoleAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: HMSH
 * @description: 角色与菜单
 * @author: laoyangtou
 * @create: 2018-07-06 15:47
 **/
@Service
public class SysRoleAuthServiceImpl extends BaseServiceImpl<SysRoleAuth> implements ISysRoleAuthService {
    @Autowired
    SysRoleAuthDao sysRoleAuthDao;

    @Override
    public List<SysRoleAuth> getByRoleId(List<Integer> roleIdList) {
        return sysRoleAuthDao.getByRoleId(roleIdList);
    }
    @Override
    public BaseDao<SysRoleAuth> baseDao() {
        return sysRoleAuthDao;
    }
}
