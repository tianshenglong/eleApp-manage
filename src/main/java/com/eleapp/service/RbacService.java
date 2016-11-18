package com.eleapp.service;

import com.eleapp.dao.SysRbacMenuMapper;
import com.eleapp.dao.SysRbacRoleauthMapper;
import com.eleapp.model.*;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by 胜龙 on 2016/10/22.
 */
@Service
public class RbacService {
    @Autowired
    SysRbacMenuMapper sysRbacMenuMapper;

    @Autowired
    SysRbacRoleauthMapper sysRbacRoleAuthMapper;

    public UserAccess getUserAccess(HttpServletRequest request) {
        UserAccess userAccess = (UserAccess) request.getSession().getAttribute("userAccess");
        UserRole userRole = userAccess.getUserRole();
        //查询用户目录权限
        List<SysRbacTopMenuDO> topMenu = sysRbacMenuMapper.queyRoleMenuNew(String.valueOf(userRole.getRoleId()), "");
        List<RoleTopMenu> roleTopMenus = Lists.newArrayList();
        Map<String,Set> roleButton = Maps.newHashMap();
        for (SysRbacTopMenuDO sysRbacTopMenuDO : topMenu) {
            int menuId = sysRbacTopMenuDO.getId();
            RoleTopMenu roleTopMenu = new RoleTopMenu();
            roleTopMenu.setId(menuId);
            roleTopMenu.setMenuName(sysRbacTopMenuDO.getMenuName());
            roleTopMenu.setLogo(sysRbacTopMenuDO.getLogo());
            List<SysRbacTopMenuDO> subMenuList= sysRbacMenuMapper.queyRoleMenuNew(String.valueOf(userRole.getRoleId()), String.valueOf(menuId));
            List<RoleSubMenu> subMenus = Lists.newArrayList();
            for (SysRbacTopMenuDO rbacTopMenuDO : subMenuList) {
                RoleSubMenu roleSubMenu = new RoleSubMenu();
                roleSubMenu.setMenuId(rbacTopMenuDO.getId());
                roleSubMenu.setMenuName(rbacTopMenuDO.getMenuName());
                roleSubMenu.setAuthButtons(rbacTopMenuDO.getButtons());
                roleSubMenu.setUrl(rbacTopMenuDO.getUrl());
                String buttons = rbacTopMenuDO.getButtons();
                if (!Strings.isNullOrEmpty(buttons)){
                    String[] button = buttons.split("\\|");
                    Set<String> roleButtonSet = Sets.newLinkedHashSet();
                    for (String s : button) {
                        roleButtonSet.add(s);
                    }
                    roleButton.put(String.valueOf(rbacTopMenuDO.getId()),roleButtonSet);
                    userRole.setButton(roleButton);
                }
                subMenus.add(roleSubMenu);
            }
            roleTopMenu.setRoleSubMenuList(subMenus);
            roleTopMenus.add(roleTopMenu);
        }

        userRole.setRoleTopMenuList(roleTopMenus);
        return userAccess;
    }

    public UserRole getRoleUser(Integer roleId) {
        //查询用户目录权限
        List<SysRbacTopMenuDO> topMenu = sysRbacMenuMapper.queyRoleMenuNew(String.valueOf(roleId), "");
        List<RoleTopMenu> roleTopMenus = Lists.newArrayList();
        for (SysRbacTopMenuDO sysRbacTopMenuDO : topMenu) {
            int menuId = sysRbacTopMenuDO.getId();
            RoleTopMenu roleTopMenu = new RoleTopMenu();
            roleTopMenu.setId(menuId);
            roleTopMenu.setMenuName(sysRbacTopMenuDO.getMenuName());
            roleTopMenu.setLogo(sysRbacTopMenuDO.getLogo());
            List<SysRbacTopMenuDO> subMenuList= sysRbacMenuMapper.queyRoleMenuNew(String.valueOf(roleId), String.valueOf(menuId));
            List<RoleSubMenu> subMenus = Lists.newArrayList();
            for (SysRbacTopMenuDO rbacTopMenuDO : subMenuList) {
                RoleSubMenu roleSubMenu = new RoleSubMenu();
                roleSubMenu.setMenuId(rbacTopMenuDO.getId());
                roleSubMenu.setMenuName(rbacTopMenuDO.getMenuName());
                roleSubMenu.setAuthButtons(rbacTopMenuDO.getButtons());
                roleSubMenu.setUrl(rbacTopMenuDO.getUrl());
                subMenus.add(roleSubMenu);
            }
            roleTopMenu.setRoleSubMenuList(subMenus);
            roleTopMenus.add(roleTopMenu);
        }
        UserRole userRole = new UserRole();
        userRole.setRoleId(roleId);
        userRole.setRoleTopMenuList(roleTopMenus);
        return userRole;
    }

    public SysRbacRoleauth getRoleAuto(Integer roleId,Integer menuId) {
        return sysRbacRoleAuthMapper.selectByRoleIdMenuId(roleId,menuId);
    }

