package com.eleapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eleapp.model.*;
import com.eleapp.service.*;
import com.eleapp.util.UploadUtil;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
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

    @Autowired
    AppImagesService appImagesService;

    @Autowired
    SchoolCaseImagesService schoolCaseImagesService;

    @Autowired
    AppTypeService appTypeService;

    @Autowired
    AppToTypeService appToTypeService;

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

        List<EleApptype> allTypes= appTypeService.getALlTypes();
        model.addAttribute("closeOrnot",0);
        model.addAttribute("allTypes",allTypes);
        return "app/app-add";
    }

    /**
     * 跳转到上传应用图片页面
     * @param model
     * @return
     */
    @RequestMapping("toUploadImgs")
    public String toUploadImgs(Model model,String appId){
        model.addAttribute("appId",appId);
        model.addAttribute("closeOrnot",0);
        return "app/uploadImgs";
    }

    /**
     * 跳转到上传使用案例图片页面
     * @param model
     * @return
     */
    @RequestMapping("toUploadCaseImgs")
    public String toUploadCaseImgs(Model model,String appId){
        model.addAttribute("appId",appId);
        model.addAttribute("closeOrnot",0);
        return "app/uploadCaseImgs";
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

            EleApptotype eleApptotype = new EleApptotype();
            appInfoService.insertSelective(eleApp,imgBigFile,imgSmallFile,request);

            eleApptotype.setAppId(eleApp.getAutoID());
            eleApptotype.setAppTypeId(Integer.parseInt(param.get("appTypeId").toString()));
            eleApptotype.setCreateTime(new Date());
            eleApptotype.setIsDel(1);
            appToTypeService.insertSelective(eleApptotype);

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
            appInfoService.updateAppStatus(status, id);
            reStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reStatus;
    }

    @ResponseBody
    @RequestMapping("/setPerfact")
    public Boolean setPerfact(String appIds) {
        Boolean reStatus = false;
        try {
            appInfoService.setPerfact(appIds.substring(0, appIds.length() - 1), 1);
            reStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reStatus;
    }

    @ResponseBody
    @RequestMapping("/uploadAppImgs")
    public Map<String,Object> uploadAppImgs(HttpServletRequest request,String appId){
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                // 数据封装操作 MultipartFile reqeust
                // 取得当前上传文件的文 件名称<span style="white-space:pre"></span>; //这里需要你对文件的处理哦
//              logger.debug("图片上传：{}", JsonUtil.toString(map));
                String myFileName = file.getOriginalFilename();
                try {
                    String imgUrl = UploadUtil.uploadFile(file, request);
                    EleAppImages aapImages = new EleAppImages();
                    aapImages.setCreateTime(new Date());
                    aapImages.setIsDel(1);
                    aapImages.setAppId(Integer.parseInt(appId));
                    aapImages.setImgUrl(imgUrl.substring(imgUrl.lastIndexOf(File.separator)+1,imgUrl.length()));
                    appImagesService.insertSelective(aapImages);
                    //photoAlbumService.insertWebPhotos(map);
                } catch (Exception e) {
                   // return Tools.retMap(Msg.bizMsgIntance(ErrInfo.PHOTO_WALL_UPLOAD_FAIL,ErrInfo.PHOTO_WALL_UPLOAD_FAIL_MSG));
                }
            }
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/uploadCaseImgs")
    public Map<String,Object> uploadCaseImgs(HttpServletRequest request,String appId){
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                // 数据封装操作 MultipartFile reqeust
                // 取得当前上传文件的文 件名称<span style="white-space:pre"></span>; //这里需要你对文件的处理哦
//              logger.debug("图片上传：{}", JsonUtil.toString(map));
                String myFileName = file.getOriginalFilename();
                try {
                    String imgUrl = UploadUtil.uploadFile(file, request);
                    EleWebSchoolcase caseImages = new EleWebSchoolcase();
                    caseImages.setCreateTime(new Date());
                    caseImages.setIsDel(1);
                    caseImages.setAppId(Integer.parseInt(appId));
                    caseImages.setContect(imgUrl.substring(imgUrl.lastIndexOf(File.separator) + 1, imgUrl.length()));
                    schoolCaseImagesService.insertSelective(caseImages);
                    //photoAlbumService.insertWebPhotos(map);
                } catch (Exception e) {
                    // return Tools.retMap(Msg.bizMsgIntance(ErrInfo.PHOTO_WALL_UPLOAD_FAIL,ErrInfo.PHOTO_WALL_UPLOAD_FAIL_MSG));
                }
            }
        }
        return null;
    }



}
