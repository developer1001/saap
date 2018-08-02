package com.zgc.saap.dao;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserRoleDao extends BaseDao<SysUserRole> {
    List<SysUserRole> getByUserId(@Param("userId") int userId);
}
