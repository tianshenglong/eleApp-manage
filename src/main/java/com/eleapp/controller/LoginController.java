package com.eleapp.controller;

import com.eleapp.model.Userinfo;
import com.eleapp.service.UserInfoService;
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
            Userinfo userinfo = userInfoService.getUserByUserNameAndPwd(loginName,pwd);
            if (userinfo !=null) {
                request.getSession().setAttribute("userName", loginName);
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
            if (userLoginName.equals("admin")&&userPwd.equals("123456")) {
                return "redirect:/index";
            } else {
                return "login";
            }
        } else {
            return "login";
        }
    }
}
