package com.eleapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eleapp.model.Appinfo;
import com.eleapp.model.EleStudent;
import com.eleapp.service.EleStudentService;
import com.eleapp.service.EleTeacherService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/11/4.
 */
@Controller
@RequestMapping("/student")
public class EleStudentController {

    private static Logger log = LoggerFactory.getLogger(EleNewsController.class);

    @Autowired
    EleStudentService eleStudentService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

    @RequestMapping("toStudentList")
    public String toStudentList(Model model){
        return "student/student-list";
    }

    @RequestMapping("getStudentList")
    @ResponseBody
    public JSONObject getStudentList(Model model,String start, String length, String draw,@RequestParam Map param){

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
            List<Map> listNews = eleStudentService.selectAllStudentList(param);

            reObj.put("draw", draw);
            reObj.put("recordsTotal", ((Page) listNews).getTotal());
            reObj.put("recordsFiltered", ((Page) listNews).getTotal());

            for (Map stu: listNews) {
                JSONArray jo = new JSONArray();
                jo.add(stu.get("id"));
                jo.add(stu.get("name"));
                jo.add(stu.get("sertId"));
                jo.add(stu.get("sex"));
                jo.add(stu.get("parentMobile"));
                jo.add(stu.get("email"));
                jo.add(stu.get("birthDay"));
                jo.add(stu.get("createTime"));
                jo.add(stu.get("motifyTime"));
                ja.add(jo);
            }
            reObj.put("aaData", ja);  // aaDate 为固定

        }catch (Exception e){
            log.info("获取学生列表数据出错");
        }
        return reObj;
    }

    @RequestMapping("toStudentAdd")
    public String toStudentAdd(Model model){
        model.addAttribute("closeOrnot",0);
        return "student/student-add";
    }

    /**
     * 添加app的方法
     * @param model
     * @param student
     * @param param
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/addStudent")
    public String addStudent(Model model, EleStudent student,
                         @RequestParam Map param, HttpServletRequest request,RedirectAttributes redirectAttributes,MultipartFile imgUrlFile) {
        try {

            student.setIsDel(1);
            student.setCreateTime(new Date());
            eleStudentService.insertSelective(student);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("closeOrnot",1);
        return "app/app-add";
    }
}