    public int editRoleResources(Integer roleId, Integer menuId, String button, Integer level, Boolean checkStatus) {
        SysRbacRoleauth sysRbacRoleAuth = sysRbacRoleAuthMapper.selectByRoleIdMenuId(roleId,menuId);
        if (sysRbacRoleAuth !=null){
            if(0==level||1==level){
                if (checkStatus){
                    sysRbacRoleAuth.setMenuId(menuId);
                    sysRbacRoleAuth.setMenuId(roleId);
                    sysRbacRoleAuthMapper.insert(sysRbacRoleAuth);
                }else {
                    sysRbacRoleAuthMapper.deleteByRoleIdMenuId(menuId,roleId);
                }
            }else if(2==level){
                String buttons = sysRbacRoleAuth.getButtons();
                if (checkStatus){
                    if (Strings.isNullOrEmpty(buttons)){
                        sysRbacRoleAuth.setButtons(button);
                        sysRbacRoleAuthMapper.updateByPrimaryKey(sysRbacRoleAuth);
                    }else {
                        sysRbacRoleAuth.setButtons(sysRbacRoleAuth.getButtons()+"|"+button);
                        sysRbacRoleAuthMapper.updateByPrimaryKey(sysRbacRoleAuth);
                    }
                }else {
                    String[] buttonNew = buttons.split("\\|");
                    String buttonsNew="";
                    for (String s : buttonNew) {
                        if (!s.equals(button)){
                            buttonsNew+=s+"|";
                        }
                    }
                    if (!Strings.isNullOrEmpty(buttonsNew)){
                        buttonsNew = buttonsNew.substring(0, buttonsNew.length() - 1);
                    }
                    sysRbacRoleAuth.setButtons(buttonsNew);
                    sysRbacRoleAuthMapper.updateByPrimaryKey(sysRbacRoleAuth);
                }

            }
        }else {
            sysRbacRoleAuth = new SysRbacRoleauth();
            sysRbacRoleAuth.setMenuId(menuId);
            sysRbacRoleAuth.setRoleId(roleId);
            sysRbacRoleAuth.setButtons(button);
            sysRbacRoleAuthMapper.insert(sysRbacRoleAuth);
        }
        return 1;
    }

    /**
     * 获得用户当前地区
     * @param userAccess
     *//*
    public void getUserArea(UserAccess userAccess) {
        Integer areaType = userAccess.getYbsRbacDataAccess().getAreaType();
        String areaIds = userAccess.getYbsRbacDataAccess().getAreaIds();
        String[] areaId = null;
        if (!Strings.isNullOrEmpty(areaIds)){
            areaId=areaIds.split(",");
            if(areaType==1){
                ArrayList<HashMap<String, Object>> proviceList = organizationService.getCustomAreaList("____");
                userAccess.setListProvince(proviceList);
            }else if(areaType==2){
                userAccess.setListProvince(Lists.newArrayList());
                for (String s : areaId) {
                    HashMap<String, Object> provice = organizationService.getCustomAreaList(s).get(0);
                    userAccess.getListProvince().add(provice);
                }
            }else if(areaType==3){
                HashMap<String, Object> provice = organizationService.getCustomAreaList(areaId[0].substring(0,4)).get(0);
                userAccess.setListProvince(Lists.newArrayList());
                userAccess.getListProvince().add(provice);
                List cityList = Lists.newArrayList();
                for (String s : areaId) {
                    HashMap<String, Object> city = organizationService.getCustomAreaList(s).get(0);
                    cityList.add(city);
                }
                userAccess.setListCity(Maps.newHashMap());
                userAccess.getListCity().put(String.valueOf(provice.get("id")),cityList);
            }else if(areaType==4){
                HashMap<String, Object> provice = organizationService.getCustomAreaList(areaId[0].substring(0,4)).get(0);
                userAccess.setListProvince(Lists.newArrayList());
                userAccess.getListProvince().add(provice);
                HashMap<String, Object> city = organizationService.getCustomAreaList(areaId[0].substring(0,6)).get(0);
                List cityList = new ArrayList<>();
                cityList.add(city);
                userAccess.setListCity(Maps.newHashMap());
                userAccess.getListCity().put(String.valueOf(provice.get("id")),cityList);
                List countyList = new ArrayList<>();
                for (String s : areaId) {
                    HashMap<String, Object> county = organizationService.getCustomAreaList(s).get(0);
                    countyList.add(county);
                }
                userAccess.setListCounty(Maps.newHashMap());
                userAccess.getListCounty().put(String.valueOf(city.get("id")),countyList);
            }else if(areaType==5){
                for (String s : areaId) {
                    YbsCompCompany ybsCompCompany = ybsCompCompanyMapper.selectByPrimaryKey(s);
                    HashMap<String, Object> provice = organizationService.getCustomAreaList(String.valueOf(ybsCompCompany.getProvince())).get(0);
                    userAccess.setListProvince(Lists.newArrayList());
                    userAccess.getListProvince().add(provice);
                    ArrayList<HashMap<String, Object>> cityListMap = organizationService.getCustomAreaList(String.valueOf(ybsCompCompany.getCity()));
                    if(cityListMap.size()>0){
                        HashMap<String, Object> city = cityListMap.get(0);
                        List cityList = new ArrayList<>();
                        cityList.add(city);
                        userAccess.setListCity(Maps.newHashMap());
                        userAccess.getListCity().put(String.valueOf(provice.get("id")),cityList);
                        ArrayList<HashMap<String, Object>> countyLists = organizationService.getCustomAreaList(String.valueOf(ybsCompCompany.getCounty()));
                        if(countyLists.size()>0){
                            HashMap<String, Object> county = countyLists.get(0);
                            List countyList = new ArrayList<>();
                            countyList.add(county);
                            userAccess.setListCounty(Maps.newHashMap());
                            userAccess.getListCounty().put(String.valueOf(city.get("id")),countyList);
                        }
                    }
                }
            }
        }
    }*/
}

