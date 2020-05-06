package com.zgc.saap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zgc.saap.common.entity.ResResult;
import com.zgc.saap.common.utils.ResResultUtil;

@RestController
public class IndexController{
    @RequestMapping("/index")
    public ResResult<?> index()throws Exception{
    	return ResResultUtil.success();
    }

}
