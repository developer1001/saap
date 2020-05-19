package com.zgc.saap.config.shiro;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.zgc.saap.common.constant.Constant;
import com.zgc.saap.persistent.dao.SysPermissionMapper;
import com.zgc.saap.persistent.entity.SysPermission;
import com.zgc.saap.persistent.entity.SysPermissionExample;

import lombok.Data;

/**
 * 
 * @date 2020-04-29 10:45:26
 * @author yang
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class ShiroConfig {
	private String host;
	private int port;
	private String password;
	private int timeout;

	@Autowired
	private SysPermissionMapper sysPermissionMapper;

	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/login", "anon");
		// filterChainDefinitionMap.put("/fonts/**", "anon");
		filterChainDefinitionMap.put("/**/*.png", "anon");
		filterChainDefinitionMap.put("/**/*.jpg", "anon");
		filterChainDefinitionMap.put("/**/*.gif", "anon");
		filterChainDefinitionMap.put("/**/*.ico", "anon");
		filterChainDefinitionMap.put("/**/*.js", "anon");
		filterChainDefinitionMap.put("/**/*.css", "anon");
		filterChainDefinitionMap.put("/**/*.html", "anon");
		filterChainDefinitionMap.put("/**/*.eot", "anon");
		filterChainDefinitionMap.put("/**/*.svg", "anon");
		filterChainDefinitionMap.put("/**/*.ttf", "anon");
		filterChainDefinitionMap.put("/**/*.woff", "anon");
		filterChainDefinitionMap.put("/**/*.woff2", "anon");
		// //管理员角色才可以访问
		// filterChainDefinitionMap.put("/sysUser/del", "roles[superadmin]");
//		 filterChainDefinitionMap.put("/sysUser/del", "perms[user:del]");
		SysPermissionExample example = new SysPermissionExample();
		example.createCriteria().andAvailableEqualTo(Constant.VALID_TRUE);
		List<SysPermission> permissions = sysPermissionMapper.selectByExample(example);
		for (SysPermission perm : permissions) {
			filterChainDefinitionMap.put(perm.getUrl(), "perms[" + perm.getPermission() + "]");
		}
		// 需要登录的接口:如果访问某个接口,需要登录却没有登录,则调用此接口
		shiroFilterFactoryBean.setLoginUrl("/pub/needLogin");
		// 登录成功,但是没有权限,未授权就会调用这个接口
		shiroFilterFactoryBean.setUnauthorizedUrl("/pub/noPermission");
		// 登录成功 跳转url
		// shiroFilterFactoryBean.setSuccessUrl("/index");
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");
		hashedCredentialsMatcher.setHashIterations(2);
		return hashedCredentialsMatcher;
	}

	@Bean
	public MyShiroRealm myShiroRealm() {
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}

	@Bean
	public RedisSessionDAO redisSessionDAO() {
		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
		redisSessionDAO.setRedisManager(redisManager());
		redisSessionDAO.setSessionIdGenerator(sessionIdGenerator());
		redisSessionDAO.setExpire(3 * 3600);
		return redisSessionDAO;
	}

	@Bean
	public RedisManager redisManager() {
		RedisManager redisManager = new RedisManager();
		// ip和端口合并在一起（此版本的shiro-redis 插件将host和port合在了一起）
		redisManager.setHost(host + ":" + port);
		redisManager.setTimeout(timeout);
		redisManager.setPassword(password);
		return redisManager;
	}

	@Bean
	public RedisCacheManager cacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager();
		redisCacheManager.setRedisManager(redisManager());
		// 必须要设置主键名称，shiro-redis 插件用过这个缓存用户信息
		redisCacheManager.setPrincipalIdFieldName("userId");
		return redisCacheManager;
	}

	@Bean
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setSessionIdCookie(cookie());
		// ms单位
		sessionManager.setGlobalSessionTimeout(2 * 3600 * 1000);
		sessionManager.setSessionDAO(redisSessionDAO());
		return sessionManager;
	}

	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		securityManager.setSessionManager(sessionManager());
		return securityManager;
	}

	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
		return authorizationAttributeSourceAdvisor;
	}

	@Bean("lifecycleBeanPostProcessor")
	public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public SimpleCookie cookie() {
		SimpleCookie cookie = new SimpleCookie("SHARE_JSESSIONID");
		cookie.setHttpOnly(true);
		// h * s
		cookie.setMaxAge(24 * 3600);
		// path为 / 用于多个系统共享 JSESSIONID
		cookie.setPath("/");
		return cookie;
	}

	@Bean
	public JavaUuidSessionIdGenerator sessionIdGenerator() {
		return new JavaUuidSessionIdGenerator();
	}
}