package com.eleapp.service;

import com.eleapp.dao.EleStudentMapper;
import com.eleapp.model.EleStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/11/4.
 */
@Service
public class EleStudentService {

    @Autowired
    EleStudentMapper eleStudentMapper;


    public int deleteByPrimaryKey(Integer id){
        return eleStudentMapper.deleteByPrimaryKey(id);
    }

    public int insert(EleStudent record){
        return eleStudentMapper.insert(record);
    }

    public int insertSelective(EleStudent record){
        return eleStudentMapper.insertSelective(record);
    }

    public EleStudent selectByPrimaryKey(Integer id){
        return eleStudentMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EleStudent record){
        return eleStudentMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EleStudent record){
        return eleStudentMapper.updateByPrimaryKey(record);
    }

    public List<Map> selectAllStudentList(Map param){
        return eleStudentMapper.selectAllStudentList(param);
    }
}
