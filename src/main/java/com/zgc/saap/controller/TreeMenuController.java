package com.zgc.saap.controller;

import com.alibaba.fastjson.JSONObject;
import com.zgc.saap.model.TreeMenu;
import com.zgc.saap.service.ITreeMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: HMSH
 * @description: 菜单树treeMenu的控制器，
 * @author: laoyangtou
 * @create: 2018-07-20 09:58
 **/
@Controller
@RequestMapping("/treeMenu")
public class TreeMenuController {

    @Autowired
    ITreeMenuService treeMenuService;
    @RequestMapping("addFromJson")
    public void addFromJson(String jsonObj){
        TreeMenu treeMenu =  JSONObject.parseObject(jsonObj,TreeMenu.class);
        System.out.print(treeMenu);
        treeMenuService.add(treeMenu);
    }

}
