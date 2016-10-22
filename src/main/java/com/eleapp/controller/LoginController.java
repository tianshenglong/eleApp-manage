package com.eleapp.controller;

import com.eleapp.model.UserAccess;
import com.eleapp.model.Userinfo;
import com.eleapp.service.AdminUserService;
import com.eleapp.service.RbacService;
import com.eleapp.service.SysRbacRoleService;
import com.eleapp.service.UserInfoService;
import org.apache.ibatis.binding.MapperMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by 胜龙 on 2016/10/3.
 */
@Controller
public class LoginController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    AdminUserService adminUserService;

    @Autowired
    RbacService rbacService;

    @Autowired
    SysRbacRoleService roleService;
    /*
     * 页面登录
	 */
    @RequestMapping(value = "/ajaxLogin", method = {RequestMethod.POST})
    public String ajaxLogin(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String loginName = request.getParameter("j_username");
        String pwd = request.getParameter("j_password");
        HashMap<String, String> msg = new HashMap<String, String>();
        if (null == loginName || null == pwd || "".equals(loginName) || "".equals(pwd)) {
            msg.put("msg", "用户名密码不能为空，请重新输入");
        } else {

            if (checkLogin(request, response, pwd, loginName)) {
                msg.put("msg", "ok");
                response.sendRedirect("index");
            } else {
                msg.put("msg", "用户名密码不正确，请重新填写");
            }
        }
        model.addAttribute("msg", msg.get("msg"));
        return "login";
    }

    /*
   * 用户登录(记住密码情况下从cookie获取验证)
   */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        // 获取cookie
        String userLoginName = null;
        String userPwd = null;
        if (null != userLoginName && null != userPwd) {
            if (checkLogin(request, response, userPwd, userLoginName)) {
                //response.sendRedirect("index");
                return "redirect:/index";
            } else {
                // response.sendRedirect("logout.action");
                return "login";
            }
        } else {
            return "login";
        }
    }


    private boolean checkLogin(HttpServletRequest request, HttpServletResponse response, String pwd, String loginName) {
        MapperMethod.ParamMap p = new MapperMethod.ParamMap();
        p.put("passWord", pwd);
        p.put("userName", loginName);
        boolean flag = false;
        try {

            Userinfo userinfo = userInfoService.getUserByUserNameAndPwd(loginName, pwd);
            if (null != userinfo) {
                //取得用户角色信息
                Integer userId = userinfo.getAutoID();
                UserAccess userAccess = new UserAccess();
                userAccess.setUserRole(adminUserService.getUserRoleId(userId));
                // 缓存用户信息
                request.getSession().setAttribute("ybsRbacUser", userinfo);
                /************************************  旧权限系统代码 ************************************/
                userAccess.setUserId(userId);//获取用户地区
                userAccess.setUserName(userinfo.getUserName());
                userAccess.setRealName(userinfo.getNickName());
//                getUserArea(request, ybsRbacUser, userAccess);
                request.getSession().setAttribute("userAccess", userAccess);
                userAccess = rbacService.getUserAccess(request);
                request.getSession().setAttribute("userAccess", userAccess);
                /************************************  旧权限系统代码 ************************************/
                /************************************  新权限系统代码 ************************************/
                userAccess.setSysRbacDataAccess(roleService.selectDataAccessByUserId(userId));
                //获得省市县属性放进userAccess
                //rbacService.getUserArea(userAccess);
                /************************************  新权限系统代码 ************************************/
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
