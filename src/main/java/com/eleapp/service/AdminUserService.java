package com.eleapp.service;

import com.eleapp.dao.SysRbacUserroleMapper;
import com.eleapp.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 胜龙 on 2016/10/21.
 */
@Service
public class AdminUserService {

    @Autowired
    SysRbacUserroleMapper sysRbacUserroleMapper;


    public UserRole getUserRoleId(Integer userId){
        return sysRbacUserroleMapper.getUserRole(userId);
    }
}
