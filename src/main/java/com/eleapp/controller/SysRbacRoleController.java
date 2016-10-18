package com.eleapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eleapp.model.Newsinfo;
import com.eleapp.model.SysRbacRole;
import com.eleapp.service.SysRbacRoleService;
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
 * Created by 胜龙 on 2016/10/18.
 */
@Controller
@RequestMapping("role")
public class SysRbacRoleController {

    private static Logger log = LoggerFactory.getLogger(SysRbacRoleController.class);

    @Autowired
    SysRbacRoleService sysRbacRoleService;

    @RequestMapping("toRoleList")
    public String toRoleList(Model model){
        return "sys/role/role-list";
    }

    @RequestMapping("getRoleList")
    @ResponseBody
    public JSONObject getRoleList(Model model,String start, String length, String draw,@RequestParam Map param){

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
            List<Map> listApp = sysRbacRoleService.selectAllRoleList(param);

            reObj.put("draw", draw);
            reObj.put("recordsTotal", ((Page) listApp).getTotal());
            reObj.put("recordsFiltered", ((Page) listApp).getTotal());

            for (Map map: listApp) {
                JSONArray jo = new JSONArray();
                jo.add(map.get("id"));
                jo.add(map.get("roleName"));
                jo.add(map.get("comments"));
                jo.add(map.get("createTime"));
                jo.add(map.get("updateTime"));
                ja.add(jo);
            }
            reObj.put("aaData", ja);  // aaDate 为固定

        }catch (Exception e){
            log.info("获取app列表数据出错");
        }
        return reObj;
    }

    @RequestMapping("toRoleAdd")
    public String toNewsAdd(Model model){
        model.addAttribute("closeOrnot",0);
        return "sys/role/role-add";
    }

    @RequestMapping("/addRole")
    public String addNews(Model model, @RequestParam Map param, HttpServletRequest request,SysRbacRole sysRbacRole) {
        try {

            sysRbacRole.setCreateTime(new Date());
            sysRbacRole.setStatus(1);
            sysRbacRoleService.insertSelective(sysRbacRole);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("closeOrnot",1);
        return "sys/role/role-add";
    }
}
