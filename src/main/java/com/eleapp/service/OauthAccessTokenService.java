package com.eleapp.service;

import com.eleapp.dao.OauthAccessTokenMapper;
import com.eleapp.model.OauthAccessToken;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/11/2.
 */
@Service
public class OauthAccessTokenService {

    @Autowired
    OauthAccessTokenMapper oauthAccessTokenMapper;
    public int deleteByPrimaryKey(Integer id){
       return oauthAccessTokenMapper.deleteByPrimaryKey(id);
    }

    public int insert(OauthAccessToken record){
       return oauthAccessTokenMapper.insert(record);
    }

    public int insertSelective(OauthAccessToken record){
        return oauthAccessTokenMapper.insertSelective(record);
    }

    public OauthAccessToken selectByPrimaryKey(Integer id){
        return oauthAccessTokenMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(OauthAccessToken record){
        return oauthAccessTokenMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(OauthAccessToken record){
        return oauthAccessTokenMapper.updateByPrimaryKey(record);
    }

    public List<Map> selectAllOauthAccessList(Map param){
        return oauthAccessTokenMapper.selectAllOauthAccessList(param);
    }

    public int updateOauthStatus(Integer status,Integer id){
        return oauthAccessTokenMapper.updateOauthStatus(status,id);
    }
}
