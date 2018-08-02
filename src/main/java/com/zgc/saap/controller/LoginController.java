package com.zgc.saap.controller;

import com.zgc.saap.base.controller.BaseController;
import com.zgc.saap.base.model.Json;
import com.zgc.saap.model.*;
import com.zgc.saap.service.*;
import com.zgc.saap.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.*;

@Controller
@RequestMapping("/")
public class LoginController extends BaseController {

    @Autowired
    ILoginService loginService;
    @Autowired
    ISysUserRoleService sysUserRoleService;
    @Autowired
    ISysRoleAuthService sysRoleAuthService;
    @Autowired
    ISysAuthService sysAuthService;
    @Autowired
    ITreeMenuService treeMenuService;

    private static final int cookieMaxAge = 3*24*60*60;// 1*24*60*60
    @RequestMapping("login")
    public void login(String loginName, String password, HttpServletResponse response)throws Exception{
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("main");
        String encodePwd = EncodeUtil.toMD5(password.trim());
        SysUser sysUser = loginService.login(loginName.trim(),encodePwd);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (sysUser != null && sysUser.getIsActive() == 1){
            HttpSession session = request.getSession();
            if (session.getAttribute("loginUser") != null)
                session.removeAttribute("loginUser");
            session.setAttribute("loginUser",sysUser);
//            List<SysAuth> sysAuths = getUserAuth(sysUser.getId());
            Json json = new Json(true,sysUser);
            //加入cookie,记住用户名和密码,但是没有做密码的安全性处理，十分不推荐这样做，你需要处理这个过程
                //创建Cookie
                Cookie nameCookie=new Cookie("loginName",URLEncoder.encode(sysUser.getLoginName(),"utf-8"));
                Cookie pswCookie=new Cookie("password",password);
                //设置Cookie的父路径
                nameCookie.setPath(request.getContextPath()+"/");
                pswCookie.setPath(request.getContextPath()+"/");
                //获取是否保存Cookie
                String rememberMe=request.getParameter("remember");
                if(rememberMe.equals("no")){//不保存Cookie
                    nameCookie.setMaxAge(0);
                    pswCookie.setMaxAge(0);
                }else{//保存Cookie的时间长度，单位为秒
                    nameCookie.setMaxAge(cookieMaxAge);
                    pswCookie.setMaxAge(cookieMaxAge);
                }
                //加入Cookie到响应头
                response.addCookie(nameCookie);
                response.addCookie(pswCookie);
            writeJson(json,response);
//            modelAndView.addObject("loginUser",sysUser);
//            return modelAndView;
        }
        else{
            Json json = new Json(false,"用户信息错误，请重试");
            writeJson(json,response);
        }
    }

    /**
     * 根据用户ID获取对应的菜单权限
     *1）：根据userId获得对应的一个或多个角色的 roleId;
     *2）：根据roleId获取对应的权限authId；这个过程要去重复的anthId。
     *3）：根据authId获取对应的多个权限菜单对象，即SysAuth
     */
    @RequestMapping("getAuth")
    public void getUserAuth(HttpServletResponse response){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        int userid = ((SysUser)session.getAttribute("loginUser")).getId();
        //根据用户查多个角色
        List<SysUserRole> list  = sysUserRoleService.getByUserId(userid);
        List<Integer> roleIdList = new ArrayList<>();
        for (SysUserRole item:list){
            roleIdList.add(item.getRoleId());
        }
        //根据多个角色查询权限id的集合,权限ID有重复，要去重
        List<SysRoleAuth> roleAuthList = sysRoleAuthService.getByRoleId(roleIdList);
        Set<Integer> authIdList = new HashSet<>();
        for (SysRoleAuth item:roleAuthList){
            authIdList.add(item.getAuthId());
        }

        //根据authId集合查询所有的权限项
        List<SysAuth> sysAuths = sysAuthService.getByRoleId(new ArrayList<Integer>(authIdList));
        writeJson(new Json(true,sysAuths.size(),sysAuths),response);
    }

    /**
     * 获得菜单树，菜单树是前端自动处理的，后端并没有进行树节点的处理。此菜单树为测试所用，不推荐直接应用
     */
    @RequestMapping("getTreeMenu")
    public void getTreeMenu(HttpServletResponse response){
        List<TreeMenu> treeMenus = treeMenuService.findAllObj();
        writeJson(new Json(true,treeMenus),response);
    }

    @RequestMapping("index")
    public String loginIndex(HttpServletResponse response)throws Exception{
        return "main";
    }

    @RequestMapping("logout/logout")
    public String logout(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") != null){
            session.removeAttribute("loginUser");
            session.invalidate();
        }
        return "login";
    }
}
