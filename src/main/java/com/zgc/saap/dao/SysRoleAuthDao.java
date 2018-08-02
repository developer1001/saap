package com.zgc.saap.dao;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.model.SysRoleAuth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleAuthDao extends BaseDao<SysRoleAuth> {

    public List<SysRoleAuth> getByRoleId(@Param("roleIdList") List<Integer> roleIdList);
}
