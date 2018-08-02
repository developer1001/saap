package com.zgc.saap.controller;

import com.zgc.saap.base.controller.BaseController;
import com.zgc.saap.base.model.Json;
import com.zgc.saap.model.SysRoleAuth;
import com.zgc.saap.model.SysUser;
import com.zgc.saap.service.ISysRoleAuthService;
import com.zgc.saap.service.ISysUserService;
import com.zgc.saap.util.EncodeUtil;
import com.zgc.saap.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: HMSH
 * @description: 角色、权限控制器
 * @author: laoyangtou
 * @create: 2018-07-06 14:39
 **/
@Controller
@RequestMapping("/sysRoleAuth/")
public class SysRoleAuthController extends BaseController {

    @Autowired
    ISysRoleAuthService sysRoleAuthService;

    @RequestMapping("add")
    public void add(SysRoleAuth sysRoleAuth, HttpServletResponse response){
        int flag = sysRoleAuthService.add(sysRoleAuth);
        if (flag == 1){
            writeJson(new Json(true,"新角色权限添加成功"),response);
        }
        else
            writeJson(new Json(false,"添加新角色权限失败，请重新添加"),response);
    }

    @RequestMapping("find")
    public void find(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            SysRoleAuth sysRoleAuth = sysRoleAuthService.findById(Integer.parseInt(id));
            Json json = new Json(true,1,sysRoleAuth);
            writeJson(json,response);
        }
        else
            writeJson(new Json(false,"角色权限不存在或者用户ID输入有误"),response);
    }

    @RequestMapping("delete")
    public void delete(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            int a =   sysRoleAuthService.deleteById(Integer.parseInt(id));
            if (a == 1){
                writeJson(new Json(true,a,"id为 "+id+" 的角色权限删除成功"),response);
            }
            else if (a == 0){
                writeJson(new Json(false,a,"id为 "+id+" 的角色权限不存在，无法删除"),response);
            }
        }
    }

    @RequestMapping("update")
    public void update(SysRoleAuth sysRoleAuth,HttpServletResponse response){
        int a = sysRoleAuthService.update(sysRoleAuth);
        int id = sysRoleAuth.getId().intValue();
        if (a == 1){
            writeJson(new Json(true,"id为 "+id+" 的角色权限信息修改成功"),response);
        }
    }

}
