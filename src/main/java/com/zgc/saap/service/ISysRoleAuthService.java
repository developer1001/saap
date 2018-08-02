package com.zgc.saap.service;

import com.zgc.saap.base.service.BaseService;
import com.zgc.saap.model.SysAuth;
import com.zgc.saap.model.SysRoleAuth;

import java.util.List;

public interface ISysRoleAuthService extends BaseService<SysRoleAuth> {
    /**
     * 根据roleId获得对应的权限菜单ID
     * @param roleIdList
     * @return
     */
    List<SysRoleAuth> getByRoleId(List<Integer> roleIdList);
}
