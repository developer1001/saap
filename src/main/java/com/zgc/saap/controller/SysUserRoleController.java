package com.zgc.saap.controller;

import com.zgc.saap.base.controller.BaseController;
import com.zgc.saap.base.model.Json;
import com.zgc.saap.model.SysUser;
import com.zgc.saap.model.SysUserRole;
import com.zgc.saap.service.ISysUserRoleService;
import com.zgc.saap.service.ISysUserService;
import com.zgc.saap.util.EncodeUtil;
import com.zgc.saap.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: HMSH
 * @description: 用户角色控制器
 * @author: laoyangtou
 * @create: 2018-07-06 14:39
 **/
@Controller
@RequestMapping("/sysUserRole/")
public class SysUserRoleController extends BaseController {

    @Autowired
    ISysUserRoleService sysUserRoleService;

    @RequestMapping("add")
    public void add(SysUserRole sysUserRole, HttpServletResponse response){
        int flag = sysUserRoleService.add(sysUserRole);
        if (flag == 1){
            writeJson(new Json(true,"新用户角色添加成功"),response);
        }
        else
            writeJson(new Json(false,"添加新用户角色失败，请重新添加"),response);
    }

    @RequestMapping("find")
    public void find(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            SysUserRole sysUserRole = sysUserRoleService.findById(Integer.parseInt(id));
            Json json = new Json(true,1,sysUserRole);
            writeJson(json,response);
        }
        else
            writeJson(new Json(false,"用户角色不存在或者用户角色ID输入有误"),response);
    }

    @RequestMapping("delete")
    public void delete(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            int a =   sysUserRoleService.deleteById(Integer.parseInt(id));
            if (a == 1){
                writeJson(new Json(true,a,"id为 "+id+" 的用户角色删除成功"),response);
            }
            else if (a == 0){
                writeJson(new Json(false,a,"id为 "+id+" 的用户角色不存在，无法删除"),response);
            }
        }
    }

    @RequestMapping("updateUser")
    public void updateUser(SysUserRole sysUserRole,HttpServletResponse response){
        int a = sysUserRoleService.update(sysUserRole);
        int userId = sysUserRole.getId().intValue();
        if (a == 1){
            writeJson(new Json(true,"id为 "+userId+" 的用户角色信息修改成功"),response);
        }
    }

}
