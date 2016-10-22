package com.eleapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eleapp.model.*;
import com.eleapp.service.RbacService;
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

    @Autowired
    RbacService rbacService;

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


    @RequestMapping("/toRoleResourcesManager")
    public String toRoleResourcesManager(Model model,String roleId) {
        return "sys/role/role-resources";
    }

    @RequestMapping("/getRoleResources")
    public @ResponseBody JSONArray getRoleResources(HttpServletRequest request,String roleId) {
        JSONArray jsonArray = new JSONArray();
        UserAccess userAccess = rbacService.getUserAccess(request);
        UserRole thisUserRole = userAccess.getUserRole();
        List<RoleTopMenu> thisTopMenuList = thisUserRole.getRoleTopMenuList();
        for (RoleTopMenu roleTopMenu : thisTopMenuList) {
            JSONObject jsonObject = new JSONObject(true);
            jsonObject.put("id",roleTopMenu.getId());
            jsonObject.put("name",roleTopMenu.getMenuName());
            jsonObject.put("open",true);
            SysRbacRoleauth  ybsRbacRoleAuthTop = rbacService.getRoleAuto(Integer.parseInt(roleId), roleTopMenu.getId());
            if (ybsRbacRoleAuthTop !=null){
                jsonObject.put("checked",true);
            }
            JSONArray childrenSubArr = new JSONArray();
            List<RoleSubMenu> thisSubMenuList = roleTopMenu.getRoleSubMenuList();
            for (RoleSubMenu roleSubMenu : thisSubMenuList) {
                JSONObject childrenSubObj = new JSONObject(true);
                childrenSubObj.put("id",roleSubMenu.getMenuId());
                childrenSubObj.put("name",roleSubMenu.getMenuName());
                childrenSubObj.put("open", true);
                SysRbacRoleauth ybsRbacRoleAuthSub = rbacService.getRoleAuto(Integer.parseInt(roleId), roleSubMenu.getMenuId());
                if (ybsRbacRoleAuthSub !=null){
                    childrenSubObj.put("checked",true);
                }
                String buttons = roleSubMenu.getAuthButtons();
                if (!Strings.isNullOrEmpty(buttons)) {
                    String[] buttonArr = buttons.split("\\|");
                    JSONArray childrenBtnArr = new JSONArray();
                    for (String s : buttonArr) {
                        JSONObject childrenBtnObj = new JSONObject(true);
                        childrenBtnObj.put("id", roleSubMenu.getMenuId());
                        childrenBtnObj.put("name", s);
                        childrenBtnObj.put("open", true);
                        childrenBtnArr.add(childrenBtnObj);
                        if (ybsRbacRoleAuthSub !=null){
                            String sysRbacRoleAuthBtns = ybsRbacRoleAuthSub.getButtons();
                            if(!Strings.isNullOrEmpty(sysRbacRoleAuthBtns)){
                                String[]  sysRbacRoleAuthBtn = sysRbacRoleAuthBtns.split("\\|");
                                for (String s1 : sysRbacRoleAuthBtn) {
                                    if (s1.equals(s)){
                                        childrenBtnObj.put("checked",true);
                                    }
                                }
                            }
                        }
                    }
                    childrenSubObj.put("children", childrenBtnArr);
                }
                childrenSubArr.add(childrenSubObj);
            }
            jsonObject.put("children", childrenSubArr);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    @ResponseBody
    @RequestMapping("/editRole")
    public JSONObject editRole(String roleId,String level1,String level2,String level3) {
        JSONObject jsonObject = new JSONObject(true);
        try {
            JSONArray level1JSON = JSONArray.parseArray(level1);
            JSONArray level2JSON = JSONArray.parseArray(level2);
            JSONArray level3JSON = JSONArray.parseArray(level3);
            sysRbacRoleService.editRoleAuto(roleId,level1JSON,level2JSON,level3JSON);
            jsonObject.put("msg","修改成功");
        } catch (Exception e) {
            jsonObject.put("msg","修改失败");
            e.printStackTrace();
        }
        return jsonObject;
    }
}
