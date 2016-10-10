package com.eleapp.service;

import com.eleapp.dao.UserMapper;
import com.eleapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 胜龙 on 2016/10/4.
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    public int deleteByPrimaryKey(Integer id){
        return userMapper.deleteByPrimaryKey(id);
    }

    public int insert(User record){
        return userMapper.insert(record);
    }

    public int insertSelective(User record){
        return userMapper.insertSelective(record);
    }

    public User selectByPrimaryKey(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record){
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record){
        return userMapper.updateByPrimaryKey(record);
    }

    public List<User> selectAllUserList(){
        return userMapper.selectAllUserList();
    }
}
