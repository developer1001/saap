package com.zgc.saap.controller;

import com.zgc.saap.base.controller.BaseController;
import com.zgc.saap.base.model.Json;
import com.zgc.saap.model.SysUser;
import com.zgc.saap.service.ISysUserService;
import com.zgc.saap.util.EncodeUtil;
import com.zgc.saap.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: HMSH
 * @description: 系统用户控制器
 * @author: laoyangtou
 * @create: 2018-07-06 14:39
 **/
@Controller
@RequestMapping("/sysUser/")
public class SysUserController extends BaseController {

    @Autowired
    ISysUserService sysUserService;

    @RequestMapping("add")
    public void addSysUser(SysUser sysUser,HttpServletResponse response){
        SysUser user = sysUser;
        user.setPassword(EncodeUtil.toMD5(sysUser.getPassword()));
        int flag = sysUserService.add(user);
        if (flag == 1){
            writeJson(new Json(true,"新用户添加成功"),response);
        }
        else
            writeJson(new Json(false,"添加新用户失败，请重新添加"),response);
    }

    @RequestMapping("find")
    public void findSysUser(String userId,HttpServletResponse response){
        if (StringUtil.isValid(userId)){
            SysUser user = sysUserService.findById(Integer.parseInt(userId));
            Json json = new Json(true,1,user);
            writeJson(json,response);
        }
        else
            writeJson(new Json(false,"用户不存在或者用户ID输入有误"),response);
    }

    @RequestMapping("delete")
    public void deleteUserById(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            int a =   sysUserService.deleteById(Integer.parseInt(id));
            if (a == 1){
                writeJson(new Json(true,a,"id为 "+id+" 的用户删除成功"),response);
            }
            else if (a == 0){
                writeJson(new Json(false,a,"id为 "+id+" 的用户不存在，无法删除"),response);
            }
        }
    }

    @RequestMapping("updateUser")
    public void updateUser(SysUser user,HttpServletResponse response){
        SysUser newUser = user;
        newUser.setPassword(EncodeUtil.toMD5(user.getPassword()));
        int a = sysUserService.update(newUser);
        int userId = user.getId().intValue();
        if (a == 1){
            writeJson(new Json(true,"id为 "+userId+" 的用户信息修改成功"),response);
        }
    }

}
