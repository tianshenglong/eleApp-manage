package com.eleapp.controller;

import com.eleapp.service.OrganizationService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/12/24.
 */
@Controller
@RequestMapping("/public")
public class PublicController {

    @Autowired
    OrganizationService organizationService;

    @RequestMapping("/getCityList")
    @ResponseBody
    public ArrayList getCityList(String province) {
        List<Map> index1 = organizationService.getOrgListByOrgId(province);
        ArrayList<ImmutableMap<String, String>> cityList = com.google.common.collect.Lists.newArrayList();
        cityList.add(ImmutableMap.of("0", "请选择"));
        for (Map<String, Object> stringObjectMap : index1) {
            String id =  stringObjectMap.get("id").toString();
            String name = (String) stringObjectMap.get("name");
            cityList.add(ImmutableMap.of(id, name));
        }
        return cityList;
    }

    @RequestMapping("/getCountyList")
    @ResponseBody
    public ArrayList getCountyList(String city) {
        List<Map> index1 = organizationService.getOrgListByOrgId(city);
        ArrayList<ImmutableMap<String, String>> countyList = com.google.common.collect.Lists.newArrayList();
        countyList.add(ImmutableMap.of("0", "请选择"));
        for (Map<String, Object> stringObjectMap : index1) {
            String id =  stringObjectMap.get("id").toString();
            String name = (String) stringObjectMap.get("name");
            countyList.add(ImmutableMap.of(id, name));
        }
        return countyList;
    }

    @RequestMapping("/getRuralList")
    @ResponseBody
    public ArrayList getRuralList(String county) {
        List<Map> index1 = organizationService.getRuralListByOrgId(county);
        ArrayList<ImmutableMap<String, String>> ruralList = com.google.common.collect.Lists.newArrayList();
        ruralList.add(ImmutableMap.of("0", "请选择"));
        for (Map<String, Object> stringObjectMap : index1) {
            String id =  stringObjectMap.get("id").toString();
            String name = (String) stringObjectMap.get("name");
            ruralList.add(ImmutableMap.of(id, name));
        }
        return ruralList;
    }
}
