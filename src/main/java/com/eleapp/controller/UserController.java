package com.eleapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eleapp.dao.SysRbacUserroleMapper;
import com.eleapp.model.Appinfo;
import com.eleapp.model.SysRbacUserrole;
import com.eleapp.model.Userinfo;
import com.eleapp.service.SysRbacRoleService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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

    @Autowired
    SysRbacRoleService roleService;

    @Autowired
    SysRbacUserroleMapper sysRbacUserroleMapper;


    @RequestMapping("toAppUser")
    public String toAppUser(Model model){
        model.addAttribute("roleList", roleService.getRoleAllListByRoleName(""));
        model.addAttribute("closeOrnot",0);
        return "user/user-add";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model, Userinfo userinfo,String roleId,
                         @RequestParam Map param, HttpServletRequest request,RedirectAttributes redirectAttributes) {
        try {



            userinfo.setStatus(0);
            userinfo.setCreateDate(new Date());
            userInfoService.insertSelective(userinfo);

            SysRbacUserrole ybsRbacUserRole = new SysRbacUserrole();
            ybsRbacUserRole.setRoleId(Integer.parseInt(roleId));
            ybsRbacUserRole.setUserId(userinfo.getAutoID());
            sysRbacUserroleMapper.insert(ybsRbacUserRole);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("closeOrnot",1);
        return "app/app-add";
    }

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
            List<Map> listUser = userInfoService.selectAllUserList(param);

            reObj.put("draw", draw);
            reObj.put("recordsTotal", ((Page) listUser).getTotal());
            reObj.put("recordsFiltered", ((Page) listUser).getTotal());

            for (Map user: listUser) {
                JSONArray jo = new JSONArray();
                jo.add(user.get("AutoID"));
                jo.add(user.get("UserCode"));
                jo.add(user.get("UserName"));
                jo.add(user.get("PhoneNum"));
                jo.add(user.get("UserType"));
                jo.add(user.get("NickName"));
                jo.add(user.get("Integration"));
                jo.add(user.get("EMail"));
                jo.add(user.get("Status"));
                jo.add(user.get("CreateDate"));
                ja.add(jo);
            }
            reObj.put("aaData", ja);  // aaDate 为固定

        }catch (Exception e){
            log.info("获取用户列表数据出错");
        }
        return reObj;
    }
}
