package com.eleapp.service;

import com.eleapp.dao.EleAppImagesMapper;
import com.eleapp.model.EleAppImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 胜龙 on 2016/12/23.
 */
@Service
public class AppImagesService {

    @Autowired
    EleAppImagesMapper eleAppImagesMapper;

    public int insertSelective(EleAppImages record){
        return eleAppImagesMapper.insertSelective(record);
    }
}
