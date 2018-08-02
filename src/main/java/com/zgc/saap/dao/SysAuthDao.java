package com.zgc.saap.dao;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.model.SysAuth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysAuthDao extends BaseDao<SysAuth> {
    List<SysAuth> getByRoleId (@Param("authIdList") List<Integer> roleIdList);
}
