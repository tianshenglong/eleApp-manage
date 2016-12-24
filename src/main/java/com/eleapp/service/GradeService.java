package com.eleapp.service;

import com.eleapp.dao.EleGradeMapper;
import com.eleapp.model.EleGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/12/25.
 */
@Service
public class GradeService {

    @Autowired
    EleGradeMapper eleGradeMapper;

    public int deleteByPrimaryKey(Integer id){
        return eleGradeMapper.deleteByPrimaryKey(id);
    }

    public int insert(EleGrade record){
        return eleGradeMapper.insert(record);
    }

    public int insertSelective(EleGrade record){
        return eleGradeMapper.insertSelective(record);
    }

    public EleGrade selectByPrimaryKey(Integer id){
        return eleGradeMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EleGrade record){
        return eleGradeMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(EleGrade record){
        return eleGradeMapper.updateByPrimaryKey(record);
    }

    public List<Map> selectAllGradeList(Map param){
        return eleGradeMapper.selectAllGradeList(param);
    }
}
