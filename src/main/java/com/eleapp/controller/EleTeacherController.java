package com.eleapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eleapp.service.EleTeacherService;
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
 * Created by 胜龙 on 2016/11/4.
 */
@Controller
@RequestMapping("/teacher")
public class EleTeacherController {

    private static Logger log = LoggerFactory.getLogger(EleNewsController.class);

    @Autowired
    EleTeacherService eleTeacherService;

    @RequestMapping("toTeacherList")
    public String toTeacherList(Model model){
        return "teacher/teacher-list";
    }

    @RequestMapping("getTeacherList")
    @ResponseBody
    public JSONObject getTeacherList(Model model,String start, String length, String draw,@RequestParam Map param){

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
            List<Map> listNews = eleTeacherService.selectAllTeacherList(param);

            reObj.put("draw", draw);
            reObj.put("recordsTotal", ((Page) listNews).getTotal());
            reObj.put("recordsFiltered", ((Page) listNews).getTotal());

            for (Map news: listNews) {
                JSONArray jo = new JSONArray();
                jo.add(news.get("AutoID"));
                jo.add(news.get("NewsTitle"));
                jo.add(news.get("PushTime"));
                jo.add(news.get("NewsType"));
                jo.add(news.get("CreateDate"));
                ja.add(jo);
            }
            reObj.put("aaData", ja);  // aaDate 为固定

        }catch (Exception e){
            log.info("获取教师列表数据出错");
        }
        return reObj;
    }

}
