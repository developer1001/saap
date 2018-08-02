package com.zgc.saap.controller;

import com.zgc.saap.base.controller.BaseController;
import com.zgc.saap.base.model.Json;
import com.zgc.saap.model.SysRole;
import com.zgc.saap.model.SysUser;
import com.zgc.saap.service.ISysRoleService;
import com.zgc.saap.service.ISysUserService;
import com.zgc.saap.util.EncodeUtil;
import com.zgc.saap.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: HMSH
 * @description: 系统角色控制器
 * @author: laoyangtou
 * @create: 2018-07-06 14:39
 **/
@Controller
@RequestMapping("/sysRole/")
public class SysRoleController extends BaseController {

    @Autowired
    ISysRoleService sysRoleService;

    @RequestMapping("add")
    public void add(SysRole sysRole, HttpServletResponse response){
        int flag = sysRoleService.add(sysRole);
        if (flag == 1){
            writeJson(new Json(true,"新角色添加成功"),response);
        }
        else
            writeJson(new Json(false,"添加新角色失败，请重新添加"),response);
    }

    @RequestMapping("find")
    public void find(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            SysRole sysRole = sysRoleService.findById(Integer.parseInt(id));
            Json json = new Json(true,1,sysRole);
            writeJson(json,response);
        }
        else
            writeJson(new Json(false,"角色不存在或者角色ID输入有误"),response);
    }

    @RequestMapping("delete")
    public void delete(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            int a =   sysRoleService.deleteById(Integer.parseInt(id));
            if (a == 1){
                writeJson(new Json(true,a,"id为 "+id+" 的角色删除成功"),response);
            }
            else if (a == 0){
                writeJson(new Json(false,a,"id为 "+id+" 的角色不存在，无法删除"),response);
            }
        }
    }

    @RequestMapping("update")
    public void update(SysRole sysRole,HttpServletResponse response){
        int a = sysRoleService.update(sysRole);
        int id = sysRole.getId().intValue();
        if (a == 1){
            writeJson(new Json(true,"id为 "+id+" 的用户信息修改成功"),response);
        }
    }

}
