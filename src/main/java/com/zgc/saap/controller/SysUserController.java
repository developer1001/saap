package com.zgc.saap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zgc.saap.common.entity.ResResult;
import com.zgc.saap.common.utils.ResResultUtil;
import com.zgc.saap.persistent.entity.SysUser;
import com.zgc.saap.service.SysUserService;

/**
 * 系统用户
 * @date 2020-04-30 15:10:43
 * @author yang
 */
@RestController
@RequestMapping("/sysUser/")
public class SysUserController{
	@Autowired
	private SysUserService sysUserService;
    @RequestMapping("add")
    public void addSysUser(){
    }

    @RequestMapping("findByName")
    public Object findSysUser(String userName){
    	SysUser user = sysUserService.findByUserName(userName);
		return user;
    }
    
    @PostMapping("del")
    public ResResult<String> deleteUserById(int id){
    	int delById = sysUserService.delById(id);
		return ResResultUtil.success("删除用户数：" + delById);
    }

    @RequestMapping("updateUser")
    public void updateUser(){
    }

}
