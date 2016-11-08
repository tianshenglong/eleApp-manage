package com.eleapp.service;

import com.eleapp.dao.AppinfoMapper;
import com.eleapp.model.Appinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 胜龙 on 2016/10/14.
 */

@Service
public class AppInfoService {

    @Autowired
    AppinfoMapper appinfoMapper;

    public int deleteByPrimaryKey(Integer autoID){
        return appinfoMapper.deleteByPrimaryKey(autoID);
    }


    public int insert(Appinfo record){
        return appinfoMapper.insert(record);
    }


    public int insertSelective(Appinfo record){
        record.setAppKey(UUID.randomUUID().toString());
        record.setCreateDate(new Date());
        record.setStatus(0);
        record.setIsDel(1);
        return appinfoMapper.insertSelective(record);
    }


    public Appinfo selectByPrimaryKey(Integer autoID){
        return appinfoMapper.selectByPrimaryKey(autoID);
    }


    public int updateByPrimaryKeySelective(Appinfo record){
        return appinfoMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Appinfo record){
        return appinfoMapper.updateByPrimaryKey(record);
    }


    public List<Map> selectAllAppList(Map param){
        return appinfoMapper.selectAllAppList(param);
    }

    public int updateAppStatus(String status,String id){
        return appinfoMapper.updateAppStatus(status,id);
    }
}
