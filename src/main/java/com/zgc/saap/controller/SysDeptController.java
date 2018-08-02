package com.zgc.saap.controller;

import com.zgc.saap.base.controller.BaseController;
import com.zgc.saap.base.model.Json;
import com.zgc.saap.model.SysDept;
import com.zgc.saap.model.SysUser;
import com.zgc.saap.service.ISysDeptService;
import com.zgc.saap.service.ISysUserService;
import com.zgc.saap.util.EncodeUtil;
import com.zgc.saap.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: HMSH
 * @description: 系统用户部门控制器
 * @author: laoyangtou
 * @create: 2018-07-06 14:39
 **/
@Controller
@RequestMapping("/sysDept/")
public class SysDeptController extends BaseController {

    @Autowired
    ISysDeptService sysDeptService;

    @RequestMapping("add")
    public void add(SysDept sysDept, HttpServletResponse response){
        int flag = sysDeptService.add(sysDept);
        if (flag == 1){
            writeJson(new Json(true,"新部门添加成功"),response);
        }
        else
            writeJson(new Json(false,"添加新部门失败，请重新添加"),response);
    }

    @RequestMapping("find")
    public void find(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            SysDept sysDept = sysDeptService.findById(Integer.parseInt(id));
            Json json = new Json(true,1,sysDept);
            writeJson(json,response);
        }
        else
            writeJson(new Json(false,"部门不存在或者部门ID输入有误"),response);
    }

    @RequestMapping("delete")
    public void delete(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            int a =   sysDeptService.deleteById(Integer.parseInt(id));
            if (a == 1){
                writeJson(new Json(true,a,"id为 "+id+" 的部门删除成功"),response);
            }
            else if (a == 0){
                writeJson(new Json(false,a,"id为 "+id+" 的部门不存在，无法删除"),response);
            }
        }
    }

    @RequestMapping("update")
    public void update(SysDept sysDept,HttpServletResponse response){
        int a = sysDeptService.update(sysDept);
        int id = sysDept.getId().intValue();
        if (a == 1){
            writeJson(new Json(true,"id为 "+id+" 的部门信息修改成功"),response);
        }
    }

}
