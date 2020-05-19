package com.zgc.saap.config.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.zgc.saap.persistent.entity.SysPermission;
import com.zgc.saap.persistent.entity.SysRole;
import com.zgc.saap.persistent.entity.SysUser;
import com.zgc.saap.service.SysPermissionService;
import com.zgc.saap.service.SysUserRoleService;
import com.zgc.saap.service.SysUserService;

/**
 * 自定义 shiroRealm, 重写认证、授权
 * @date 2020-04-29 11:19:15
 * @author yang
 */
public class MyShiroRealm extends AuthorizingRealm {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysPermissionService sysRolePermissionService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //如果身份认证的时候没有传入User对象，这里只能取到userName
        //也就是SimpleAuthenticationInfo构造的时候第一个参数传递需要User对象
        SysUser user = (SysUser) principals.getPrimaryPrincipal();
        Integer userId = user.getId();
        // 查询用户角色，一个用户可能有多个角色
        List<SysRole> rolesList = sysUserRoleService.getUserRoles(userId);
        if(rolesList == null || rolesList.size() == 0) {
        	throw new ShiroException("用户未分配角色！");
        }
        Set<Integer> roleIds = new HashSet<>();
        for(SysRole role : rolesList) {
        	authorizationInfo.addRole(role.getRoleName());
        	roleIds.add(role.getRoleId());
        }
        // 根据角色查询权限
        List<SysPermission> permissions = sysRolePermissionService.getRolePermissions(roleIds);
        for (SysPermission p : permissions) {
            authorizationInfo.addStringPermission(p.getPermission());
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        String userName = (String) token.getPrincipal();
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser user = sysUserService.findByUserName(userName);
        if (Objects.isNull(user)) {
            throw new UnknownAccountException("用户不存在");
        }
        if(user.getActive() == 0) {
        	throw new LockedAccountException("账户已冻结");
        }
//        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
        return new SimpleAuthenticationInfo(
                // 这里传入的是user对象，比对的是用户名，直接传入用户名也没错，但是在授权部分就需要自己重新从数据库里取权限
                user,
                // 密码
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName()
        );
    }

}
