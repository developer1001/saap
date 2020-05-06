package com.zgc.saap.service;

import java.util.List;

import com.zgc.saap.persistent.entity.SysRole;

public interface SysUserRoleService {
	/**
	 * 获得用户的所有角色
	 * @param userId
	 * @return
	 */
	List<SysRole> getUserRoles(Integer userId);
}
