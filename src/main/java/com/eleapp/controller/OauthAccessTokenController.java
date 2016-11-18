package com.eleapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eleapp.service.OauthAccessTokenService;
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
 * Created by 胜龙 on 2016/11/2.
 */
@Controller
@RequestMapping("/oauth")
public class OauthAccessTokenController {

    @Autowired
    OauthAccessTokenService oauthAccessTokenService;

    private static Logger log = LoggerFactory.getLogger(EleAppController.class);

    @RequestMapping("toOauthList")
    public String toOauthList(Model model){
        return "oauth/oauth-list";
    }

    @RequestMapping("getOauthList")
    @ResponseBody
    public JSONObject getOauthList(Model model,String start, String length, String draw,@RequestParam Map param){

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
            List<Map> listApp = oauthAccessTokenService.selectAllOauthAccessList(param);

            reObj.put("draw", draw);
            reObj.put("recordsTotal", ((Page) listApp).getTotal());
            reObj.put("recordsFiltered", ((Page) listApp).getTotal());

            for (Map map: listApp) {
                JSONArray jo = new JSONArray();
                jo.add(map.get("id"));
                jo.add(map.get("app_id"));
                jo.add(map.get("access_token"));
                jo.add(map.get("user_code"));
                jo.add(map.get("open_id"));
                jo.add(map.get("create_date"));
                jo.add(map.get("refresh_date"));
                jo.add(map.get("expires_in"));
                jo.add(map.get("status"));
                ja.add(jo);
            }
            reObj.put("aaData", ja);  // aaDate 为固定

        }catch (Exception e){
            log.info("获取oauth列表数据出错");
        }
        return reObj;
    }

    @ResponseBody
    @RequestMapping("/updateOauthStatus")
    public Boolean updateOauthStatus(Integer status,Integer id) {
        Boolean reStatus = false;
        try {
            oauthAccessTokenService.updateOauthStatus(status, id);
            reStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reStatus;
    }
}
