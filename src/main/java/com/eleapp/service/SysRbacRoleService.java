package com.eleapp.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eleapp.dao.SysRbacDataaccessMapper;
import com.eleapp.dao.SysRbacRoleMapper;
import com.eleapp.dao.SysRbacRoleauthMapper;
import com.eleapp.model.SysRbacDataaccess;
import com.eleapp.model.SysRbacRole;
import com.eleapp.model.SysRbacRoleauth;
import org.apache.ibatis.annotations.Param;
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

    @Autowired
    SysRbacRoleauthMapper sysRbacRoleauthMapper;

    @Autowired
    SysRbacDataaccessMapper sysRbacDataaccessMapper;

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

    public void editRoleAuto(String roleId, JSONArray level1JSON, JSONArray level2JSON, JSONArray level3JSON) {
        sysRbacRoleauthMapper.deleteByRoleId(Integer.parseInt(roleId));
        for (Object o : level1JSON) {
            Integer level1 = (Integer) o;
            SysRbacRoleauth ybsRbacRoleAuth = new SysRbacRoleauth();
            ybsRbacRoleAuth.setMenuId(level1);
            ybsRbacRoleAuth.setRoleId(Integer.parseInt(roleId));
            sysRbacRoleauthMapper.insertSelective(ybsRbacRoleAuth);
        }
        for (Object o : level2JSON) {
            Integer level2 = (Integer) o;
            SysRbacRoleauth ybsRbacRoleAuth = new SysRbacRoleauth();
            ybsRbacRoleAuth.setMenuId(level2);
            ybsRbacRoleAuth.setRoleId(Integer.parseInt(roleId));
            StringBuffer buttons = new StringBuffer();
            for (Object o1 : level3JSON) {
                JSONObject level3 =  JSONObject.parseObject(o1.toString());
                if (level2.equals(level3.getInteger("id"))){
                    buttons.append(level3.getString("name")+"|");
                }
            }
            if(!buttons.toString().equals("")){
                ybsRbacRoleAuth.setButtons(buttons.substring(0,buttons.length()-1));
            }
            sysRbacRoleauthMapper.insertSelective(ybsRbacRoleAuth);
        }
    }

    public List<SysRbacRole> getRoleAllListByRoleName(String roleName) {
        return sysRbacRoleMapper.getRoleAllListByRoleName(roleName);
    }


    public SysRbacDataaccess selectDataAccessByUserId(Integer userId) {
        return sysRbacDataaccessMapper.selectByUserId(userId);
    }
}
