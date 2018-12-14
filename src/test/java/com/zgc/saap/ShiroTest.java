package com.zgc.saap;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import junit.framework.Assert;

public class ShiroTest {

//	@Test
	public void loginLogout() {
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		 //2、得到SecurityManager实例 并绑定给SecurityUtils   
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		try {
			//4、登录，即身份验证
			subject.login(token);
		} catch (Exception e) {
			//5、身份验证失败
			e.printStackTrace();
		}
		 Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
		    //6、退出
		subject.logout();
	}
	
	@Test
	public void testRealm1() {
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
				Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
				 //2、得到SecurityManager实例 并绑定给SecurityUtils   
				SecurityManager securityManager = factory.getInstance();
				SecurityUtils.setSecurityManager(securityManager);
				//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
				Subject subject = SecurityUtils.getSubject();
				UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
				try {
					//4、登录，即身份验证
					subject.login(token);
				} catch (Exception e) {
					//5、身份验证失败
					e.printStackTrace();
				}
				 Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
				    //6、退出
				subject.logout();
	}
}