package com.eleapp.service;

import com.eleapp.dao.EleAppImagesMapper;
import com.eleapp.dao.EleWebSchoolcaseMapper;
import com.eleapp.model.EleAppImages;
import com.eleapp.model.EleWebSchoolcase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 胜龙 on 2016/12/23.
 */
@Service
public class SchoolCaseImagesService {

    @Autowired
    EleWebSchoolcaseMapper eleWebSchoolcaseMapper;

    public int insertSelective(EleWebSchoolcase record){
        return eleWebSchoolcaseMapper.insertSelective(record);
    }
}
