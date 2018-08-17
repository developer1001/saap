package com.zgc.saap.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;
/**
 * 
 *description: 
 *Author:yp
 *2018年8月17日 下午4:39:30
 */
public class MyRealm1 implements Realm {

	@Override
	public String getName() {
		return "myrealm1";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		//仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken; 
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//用户名
		String username = (String) token.getPrincipal();
		//密码
		String password = new String((char[])token.getCredentials());
		if(! "zhang".equals(username))
			//用户名错误
			throw new UnknownAccountException();
		if(!"123".equals(password))
			//密码错误
			throw new IncorrectCredentialsException();
		 //如果身份认证验证成功，返回一个AuthenticationInfo实现；
		return new SimpleAuthenticationInfo(username,password,getName());
	}

}
