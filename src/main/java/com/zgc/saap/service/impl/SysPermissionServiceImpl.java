package com.zgc.saap.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zgc.saap.persistent.dao.SysPermissionMapper;
import com.zgc.saap.persistent.dao.SysRolePermissionMapper;
import com.zgc.saap.persistent.entity.SysPermission;
import com.zgc.saap.persistent.entity.SysPermissionExample;
import com.zgc.saap.persistent.entity.SysRolePermission;
import com.zgc.saap.persistent.entity.SysRolePermissionExample;
import com.zgc.saap.service.SysPermissionService;
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
	@Autowired
	private SysRolePermissionMapper sysRolePermissionMapper;
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	@Override
	public List<SysPermission> getRolePermissions(Set<Integer> roleIds) {
		SysRolePermissionExample example = new SysRolePermissionExample();
		example.createCriteria().andRoleidIn(new ArrayList(roleIds));
		List<SysRolePermission> Rolepermissions= sysRolePermissionMapper.selectByExample(example);
		ArrayList<Integer> permissionIdList = new ArrayList<Integer>();
		for(SysRolePermission rolePermission : Rolepermissions) {
			if(!permissionIdList.contains(rolePermission.getPermissionid())) {
				permissionIdList.add(rolePermission.getPermissionid());
			}
		}
		
		SysPermissionExample example2 = new SysPermissionExample();
		example2.createCriteria().andPermissionIdIn(permissionIdList);
		List<SysPermission> permissionList = sysPermissionMapper.selectByExample(example2);
		return permissionList;
	}

}
