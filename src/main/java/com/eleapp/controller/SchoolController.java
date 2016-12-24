package com.eleapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eleapp.model.EleSchool;
import com.eleapp.model.EleStudent;
import com.eleapp.service.EleStudentService;
import com.eleapp.service.OrganizationService;
import com.eleapp.service.SchoolService;
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
 * Created by 胜龙 on 2016/12/24.
 */
@Controller
@RequestMapping("/school")
public class SchoolController {

    private static Logger log = LoggerFactory.getLogger(EleNewsController.class);

    @Autowired
    SchoolService schoolService;

    @Autowired
    OrganizationService organizationService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

    @RequestMapping("toSchoolList")
    public String toStudentList(Model model){
        return "school/school-list";
    }

    @RequestMapping("getSchoolList")
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
            List<Map> listSchool = schoolService.selectAllSchoolList(param);

            reObj.put("draw", draw);
            reObj.put("recordsTotal", ((Page) listSchool).getTotal());
            reObj.put("recordsFiltered", ((Page) listSchool).getTotal());

            for (Map stu: listSchool) {
                JSONArray jo = new JSONArray();
                jo.add(stu.get("id"));
                jo.add(stu.get("name"));
                jo.add(stu.get("province"));
                jo.add(stu.get("city"));
                jo.add(stu.get("county"));
                jo.add(stu.get("rural"));
                jo.add(stu.get("contactPerson"));
                jo.add(stu.get("contactMobile"));
                jo.add(stu.get("createTime"));
                ja.add(jo);
            }
            reObj.put("aaData", ja);  // aaDate 为固定

        }catch (Exception e){
            log.info("获取学校列表数据出错");
        }
        return reObj;
    }

    @RequestMapping("toSchoolAdd")
    public String toStudentAdd(Model model){
        List<Map> listProvince = organizationService.getOrgListByOrgId("10");
        model.addAttribute("listProvince",listProvince);
        model.addAttribute("closeOrnot",0);
        return "school/school-add";
    }

    /**
     * 添加app的方法
     * @param model
     * @param school
     * @param param
     * @return
     */
    @RequestMapping("/addSchool")
    public String addStudent(Model model, EleSchool school,@RequestParam Map param ) {
        try {
            school.setIsDel(1);
            school.setCreateTime(new Date());
            schoolService.insertSelective(school);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("closeOrnot",1);
        return "school/school-add";
    }
}
