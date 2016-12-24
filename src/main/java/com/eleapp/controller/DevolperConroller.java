package com.eleapp.controller;

import com.eleapp.model.Appinfo;
import com.eleapp.model.EleCompany;
import com.eleapp.service.AppInfoService;
import com.eleapp.service.CompanyService;
import com.eleapp.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Random;

/**
 * Created by 胜龙 on 2016/11/7.
 */
@RequestMapping("/devolper")
@Controller
public class DevolperConroller {

    @Autowired
    CompanyService companyService;

    @Autowired
    AppInfoService appInfoService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public String toIndex(Model model){
        return "devolper/index";
    }

    @RequestMapping("join")
    public String join(){
        return "devolper/company-add";
    }

    @RequestMapping("joinUp")
    public String joinUp(Model model,EleCompany eleCompany){
        companyService.insertSelective(eleCompany);
        model.addAttribute("compId",eleCompany.getId());
        return "devolper/app-add";
    }
    @RequestMapping("addApp")
    public String addApp(Model model,Appinfo appinfo,MultipartFile bigImg,MultipartFile smallImg,HttpServletRequest request){
        appInfoService.insertSelective(appinfo,bigImg,smallImg,request);
        model.addAttribute("AppKey", appinfo.getAppKey());
        model.addAttribute("Secret", (int)((Math.random()*9+1)*100000));
        return "devolper/success";
    }
}
