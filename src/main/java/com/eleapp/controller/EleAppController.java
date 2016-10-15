package com.eleapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eleapp.model.Appinfo;
import com.eleapp.service.AppInfoService;
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
 * Created by 胜龙 on 2016/10/8.
 */
@Controller
@RequestMapping("/app")
public class EleAppController {

    private static Logger log = LoggerFactory.getLogger(EleAppController.class);

    @Autowired
    AppInfoService appInfoService;

    @RequestMapping("toAppList")
    public String toUserList(Model model){
        return "app/app-list";
    }

    @RequestMapping("getAppList")
    @ResponseBody
    public JSONObject getAppList(Model model,String start, String length, String draw,@RequestParam Map param){

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
            List<Map> listApp = appInfoService.selectAllAppList(param);

            reObj.put("draw", draw);
            reObj.put("recordsTotal", ((Page) listApp).getTotal());
            reObj.put("recordsFiltered", ((Page) listApp).getTotal());

            for (Map map: listApp) {
                JSONArray jo = new JSONArray();
                jo.add(map.get("AutoID"));
                jo.add(map.get("AppCode"));
                jo.add(map.get("AppName"));
                jo.add(map.get("AppType"));
                jo.add(map.get("CompanyCode"));
                jo.add(map.get("IsFree"));
                jo.add(map.get("Price"));
                jo.add(map.get("Status"));
                jo.add(map.get("CreateDate"));
                ja.add(jo);
            }
            reObj.put("aaData", ja);  // aaDate 为固定

        }catch (Exception e){
            log.info("获取app列表数据出错");
        }
        return reObj;
    }

    /**
     * 跳转到添加app页面
     * @param model
     * @return
     */
    @RequestMapping("toAppAdd")
    public String toAppAdd(Model model){
        model.addAttribute("closeOrnot",0);
        return "app/app-add";
    }

    /**
     * 添加app的方法
     * @param model
     * @param eleApp
     * @param param
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/addApp")
    public String addApp(Model model, Appinfo eleApp,
                          @RequestParam Map param, HttpServletRequest request,RedirectAttributes redirectAttributes,MultipartFile imgSmallFile,MultipartFile imgBigFile) {
        try {

            eleApp.setStatus(0);
            eleApp.setCreateDate(new Date());
            eleApp.setUploadUserID(1); //上传人
            eleApp.setOperaterUserID("1"); //操作人
            appInfoService.insertSelective(eleApp);

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("closeOrnot",1);
        return "app/app-add";
    }


    @ResponseBody
    @RequestMapping("/updateAppStatus")
    public Boolean updateAppStatus(String status,String id) {
        Boolean reStatus = false;
        try {
            appInfoService.updateAppStatus(status,id);
            reStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reStatus;
    }

}
