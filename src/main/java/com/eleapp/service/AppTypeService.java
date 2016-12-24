package com.eleapp.service;

import com.eleapp.dao.EleApptypeMapper;
import com.eleapp.model.EleApptype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 胜龙 on 2016/12/24.
 */
@Service
public class AppTypeService {

    @Autowired
    EleApptypeMapper eleApptypeMapper;

    public List<EleApptype> getALlTypes(){
        return eleApptypeMapper.getALlTypes();
    }
}
