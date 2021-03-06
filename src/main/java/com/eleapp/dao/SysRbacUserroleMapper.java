package com.eleapp.dao;

import com.eleapp.model.SysRbacUserrole;
import com.eleapp.model.UserRole;

public interface SysRbacUserroleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rbac_userrole
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rbac_userrole
     *
     * @mbggenerated
     */
    int insert(SysRbacUserrole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rbac_userrole
     *
     * @mbggenerated
     */
    int insertSelective(SysRbacUserrole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rbac_userrole
     *
     * @mbggenerated
     */
    SysRbacUserrole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rbac_userrole
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysRbacUserrole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rbac_userrole
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysRbacUserrole record);

    UserRole getUserRole(Integer userId);
}