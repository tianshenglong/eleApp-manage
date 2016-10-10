package com.eleapp.service;

import com.eleapp.dao.EleAppMapper;
import com.eleapp.model.EleApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 胜龙 on 2016/10/8.
 */
@Service
public class EleAppService {

    @Autowired
    EleAppMapper eleAppMapper;

    public int deleteByPrimaryKey(Integer id){
        return eleAppMapper.deleteByPrimaryKey(id);
    }

    public int insert(EleApp record){
        return eleAppMapper.insert(record);
    }

    public int insertSelective(EleApp record){
        return eleAppMapper.insertSelective(record);
    }

    public EleApp selectByPrimaryKey(Integer id){
        return eleAppMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EleApp record){
        return eleAppMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(EleApp record){
        return eleAppMapper.updateByPrimaryKey(record);
    }

    public List<EleApp> selectAllAppList(){
        return eleAppMapper.selectAllAppList();
    }
}
