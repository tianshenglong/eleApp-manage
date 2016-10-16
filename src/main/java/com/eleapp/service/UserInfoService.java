package com.eleapp.service;

import com.eleapp.dao.UserinfoMapper;
import com.eleapp.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/10/4.
 */
@Service
public class UserInfoService {

    @Autowired
    UserinfoMapper userinfoMapper;

    public int deleteByPrimaryKey(Integer autoID){
        return userinfoMapper.deleteByPrimaryKey(autoID);
    }


    public int insert(Userinfo record){
        return userinfoMapper.insert(record);
    }


    public int insertSelective(Userinfo record){
        return userinfoMapper.insertSelective(record);
    }

    public Userinfo selectByPrimaryKey(Integer autoID){
        return userinfoMapper.selectByPrimaryKey(autoID);
    }


    public int updateByPrimaryKeySelective(Userinfo record){
        return userinfoMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Userinfo record){
        return userinfoMapper.updateByPrimaryKey(record);
    }


    public List<Map> selectAllUserList(Map param){
        return userinfoMapper.selectAllUserList(param);
    }

    public Userinfo getUserByUserNameAndPwd(String userName,String passWord){
        return userinfoMapper.getUserByUserNameAndPwd(userName,passWord);
    }
}
