package com.zgc.saap.service;

import com.zgc.saap.persistent.entity.SysUser;

/**
 * 系统用户
 * @date 2020-04-29 12:27:06
 * @author yang
 */
public interface SysUserService {
	SysUser findByUserName(String userName);
	
	SysUser getUserById(String userId);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	int delById(int id);
}
