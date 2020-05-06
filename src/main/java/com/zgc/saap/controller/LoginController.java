package com.zgc.saap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zgc.saap.common.entity.ResResult;
import com.zgc.saap.common.utils.ResResultUtil;
import com.zgc.saap.persistent.entity.SysUser;
import com.zgc.saap.service.LoginService;

@RestController
@RequestMapping("/")
public class LoginController{
	@Autowired
	private LoginService loginService;
	
    @PostMapping("/login")
    public ResResult<Object> login(SysUser user)throws Exception{
    	Object login = loginService.login(user);
    	return ResResultUtil.success(login);
    }

    @GetMapping("/logout")
    public ResResult<Object> logout(){
    	Object logout = loginService.logout();
		return ResResultUtil.success(logout);
    }
}
