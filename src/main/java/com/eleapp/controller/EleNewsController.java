package com.eleapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eleapp.model.EleNews;
import com.eleapp.model.User;
import com.eleapp.service.EleNewsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/10/8.
 */
@Controller
@RequestMapping("/news")
public class EleNewsController {

    private static Logger log = LoggerFactory.getLogger(EleNewsController.class);

    @Autowired
    EleNewsService eleNewsService;

    @RequestMapping("toNewsList")
    public String toUserList(Model model){
        return "news/news-list";
    }

    @RequestMapping("getNewsList")
    @ResponseBody
    public JSONObject getNewsList(Model model,String start, String length, String draw,@RequestParam Map param){

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
            List<EleNews> listNews = eleNewsService.selectAllNewsList();

            reObj.put("draw", draw);
            reObj.put("recordsTotal", ((Page) listNews).getTotal());
            reObj.put("recordsFiltered", ((Page) listNews).getTotal());

            for (EleNews news: listNews) {
                JSONArray jo = new JSONArray();
                jo.add(news.getId());
                jo.add(news.getName());
                jo.add(news.getAuthor());
                jo.add(news.getPublishDate());
                jo.add(news.getNewsTypeId());
                jo.add(news.getCreateTime());
                ja.add(jo);
            }
            reObj.put("aaData", ja);  // aaDate 为固定

        }catch (Exception e){
            log.info("获取资讯列表数据出错");
        }
        return reObj;
    }


    /**
     * 跳转到添加资讯页面
     * @param model
     * @return
     */
    @RequestMapping("toNewsAdd")
    public String toNewsAdd(Model model){
        model.addAttribute("closeOrnot",0);
        return "news/news-add";
    }

    @RequestMapping("/addNews")
    public String addNews(Model model, EleNews eleNews,
                                 @RequestParam Map param, HttpServletRequest request,RedirectAttributes redirectAttributes) {
        try {
            eleNews.setContent(param.get("editorValue").toString());
            eleNews.setIsDel(1);
            eleNews.setCreateTime(new Date());
            eleNews.setCreator(1);
            eleNewsService.insertSelective(eleNews);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("closeOrnot",1);
        return "news/news-add";
    }
}
