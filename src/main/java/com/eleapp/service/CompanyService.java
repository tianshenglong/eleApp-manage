package com.eleapp.service;

import com.eleapp.dao.EleCompanyMapper;
import com.eleapp.model.EleCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by 胜龙 on 2016/11/8.
 */
@Service
public class CompanyService {

    @Autowired
    private EleCompanyMapper eleCompanyMapper;

    public int deleteByPrimaryKey(Integer id){
        return eleCompanyMapper.deleteByPrimaryKey(id);
    }

    public int insert(EleCompany record){
        return eleCompanyMapper.insert(record);
    }

    public int insertSelective(EleCompany record){
        record.setCreateTime(new Date());
        record.setStatus(0);
        record.setIsDel(1);
        return eleCompanyMapper.insertSelective(record);
    }

    public EleCompany selectByPrimaryKey(Integer id){
        return eleCompanyMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(EleCompany record){
        return eleCompanyMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EleCompany record){
        return eleCompanyMapper.updateByPrimaryKey(record);
    }
}
