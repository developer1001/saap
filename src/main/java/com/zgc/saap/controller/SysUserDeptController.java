package com.zgc.saap.controller;

import com.zgc.saap.base.controller.BaseController;
import com.zgc.saap.base.model.Json;
import com.zgc.saap.model.SysUser;
import com.zgc.saap.model.SysUserDept;
import com.zgc.saap.service.ISysUserDeptService;
import com.zgc.saap.service.ISysUserService;
import com.zgc.saap.util.EncodeUtil;
import com.zgc.saap.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: HMSH
 * @description: 用户、部门控制器
 * @author: laoyangtou
 * @create: 2018-07-06 14:39
 **/
@Controller
@RequestMapping("/sysUserDept/")
public class SysUserDeptController extends BaseController {

    @Autowired
    ISysUserDeptService sysUserDeptService;

    @RequestMapping("add")
    public void add(SysUserDept sysUserDept, HttpServletResponse response){
        int flag = sysUserDeptService.add(sysUserDept);
        if (flag == 1){
            writeJson(new Json(true,"新用户部门添加成功"),response);
        }
        else
            writeJson(new Json(false,"添加新用户部门失败，请重新添加"),response);
    }

    @RequestMapping("find")
    public void find(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            SysUserDept sysUserDept = sysUserDeptService.findById(Integer.parseInt(id));
            Json json = new Json(true,1,sysUserDept);
            writeJson(json,response);
        }
        else
            writeJson(new Json(false,"用户部门不存在或者用户部门ID输入有误"),response);
    }

    @RequestMapping("delete")
    public void delete(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            int a =   sysUserDeptService.deleteById(Integer.parseInt(id));
            if (a == 1){
                writeJson(new Json(true,a,"id为 "+id+" 的用户部门删除成功"),response);
            }
            else if (a == 0){
                writeJson(new Json(false,a,"id为 "+id+" 的用户部门不存在，无法删除"),response);
            }
        }
    }

    @RequestMapping("update")
    public void update(SysUserDept sysUserDept,HttpServletResponse response){
        int a = sysUserDeptService.update(sysUserDept);
        int id = sysUserDept.getId().intValue();
        if (a == 1){
            writeJson(new Json(true,"id为 "+id+" 的用户部门信息修改成功"),response);
        }
    }

}
