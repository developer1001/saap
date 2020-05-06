package com.zgc.saap.persistent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zgc.saap.persistent.entity.SysRole;
import com.zgc.saap.persistent.entity.SysUser;

public interface SysUserExtendMapper {
	@Select("select * from sys_user where id = #{userId}")
	SysUser getUserById(Integer userId);
	
	SysUser getUserByPhone(String phone);
	
	@Select("SELECT a.* FROM sys_role a, sys_user_role b WHERE a.role_id = b.roleId AND a.valid = '1' AND b.userId = #{userId}")
	List<SysRole> getRolesByUserId(int userId);
}
