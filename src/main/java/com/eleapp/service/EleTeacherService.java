package com.eleapp.service;

import com.eleapp.dao.EleTeacherMapper;
import com.eleapp.model.EleTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/11/4.
 */
@Service
public class EleTeacherService {

    @Autowired
    EleTeacherMapper eleTeacherMapper;

    public int deleteByPrimaryKey(Integer id){
        return eleTeacherMapper.deleteByPrimaryKey(id);
    }

    public int insert(EleTeacher record){
        return eleTeacherMapper.insert(record);
    }

    public int insertSelective(EleTeacher record){
        return eleTeacherMapper.insertSelective(record);
    }

    public EleTeacher selectByPrimaryKey(Integer id){
        return eleTeacherMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EleTeacher record){
        return eleTeacherMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EleTeacher record){
        return eleTeacherMapper.updateByPrimaryKey(record);
    }

    public List<Map> selectAllTeacherList(Map param){
        return eleTeacherMapper.selectAllTeacherList(param);
    }
}
