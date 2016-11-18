package com.eleapp.service;

import com.eleapp.dao.NewsinfoMapper;
import com.eleapp.model.Newsinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/10/14.
 */
@Service
public class NewsInfoService {

    @Autowired
    NewsinfoMapper newsinfoMapper;

    public int deleteByPrimaryKey(Integer autoID){
        return newsinfoMapper.deleteByPrimaryKey(autoID);
    }

    public int insert(Newsinfo record){
        return newsinfoMapper.insert(record);
    }

    public int insertSelective(Newsinfo record){
        return newsinfoMapper.insertSelective(record);
    }

    public Newsinfo selectByPrimaryKey(Integer autoID){
        return newsinfoMapper.selectByPrimaryKey(autoID);
    }

    public int updateByPrimaryKeySelective(Newsinfo record){
        return newsinfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKeyWithBLOBs(Newsinfo record){
        return newsinfoMapper.updateByPrimaryKeyWithBLOBs(record);
    }


    public int updateByPrimaryKey(Newsinfo record){
        return newsinfoMapper.updateByPrimaryKey(record);
    }

    public List<Map> selectAllNewsList(Map  param){
        return newsinfoMapper.selectAllNewsList(param);
    }
}
