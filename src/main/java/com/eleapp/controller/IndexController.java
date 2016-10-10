package com.eleapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 胜龙 on 2016/10/3.
 */
@Controller
@RequestMapping
public class IndexController {

    /***
     * 启动后跳转登陆页
     * @return
     */
    @RequestMapping("/")
    public String toLogin() {
        return "redirect:/login";
    }

    /**
     * 登陆后跳转到首页
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/index")
    public String toIndex(Model model,HttpServletRequest request) {
        return "index";
    }
}
