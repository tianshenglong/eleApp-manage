package com.eleapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.beust.jcommander.internal.Maps;
import com.eleapp.model.*;
import com.eleapp.service.*;
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
 * Created by 胜龙 on 2016/12/25.
 */
@Controller
@RequestMapping("/graClass")
public class SchGraClassController {

    private static Logger log = LoggerFactory.getLogger(SchGraClassController.class);

    @Autowired
    GradeService gradeService;

    @Autowired
    ClassService classService;

    @Autowired
    SchoolService schoolService;


    @RequestMapping("toGradeList")
    public String toGradeList(Model model){
        return "school/grade/grade-list";
    }

    @ResponseBody
    @RequestMapping("getGradeList")
    public JSONObject getGradeList(Model model,String start, String length, String draw,@RequestParam Map param){

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
            List<Map> listGrade = gradeService.selectAllGradeList(param);

            reObj.put("draw", draw);
            reObj.put("recordsTotal", ((Page) listGrade).getTotal());
            reObj.put("recordsFiltered", ((Page) listGrade).getTotal());

            for (Map map: listGrade) {
                JSONArray jo = new JSONArray();
                jo.add(map.get("id"));
                jo.add(map.get("name"));
                jo.add(map.get("schoolName"));
                jo.add(map.get("createTime"));
                ja.add(jo);
            }
            reObj.put("aaData", ja);  // aaDate 为固定

        }catch (Exception e){
            log.info("获取年级列表数据出错");
        }
        return reObj;
    }

    @RequestMapping("toGradeAdd")
    public String toGradeAdd(Model model){

        Map param = Maps.newHashMap();
        List<Map> allSchool= schoolService.selectAllSchoolList(param);
        model.addAttribute("closeOrnot",0);
        model.addAttribute("allSchool",allSchool);
        return "school/grade/grade-add";
    }

    @RequestMapping("/addGrade")
    public String addGrade(Model model, EleGrade grade,@RequestParam Map param) {
        try {
            grade.setCreateTime(new Date());
            grade.setIsDel(1);
            gradeService.insertSelective(grade);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("closeOrnot",1);
        return "school/grade/grade-add";
    }


    @RequestMapping("toClassList")
    public String toClassList(Model model){
        return "school/class/class-list";
    }

    @RequestMapping("getClassList")
    @ResponseBody
    public JSONObject getClassList(Model model,String start, String length, String draw,@RequestParam Map param){

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
            List<Map> listClass = classService.selectAllClassList(param);

            reObj.put("draw", draw);
            reObj.put("recordsTotal", ((Page) listClass).getTotal());
            reObj.put("recordsFiltered", ((Page) listClass).getTotal());

            for (Map map: listClass) {
                JSONArray jo = new JSONArray();
                jo.add(map.get("id"));
                jo.add(map.get("name"));
                jo.add(map.get("gradeName"));
                jo.add(map.get("schoolName"));
                jo.add(map.get("createTime"));
                ja.add(jo);
            }
            reObj.put("aaData", ja);  // aaDate 为固定

        }catch (Exception e){
            log.info("获取年级列表数据出错");
        }
        return reObj;
    }

    @RequestMapping("toClassAdd")
    public String toClassAdd(Model model){

        Map param = Maps.newHashMap();
        List<Map> allSchool= schoolService.selectAllSchoolList(param);
        model.addAttribute("closeOrnot",0);
        model.addAttribute("allSchool",allSchool);
        return "school/class/class-add";
    }

    @RequestMapping("/addClass")
    public String addClass(Model model, EleClass eleClass,@RequestParam Map param) {
        try {
            eleClass.setCreateTime(new Date());
            eleClass.setIsDel(1);
            classService.insertSelective(eleClass);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("closeOrnot",1);
        return "school/class/class-add";
    }

}
