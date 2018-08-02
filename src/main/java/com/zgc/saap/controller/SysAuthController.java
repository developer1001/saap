package com.zgc.saap.controller;

import com.zgc.saap.base.controller.BaseController;
import com.zgc.saap.base.model.Json;
import com.zgc.saap.model.SysAuth;
import com.zgc.saap.model.SysUser;
import com.zgc.saap.service.ISysAuthService;
import com.zgc.saap.service.ISysUserService;
import com.zgc.saap.util.EncodeUtil;
import com.zgc.saap.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: HMSH
 * @description: 系统权限(菜单)控制器
 * @author: laoyangtou
 * @create: 2018-07-06 14:39
 **/
@Controller
@RequestMapping("/sysAuth/")
public class SysAuthController extends BaseController {

    @Autowired
    ISysAuthService sysAuthService;

    @RequestMapping("add")
    public void add(SysAuth sysAuth, HttpServletResponse response){
        int flag = sysAuthService.add(sysAuth);
        if (flag == 1){
            writeJson(new Json(true,"菜单添加成功"),response);
        }
        else
            writeJson(new Json(false,"添加菜单失败，请重新添加"),response);
    }

    @RequestMapping("find")
    public void find(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            SysAuth sysAuth = sysAuthService.findById(Integer.parseInt(id));
            Json json = new Json(true,1,sysAuth);
            writeJson(json,response);
        }
        else
            writeJson(new Json(false,"菜单不存在或者菜单ID输入有误"),response);
    }

    @RequestMapping("delete")
    public void delete(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            int a =   sysAuthService.deleteById(Integer.parseInt(id));
            if (a == 1){
                writeJson(new Json(true,a,"id为 "+id+" 的菜单删除成功"),response);
            }
            else if (a == 0){
                writeJson(new Json(false,a,"id为 "+id+" 的菜单不存在，无法删除"),response);
            }
        }
    }

    @RequestMapping("update")
    public void update(SysAuth sysAuth,HttpServletResponse response){
        int a = sysAuthService.update(sysAuth);
        int id = sysAuth.getId().intValue();
        if (a == 1){
            writeJson(new Json(true,"id为 "+id+" 的菜单信息修改成功"),response);
        }
    }

}
