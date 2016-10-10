package com.eleapp.service;

import com.eleapp.dao.EleNewsMapper;
import com.eleapp.model.EleNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 胜龙 on 2016/10/8.
 */
@Service
public class EleNewsService {

    @Autowired
    EleNewsMapper eleNewsMapper;

    public int deleteByPrimaryKey(Integer id){
        return eleNewsMapper.deleteByPrimaryKey(id);
    }


    public int insert(EleNews record){
        return eleNewsMapper.insert(record);
    }


    public int insertSelective(EleNews record){
        return eleNewsMapper.insertSelective(record);
    }


    public EleNews selectByPrimaryKey(Integer id){
        return eleNewsMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(EleNews record){
        return eleNewsMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKeyWithBLOBs(EleNews record){
        return eleNewsMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    public int updateByPrimaryKey(EleNews record){
        return eleNewsMapper.updateByPrimaryKey(record);
    }

    public List<EleNews> selectAllNewsList(){
        return eleNewsMapper.selectAllNewsList();
    }
}
