package com.zgc.saap.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.zgc.saap.persistent.entity.SysUser;
import com.zgc.saap.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public Object login(SysUser user) {
		Map<String, Object> map = new HashMap<>();
		if (user == null) {
			throw new RuntimeException("登录用户名或密码不可为空");
		}
		String userName = user.getUserName();
		String password = user.getPassword();
		if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
			throw new RuntimeException("登录用户名或密码不可为空");
		}
		// 获取Subject实例对象，用户实例
		Subject subject = SecurityUtils.getSubject();
		// 将用户名和密码封装到UsernamePasswordToken
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			map.put("login", false);
			return map;
		}
		map.put("login", true);
		return map;
	}

	@Override
	public Object logout() {
		Map<String, Object> map = new HashMap<>();
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("logout", true);
		return map;
	}

}
