package com.eleapp.service;

import com.eleapp.dao.SysRbacRoleMapper;
import com.eleapp.model.SysRbacRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 胜龙 on 2016/10/18.
 */
@Service
public class SysRbacRoleService {

    @Autowired
    SysRbacRoleMapper sysRbacRoleMapper;

    public int deleteByPrimaryKey(Integer id){
        return sysRbacRoleMapper.deleteByPrimaryKey(id);
    }


    public int insert(SysRbacRole record){
        return sysRbacRoleMapper.insert(record);
    }


    public int insertSelective(SysRbacRole record){
        return sysRbacRoleMapper.insertSelective(record);
    }


    public SysRbacRole selectByPrimaryKey(Integer id){
        return sysRbacRoleMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(SysRbacRole record){
        return sysRbacRoleMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(SysRbacRole record){
        return sysRbacRoleMapper.updateByPrimaryKey(record);
    }

    public List<Map> selectAllRoleList(Map param){
        return sysRbacRoleMapper.selectAllRoleList(param);
    }
}
