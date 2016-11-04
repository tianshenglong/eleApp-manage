package com.eleapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eleapp.model.EleStudent;
import com.eleapp.model.EleTeacher;
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
@RequestMapping("/teacher")
public class EleTeacherController {

    private static Logger log = LoggerFactory.getLogger(EleNewsController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

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
            List<Map> listTeac = eleTeacherService.selectAllTeacherList(param);

            reObj.put("draw", draw);
            reObj.put("recordsTotal", ((Page) listTeac).getTotal());
            reObj.put("recordsFiltered", ((Page) listTeac).getTotal());

            for (Map teat: listTeac) {
                JSONArray jo = new JSONArray();
                jo.add(teat.get("id"));
                jo.add(teat.get("name"));
                jo.add(teat.get("sertId"));
                jo.add(teat.get("sex"));
                jo.add(teat.get("isAdviser"));
                jo.add(teat.get("subject"));
                jo.add(teat.get("mobile"));
                jo.add(teat.get("email"));
                jo.add(teat.get("birthDay"));
                jo.add(teat.get("createTime"));
                jo.add(teat.get("motifyTime"));
                ja.add(jo);
            }
            reObj.put("aaData", ja);  // aaDate 为固定

        }catch (Exception e){
            log.info("获取教师列表数据出错");
        }
        return reObj;
    }

    @RequestMapping("toTeacherAdd")
    public String toTeacherAdd(Model model){
        model.addAttribute("closeOrnot",0);
        return "teacher/teacher-add";
    }

    /**
     * 添加app的方法
     * @param model
     * @param teacher
     * @param param
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/addTeacher")
    public String addStudent(Model model, EleTeacher teacher,
                             @RequestParam Map param, HttpServletRequest request,RedirectAttributes redirectAttributes,MultipartFile imgUrlFile) {
        try {

            teacher.setIsDel(1);
            teacher.setCreateDate(new Date());
            eleTeacherService.insertSelective(teacher);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("closeOrnot",1);
        return "teacher/teacher-add";
    }

}
