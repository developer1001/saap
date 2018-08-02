package com.zgc.saap.controller;

import com.zgc.saap.base.controller.BaseController;
import com.zgc.saap.base.model.Json;
import com.zgc.saap.model.SysUser;
import com.zgc.saap.model.User;
import com.zgc.saap.service.IUserService;
import com.zgc.saap.util.EncodeUtil;
import com.zgc.saap.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user/")
public class UserController extends BaseController {
    @Autowired
    IUserService userService;

    @RequestMapping("getUserById")
    public void getUser(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
            User user = userService.findById(Integer.parseInt(id));
            Json json = new Json(true,1,user);
            writeJson(json,response);
        }
        else
            writeJson(new Json(false,"用户不存在或者用户ID输入有误"),response);
    }
    @RequestMapping("deleteUserById")
    public void deleteUserById(String id,HttpServletResponse response){
        if (StringUtil.isValid(id)){
        int a =   userService.deleteById(Integer.parseInt(id));
          Json json = new Json();
          if (a == 1){
              json.setSuccess(true);
              json.setData(a);
              json.setMsg("id为 "+id+" 的用户删除成功");
              writeJson(json,response);
          }
          else if (a == 0){
              json.setSuccess(false);
              json.setData(a);
              json.setMsg("id为 "+id+" 的用户不存在，无法删除");
              writeJson(json,response);
          }
        }
    }

    @RequestMapping("addUser")
    public void addUser(User user,HttpServletResponse response){
        User newUser = user;
        newUser.setPassword(EncodeUtil.toMD5(user.getPassword()));
        int a = userService.add(newUser);
        if (a == 1){
            Json json = new Json();
            json.setSuccess(true);
            json.setTotal(1);
            json.setMsg("添加新用户成功");
            writeJson(json,response);
        }
    }

    @RequestMapping("updateUser")
    public void updateUser(User user,HttpServletResponse response){
        User newUser = user;
        newUser.setPassword(EncodeUtil.toMD5(user.getPassword()));
        int a = userService.update(newUser);
        int userId = user.getId().intValue();
        if (a == 1){
            Json json = new Json();
            json.setSuccess(true);
            json.setMsg("id为"+userId+"的用户信息修改成功");
            writeJson(json,response);
        }
    }

    @RequestMapping("toNewPage")
    public String toNewPage(){
        //加上前缀和后缀，组成新的url地址，页面跳转
        return "test";
    }
}
