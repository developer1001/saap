package com.zgc.saap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zgc.saap.persistent.dao.SysUserExtendMapper;
import com.zgc.saap.persistent.dao.SysUserMapper;
import com.zgc.saap.persistent.entity.SysUser;
import com.zgc.saap.persistent.entity.SysUserExample;
import com.zgc.saap.service.SysUserService;
@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserExtendMapper sysUserExtendMapper;
	@Override
	public SysUser findByUserName(String userName) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUserNameEqualTo(userName);
		List<SysUser> users = sysUserMapper.selectByExample(example);
		if(users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
	
	@Override
	public SysUser getUserById(String userId) {
		return sysUserExtendMapper.getUserByPhone(userId);
	}

	@Override
	public int delById(int id) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andIdEqualTo(id);
		int deleteByExample = sysUserMapper.deleteByExample(example);
		return deleteByExample;
	}

}
