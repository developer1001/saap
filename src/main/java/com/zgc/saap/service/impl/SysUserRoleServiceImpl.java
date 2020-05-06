package com.zgc.saap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zgc.saap.persistent.dao.SysUserExtendMapper;
import com.zgc.saap.persistent.entity.SysRole;
import com.zgc.saap.service.SysUserRoleService;
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
	@Autowired
	private SysUserExtendMapper sysUserExtendMapper;
	@Override
	public List<SysRole> getUserRoles(Integer userId) {
		List<SysRole> roles = sysUserExtendMapper.getRolesByUserId(userId);
		return roles;
	}

}
