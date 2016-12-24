package com.eleapp.service;

import com.eleapp.dao.EleSchoolMapper;
import com.eleapp.model.EleSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/12/24.
 */
@Service
public class SchoolService {

    @Autowired
    EleSchoolMapper eleSchoolMapper;

    public int deleteByPrimaryKey(Integer id){
        return eleSchoolMapper.deleteByPrimaryKey(id);
    }

    public int insert(EleSchool record){
        return eleSchoolMapper.insert(record);
    }

    public int insertSelective(EleSchool record){
        return eleSchoolMapper.insertSelective(record);
    }

    public EleSchool selectByPrimaryKey(Integer id){
        return eleSchoolMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EleSchool record){
        return eleSchoolMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EleSchool record){
        return eleSchoolMapper.updateByPrimaryKey(record);
    }

    public List<Map> selectAllSchoolList(Map param){
        return eleSchoolMapper.selectAllSchoolList(param);
    }

}
