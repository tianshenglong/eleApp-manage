package com.eleapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eleapp.model.Userinfo;
import com.eleapp.service.UserInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/10/4.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserInfoService userInfoService;

    /**
     * 跳转到用户列表页
     * @param model
     * @return
     */
    @RequestMapping("toUserList")
    public String toUserList(Model model){
        return "user/user-list";
    }

    /**
     * 获取列表页数据，分页使用pagehelper，不需手动处理分页
     * @param model
     * @param start
     * @param length
     * @param draw
     * @param param  页面所有请求参数
     * @return
     */
    @RequestMapping("getUserList")
    @ResponseBody
    public JSONObject getUserList(Model model,String start, String length, String draw,@RequestParam Map param){

        JSONArray ja = new JSONArray();
        JSONObject reObj = new JSONObject(true);

        int page;
        int row = Integer.valueOf(length);
        if (!Strings.isNullOrEmpty(start) && !Strings.isNullOrEmpty(length)) {
            page = Integer.valueOf(start) / Integer.valueOf(length) + 1;
        } else {
            page = 1;
            row = 10;
        }
        try{

            PageHelper.startPage(page, row); //该语句下面第一个查询方法为需要分页的方法
            List<Userinfo> listUser = userInfoService.selectAllUserList(param);

            reObj.put("draw", draw);
            reObj.put("recordsTotal", ((Page) listUser).getTotal());
            reObj.put("recordsFiltered", ((Page) listUser).getTotal());

            for (Userinfo user: listUser) {
                JSONArray jo = new JSONArray();
                jo.add(user.getAutoID());
                jo.add(user.getUserCode());
                jo.add(user.getUserName());
                jo.add(user.getPhoneNum());
                jo.add(user.getUserType());
                jo.add(user.getNickName());
                jo.add(user.getIntegration());
                jo.add(user.getEMail());
                jo.add(user.getStatus());
                jo.add(user.getCreateDate());
                ja.add(jo);
            }
            reObj.put("aaData", ja);  // aaDate 为固定

        }catch (Exception e){
            log.info("获取用户列表数据出错");
        }
        return reObj;
    }
}
