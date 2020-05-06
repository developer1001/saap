package com.zgc.saap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zgc.saap.common.entity.ResResult;
import com.zgc.saap.common.utils.ResResultUtil;

/**
 * 大厅，无需登录
 * @date 2020-04-30 15:10:57
 * @author yang
 */
@RestController
@RequestMapping("/pub/")
public class PubController{
	
    @RequestMapping("needLogin")
    public ResResult<String> needLogin(){
    	return ResResultUtil.error("please login first!");
    }

    @RequestMapping("noPermission")
    public ResResult<String> noPermission(String userName){
    	return ResResultUtil.error("you have no permission for this operation!");
    }

}
