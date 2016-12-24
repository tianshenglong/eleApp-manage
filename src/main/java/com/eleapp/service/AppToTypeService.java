package com.eleapp.service;

import com.eleapp.dao.EleApptotypeMapper;
import com.eleapp.model.EleApptotype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 胜龙 on 2016/12/24.
 */

@Service
public class AppToTypeService {

    @Autowired
    EleApptotypeMapper eleApptotypeMapper;

    public int insertSelective(EleApptotype record){
        return eleApptotypeMapper.insertSelective(record);
    }
}
