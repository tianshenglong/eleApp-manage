package com.eleapp.dao;

import com.eleapp.model.SysRbacRole;

import java.util.List;
import java.util.Map;

public interface SysRbacRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rbac_role
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rbac_role
     *
     * @mbggenerated
     */
    int insert(SysRbacRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rbac_role
     *
     * @mbggenerated
     */
    int insertSelective(SysRbacRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rbac_role
     *
     * @mbggenerated
     */
    SysRbacRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rbac_role
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysRbacRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rbac_role
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysRbacRole record);


    List<Map> selectAllRoleList(Map param);
}