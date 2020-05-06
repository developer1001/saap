package com.zgc.saap.service;

import java.util.List;
import java.util.Set;

import com.zgc.saap.persistent.entity.SysPermission;

/**
 * 角色权限
 * @date 2020-04-29 14:05:05
 * @author yangO
 */
public interface SysPermissionService {
	/**
	 * 获得这些角色所拥有的所有权限
	 * @param roleIdList
	 * @return
	 */
	List<SysPermission> getRolePermissions(Set<Integer> roleIds);
}
