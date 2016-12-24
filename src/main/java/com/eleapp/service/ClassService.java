package com.eleapp.service;

import com.eleapp.dao.EleClassMapper;
import com.eleapp.model.EleClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/12/25.
 */
@Service
public class ClassService {

    @Autowired
    EleClassMapper eleClassMapper;

    public int deleteByPrimaryKey(Integer id){
        return  eleClassMapper.deleteByPrimaryKey(id);
    }

    public int insert(EleClass record){
        return eleClassMapper.insert(record);
    }

    public int insertSelective(EleClass record){
        return eleClassMapper.insertSelective(record);
    }

    public EleClass selectByPrimaryKey(Integer id){
        return eleClassMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EleClass record){
        return eleClassMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(EleClass record){
        return eleClassMapper.updateByPrimaryKey(record);
    }

    public List<Map> selectAllClassList(Map param){
        return eleClassMapper.selectAllClassList(param);
    }
}
