package com.zgc.saap.service;

import com.zgc.saap.persistent.entity.SysUser;

public interface LoginService {
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	Object login(SysUser user);
	/**
	 * 登出
	 * @return
	 */
	Object logout();
}
